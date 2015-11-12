package br.com.store.backend.view.endpoint;

import static org.apache.commons.lang3.StringUtils.isEmpty;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.store.backend.infrastructure.configuration.StoreMessageSource;
import br.com.store.backend.infrastructure.exception.BadRequestException;
import br.com.store.backend.infrastructure.exception.CustomRuntimeException;
import br.com.store.backend.infrastructure.exception.ForbiddenException;
import br.com.store.backend.infrastructure.exception.InternalServerErrorException;
import br.com.store.backend.infrastructure.exception.NotFoundException;
import br.com.store.backend.infrastructure.exception.NotModifiedException;
import br.com.store.backend.infrastructure.exception.RepositoryException;
import br.com.store.backend.infrastructure.exception.UnauthorizedException;
import br.com.store.backend.infrastructure.rest.model.ErrorMessage;
import br.com.store.backend.infrastructure.rest.model.ErrorResource;
import br.com.store.backend.infrastructure.rest.model.Resource;
import br.com.store.validation.Error;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Endpoint Base para os demais endpoints.<br />
 * Ele é um assistente para todos os Controllers. Ele é responsável pelo
 * tratamento de Exceptions.
 * 
 * @see ControllerAdvice
 */
@ControllerAdvice
@ResponseBody
public class BaseRestEndpoint extends ResponseEntityExceptionHandler {
	
    private static final String BAD_REQUEST = "badRequest";
	
    @Autowired
    private StoreMessageSource messageSource;

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers,
            HttpStatus status, WebRequest request) {

        return handleExceptionInternal(ex, buildErrorResource(ex.getBindingResult().getAllErrors()), headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleBindException(BindException ex, HttpHeaders headers, HttpStatus status,
            WebRequest request) {

        return handleExceptionInternal(ex, buildErrorResource(ex.getAllErrors()), headers, status, request);
    }

    private Resource<?> buildErrorResource(List<ObjectError> errorList) {

        ErrorResource errorResource = new ErrorResource();

        for (ObjectError objError : errorList) {

            Long code = 0l;
            String title = null;
            String message = null;
            String field = null;

            try {

                ObjectMapper mapper = new ObjectMapper();
                Error error = mapper.readValue(objError.getDefaultMessage(), Error.class);

                if (error.getCode() != null) {
                    code = error.getCode();
                } else {
                    code = null;
                }

                title = getTitle(BAD_REQUEST);
                message = getMessage(error);
                field = error.getField();

            } catch (IOException e) {
                message = objError.getDefaultMessage();
                field = ((FieldError) objError).getField();
            }

            errorResource.addMessages(new ErrorMessage(code, field, title, message));
        }

        Resource<?> resource = new Resource<>();
        resource.setErrors(errorResource);
        return resource;
    }

    private String getMessage(Error error) {

        String messageKey = BAD_REQUEST + "." + error.getCode().intValue();
        String message = getMessage(BAD_REQUEST, error.getCode(), null);

        if (message == null || messageKey.equals(message)) {
            message = error.getMessage();
        }

        return message;
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public Resource<?> handleUnauthorizedException(UnauthorizedException ex) {
        return handleException(ex, "unauthorized");
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public Resource<?> handleBadRequestError(BadRequestException ex) {
        return handleException(ex, BAD_REQUEST);
    }

    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    @ExceptionHandler(NotModifiedException.class)
    public Resource<?> handleNotModifiedException(NotModifiedException ex) {
        return handleException(ex, "notModified");
    }

    @ExceptionHandler(ForbiddenException.class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    public Resource<?> handleForbiddenException(ForbiddenException ex) {
        return handleException(ex, "forbidden");
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public Resource<?> handleNotFoundException(NotFoundException ex) {
        return handleException(ex, "notFound");
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(RepositoryException.class)
    @ResponseBody
    public Resource<?> handleRepositoryException(RepositoryException ex) {
        return handleInternalServerErrorException(new InternalServerErrorException(
                InternalServerErrorException.REPOSITORY_EXCEPTION));
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(InternalServerErrorException.class)
    @ResponseBody
    public Resource<?> handleInternalServerErrorException(InternalServerErrorException ex) {

        ErrorResource errorResource = new ErrorResource();
        errorResource.addMessages(new ErrorMessage(ex.getCode(), null, null, null));

        Resource<Object> resource = new Resource<>();
        resource.setErrors(errorResource);

        return resource;
    }

    private Resource<?> handleException(CustomRuntimeException ex, String exceptionCode) {

        ErrorResource errorResource = new ErrorResource();

        if (!ex.getErros().isEmpty()) {

            for (ErrorMessage errorMessages : ex.getErros()) {

                if (isEmpty(errorMessages.getTitle())) {
                    String title = getTitle(exceptionCode, errorMessages.getCode());
                    errorMessages.setTitle(title);
                }

                if (isEmpty(errorMessages.getMessage())) {
                    String message = getMessage(exceptionCode, errorMessages.getCode(), ex.getArgs());
                    errorMessages.setMessage(message);
                }
            }

            errorResource.addMessages(ex.getErros());

        } else {
            String title = getTitle(exceptionCode);
            String message = getMessage(exceptionCode, ex.getCode(), ex.getArgs());
            errorResource.addMessages(new ErrorMessage(ex.getCode(), ex.getField(), title, message));
        }

        Resource<Object> resource = new Resource<>();
        resource.setErrors(errorResource);
        return resource;
    }

    private String getTitle(String exceptionCode, Long code) {

        String key = exceptionCode + ".title." + code;
        String title = messageSource.getMessage(key);

        if (title == null || key.equals(title)) {
            title = getTitle(exceptionCode);
        }

        return title;
    }

    private String getTitle(String exceptionCode) {

        String key = exceptionCode + ".title";
        String title = messageSource.getMessage(key);

        if (title == null || key.equals(title)) {
            title = "Atenção";
        }

        return title;
    }

    private String getMessage(String exceptionCode, Long code, String[] args) {
        return messageSource.getMessage(exceptionCode + "." + code, args);
    }

}



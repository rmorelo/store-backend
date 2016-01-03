package br.com.store.backend.infrastructure.exception;

import java.util.List;

import br.com.store.backend.infrastructure.rest.model.ErrorMessage;

public class BadRequestException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String EXCEPTION_CODE = "badRequest";

    public static final Integer INVALID_PERSON_TYPE = 400001;

    public static final Integer RECOVERIES_TYPE_PATH = 400002;
    
    public static final Integer SELECTOR_NOT_FOUND = 400036;
        
    public static final Integer HEADERS_VALIDATION_NULL = 4002034;
    public static final Integer HEADERS_BROWSER_IP_NULL = 4002035;
    public static final Integer HEADERS_REQUEST_ID_NULL = 4002036;
    public static final Integer HEADERS_CONTENT_TYPE_NULL = 4002037;
    
    public static final Integer INVALID_SELECTOR = 4002056;

    public BadRequestException(int code) {
        super(code);
    }

    public BadRequestException(List<ErrorMessage> errors) {
        super(errors);
    }

    public BadRequestException(String field, Integer code) {
        super(field, code);
    }

    public BadRequestException(String field, Integer code, String title, String message, String... args) {
        super(field, code, title, message, args);
    }

}

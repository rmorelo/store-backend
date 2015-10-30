package br.com.store.backend.infrastructure.exception;

import java.util.List;

import br.com.store.backend.infrastructure.rest.model.ErrorMessage;

public class BadRequestException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String EXCEPTION_CODE = "badRequest";
    
    public static final Integer SELECTOR_NOT_FOUND = 400036;

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

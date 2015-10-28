package br.com.store.infrastructure.exception;

import java.util.List;

import br.com.store.infrastructure.rest.model.ErrorMessage;

public class BadRequestException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final String EXCEPTION_CODE = "badRequest";

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

package br.com.store.infrastructure.exception;

import java.util.List;

import br.com.store.infrastructure.rest.model.ErrorMessage;

public class ForbiddenException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;


    public ForbiddenException(int code, String... args) {
        super(null, code, null, null, args);
    }

    public ForbiddenException(String field, int code, String... args) {
        super(field, code, null, null, args);
    }

    public ForbiddenException(List<ErrorMessage> errors) {
        super(errors);
    }

}

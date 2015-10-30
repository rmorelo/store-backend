package br.com.store.backend.infrastructure.exception;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import br.com.store.backend.infrastructure.rest.model.ErrorMessage;

public class CustomRuntimeException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    private List<ErrorMessage> erros = new LinkedList<ErrorMessage>();
    private String field;
    private int code;
    private String[] args;

    public CustomRuntimeException() {}

    public CustomRuntimeException(int code) {
        this.code = code;
    }

    public CustomRuntimeException(int code, Throwable th) {
        super(th);
        this.code = code;
    }

    public CustomRuntimeException(String field, int code) {
        super();
        this.field = field;
        this.code = code;
        this.erros.add(new ErrorMessage(code, field, null, null));
    }

    public CustomRuntimeException(String field, int code, String title, String message, String... args) {
        super();
        this.field = field;
        this.code = code;
        this.args = args;
        this.erros.add(new ErrorMessage(code, field, title, message));
    }

    public CustomRuntimeException(ErrorMessage... errors) {
        super();
        this.erros.addAll(Arrays.asList(errors));
    }

    public CustomRuntimeException(List<ErrorMessage> errors) {
        super();
        this.erros.addAll(errors);
    }

    public String getField() {
        return field;
    }

    public int getCode() {
        return code;
    }

    public String[] getArgs() {
        return args;
    }

    public List<ErrorMessage> getErros() {
        return erros;
    }
}

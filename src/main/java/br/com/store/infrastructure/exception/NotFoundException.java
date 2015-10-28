package br.com.store.infrastructure.exception;

public class NotFoundException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final int STORE = 404001;

    public NotFoundException(int code) {
        super(code);
    }

    public NotFoundException(String field, int code) {
        super(field, code);
    }

}

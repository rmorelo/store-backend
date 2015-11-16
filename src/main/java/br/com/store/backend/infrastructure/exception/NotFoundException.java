package br.com.store.backend.infrastructure.exception;

public class NotFoundException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final int PARTNER_NOT_FOUND = 404001;
    
    public static final int EMAIL_NOT_FOUND = 404002;

    public NotFoundException(int code) {
        super(code);
    }

    public NotFoundException(String field, int code) {
        super(field, code);
    }

}

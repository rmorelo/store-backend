package br.com.store.infrastructure.exception;

public class NotModifiedException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    public static final int DEFAULT = 304000;
    public static final int CONTACTS = 304001;
    public static final int ACCOUNT = 304002;

    public NotModifiedException(int code) {
        super(code);
    }

    public NotModifiedException(String field, int code) {
        super(field, code);
    }

}

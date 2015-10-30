package br.com.store.backend.infrastructure.exception;

public class InternalServerErrorException extends CustomRuntimeException {

    private static final long serialVersionUID = 8257329482542221840L;

    public static final int SERVER_ERROR = 500001;
  
    public static final int REPOSITORY_EXCEPTION = 500003;

    public InternalServerErrorException(int code) {
        super(code);
    }

    public InternalServerErrorException() {
        super(SERVER_ERROR);
    }

    public InternalServerErrorException(Throwable th) {
        super(SERVER_ERROR, th);
    }

}

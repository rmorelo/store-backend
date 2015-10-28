package br.com.store.infrastructure.rest;

public class RestClientException extends Exception {

    private static final long serialVersionUID = 8641143750912683833L;

    public RestClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestClientException(String message) {
        super(message);
    }

    public RestClientException(Throwable th) {
        super(th);
    }

}

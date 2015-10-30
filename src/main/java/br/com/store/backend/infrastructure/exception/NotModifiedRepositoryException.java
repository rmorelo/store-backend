package br.com.store.backend.infrastructure.exception;

import org.apache.http.HttpStatus;

public class NotModifiedRepositoryException extends RepositoryException {

    private static final long serialVersionUID = -7142834969643540307L;

    public NotModifiedRepositoryException() {
        super(HttpStatus.SC_NOT_MODIFIED);
    }

}

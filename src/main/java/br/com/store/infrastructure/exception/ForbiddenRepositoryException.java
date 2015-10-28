package br.com.store.infrastructure.exception;

import java.util.List;

import org.apache.http.HttpStatus;

import br.com.store.infrastructure.rest.model.ErrorMessage;

public class ForbiddenRepositoryException extends RepositoryException {

    private static final long serialVersionUID = 3011879653463541857L;

    public ForbiddenRepositoryException() {
        super(HttpStatus.SC_FORBIDDEN);
    }

    public ForbiddenRepositoryException(List<ErrorMessage> messages) {
        super(messages);
    }
}

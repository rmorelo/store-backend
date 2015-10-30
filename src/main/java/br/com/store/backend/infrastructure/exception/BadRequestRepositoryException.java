package br.com.store.backend.infrastructure.exception;

import java.util.List;

import org.apache.http.HttpStatus;

import br.com.store.backend.infrastructure.rest.model.ErrorMessage;

public class BadRequestRepositoryException extends RepositoryException {

    private static final long serialVersionUID = 3925209645060076236L;

    public BadRequestRepositoryException() {
        super(HttpStatus.SC_BAD_REQUEST);
    }

    public BadRequestRepositoryException(List<ErrorMessage> messages) {
        super(messages);
    }

}

package br.com.store.infrastructure.exception;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import br.com.store.infrastructure.rest.model.ErrorMessage;

public class RepositoryException extends CustomRuntimeException {

    private static final long serialVersionUID = 8611820097329961166L;

    public RepositoryException(int code) {
        super(code);
    }

    public RepositoryException(List<ErrorMessage> messages) {
        super();
        if (CollectionUtils.isNotEmpty(messages)) {
            this.getErros().addAll(messages);
        }
    }
}

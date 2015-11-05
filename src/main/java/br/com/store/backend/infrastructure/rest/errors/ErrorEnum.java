package br.com.store.backend.infrastructure.rest.errors;

import br.com.store.validation.Error;

public interface ErrorEnum {

    Long getCode();

    String getError();

    String getField();

    Error buildError();
}

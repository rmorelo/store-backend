package br.com.store.backend.infrastructure.exception;

import java.util.List;

import br.com.store.backend.infrastructure.rest.errors.BadRequestEnum;
import br.com.store.backend.infrastructure.rest.model.ErrorMessage;

public class BadRequestException extends BaseException {

    private static final long serialVersionUID = 652270638999357505L;

    public BadRequestException(BadRequestEnum badEnum) {
        super(badEnum.buildError());
    }

    public BadRequestException(BadRequestEnum badEnum, Object... params) {
        super(badEnum.buildError(), params);
    }

    public BadRequestException(List<ErrorMessage> messages) {
        super(messages);
    }
}

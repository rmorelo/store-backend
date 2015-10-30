package br.com.store.backend.infrastructure.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class UnauthorizedException extends CustomRuntimeException {

    private static final long serialVersionUID = 1L;

    private static final int UNAUTHORIZED = 401001;

    public UnauthorizedException() {
        super(UNAUTHORIZED);
    }

}

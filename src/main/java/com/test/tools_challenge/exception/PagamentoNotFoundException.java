package com.test.tools_challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class PagamentoNotFoundException extends RuntimeException {
    private static final long serialVersionUID = -8396976205864418580L;
}
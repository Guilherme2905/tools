package com.test.tools_challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ProcessarPagamentoException extends RuntimeException {
    private static final long serialVersionUID = -8396976205862218580L;
}
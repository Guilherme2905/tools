package com.test.tools_challenge.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class HandlerNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 4624859687274396374L;
}

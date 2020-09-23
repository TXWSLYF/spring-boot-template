package com.example.springboottemplate.common.exception;

import com.example.springboottemplate.common.dto.response.ResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 业务 api 异常 handler
 */
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiException.class)
    public ResponseException apiExceptionHandler(ApiException e) {
        ResponseException responseException = new ResponseException(e.getResponseCodeAndMsg());

        return responseException;
    }
}


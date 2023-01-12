package com.example.googlelogin.exception;

import org.springframework.http.HttpStatus;

public interface IErrorCode {
    HttpStatus getHttpStatus();

    int getCode();

    String getMessage();

    String name();

}

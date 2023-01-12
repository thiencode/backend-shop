package com.example.googlelogin.exception.constant;

import com.example.googlelogin.exception.IErrorCode;
import org.springframework.http.HttpStatus;

public enum ErrorCode implements IErrorCode {

    OK(HttpStatus.OK, 200000, "OK"),
    NOT_FOUND(HttpStatus.NOT_FOUND, 400000, "Not Found");

    private final HttpStatus httpStatus;

    private final int code;

    private final String message;

    ErrorCode(HttpStatus httpStatus, int code, String message) {
        this.httpStatus = httpStatus;
        this.code = code;
        this.message = message;
    }


    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public int getCode() {
        return code;
    }

    @Override
    public String getMessage() {
        return message;
    }
}

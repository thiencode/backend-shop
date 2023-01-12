package com.example.googlelogin.model.factory.response;

import com.example.googlelogin.exception.IErrorCode;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface IResponseFactory {

    <I> ResponseEntity<BaseResponse<I>> success(I data);

    ResponseEntity<ErrorResponse> error(IErrorCode errorCode);

    ResponseEntity<ErrorResponse> error(IErrorCode errorCode, Map<String, String> fieldError);
}

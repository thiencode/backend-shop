package com.example.googlelogin.model.factory.response;

import com.example.googlelogin.constant.CommonConstant;
import com.example.googlelogin.exception.IErrorCode;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DefaultResponseFactory implements IResponseFactory {
    protected final String servicePrefix;

    public DefaultResponseFactory(Environment environment) {
        String serviceName = environment.getProperty("spring.application.name");
        if (serviceName != null)
            this.servicePrefix = serviceName.toUpperCase();
        else
            this.servicePrefix = "";
    }

    @Override
    public <I> ResponseEntity<BaseResponse<I>> success(I data) {
        BaseResponse<I> response = BaseResponse.<I>builder()
                                               .data(data)
                                               .success(true)
                                               .build();
        return ResponseEntity.status(HttpStatus.OK)
                             .contentType(MediaType.APPLICATION_JSON)
                             .body(response);
    }

    @Override
    public ResponseEntity<ErrorResponse> error(IErrorCode errorCode) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .body(getErrorResponse(errorCode));
    }

    @Override
    public ResponseEntity<ErrorResponse> error(IErrorCode errorCode, Map<String, String> fieldError) {
        return ResponseEntity
                .status(errorCode.getHttpStatus())
                .contentType(MediaType.APPLICATION_JSON)
                .body(getErrorResponse(errorCode, fieldError));
    }

    protected String getCode(IErrorCode iErrorCode) {
        return servicePrefix != null ? servicePrefix.concat(
                String.format(CommonConstant.SIX_DIGITS_FORMAT, iErrorCode.getCode())
                      .toUpperCase()) : String.format(CommonConstant.SIX_DIGITS_FORMAT, iErrorCode.getCode());
    }

    protected ErrorResponse getErrorResponse(IErrorCode iErrorCode, Map<String, String> fieldError) {
        return ErrorResponse.builder()
                            .code(getCode(iErrorCode))
                            .message(iErrorCode.name())
                            .success(false)
                            .data(fieldError)
                            .build();
    }

    protected ErrorResponse getErrorResponse(IErrorCode iErrorCode) {
        return getErrorResponse(iErrorCode, null);
    }
}

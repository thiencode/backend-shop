package com.example.googlelogin.model.factory.impl;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder(toBuilder = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class ErrorResponse extends BaseResponse<Object> {
    private String title;
    private String subTitle;
    private String message;
    private String code;
}

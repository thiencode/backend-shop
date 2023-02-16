package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;


/**
 * ICreateModelController
 *
 * @param <I> id
 * @param <U> detail
 * @see ICreateModelController
 */
public interface ICreateModelController<I, U extends IBaseData<I>> {
    @PostMapping("/create")
    ResponseEntity<BaseResponse<U>> createModel(@RequestBody @Valid U request);
}

package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.request.FactoryUpdateRequest;
import com.example.googlelogin.model.factory.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

/**
 * IUpdateModelController
 *
 * @param <I> id
 * @param <U> detail
 * @see IUpdateModelController
 */
public interface IUpdateModelController<I, U extends IBaseData<I>> {
    @PutMapping("/update")
    ResponseEntity<BaseResponse<U>> updateModel(@RequestBody @Valid FactoryUpdateRequest<I, U> request) throws Exception;
}

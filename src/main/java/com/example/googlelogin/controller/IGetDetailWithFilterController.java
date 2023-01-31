package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.filter.IFilter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;

/**
 * IGetDetailWithFilterController <br/>
 * Get Detail model with filter
 *
 * @param <I> id
 * @param <U> detail
 * @param <F> extend IFilter
 */
public interface IGetDetailWithFilterController<I, U extends IBaseData<I>, F extends IFilter> {
    @GetMapping("/detail")
    ResponseEntity<BaseResponse<U>> getDetailWithFilter(@ParameterObject @Valid F filter);
}

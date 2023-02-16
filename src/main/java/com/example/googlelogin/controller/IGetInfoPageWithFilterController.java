package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BasePagingResponse;
import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.filter.IFilter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


/**
 * IGetInfoPageWithFilterController
 *
 * @param <I> id
 * @param <T> info
 * @param <F> extend IFilter
 * @see IGetInfoPageWithFilterController
 */
public interface IGetInfoPageWithFilterController<I, T extends IBaseData<I>, F extends IFilter> {
    @GetMapping("/page")
    ResponseEntity<BaseResponse<BasePagingResponse<T>>> getInfoPageWithFilter(
            @ParameterObject @Valid F filter,
            @RequestParam(defaultValue = "0") Integer number,
            @RequestParam(defaultValue = "20") Integer size
                                                                             );
}

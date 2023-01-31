package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.filter.IFilter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import java.util.List;

/**
 * IGetInfoListWithFilterController
 *
 * @param <I> id
 * @param <T> info
 * @param <F> extend IFilter
 * @see IGetInfoListWithFilterController
 */
public interface IGetInfoListWithFilterController<I, T extends IBaseData<I>, F extends IFilter> {
    @GetMapping("/list")
    ResponseEntity<BaseResponse<List<T>>> getInfoListWithFilter(@ParameterObject @Valid F filter);
}

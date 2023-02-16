package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.factory.response.FactoryDeleteResponse;
import com.example.googlelogin.model.filter.IFilter;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

import javax.validation.Valid;


/**
 * IDeleteModelWithFilterController <br/>
 * Delete model with filter
 *
 * @param <F> extend IFilter
 */
public interface IDeleteModelWithFilterController<F extends IFilter> {
    @DeleteMapping("/delete")
    ResponseEntity<BaseResponse<FactoryDeleteResponse>> deleteModelWithFilter(@ParameterObject @Valid F filter);
}

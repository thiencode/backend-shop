package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * IGetDetailByIdController <br/>
 * Get detail by id
 *
 * @param <I> id
 * @param <U> detail
 */
public interface IGetDetailByIdController<I, U extends IBaseData<I>> {
    @GetMapping("/{id}/detail")
    ResponseEntity<BaseResponse<U>> getDetailById(@PathVariable I id);
}

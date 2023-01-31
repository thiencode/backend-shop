package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.factory.response.FactoryDeleteResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * IDeleteModelByIdController
 *
 * @param <I> id
 */
public interface IDeleteModelByIdController<I> {
    @DeleteMapping("/{id}/delete")
    ResponseEntity<BaseResponse<FactoryDeleteResponse>> deleteModelById(@PathVariable I id);
}

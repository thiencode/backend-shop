package com.example.googlelogin.controller;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BaseResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * IGetInfoListController
 *
 * @param <I> id
 * @param <T> info
 * @see IGetInfoListController
 */
public interface IGetInfoListController<I, T extends IBaseData<I>> {
    @GetMapping("/list")
    ResponseEntity<BaseResponse<List<T>>> getInfoList();
}

package com.example.googlelogin.controller;

import com.example.googlelogin.factory.IDataFactory;
import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.request.FactoryUpdateRequest;
import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.factory.response.FactoryDeleteResponse;
import com.example.googlelogin.model.factory.response.IResponseFactory;
import com.example.googlelogin.model.filter.IFilter;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * BaseController
 *
 * @param <I> id
 * @param <T> info
 * @param <U> detail
 * @see BaseController
 */
public abstract class BaseController<I, T extends IBaseData<I>, U extends T> {
    protected final IResponseFactory iResponseFactory;

    protected final IDataFactory<I, T, U> iDataFactory;

    protected BaseController(IResponseFactory iResponseFactory, IDataFactory<I, T, U> iDataFactory) {
        this.iResponseFactory = iResponseFactory;
        this.iDataFactory = iDataFactory;
    }

    protected ResponseEntity<BaseResponse<U>> factoryCreateModel(U request) {
        U response = iDataFactory.createModel(request);
        return iResponseFactory.success(response);
    }

    protected ResponseEntity<BaseResponse<U>> factoryUpdateModel(FactoryUpdateRequest<I, U> request) throws Exception {
        return factoryUpdateModel(request.getId(), request.getData());
    }

    protected ResponseEntity<BaseResponse<U>> factoryUpdateModel(U request) throws Exception {
        return factoryUpdateModel(request.getId(), request);
    }

    protected ResponseEntity<BaseResponse<U>> factoryUpdateModel(I id, U request) throws Exception {
        return iResponseFactory.success(iDataFactory.updateModel(id, request));
    }

    protected <F extends IFilter> ResponseEntity<BaseResponse<FactoryDeleteResponse>> factoryDeleteWithFilter(I id, F filter) throws Exception {
        return iResponseFactory.success(
                FactoryDeleteResponse.builder()
                        .success(iDataFactory.deleteModel(id, filter))
                        .build()
        );
    }

    protected ResponseEntity<BaseResponse<U>> factoryGetDetailById(I id) throws Exception {
        return factoryGetDetailWithFilter(id, null);
    }

    protected <F extends IFilter> ResponseEntity<BaseResponse<U>> factoryGetDetailWithFilter(I id, F filter) throws Exception {
        return iResponseFactory.success(iDataFactory.getDetailModel(id, filter));
    }

    protected <F extends IFilter> ResponseEntity<BaseResponse<List<T>>> factoryGetInfoListWithFilter(F filter) {
        return iResponseFactory.success(iDataFactory.getInfoList(filter));
    }
}

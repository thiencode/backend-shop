package com.example.googlelogin.factory;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BasePagingResponse;
import com.example.googlelogin.model.filter.IFilter;

import java.util.List;

/**
 * IDataFactory
 *
 * @param <I> id
 * @param <T> object info
 * @param <U> object detail
 */
public interface IDataFactory<I, T extends IBaseData<I>, U extends T> {

    U createModel(U detail);

    U updateModel(I id, U detail) throws Exception;

    <F extends IFilter> boolean deleteModel(I id, F filter) throws Exception;

    <F extends IFilter> List<T> getInfoList(F filter);

    <F extends IFilter> BasePagingResponse<T> getInfoPage(F filter, int number, int size);

    List<T> getInfoList();

    <F extends IFilter> U getDetailModel(I id, F filter) throws Exception;

    <F extends IFilter> boolean existByFilter(I id, F filter) throws Exception;

    boolean existByDetail(U detail) throws Exception;
}

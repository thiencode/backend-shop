package com.example.googlelogin.factory;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.filter.IFilter;

import java.util.List;

/**
 *  IDataFactory
 * @param <I> id
 * @param <T> object info
 * @param <U> object detail
 */
public interface IDataFactory<I, T extends IBaseData<I>, U extends T> {

    U createModel(U detail);

    U updateModel(I id, U detail);

    <F extends IFilter> boolean deleteModel(I id, F filter);

    <F extends IFilter> List<T> getInfoList(F filter);

    List<T> getInfoList();

    <F extends IFilter> U getDetailModel(I id);

    <F extends IFilter> boolean existByFilter(I id, F filter);

    boolean existByDetail(U detail);
}

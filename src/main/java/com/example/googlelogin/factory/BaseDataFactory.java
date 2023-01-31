package com.example.googlelogin.factory;


import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BasePagingResponse;
import com.example.googlelogin.model.filter.IFilter;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public abstract class BaseDataFactory<I, T extends IBaseData<I>, U extends T> implements IDataFactory<I, T, U> {
    @Override
    public U createModel(U detail) {
        detail = didCreate(preCreate(detail));
        return detail;
    }

    protected U preCreate(U detail) {
        return detail;
    }

    protected abstract U didCreate(U detail);

    @Override
    public U updateModel(I id, U detail) {
        detail = didUpdate(id, preUpdate(id, detail));
        return detail;
    }

    protected U preUpdate(I id, U detail) {
        return detail;
    }

    protected abstract U didUpdate(I id, U detail) throws Exception;

    @Override
    public <F extends IFilter> boolean deleteModel(I id, F filter) {
        F preFilter = preDelete(id, filter);
        didDelete(id, preFilter);
        return true;
    }

    protected <F extends IFilter> F preDelete(I id, F filter) {
        return filter;
    }

    protected abstract <F extends IFilter> void didDelete(I id, F filter) throws Exception;

    @Override
    public <F extends IFilter> List<T> getInfoList(F filter) {
        //Check Cache
        F preFilter = preGetInfoList(filter);
        return didGetInfoList(preFilter);
    }

    protected <F extends IFilter> F preGetInfoList(F filter) {
        return filter;
    }

    protected abstract <F extends IFilter> List<T> didGetInfoList(F filter);

    @Override
    public List<T> getInfoList() {
        preGetInfoList();
        return didGetInfoList();
    }

    protected void preGetInfoList() {
    }

    protected abstract List<T> didGetInfoList();

    @Override
    public <F extends IFilter> U getDetailModel(I id, F filter) {
        F preFilter = preGetDetailModel(id, filter);
        return didGetDetailModel(id, preFilter);
    }

    protected <F extends IFilter> F preGetDetailModel(I id, F filter) {
        return filter;
    }

    protected abstract <F extends IFilter> U didGetDetailModel(I id, F filter) throws Exception;

    @Override
    public <F extends IFilter> BasePagingResponse<T> getInfoPage(F filter, int number, int size) {
        F preFilter = preGetInfoPage(filter, number, size);
        return didGetInfoPage(filter, number, size);
    }

    protected <F extends IFilter> F preGetInfoPage(F filter, int number, int size) {
        return filter;
    }

    protected abstract <F extends IFilter> BasePagingResponse<T> didGetInfoPage(F filter, Integer number, Integer size);
}

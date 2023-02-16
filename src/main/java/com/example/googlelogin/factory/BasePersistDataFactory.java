package com.example.googlelogin.factory;

import com.example.googlelogin.model.factory.IBaseData;
import com.example.googlelogin.model.factory.response.BasePagingResponse;
import com.example.googlelogin.model.filter.IFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * BasePersistDataFactory
 *
 * @param <I> id
 * @param <T> info
 * @param <D> detail
 * @param <A> id of entity
 * @param <E> entity
 * @see BasePersistDataFactory
 */
@Transactional
public abstract class BasePersistDataFactory<I, T extends IBaseData<I>, D extends T, A, E>
        extends BaseDataFactory<I, T, D>
        implements IPersistDataFactory<T, D, E> {
    protected final PagingAndSortingRepository<E, A> repository;

    protected BasePersistDataFactory(PagingAndSortingRepository<E, A> repository) {
        this.repository = repository;
    }

    @Override
    protected D didCreate(D detail) {
        E entity = repository.save(createConvertToEntity(detail));
        return convertToDetail(entity);
    }

    @Override
    protected D didUpdate(I id, D detail) throws Exception {
        E prevEntity = getEntity(id, detail).orElseThrow(Exception::new);
        updateConvertToEntity(prevEntity, detail);
        E entity = repository.save(prevEntity);
        return convertToDetail(entity);
    }

    @Override
    protected <F extends IFilter> void didDelete(I id, F filter) throws Exception {
        repository.deleteById(convertId(id));
    }

    @Override
    protected <F extends IFilter> List<T> didGetInfoList(F filter) {
        return convertList(listQuery());
    }

    @Override
    protected List<T> didGetInfoList() {
        return convertList(listQuery());
    }

    @Override
    protected <F extends IFilter> D didGetDetailModel(I id, F filter) throws Exception {
        E entity = getEntity(id, filter).orElseThrow(Exception::new);
        return convertToDetail(entity);
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<T> didGetInfoPage(F filter, Integer number, Integer size) {
        Page<E> pageEntity = pageQuery(filter, number, size);
        return BasePagingResponse.<T>builder()
                                 .contents(convertList(pageEntity.getContent()))
                                 .pageNumber(pageEntity.getNumber())
                                 .pageSize(pageEntity.getSize())
                                 .totalElement(pageEntity.getTotalElements())
                                 .build();
    }

    @Override
    public <F extends IFilter> boolean existByFilter(I id, F filter) throws Exception {
        return repository.existsById(convertId(id));
    }

    @Override
    public boolean existByDetail(D detail) throws Exception {
        if (detail.getId() == null) return false;
        return repository.existsById(convertId(detail.getId()));
    }

    protected Optional<E> getEntity(I id, D detail) throws Exception {
        return repository.findById(convertId(id));
    }

    protected <F extends IFilter> Optional<E> getEntity(I id, F filter) throws Exception {
        return repository.findById(convertId(id));
    }

    protected A convertId(I id) throws Exception {
        try {
            return (A) id;
        } catch (Exception e) {
            throw new Exception("Can");
        }
    }

    protected List<T> convertList(Iterable<E> entities) {
        List<T> response = new ArrayList<>();
        for (E entity : entities) {
            response.add(convertToInfo(entity));
        }
        return response;
    }

    protected Iterable<E> listQuery() {
        return repository.findAll();
    }

    protected <F extends IFilter> Page<E> pageQuery(F filter, Integer number, Integer size) {
        return repository.findAll(PageRequest.of(number, size));
    }
}

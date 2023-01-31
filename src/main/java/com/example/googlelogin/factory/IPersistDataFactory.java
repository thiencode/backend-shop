package com.example.googlelogin.factory;

/**
 * IPersistDataFactory
 *
 * @param <I> info
 * @param <D> detail
 * @param <E> entity
 * @see IPersistDataFactory
 */
public interface IPersistDataFactory<I, D extends I, E> {
    E createConvertToEntity(D detail);

    void updateConvertToEntity(E entity, D detail);

    D convertToDetail(E entity);

    I convertToInfo(E entity);
}

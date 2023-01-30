package com.example.googlelogin.model.factory;

import lombok.Getter;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Objects;

@Getter
public abstract class BaseData<T extends Serializable> implements IBaseData<T>, Serializable {

    @Valid
    protected T id;

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseData<?> baseData = (BaseData<?>) obj;
        return Objects.equals(id, baseData.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

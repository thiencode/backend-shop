package com.example.googlelogin.model.factory;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import java.io.Serializable;
import java.util.Objects;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public abstract class BaseData<T extends Serializable> implements IBaseData<T>,
                                                                  Serializable {
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

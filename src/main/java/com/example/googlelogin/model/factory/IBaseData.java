package com.example.googlelogin.model.factory;

import java.io.Serializable;

public interface IBaseData<T> extends Serializable {

    T getId();
}

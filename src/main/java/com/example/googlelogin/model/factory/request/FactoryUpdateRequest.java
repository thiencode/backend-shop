package com.example.googlelogin.model.factory.request;

import com.example.googlelogin.model.factory.IBaseData;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class FactoryUpdateRequest<I, T extends IBaseData<I>> {
    @NotNull
    I id;

    @NotNull
    @Valid
    T data;
}

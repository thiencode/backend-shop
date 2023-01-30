package com.example.googlelogin.modules.product.model;

import com.example.googlelogin.model.factory.BaseData;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class ProductInfo extends BaseData<UUID> {

    private String name;

    private String ProductCode;

    private String image;

    private int quantity;

    private double price;

    private String status;

}

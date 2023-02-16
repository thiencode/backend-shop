package com.example.googlelogin.modules.product.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder(toBuilder = true)
public class ProductDetail extends ProductInfo {


    private String description;

    private String brand;

    private String quantity;

    private String unit;

    private String type;
}

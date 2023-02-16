package com.example.googlelogin.modules.product.factory;

import com.example.googlelogin.factory.IDataFactory;
import com.example.googlelogin.modules.product.model.ProductDetail;
import com.example.googlelogin.modules.product.model.ProductInfo;

import java.util.UUID;

public interface IProductFactory extends IDataFactory<UUID, ProductInfo, ProductDetail> {
}

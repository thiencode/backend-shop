package com.example.googlelogin.modules.product.controller;

import com.example.googlelogin.controller.*;
import com.example.googlelogin.model.filter.IFilter;
import com.example.googlelogin.modules.product.model.ProductDetail;
import com.example.googlelogin.modules.product.model.ProductInfo;

import java.util.UUID;

public interface IProductController extends
        ICreateModelController<UUID, ProductDetail>,
        IGetInfoListController<UUID, ProductInfo>,
        IGetDetailByIdController<UUID, ProductDetail>,
        IGetInfoPageWithFilterController<UUID, ProductInfo, IFilter>,
        IUpdateModelController<UUID, ProductDetail>,
        IDeleteModelByIdController<UUID> {
}

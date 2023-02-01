package com.example.googlelogin.modules.product.controller.impl;

import com.example.googlelogin.controller.BaseController;
import com.example.googlelogin.factory.IDataFactory;
import com.example.googlelogin.model.factory.request.FactoryUpdateRequest;
import com.example.googlelogin.model.factory.response.BasePagingResponse;
import com.example.googlelogin.model.factory.response.BaseResponse;
import com.example.googlelogin.model.factory.response.FactoryDeleteResponse;
import com.example.googlelogin.model.factory.response.IResponseFactory;
import com.example.googlelogin.model.filter.IFilter;
import com.example.googlelogin.modules.product.controller.IProductController;
import com.example.googlelogin.modules.product.model.ProductDetail;
import com.example.googlelogin.modules.product.model.ProductInfo;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/product")
@Tag(name = "product")
public class ProductController extends BaseController<UUID, ProductInfo, ProductDetail> implements IProductController {
    protected ProductController(IResponseFactory iResponseFactory, IDataFactory<UUID, ProductInfo, ProductDetail> iDataFactory) {
        super(iResponseFactory, iDataFactory);
    }

    @Override
    public ResponseEntity<BaseResponse<ProductDetail>> createModel(ProductDetail request) {
        return super.factoryCreateModel(request);
    }

    @Override
    public ResponseEntity<BaseResponse<FactoryDeleteResponse>> deleteModelById(UUID id) throws Exception {
        return super.factoryDeleteWithFilter(id, null);
    }

    @Override
    public ResponseEntity<BaseResponse<ProductDetail>> getDetailById(UUID id) throws Exception {
        return super.factoryGetDetailById(id);
    }

    @Override
    public ResponseEntity<BaseResponse<List<ProductInfo>>> getInfoList() {
        return super.factoryGetInfoListWithFilter(null);
    }

    @Override
    public ResponseEntity<BaseResponse<BasePagingResponse<ProductInfo>>> getInfoPageWithFilter(IFilter filter, Integer number, Integer size) {
        return null;
    }

    @Override
    public ResponseEntity<BaseResponse<ProductDetail>> updateModel(FactoryUpdateRequest<UUID, ProductDetail> request) throws Exception {
        return super.factoryUpdateModel(request);
    }
}

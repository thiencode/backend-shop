package com.example.googlelogin.modules.product.factory.impl;

import com.example.googlelogin.factory.BasePersistDataFactory;
import com.example.googlelogin.model.factory.response.BasePagingResponse;
import com.example.googlelogin.model.filter.IFilter;
import com.example.googlelogin.modules.product.entity.ProductEntity;
import com.example.googlelogin.modules.product.factory.IProductFactory;
import com.example.googlelogin.modules.product.model.ProductDetail;
import com.example.googlelogin.modules.product.model.ProductInfo;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProductFactory extends BasePersistDataFactory<UUID, ProductInfo, ProductDetail, UUID, ProductEntity> implements IProductFactory {
    protected ProductFactory(PagingAndSortingRepository<ProductEntity, UUID> repository) {
        super(repository);
    }

    @Override
    public ProductEntity createConvertToEntity(ProductDetail detail) {
        return ProductEntity.builder()
                .name(detail.getName())
                .productCode(detail.getProductCode())
                .image(detail.getImage())
                .quantity(detail.getQuantity())
                .brand(detail.getBrand())
                .status(detail.getStatus())
                .description(detail.getDescription())
                .price(detail.getPrice())
                .type(detail.getType())
                .unit(detail.getUnit())
                .build();
    }

    @Override
    public void updateConvertToEntity(ProductEntity entity, ProductDetail detail) {
        entity.setName(detail.getName());
        entity.setProductCode(detail.getProductCode());
        entity.setImage(detail.getImage());
        entity.setQuantity(detail.getQuantity());
        entity.setBrand(detail.getBrand());
        entity.setStatus(detail.getStatus());
        entity.setDescription(detail.getDescription());
        entity.setPrice(detail.getPrice());
        entity.setType(detail.getType());
        entity.setUnit(detail.getUnit());
    }

    @Override
    public ProductDetail convertToDetail(ProductEntity entity) {
        return ProductDetail.builder()
                .id(entity.getId())
                .name(entity.getName())
                .productCode(entity.getProductCode())
                .image(entity.getImage())
                .quantity(entity.getQuantity())
                .brand(entity.getBrand())
                .status(entity.getStatus())
                .description(entity.getDescription())
                .price(entity.getPrice())
                .type(entity.getType())
                .unit(entity.getUnit())
                .build();
    }

    @Override
    public ProductInfo convertToInfo(ProductEntity entity) {
        return ProductInfo.builder()
                .id(entity.getId())
                .name(entity.getName())
                .productCode(entity.getProductCode())
                .image(entity.getImage())
                .price(entity.getPrice())
                .status(entity.getStatus())
                .build();
    }

    @Override
    protected ProductDetail didCreate(ProductDetail detail) {
        return super.didCreate(detail);
    }

    @Override
    protected ProductDetail didUpdate(UUID id, ProductDetail detail) throws Exception {
        return super.didUpdate(id, detail);
    }

    @Override
    protected <F extends IFilter> void didDelete(UUID id, F filter) throws Exception {
        super.didDelete(id, filter);
    }

    @Override
    protected <F extends IFilter> List<ProductInfo> didGetInfoList(F filter) {
        return super.didGetInfoList(filter);
    }

    @Override
    protected List<ProductInfo> didGetInfoList() {
        return super.didGetInfoList();
    }

    @Override
    protected <F extends IFilter> ProductDetail didGetDetailModel(UUID id, F filter) throws Exception {
        return super.didGetDetailModel(id, filter);
    }

    @Override
    protected <F extends IFilter> BasePagingResponse<ProductInfo> didGetInfoPage(F filter, Integer number, Integer size) {
        return super.didGetInfoPage(filter, number, size);
    }

    @Override
    protected Iterable<ProductEntity> listQuery() {
        return super.listQuery();
    }

    @Override
    protected <F extends IFilter> Page<ProductEntity> pageQuery(F filter, Integer number, Integer size) {
        return super.pageQuery(filter, number, size);
    }
}

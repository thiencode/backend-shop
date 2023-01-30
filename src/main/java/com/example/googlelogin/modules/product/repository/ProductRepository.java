package com.example.googlelogin.modules.product.repository;

import com.example.googlelogin.modules.product.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
    ProductEntity findProductByName(String productName);
}

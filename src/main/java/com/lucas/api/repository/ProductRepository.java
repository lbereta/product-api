package com.lucas.api.repository;

import com.lucas.api.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository <ProductEntity, Long> {
}

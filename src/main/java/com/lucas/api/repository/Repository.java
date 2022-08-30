package com.lucas.api.repository;

import com.lucas.api.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Repository extends JpaRepository <Product, Long> {
}

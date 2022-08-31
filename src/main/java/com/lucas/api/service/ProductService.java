package com.lucas.api.service;

import com.lucas.api.entity.ProductEntity;
import com.lucas.api.exception.ProductNotFoundException;
import com.lucas.api.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity toSave(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

    public List<ProductEntity> toList() {
        return productRepository.findAll();
    }

    public Optional<ProductEntity> toSearchById(Long id) {
        return Optional.ofNullable(productRepository.findById(id).orElseThrow(ProductNotFoundException::new));
    }

    public void toRemove(Long id) {
        productRepository.deleteById(id);
    }
}

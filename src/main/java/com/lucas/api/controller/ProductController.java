package com.lucas.api.controller;

import com.lucas.api.entity.ProductEntity;
import com.lucas.api.service.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity) { return productService.toSave(productEntity); }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProductEntity> productList() { return productService.toList(); }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<ProductEntity> searchByIdProduct(@PathVariable("id") Long id) { return productService.toSearchById(id); }

    public void removeProduct(@PathVariable("id") Long id) {
        productService.toSearchById(id)
                .map(productEntity -> {
                    productService.toRemove(productEntity.getId());
                    return null;
                });
    }

    public void updateProduct(@PathVariable("id") Long id, @RequestBody ProductEntity productEntity) {
        productService.toSearchById(id)
                .map(productEntityBase -> {
                    modelMapper.map(productEntity, productEntityBase);
                    productService.toSave(productEntityBase);
                    return null;
                });
    }
}

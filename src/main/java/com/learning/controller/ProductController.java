package com.learning.controller;

import com.learning.entity.EmployeeEntity;
import com.learning.entity.ProductEntity;
import com.learning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;
    //return type ProductEntity and request payload productEntity
    @PostMapping("saveProduct")
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity){
        ProductEntity saveProduct = productRepository.save(productEntity);
       return saveProduct;

    }

    @GetMapping("getProduct/{id}")
    public ProductEntity getProductById(@PathVariable long id){
        Optional<ProductEntity> productEntity = productRepository.findById(id);
        return productEntity.get();

    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProductById(@PathVariable long id){
          productRepository.deleteById(id);

    }
    @GetMapping("getAllProduct")
    public List<ProductEntity> getAllProduct(){
        List<ProductEntity> productEntities = productRepository.findAll();
        return  productEntities;
    }

    @PutMapping("updateProduct/{id}")
    public ProductEntity updateProduct(@PathVariable long id, @RequestBody ProductEntity updatedEntity){
        Optional<ProductEntity> savedProduct = productRepository.findById(id);
        ProductEntity productEntity = savedProduct.get();
        productEntity.setProductName(updatedEntity.getProductName());
        productEntity.setProductPrice(updatedEntity.getProductPrice());
        productEntity.setAvailable(updatedEntity.isAvailable());
        ProductEntity updatedProduct = productRepository.save(productEntity);
        return updatedProduct;
    }

}

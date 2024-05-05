package com.learning.service;

import com.learning.entity.ProductEntity;
import com.learning.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductEntity saveProduct(ProductEntity productEntity){
        ProductEntity saveProduct = productRepository.save(productEntity);
        return saveProduct;
    }
    public ProductEntity getProductById(long id){
        Optional<ProductEntity> saveProductbyId = productRepository.findById(id);
        return saveProductbyId.get();
    }

    public void deleteProductById(long id){
        productRepository.deleteById(id);
    }

    public List<ProductEntity> getAllProduct(){
        List<ProductEntity> all = productRepository.findAll();
        return all;
    }
    public ProductEntity updateProduct(long id, ProductEntity updateEntity){
        Optional<ProductEntity> savedProduct = productRepository.findById(id);
        ProductEntity productEntity = savedProduct.get();
        productEntity.setProductName(updateEntity.getProductName());
        productEntity.setProductPrice(updateEntity.getProductPrice());
        productEntity.setAvailable(updateEntity.isAvailable());
        ProductEntity updatedProduct = productRepository.save(productEntity);
        return updatedProduct;
    }

}

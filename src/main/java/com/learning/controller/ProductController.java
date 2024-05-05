package com.learning.controller;

import com.learning.entity.EmployeeEntity;
import com.learning.entity.ProductEntity;
import com.learning.repository.ProductRepository;
import com.learning.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;
    //return type ProductEntity and request payload productEntity
    @PostMapping("saveProduct")
    public ProductEntity saveProduct(@RequestBody ProductEntity productEntity){
        ProductEntity saveProduct = productService.saveProduct(productEntity);
       return saveProduct;

    }

    @GetMapping("getProduct/{id}")
    public ProductEntity getProductById(@PathVariable long id){
        ProductEntity productEntity = productService.getProductById(id);
        return productEntity;
    }

    @DeleteMapping("deleteProduct/{id}")
    public void deleteProductById(@PathVariable long id){
          productService.deleteProductById(id);

    }
    @GetMapping("getAllProduct")
    public List<ProductEntity> getAllProduct(){
        List<ProductEntity> productEntities = productService.getAllProduct();
        return  productEntities;
    }

    @PutMapping("updateProduct/{id}")
    public ProductEntity updateProduct(@PathVariable long id, @RequestBody ProductEntity updatedEntity){
        ProductEntity updatedEntity1 = productService.updateProduct(id, updatedEntity);
        return updatedEntity1;
    }


}

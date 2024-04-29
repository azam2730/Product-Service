package com.learning.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class ProductEntity {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productName;
    private int productPrice;
    private boolean available;

}



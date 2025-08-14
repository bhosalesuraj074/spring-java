package com.bigbasket.models;

import jakarta.persistence.*;
import lombok.Data;

// Example of ProductInfo.java with @Column
@Entity
@Data
@Table(name = "ProductInfo")
public class ProductInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "product_name")
    private String info;
}
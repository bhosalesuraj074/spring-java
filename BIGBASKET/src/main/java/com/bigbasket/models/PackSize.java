package com.bigbasket.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "PackSize")
public class PackSize {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String size;
    private Double price;
}
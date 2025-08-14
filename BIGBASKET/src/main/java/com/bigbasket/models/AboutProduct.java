package com.bigbasket.models;

import jakarta.persistence.Id;
import lombok.Data;
import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;


@Entity
@Data
@Table(name = "AboutProduct")
public class AboutProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    private String eanCode;
    private String country;
    private String fssaiNo;
    private LocalDate expiryDate;
    private String disclaimer;
}
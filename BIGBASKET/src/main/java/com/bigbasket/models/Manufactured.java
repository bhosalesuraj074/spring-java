package com.bigbasket.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "Manufactured")
public class Manufactured {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    private String houseNo;
    private String street;
    private String city;
    private String state;
    private String country;
    private String pinCode;

    public Manufactured(String companyName, String houseNo, String street, String city, String state, String country, String pinCode) {
        this.companyName = companyName;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
    }

}
package com.bigbasket.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "ContactDetails")
public class ContactDetails {
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
    private String email;

    public ContactDetails() {
        super();
    }

    public ContactDetails(Long id, String email) {
        this.id = id;
        this.email = email;
    }

    public ContactDetails(String companyName, String houseNo, String street, String city, String state, String country, String pinCode, Long id, String email) {
        this.companyName = companyName;
        this.houseNo = houseNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.id = id;
        this.email = email;
    }
}
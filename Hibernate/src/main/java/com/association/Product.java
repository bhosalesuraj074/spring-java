package com.association;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String brandName;

    @ManyToMany()
    private List<User> users;

    public Product() {
    }

    public Product(int id, String brandName, List<User> users) {
        this.id = id;
        this.brandName = brandName;
        this.users = users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}

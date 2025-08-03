package com.association;


import jakarta.persistence.*;

@Entity
@Table(name = "Person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id ;

    @Column(name = "Name")
    private String name;
    @OneToOne
    @JoinColumn(name = "Person_passport")
    private Passport passport;

    public Person() {
    }

    public Person(int id, String name, Passport passport) {
        this.id = id;
        this.name = name;
        this.passport = passport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }
}

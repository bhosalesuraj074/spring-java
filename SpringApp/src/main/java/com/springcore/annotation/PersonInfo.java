package com.springcore.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class PersonInfo {
    @Autowired
    @Qualifier(value = "student")
    /*@Qualifier(value = "employee")*/
    private Person person;

    public PersonInfo() {
    }

    public PersonInfo(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }
    public void setPerson(Person person) {
        this.person = person;
    }
}

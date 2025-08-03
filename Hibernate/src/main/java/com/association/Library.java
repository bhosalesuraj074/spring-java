package com.association;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @Column
    private String libraryName;

    @OneToMany( mappedBy = "library", cascade =  CascadeType.ALL)
    private List<Book> books;

    public Library() {
    }

    public Library(int id, String libraryName, List<Book> books) {
        this.id = id;
        this.libraryName = libraryName;
        this.books = books;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibraryName() {
        return libraryName;
    }

    public void setLibraryName(String libraryName) {
        this.libraryName = libraryName;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}

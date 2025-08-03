package com.association;

import jakarta.persistence.*;

@Entity
@Table
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bookId;

    @Column
    private String bookName;

    @ManyToOne
    @JoinColumn(name = "libook_id")
    private Library  library;

    public Book() {
    }

    public Book(int bookId, String bookName) {
        this.bookId = bookId;
        this.bookName = bookName;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public Library getLibrary() {
        return library;
    }

    public void setLibrary(Library library) {
        this.library = library;
    }
}

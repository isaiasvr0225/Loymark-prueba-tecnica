package com.loymark.domain;

/**
 * @package : com.loymark.domain
 * @name : Book.java
 * @date : 2024-09
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */
public abstract class Book {
    protected String title;
    protected String author;
    protected String isbn;

    public Book() {
    }

    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * This method is used to show the book details, depending on the type of book implemented
     * @return String
     */
    public abstract String showBookDetails();

    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}';
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

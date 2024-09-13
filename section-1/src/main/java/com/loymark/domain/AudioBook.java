package com.loymark.domain;

/**
 * @package : com.loymark.domain
 * @name : AudioBook.java
 * @date : 2024-09
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */
public class AudioBook extends Book{

    private double length;

    public AudioBook() {
    }

    public AudioBook(String title, String author, String isbn, double length) {
        super(title, author, isbn);
        this.length = length;
    }

    /**
     * This method is used to show the AudioBook details, this method is implemented from the Book class
     * @return String
     */
    @Override
    public String showBookDetails() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "AudioBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                ", length=" + length +
                '}';
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }
}

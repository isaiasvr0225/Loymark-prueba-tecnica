package com.loymark.domain;

/**
 * @package : com.loymark.domain
 * @name : EBook.java
 * @date : 2024-09
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */
public class EBook extends Book {

    public double fileSize;

    public EBook() {}

    public EBook(String title, String author, String isbn, double fileSize) {
        super(title, author, isbn);
        this.fileSize = fileSize;
    }

    /**
     * This method is used to show the EBook details, this method is implemented from the Book class
     * @return String
     */
    @Override
    public String showBookDetails() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "EBook{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                "fileSize=" + fileSize +
                '}';
    }

    public double getFileSize() {
        return fileSize;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }
}

package com.loymark.domain;

/**
 * @package : com.loymark.domain
 * @name : AudioBook.java
 * @date : 2024-09
 * @author  : Isaias Villarreal
 * @version : 1.0.0
 */
public class Library {

    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * This method is used to add a book to the library
     * @param Book book
     */
    public void addBook(Book book) {
        this.books.add(book);
    }

    /**
     * This method is used to get a book by title
     * @param String title
     * @return Book
     */
    public Book getBookByTitle(String title) {
        try {
            return this.books.stream()
                    .filter(book -> book.getTitle().equals(title))
                    .findFirst()
                    .orElseThrow(() -> new Exception("Book not found"));
        } catch (Exception e) {
            e.printStackTrace(); //Not the best practice, but for this example is ok

        }
        return null;
    }


}

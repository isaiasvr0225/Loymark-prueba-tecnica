package com.loymark.service;

import com.loymark.domain.Book;

public interface LibraryService {

    void addBook(Book book);

    Book getBookByTitle(String title);
}

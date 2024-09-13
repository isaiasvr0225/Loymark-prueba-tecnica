package com.loymark;

import com.loymark.domain.AudioBook;
import com.loymark.domain.Book;
import com.loymark.domain.EBook;

public class Main {

    public static void main(String[] args) {
        Book eBook = new EBook("Java Programming", "John Doe", "1234567890", 10.5);
        Book audioBook = new AudioBook("Java Programming", "John Doe", "1234567890", 5);

        System.out.println(eBook.showBookDetails());
        System.out.println(audioBook.showBookDetails());
    }
}

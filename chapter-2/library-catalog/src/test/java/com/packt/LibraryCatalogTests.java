package com.packt;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class LibraryCatalogTests {
    private LibraryCatalog library;

    @Before
    public void setUp() {
        library = new LibraryCatalog();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Book D", "Author 4");
        library.addBook(book);

        assertEquals(1, library.getCatalogSize());
    }

    @Test
    public void testListBooks() {
        library.addBook(new Book("Book A", "Author 1"));
        library.addBook(new Book("Book B", "Author 2"));
        library.addBook(new Book("Book C", "Author 3"));

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Book A", "Author 1"));
        listOfBooks.add(new Book("Book B", "Author 2"));
        listOfBooks.add(new Book("Book C", "Author 3"));
        assertEquals(listToString(listOfBooks), listToString(library.listBooks()));
    }

    @Test
    public void testListBooksNegative() {
        library.addBook(new Book("Book A", "Author 1"));
        library.addBook(new Book("Book B", "Author 2"));
        library.addBook(new Book("Book C", "Author 3"));

        List<Book> listOfBooks = new ArrayList<>();
        listOfBooks.add(new Book("Book A", "Author 4"));
        listOfBooks.add(new Book("Book B", "Author 2"));
        listOfBooks.add(new Book("Book C", "Author 3"));
        assertNotEquals(listToString(listOfBooks), listToString(library.listBooks()));
    }

    public static String listToString(List<Book> list) {
        StringBuilder sb = new StringBuilder();

        for (Book item : list) {
            sb.append(item);
            sb.append("\n"); // Add a newline for each item
        }

        return sb.toString();
    }
}
package com.packt;

import java.util.ArrayList;
import java.util.List;

public class LibraryCatalog {
    private List<Book> catalog;

    public LibraryCatalog() {
        catalog = new ArrayList<>();
    }

    public void addBook(Book book) {
        catalog.add(book);
    }

    public List<Book> listBooks() {
        return catalog;
    }

    public int getCatalogSize() {
        return catalog.size();
    }

    public static void main(String[] args) {
        LibraryCatalog library = new LibraryCatalog();

        library.addBook(new Book("Terraform Cookbook", "Mikael Krief"));
        library.addBook(new Book("Mastering Kubernetes", "Gigi Sayfan"));
        library.addBook(new Book("Docker Deep Dive", "Nigel Poulton"));

        System.out.println("Library Catalog:");
        for (Book book : library.listBooks()) {
            System.out.println(book);
        }
    }
}


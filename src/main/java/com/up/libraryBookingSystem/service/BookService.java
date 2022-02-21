package com.up.libraryBookingSystem.service;

import com.up.libraryBookingSystem.dao.BooksDao;
import com.up.libraryBookingSystem.pojo.Books;

public class BookService {
    private BooksDao booksDao;

    public BookService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    public void addBook(Books book) {

    }
    }



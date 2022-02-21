package com.up.libraryBookingSystem.service;

import com.up.libraryBookingSystem.dao.BooksDao;
import com.up.libraryBookingSystem.pojo.Books;

public class BookService {
    private BooksDao booksDao;

    public BookService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    //adding book
   //todo: check if book already exists
   //todo: check that every field is filled (not null)

    //deleting book
    //todo: check if book already exists
    //todo: check if book is on loan (don't delete if loaned)

    //updating book -used to assign (loan) book to user
    //todo: check if book is on loan
    }



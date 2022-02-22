package com.up.libraryBookingSystem.service;

import com.up.libraryBookingSystem.dao.BooksDao;
import com.up.libraryBookingSystem.pojo.Authors;
import com.up.libraryBookingSystem.pojo.Books;

import java.util.List;

public class BookService {
    private BooksDao booksDao;

    public BookService(BooksDao booksDao) {
        this.booksDao = booksDao;
    }

    private boolean bookExists(Integer bookId) {
        return booksDao
                .displayBooks()
                .stream()
                .anyMatch(author -> author.getBookId().equals(bookId));

    }

    public void addBook(Books book) {
        boolean exists = bookExists(book.getBookId());
        if (!exists && book.getTitle().isEmpty() && book.getTitle() == null) {
            booksDao.addBook(book);
        } else {
            throw new IllegalStateException("Author already exists");
        }
    }

    public void deleteBook(Integer bookId, Books book) {
        boolean exists = bookExists(bookId);
        if (!exists && book.isLoaned()) {
            throw new IllegalStateException("Author does not exist");
        } else {
            booksDao.deleteBook(bookId);
        }
    }

    public void updateBook(Integer bookId, Books book) {
        boolean exists = bookExists(bookId);
        int result = booksDao.updateBook(bookId, book);
        if (result != 1 && book.isLoaned()) { //if result isn't one then you know that something failed.
            throw new IllegalStateException("Could not update car in database. Input not valid");
        }
    }

    public List<Books> displayBooks() {
        return booksDao.displayBooks();
    }

    public Books selectBookById(Integer bookId) {
        return  booksDao.selectBookById(bookId);
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



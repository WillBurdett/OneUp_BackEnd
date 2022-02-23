package com.up.libraryBookingSystem.service;

import com.up.libraryBookingSystem.ENUMS.GENRES;
import com.up.libraryBookingSystem.dao.BooksDao;
import com.up.libraryBookingSystem.pojo.Books;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BooksDao booksDao;

    public BookService(@Qualifier("books") BooksDao booksDao) {
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
        if (!exists || (book.getTitle().isEmpty() || book.getTitle() == null)) {
            booksDao.addBook(book);
        } else {
            throw new IllegalStateException("Book already exists");
        }
    }

    public void deleteBook(Integer bookId) {
        boolean exists = bookExists(bookId);
        if (!exists /*&& book.isLoaned()*/) {
            throw new IllegalStateException("Book does not exist");
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

    public Books selectBookByTitle(String bookTitle){return booksDao.selectBookByTitle(bookTitle);}

    public List<Books> displayBooksByGenre(GENRES genre) {
        return booksDao.displayBooksByGenre(genre);
    }


    public void assignUserToBook(Integer bookId, Integer userID){
        booksDao.assignUserToBook(bookId, userID);
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



package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Books;

import java.util.List;

public interface BooksDao {
    int deleteBook(Integer BookId);

    int updateBook(Integer BookId, Books bookUpdate);

    Books selectBookById(Integer BookId);

    Books selectBookByTitle(String bookTitle);

    int addBook(Books book);

    List<Books> displayBooks();

}

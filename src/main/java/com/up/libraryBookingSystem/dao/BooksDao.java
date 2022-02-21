package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Books;

import java.util.List;

public interface BooksDao {
    int addBook();

    List<Books> selectAllBooks();

    int deleteBook(Integer BookId);

    int updateBook(Integer BookId, Books bookUpdate);

    boolean selectBookById(Integer BookId);
}

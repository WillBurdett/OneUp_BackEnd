package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Books;

import java.util.List;

public interface BooksDao {
    Integer deleteBook(Integer BookId);

    Integer updateBook(Integer BookId, Books bookUpdate);

    Books selectBookById(Integer BookId);

    Books selectBookByTitle(String bookTitle);

    Integer addBook(Books book);

    List<Books> displayBooks();

    boolean isLoaned(Books book);

    Books selectBookByAuthorId(Integer AuthorId);

}

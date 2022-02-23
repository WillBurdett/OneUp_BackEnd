package com.up.libraryBookingSystem.service;


import com.up.libraryBookingSystem.dao.AuthorsDao;
import com.up.libraryBookingSystem.dao.BooksDao;
import com.up.libraryBookingSystem.pojo.Authors;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorsDao authorsDao;
//    private BooksDao booksDao;

//    public AuthorService() {
//    }

    public AuthorService(@Qualifier("authors") AuthorsDao authorsDao) {
        this.authorsDao = authorsDao;
    }

//    public AuthorService(@Qualifier("books") BooksDao booksDao) {
//        this.booksDao = booksDao;
//    }


    private boolean authorExists(Integer authorId) {
        return authorsDao
                .displayAuthors()
                .stream()
                .anyMatch(author -> author.getAuthorId().equals(authorId));

//
    }

    public void addAuthor(Authors author) {
        boolean exists = authorExists(author.getAuthorId());
        if (!exists) {
            authorsDao.addAuthors(author);
        } else {
            throw new IllegalStateException("Author already exists");
        }

    }

    public void deleteAuthor(Integer authorId) {
        boolean exists = authorExists(authorId);
        if (!exists) {
            throw new IllegalStateException("Author does not exist");
//        } else if (booksDao.selectBookByAuthorId(authorId) != null) {
//            throw new IllegalStateException("Author has book in library");
        }else{
            authorsDao.deleteAuthor(authorId);
        }//else if author has books throw exception
    }

    public void updateAuthor(Integer authorId, Authors author) {
        boolean exists = authorExists(authorId);

        int result = authorsDao.updateAuthor(authorId, author);

        if (result != 1) { //if result isn't one then you know that something failed.
            throw new IllegalStateException("Could not update author in database. Input not valid");
        }
    }

    public List<Authors> displayAuthors() {
        return authorsDao.displayAuthors();
    }

    public Authors selectAuthorById(Integer authorId) {
        return  authorsDao.selectAuthorById(authorId);
    }

    public Authors selectAuthorByName(String authorName) {
        return authorsDao.selectAuthorByName(authorName);
    }


}


//adding author
//todo: check if author already exists


//todo: check fields are not null


//deleting author
//todo: check if author has any related books. only delete author if they don't have books in our system.

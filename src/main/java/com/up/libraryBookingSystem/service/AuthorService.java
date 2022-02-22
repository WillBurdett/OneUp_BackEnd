package com.up.libraryBookingSystem.service;


import com.up.libraryBookingSystem.dao.AuthorsDao;
import com.up.libraryBookingSystem.pojo.Authors;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {

    private AuthorsDao authorsDao;

    public AuthorService(AuthorsDao authorsDao) {
        this.authorsDao = authorsDao;
    }

    private boolean authorExists(Integer authorId){
        return authorsDao
                .displayAuthors()
                .stream()
                .anyMatch(author -> author.getAuthorId().equals(authorId));

//
    }
    public void addAuthor(Authors author){
        boolean exists = authorExists(author.getAuthorId());
        if (!exists && author.getName().isEmpty() && author.getName()==null){
            authorsDao.addAuthors(author);
        }else{
            throw new IllegalStateException("Author already exists");
        }



    }




}





//adding author
//todo: check if author already exists


//todo: check fields are not null



//deleting author
//todo: check if author has any related books. only delete author if they don't have books in our system.

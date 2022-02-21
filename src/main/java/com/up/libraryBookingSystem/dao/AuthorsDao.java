package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.ENUMS.GENRES;
import com.up.libraryBookingSystem.pojo.Authors;

import java.util.List;

public interface AuthorsDao {

    Authors selectAuthorById(Integer authorId);

    int addAuthors(Authors author);
    List<Authors> displayAuthors();
    int deleteAuthor(Integer authorId);
}

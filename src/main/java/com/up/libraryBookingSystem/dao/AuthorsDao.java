package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Authors;

import java.util.List;

public interface AuthorsDao {
    int selectAuthors();
    int addAuthors();
    List<Authors> displayAuthors();



}

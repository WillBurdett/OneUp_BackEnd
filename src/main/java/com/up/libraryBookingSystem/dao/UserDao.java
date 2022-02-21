package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Users;

import java.util.List;

public interface UserDao {
    int addUser();

    List<Users> selectAllUsers();

    int deleteUser(Integer UserId);

    int updateUser(Integer UserId, Users UserUpdate);

    List<Users> selectUserById(Integer Userid);
}

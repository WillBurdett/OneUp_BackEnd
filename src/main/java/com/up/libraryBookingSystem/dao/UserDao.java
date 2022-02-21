package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Users;

import java.util.List;

public interface UserDao {
    int addUser(Users user);

    List<Users> selectAllUsers();

    int deleteUser(Integer userId);

    int updateUser(Integer userId, Users userUpdate);

    List<Users> selectUserById(Integer userId);
}

package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Users;

import java.util.List;

public class UserDataAccessService implements UserDao{
    @Override
    public int addUser() {
        return 1;
    }

    @Override
    public List<Users> selectAllUsers() {

        return null;
    }

    @Override
    public int deleteUser(Integer UserId) {
        return 0;
    }

    @Override
    public int updateUser(Integer UserId, Users UserUpdate) {
        return 0;
    }

    @Override
    public List<Users> selectUserById(Integer UserId) {
        return null;
    }
}
//test for branching
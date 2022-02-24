package com.up.libraryBookingSystem.service;
//todo: business logic checks

import com.up.libraryBookingSystem.dao.UserDao;
import com.up.libraryBookingSystem.pojo.Users;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserDao usersDao;

    public UserService(@Qualifier("users") UserDao usersDao) {
        this.usersDao = usersDao;
    }

    private boolean userExists(Integer userId) {
        return usersDao
                .selectAllUsers()
                .stream()
                .anyMatch(user -> user.getSerialID().equals(userId));
    }

    private boolean passwordSecure(String password) {

        boolean hasLetter = false;
        boolean hasDigit = false;

        if (password.length() >= 8) {
            for (int i = 0; i < password.length(); i++) {
                char x = password.charAt(i);
                if (Character.isLetter(x)) {
                    hasLetter = true;
                } else if (Character.isDigit(x)) {
                    hasDigit = true;
                }
                // no need to check further, break the loop because it's true
                if (hasLetter && hasDigit) {
                    return true;
                }
            }
            if (hasLetter && hasDigit) {
            } else {
                throw new IllegalStateException("PASSWORD NEEDS NUMBERS AND LETTERS");
            }
        } else {
            throw new IllegalStateException("PASSWORD NEEDS AT LEAST 8 CHARACTERS");
        }
        return false;
    }

    public void addUser(Users user) {
        boolean exists = userExists(user.getSerialID());
        boolean secure = passwordSecure(user.getPassword());
        if (exists) {
            throw new IllegalStateException("User already exists");
        } else if (user.getName() == null) {
            throw new IllegalStateException("No name entered.");
        } else if (user.getUsername() == null) {
            throw new IllegalStateException("No username entered");
        } else if (user.getPassword() == null) {
            throw new IllegalStateException("No password entered");
        } else if (!secure) {
            throw new IllegalStateException("Password not secure");
        } else if (user.getManager()) {
            throw new IllegalStateException("Manager already exists.");
        } else {
            usersDao.addUser(user);
        }
    }


    public void deleteUser(Integer userId) {
        boolean exists = userExists(userId);
        if (!exists) {
            throw new IllegalStateException("User does not exist");
        } else {
            usersDao.deleteUser(userId);
        }
    }

    public void updateUser(Integer userId, Users user) {
        boolean exists = userExists(userId);

        int result = usersDao.updateUser(userId, user);

        if (result != 1) { //if result isn't one then you know that something failed.
            throw new IllegalStateException("Could not update user in database. Input not valid");
        }
    }

    public List<Users> displayUsers() {
        return usersDao.selectAllUsers();
    }

    public Users selectUserById(Integer userId) {
        boolean exists = userExists(userId);
        return usersDao.selectUserById(userId);
    }


}

//adding new user
//todo: check if user already exists
//todo: check if username exists
//todo: check all fields are filled (not null)

//deleting user
//todo: check if user exists
//todo: check if user has a loaned book. do not delete if they have a book
//todo: don't delete if boolean isManager is true

//updating user

//


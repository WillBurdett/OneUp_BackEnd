package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.pojo.Users;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("users")
public class UserDataAccessService implements UserDao {

    private JdbcTemplate jdbcTemplate;

    public UserDataAccessService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addUser(Users user) {
        String sql = """
                INSERT INTO users (name, username, isManager, password)
                VALUES (?, ?, ?, ?)
                """;
        int rowsAffected = jdbcTemplate.update(sql,
                user.getName(),
                user.getUsername(),
                user.getManager(),
                user.getPassword());
        return rowsAffected;
    }

    @Override
    public List<Users> selectAllUsers() {
        String sql = """
                SELECT name, username, isManager, user_id
                FROM users
                """; //not including password as we don't want password to be easily accessible for security reasons
        RowMapper<Users> usersRowMapper = ((rs, rowNum) -> {
            Users user = new Users(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("username"),
                    rs.getBoolean("isManager")
            );
            return user;
        });

        List<Users> users = jdbcTemplate.query(sql, usersRowMapper);
        return users;
    }

    @Override
    public int deleteUser(Integer userId) {
        String sql = """
                DELETE * FROM users
                WHERE user_id = ?
                """;

        return jdbcTemplate.update(sql, userId);
    }

    @Override
    public Users selectUserById(Integer userId) {

        String sql = """
                SELECT user_id, name, username, isManager
                FROM users
                WHERE user_id = ?
                """;
        for (int i = 0; i < selectAllUsers().size(); i++) {
            if (selectAllUsers().get(i).getSerialID().equals(userId)) {
                return selectAllUsers().get(i);
            }
        }
        return null;
    }

    @Override
    public int updateUser(Integer userId, Users userUpdate) {
        String sql = """
                UPDATE users 
                SET (name, username, isManager, password) = (?, ?, ?, ?)    
                WHERE userId = ?            
                """;
        return jdbcTemplate.update(
                sql,
                userUpdate.getName(),
                userUpdate.getUsername(),
                userUpdate.getManager(),
                userUpdate.getPassword()
        );
    }


}
//test for branching
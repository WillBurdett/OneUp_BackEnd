package com.up.libraryBookingSystem.dao;

import com.up.libraryBookingSystem.ENUMS.GENRES;
import com.up.libraryBookingSystem.ENUMS.Nationality;
import com.up.libraryBookingSystem.pojo.Authors;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("Postgres")
public class AuthorDataAccessService implements AuthorsDao{

    private JdbcTemplate jdbcTemplate;

    public AuthorDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Authors selectAuthorById(Integer authorId) {

//        String sql = """
//                SELECT author_id, name, nationality, image
//                FROM authors
//                WHERE author_id = ?
//                """;
        for (int i = 0; i < displayAuthors().size() ; i++) {
            if (displayAuthors().get(i).getAuthorId().equals(authorId)){
                return displayAuthors().get(i);
            }

        }


        return null;
    }


    @Override
    public int addAuthors(Authors author) {

        String sql= """
                INSERT INTO authors (name, nationality, image) 
                VALUES (?,?,?)
                """;

        int rowsAffected =jdbcTemplate.update(
                sql,
                author.getName(),
                author.getImage(),
                author.getNationality());

        return rowsAffected;
    }

    @Override
    public List<Authors> displayAuthors() {
        String sql = """
                SELECT author_id, name, nationality, image
                FROM authors 
                WHERE author_id = ?
                """;
        RowMapper<Authors> authorsRowMapper = ((rs, rowNum) -> {
            Authors author = new Authors(
                    rs.getInt("author_id"),
                    rs.getString("name"),
                    Nationality.valueOf(rs.getString("nationality")),
                    rs.getString("image")
            );
            return author;
        });

        List<Authors> authors = jdbcTemplate.query(sql, authorsRowMapper);
        return authors;
    }




}

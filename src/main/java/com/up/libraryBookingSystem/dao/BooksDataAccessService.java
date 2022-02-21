package com.up.libraryBookingSystem.dao;


import com.up.libraryBookingSystem.ENUMS.GENRES;
import com.up.libraryBookingSystem.pojo.Books;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public class BooksDataAccessService implements BooksDao {

    private JdbcTemplate jdbcTemplate;

    public BooksDataAccessService(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Books selectBookById(Integer BookId) {

//        String sql = """
//                SELECT author_id, name, nationality, image
//                FROM authors
//                WHERE author_id = ?
//                """;
        for (int i = 0; i < displayBooks().size() ; i++) {
            if (displayBooks().get(i).getBookId().equals(BookId)){
                return displayBooks().get(i);
            }
        }
        return null;
    }


    @Override
    public int addBook(Books book) {

        String sql= """
                INSERT INTO books (title, genre, author, loaned, ISBN) 
                VALUES (?,?,?,?,?)
                """;

        int rowsAffected =jdbcTemplate.update(
                sql,
                book.getTitle(),
                book.getGenre().name(),
                book.getAuthor(),
                book.isLoaned(),
                book.getISBN()
        );
        return rowsAffected;
    }

    @Override
    public List<Books> displayBooks() {
        String sql = """
                SELECT title, genre, author, loaned, ISBN
                FROM books 
                WHERE book_id = ?
                """;
        RowMapper<Books> booksRowMapper = ((rs, rowNum) -> {
            Books book = new Books(
                    rs.getString("title"),
                    GENRES.valueOf(rs.getString("genre")),
                    rs.getString("author"),
                    rs.getBoolean("loaned"),
                    rs.getInt("ISBN")
            );
            return book;
        });
        List<Books> authors = jdbcTemplate.query(sql, booksRowMapper);
        return authors;
    }


    @Override
    public int deleteBook(Integer bookId) {
        String sql = """
                DELETE * FROM books
                WHERE bookId = ?
                """;
        return jdbcTemplate.update(
                sql,
                bookId);

    }
    @Override
    public int updateBook(Integer bookId, Books bookUpdate){
        String sql = """
                UPDATE books 
                SET (title, genre, author, loaned, ISBN) = (?, ?, ?, ?, ?)    
                WHERE bookId = ?            
                """;
        return jdbcTemplate.update(
                sql,
                bookUpdate.getTitle(),
                bookUpdate.getGenre(),
                bookUpdate.getAuthor(),
                bookUpdate.isLoaned(),
                bookUpdate.getISBN()
        );
    }
}
//test for branch 

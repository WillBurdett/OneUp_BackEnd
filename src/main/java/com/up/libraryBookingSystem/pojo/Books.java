package com.up.libraryBookingSystem.pojo;

import com.up.libraryBookingSystem.ENUMS.GENRES;

import java.util.Objects;

public class Books {

    private Integer bookId;
    private String title;
    private GENRES genre;
    private Integer authorId;
    private Integer userID;
    private boolean loaned;
    private int ISBN;

    public Books(Integer bookId, String title, GENRES genre, Integer authorId, boolean loaned, int ISBN) {
        this.bookId = bookId;
        this.title = title;
        this.genre = genre;
        this.authorId = authorId;
        this.userID = userID;
        this.loaned = loaned;
        this.ISBN = ISBN;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public GENRES getGenre() {
        return genre;
    }

    public void setGenre(GENRES genre) {
        this.genre = genre;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer author) {
        this.authorId = authorId;
    }

    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    public boolean isLoaned() {
        return loaned;
    }

    public void setLoaned(boolean loaned) {
        this.loaned = loaned;
    }

    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
        this.ISBN = ISBN;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Books books = (Books) o;
        return loaned == books.loaned && ISBN == books.ISBN && Objects.equals(bookId, books.bookId) && Objects.equals(title, books.title) && genre == books.genre && Objects.equals(authorId, books.authorId) && Objects.equals(userID, books.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookId, title, genre, authorId, userID, loaned, ISBN);
    }

    @Override
    public String toString() {
        return "Books{" +
                "bookId=" + bookId +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", authorId=" + authorId +
                ", userID=" + userID +
                ", loaned=" + loaned +
                ", ISBN=" + ISBN +
                '}';
    }
}

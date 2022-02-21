package com.up.libraryBookingSystem.pojo;

import com.up.libraryBookingSystem.ENUMS.GENRES;

import java.util.Objects;

public class Books {

    private Integer serialID;
    private String title;
    private GENRES genre;
    private String author;
    private Integer userID;
    private boolean loaned;
    private int ISBN;

    public Books(Integer serialID, String title, GENRES genre, String author, Integer userID, boolean loaned, int ISBN) {
        this.serialID = serialID;
        this.title = title;
        this.genre = genre;
        this.author = author;
        this.userID = userID;
        this.loaned = loaned;
        this.ISBN = ISBN;
    }

    public Integer getSerialID() {
        return serialID;
    }

    public void setSerialID(Integer serialID) {
        this.serialID = serialID;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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
        return loaned == books.loaned && ISBN == books.ISBN && Objects.equals(serialID, books.serialID) && Objects.equals(title, books.title) && genre == books.genre && Objects.equals(author, books.author) && Objects.equals(userID, books.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialID, title, genre, author, userID, loaned, ISBN);
    }

    @Override
    public String toString() {
        return "Books{" +
                "serialID=" + serialID +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", author='" + author + '\'' +
                ", userID=" + userID +
                ", loaned=" + loaned +
                ", ISBN=" + ISBN +
                '}';
    }
}

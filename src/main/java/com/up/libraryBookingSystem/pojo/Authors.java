package com.up.libraryBookingSystem.pojo;

import com.up.libraryBookingSystem.ENUMS.Nationality;

import java.util.Objects;

public class Authors {

    private Integer AuthorId;
    private String name;
    private Nationality nationality;
    private String image;

    public Authors(Integer authorId, String name, Nationality nationality, String image) {
        AuthorId = authorId;
        this.name = name;
        this.nationality = nationality;
        this.image = image;
    }

    public Integer getAuthorId() {
        return AuthorId;
    }

    public void setAuthorId(Integer authorId) {
        AuthorId = authorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Nationality getNationality() {
        return nationality;
    }

    public void setNationality(Nationality nationality) {
        this.nationality = nationality;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Authors authors = (Authors) o;
        return Objects.equals(AuthorId, authors.AuthorId) && Objects.equals(name, authors.name) && nationality == authors.nationality && Objects.equals(image, authors.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(AuthorId, name, nationality, image);
    }

    @Override
    public String toString() {
        return "Authors{" +
                "AuthorId=" + AuthorId +
                ", name='" + name + '\'' +
                ", nationality=" + nationality +
                ", image='" + image + '\'' +
                '}';
    }
}

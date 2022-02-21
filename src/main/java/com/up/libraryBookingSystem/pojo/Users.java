package com.up.libraryBookingSystem.pojo;

import java.util.Objects;

public class Users {

    private Integer serialID;
    private String username;
    private String name;

    public Users(Integer serialID, String username, String name) {
        this.serialID = serialID;
        this.username = username;
        this.name = name;
    }

    public Integer getSerialID() {
        return serialID;
    }

    public void setSerialID(Integer serialID) {
        this.serialID = serialID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Users{" +
                "serialID=" + serialID +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(serialID, users.serialID) && Objects.equals(username, users.username) && Objects.equals(name, users.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialID, username, name);
    }
}

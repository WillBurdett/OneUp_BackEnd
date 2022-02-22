package com.up.libraryBookingSystem.pojo;

import java.util.Objects;

public class Users {

    private Integer serialID;
    private String username;
    private String name;
    private Boolean isManager;
    private String password;


//    public Users(Integer serialID, String username, String name, Boolean isManager, String password) {
//        this.serialID = serialID;
//        this.username = username;
//        this.name = name;
//        this.isManager = isManager;
//        this.password = password;
//    }

    public Users(Integer serialID, String username, String name, Boolean isManager) {
        this.serialID = serialID;
        this.username = username;
        this.name = name;
        this.isManager = isManager;
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

    public Boolean getManager() {
        return isManager;
    }

    public void setManager(Boolean manager) {
        isManager = manager;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Users users = (Users) o;
        return Objects.equals(serialID, users.serialID) && Objects.equals(username, users.username) && Objects.equals(name, users.name) && Objects.equals(isManager, users.isManager) && Objects.equals(password, users.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serialID, username, name, isManager, password);
    }

    @Override
    public String toString() {
        return "Users{" +
                "serialID=" + serialID +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", isManager=" + isManager +
                ", password='" + password + '\'' +
                '}';
    }
}

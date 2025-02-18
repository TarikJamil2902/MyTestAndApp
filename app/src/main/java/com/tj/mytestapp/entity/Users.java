package com.tj.mytestapp.entity;

public class Users {

    public int id;
    public String username, email, password, dob;

    public Users(String username, String email, String password, String dob) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }

    public Users(int id, String username, String email, String password, String dob) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dob = dob;
    }
}

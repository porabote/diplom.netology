package ru.porabote.springbootrestauth.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity // This tells Hibernate to make a table out of this class
public class UserModel {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    public String username;
    public String password;
    public String token;

    public String getPassword() {
        return password;
    }

    public void setPassword(String psw) {
        this.password = psw;
    }

    public String getUsername() {
        return username;
    }
    public void setUsername(String name) {
        this.username = name;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }

    public UserModel(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserModel() {

    }

    public String suUsernameAuthenticationToken() {
        return "some_token";
    }
}

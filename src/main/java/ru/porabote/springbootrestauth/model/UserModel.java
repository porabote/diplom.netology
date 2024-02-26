package ru.porabote.springbootrestauth.model;

public class UserModel {
    public String login;
    public String password;

    public UserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }
}

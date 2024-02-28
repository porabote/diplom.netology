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
    public String login;
    public String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String psw) {
        this.password = psw;
    }

    public String getLogin() {
        return login;
    }
    public void setLogin(String name) {
        this.login = name;
    }

    public UserModel(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public UserModel() {

    }
}

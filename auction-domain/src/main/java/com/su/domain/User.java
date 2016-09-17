package com.su.domain;

public class User {
    private String login;
    private String firstName;
    private String LastName;

    public User(String login, String firstName, String lastName) {
        this.login = login;
        this.firstName = firstName;
        LastName = lastName;
    }

    public String getLogin() {
        return login;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }
}

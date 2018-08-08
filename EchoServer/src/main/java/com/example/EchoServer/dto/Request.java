package com.example.EchoServer.dto;

public class Request {

    private String name;

    private String lastName;

    private String emailUser;

    private String password;


    public Request(String name, String lastName, String emailUser, String password) {
        this.name = name;
        this.lastName = lastName;
        this.emailUser = emailUser;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}

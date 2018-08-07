package com.example.EchoServer.dto;

public class Request {

    private String emailUser;

    public Request(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
}

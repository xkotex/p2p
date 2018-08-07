package com.example.EchoServer.dto;

public class Response {

    private boolean checkEmail;

    public Response(boolean checkEmail) {
        this.checkEmail = checkEmail;
    }

    public boolean isCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(boolean checkEmail) {
        this.checkEmail = checkEmail;
    }
}

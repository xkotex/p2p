package com.example.EchoServer.dto;

public class Response {

    private boolean checkRegistration;

    public Response(boolean checkEmail) {
        this.checkRegistration = checkEmail;
    }

    public boolean isCheckRegistration() {
        return checkRegistration;
    }

    public void setCheckRegistration(boolean checkRegistration) {
        this.checkRegistration = checkRegistration;
    }
}

package com.example.EchoServer.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.InetAddress;

public class UserConnection {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "inet_adress")
    private InetAddress inetAddress;

    @Column(name = "name_user")
    private String user;

    @Column(name = "online")
    private int online;

    public UserConnection(){

    }

    public UserConnection(InetAddress inetAddress, String user, int online) {
        this.inetAddress = inetAddress;
        this.user = user;
        this.online = online;
    }

    public InetAddress getInetAddress() {
        return inetAddress;
    }

    public void setInetAddress(InetAddress inetAddress) {
        this.inetAddress = inetAddress;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;

    }

    public int isOnline() {
        return online;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}

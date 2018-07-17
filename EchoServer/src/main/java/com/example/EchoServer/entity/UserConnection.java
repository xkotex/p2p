package com.example.EchoServer.entity;

import javax.persistence.*;

@Entity
@Table(name = "user_connection")
public class UserConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "inet_adress")
    private String inetAddress;

    /*
    @Column(name = "name_user")
    private String user;
    */

    @Column(name = "online")
    private int online;

    public UserConnection() {

    }

    public void setInetAddress(String inetAddress) {
        this.inetAddress = inetAddress;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}

package com.example.EchoServer.entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "user_connection")
public class UserConnection {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    private LocalDateTime dateTime;

    @Column(name = "inet_adress")
    private String inetAddress;

    @Column(name = "online")
    private int online;

    public UserConnection() {

    }

    public void setInetAddress(String inetAddress) {
        this.inetAddress = inetAddress;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setOnline(int online) {
        this.online = online;
    }
}

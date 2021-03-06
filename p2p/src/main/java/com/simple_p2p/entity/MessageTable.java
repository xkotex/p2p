package com.simple_p2p.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "message_history")
public class MessageTable implements Serializable, EntityUniqueConstrain {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "message_id")
    private int id;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "username")
    private String userName;

    @Column(name = "message")
    private String message;

    public MessageTable() {

    }

    public MessageTable(LocalDateTime created, String userName, String message){
        this.created = created;
        this.userName = userName;
        this.message = message;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getUniqueConstrainName() {
        return "created";
    }

    @Override
    public Object getUniqueConstrainValue() {
        return created;
    }
}

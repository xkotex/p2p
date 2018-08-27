package com.simple_p2p.entity;

public class Chats {

    private Long chatsId;
    private String chatsName;

    public Chats() {

    }

    public Chats(Long usersId, String usersName) {
        super();
        this.chatsId = usersId;
        this.chatsName = usersName;
    }

    public Long getChatsId() {
        return chatsId;
    }

    public void setChatsId(Long usersId) {
        this.chatsId = usersId;
    }

    public String getChatsName() {
        return chatsName;
    }

    public void setChatsName(String usersName) {
        this.chatsName = usersName;
    }

}

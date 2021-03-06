package com.simple_p2p.entity;

public class Users {

    private Long usersId;
    private String usersName;

    public Users() {

    }

    public Users(Long usersId, String usersName) {
        super();
        this.usersId = usersId;
        this.usersName = usersName;
    }

    public Long getUsersId() {
        return usersId;
    }

    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    public String getUsersName() {
        return usersName;
    }

    public void setUsersName(String usersName) {
        this.usersName = usersName;
    }
}

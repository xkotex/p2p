package com.p2p.service;

import com.p2p.model.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}

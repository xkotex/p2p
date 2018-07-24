package com.simple_p2p.service;

import com.simple_p2p.model.User;

public interface UserService {
    User findUserByEmail(String email);
    void saveUser(User user);
}

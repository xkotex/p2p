package com.simple_p2p.service;

import com.simple_p2p.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


	@Override
	public User findUserByEmail(String email) {
		return null;
	}

	@Override
	public void saveUser(User user) {

	}
}

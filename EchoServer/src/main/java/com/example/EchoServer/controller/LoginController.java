package com.example.EchoServer.controller;

import com.example.EchoServer.dto.RequestLogin;
import com.example.EchoServer.dto.ResponseLogin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

public class LoginController {

    @PostMapping("/login")
    @ResponseBody
    public ResponseLogin login(@ModelAttribute RequestLogin requestLogin){
        ResponseLogin responseLogin = null;
        return responseLogin;
    }

}

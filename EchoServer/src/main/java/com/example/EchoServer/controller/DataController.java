package com.example.EchoServer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.sql.DataSource;

@Controller
public class DataController {

    @Autowired
    DataSource dataSource;

    @PostMapping("/data")
    @ResponseBody
    public DataSource login(){
        return dataSource;
    }

}

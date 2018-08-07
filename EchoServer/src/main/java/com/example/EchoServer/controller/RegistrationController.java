package com.example.EchoServer.controller;

import com.example.EchoServer.dto.Request;
import com.example.EchoServer.dto.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.*;

@Controller
public class RegistrationController {

    private static final String DB_URL = "jdbc:mysql://localhost/signal_server";

    private static final String DB_USER = "root";

    private static final String DB_PASSWORD = "root";


    @PostMapping("/registration")
    @ResponseBody
    public Response registration(@ModelAttribute Request request){
        System.out.println(request.getEmailUser());
        Response response;
        if(searchEmailDB(request.getEmailUser()) == true){
            response = new Response(false);
        } else {
            response = new Response(true);
        }
        return response;
    }

    public boolean searchEmailDB(String email){
        boolean check = false;
        String query ="SELECT\n" +
                "  email\n" +
                "FROM signal_server.user\n" +
                "  WHERE email like ? ;";
        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setString(1, email);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()){
                System.out.println(email);
                System.out.println(resultSet.next());
                if(resultSet.getString(1) == email){
                    check = true;
                }
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
        return check;
    }
}

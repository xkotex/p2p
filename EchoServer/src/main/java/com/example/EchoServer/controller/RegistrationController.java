package com.example.EchoServer.controller;

import com.example.EchoServer.dto.Request;
import com.example.EchoServer.dto.Response;
import org.springframework.stereotype.Controller;
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
        System.out.println(request.getName());
        System.out.println(request.getLastName());
        System.out.println(request.getPassword());
        Response response;
        if(searchEmailDB(request.getEmailUser()) == true){
            response = new Response(false);
        } else {
            createUserDb(request);
            response = new Response(true);
        }
        return response;
    }

    public void createUserDb(Request request){
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String query ="INSERT INTO user (name, last_name, email, password)\n" +
                "VALUES ('" + request.getName() + "', '" + request.getLastName() + "', '" + request.getEmailUser() +
                "', '" + request.getPassword() + "');";

        System.out.println(query);

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement()){

            statement.executeUpdate(query);

        } catch (SQLException e){
            e.printStackTrace();
        }
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

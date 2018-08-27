package com.simple_p2p.controller;

import com.simple_p2p.entity.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersDao {

    private static final ArrayList<Users> USERS = new ArrayList<>();

    public static ArrayList<Users> getUSERS() {
        return USERS;
    }

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/signal_server";

    public static void initData() {
        String query = "SELECT\n" +
                "  user_id, last_name\n" +
                "FROM signal_server.user\n" +
                "  WHERE active = 1;";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()){
                USERS.add(new Users(resultSet.getLong(1), resultSet.getString(2)));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Users> getUsers() {
        return USERS;
    }

    public Map<Long, String> getMapUsers() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Users c : USERS) {
            map.put(c.getUsersId(), c.getUsersName());
        }
        return map;
    }

}

package com.simple_p2p.controller;

import com.simple_p2p.entity.Country;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UsersDao {

    private static final ArrayList<Country> USERS = new ArrayList<>();

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/signal_server";

    static {
        initData();
    }

    private static void initData() {
        String query = "SELECT\n" +
                "  user_id, last_name\n" +
                "FROM signal_server.user\n" +
                "  WHERE active = 1;";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()){
                USERS.add(new Country(resultSet.getLong(1), resultSet.getString(2)));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Country> getCountries() {
        return USERS;
    }

    public Map<Long, String> getMapCountries() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Country c : USERS) {
            map.put(c.getUsersId(), c.getUsersName());
        }
        return map;
    }

}

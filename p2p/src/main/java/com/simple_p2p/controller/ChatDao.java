package com.simple_p2p.controller;

import com.simple_p2p.entity.Chats;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ChatDao {

    private static final ArrayList<Chats> CHATS = new ArrayList<>();

    public static ArrayList<Chats> getCHATS() {
        return CHATS;
    }

    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/signal_server";

    public static void initData() {
        String query = "SELECT\n" +
                "  chat_id, chat_name\n" +
                "FROM signal_server.chat;";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()){
                CHATS.add(new Chats(resultSet.getLong(1), resultSet.getString(2)));
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    public ArrayList<Chats> getChats() {
        return CHATS;
    }

    public Map<Long, String> getMapChats() {
        Map<Long, String> map = new HashMap<Long, String>();
        for (Chats c : CHATS) {
            map.put(c.getChatsId(), c.getChatsName());
        }
        return map;
    }

}

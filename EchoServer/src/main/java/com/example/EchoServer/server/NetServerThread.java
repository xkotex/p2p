package com.example.EchoServer.server;

import com.example.EchoServer.entity.UserConnection;
import com.example.EchoServer.repository.UserConnectionRepository;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {

    private UserConnectionRepository userConnectionRepository;

    public NetServerThread(UserConnectionRepository userConnectionRepository){
        this.userConnectionRepository = userConnectionRepository;
    }

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8071);
            System.out.println("initalized server");
            while (true){
                Socket socket = serverSocket.accept();
                //UserConnection userConnection = new UserConnection();
                System.out.println(socket.getInetAddress().getHostAddress() + " connected");
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


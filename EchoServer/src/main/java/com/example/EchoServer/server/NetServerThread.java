package com.example.EchoServer.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class NetServerThread {

    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(8071);
            System.out.println("initalized server");
            while (true) {
                Socket socket = serverSocket.accept();

                System.out.println(socket.getInetAddress().getHostAddress() + " connected");
                ServerThread thread = new ServerThread(socket);
                thread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


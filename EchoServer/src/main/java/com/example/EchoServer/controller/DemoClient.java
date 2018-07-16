package com.example.EchoServer.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class DemoClient {
    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader bufferedReader = null;

        try {
            socket = new Socket(InetAddress.getLocalHost(), 8071);

            PrintStream printStream = new PrintStream(socket.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true){
                printStream.println("CONNECT");
                System.out.println(bufferedReader.readLine());
                Thread.sleep(1000);
            }
        } catch (UnknownHostException e){
            System.err.println("адрес недоступен " + e);
        } catch (IOException e){
            System.err.println("ошибка I/O потока" + e);
        } catch (InterruptedException e) {
            System.err.println("ошибка потока выполнения " + e);
        } finally {
            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
            if (socket != null){
                try {
                    socket.close();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }
}
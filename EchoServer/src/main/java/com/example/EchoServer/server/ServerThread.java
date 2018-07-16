package com.example.EchoServer.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;

public class ServerThread extends Thread {
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private InetAddress address;

    public ServerThread(Socket socket) throws IOException {
        printStream = new PrintStream(socket.getOutputStream());
        bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        address = socket.getInetAddress();
    }

    public void run(){
        String string;

        try {
            while ((string = bufferedReader.readLine()).equals("CONNECT")) {
                if("CONNECT".equals(string)) {
                    printStream.println("CONNECT");
                }
                System.out.println("Connect"  + " with " + address.getHostAddress());
            }
        } catch (IOException e){
            System.err.println("Disconnect");
        } finally {
            disconnect();
        }
    }

    public void disconnect(){
        try {
            if (printStream != null){
                printStream.close();
            }
            if (bufferedReader != null){
                bufferedReader.close();
            }
            System.out.println(address.getHostAddress() + " disconnect");
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            this.interrupt();
        }
    }

    /*public void saveConnectionInDB(UserConnection userConnection, InetAddress inetAddress){
        userConnection.setInetAddress(inetAddress);
        //userConnection.setUser(user);
        userConnection.setOnline(1);
    }

    public void saveOfflineConnection(UserConnection userConnection){
        userConnection.setOnline(0);
    }*/
}

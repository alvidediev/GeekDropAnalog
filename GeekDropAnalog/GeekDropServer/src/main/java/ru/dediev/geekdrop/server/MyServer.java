package ru.dediev.geekdrop.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {
    private static final int PORT = 9999;
    private DataInputStream in;
    private DataOutputStream out;

    public MyServer() {
    }

    public void openConnection(){
        try (ServerSocket server = new ServerSocket(PORT)){
            Socket socket = server.accept();
            System.out.println("Внимание! Клиент подключился!");
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            while (true){
                String msg = in.readUTF();
                if(msg.equalsIgnoreCase("end")){
                    break;
                }
                System.out.println("Сообщение от клиета " + msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            closeConnections();
        }
    }
    public void closeConnections(){
        try{
            if(in != null){
                in.close();
            }
            if(out != null){
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

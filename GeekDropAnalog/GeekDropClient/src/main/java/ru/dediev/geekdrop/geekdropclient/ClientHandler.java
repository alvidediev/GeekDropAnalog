package ru.dediev.geekdrop.geekdropclient;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler {
    public static final int PORT = 9999;
    public static final String LOCAL_HOST= "localhost";

    private DataInputStream in;
    private DataOutputStream out;
    private Socket socket;

    public ClientHandler() {
        try {
            socket = new Socket(LOCAL_HOST, PORT);
        } catch (IOException e) {
            e.printStackTrace();
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

    public void sendRegisterData(String msg){
        try{
            out = new DataOutputStream(socket.getOutputStream());
            if(msg != null) {
                out.writeUTF(msg);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package ru.dediev.geekdrop.server;

import ru.dediev.geekdrop.base.BaseHandler;

import java.sql.SQLException;

public class ServerRunner {
    public static void main(String[] args) {
        final MyServer server = new MyServer();
        BaseHandler baseWorker = new BaseHandler();
        server.openConnection();
        try {
            baseWorker.connectToBase();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            baseWorker.disconnectFromBase();
        }
    }
}

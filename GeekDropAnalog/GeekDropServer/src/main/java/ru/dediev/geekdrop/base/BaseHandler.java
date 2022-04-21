package ru.dediev.geekdrop.base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseHandler {
    public static Connection connection;

    public void disconnectFromBase() {
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void connectToBase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:users.db");
    }
}

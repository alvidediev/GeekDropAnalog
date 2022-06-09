package ru.dediev.geekdrop.base;

import java.sql.*;

/**
 * Для чего служит класс: В классе собраны методы для взаимодействия с базой данных.
 * За основу взят JDBC.
 * Используются хранимые процедуры для избежания SQL инъекций.
 *
 * Creator: Alvi Dediev.
 */
public class BaseHandler {


    private Connection connection;
    private Statement statement;


    public BaseHandler() {
        try {
            connectToBase();
            creatTable();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            disconnectFromBase();
        }
    }

    //метод для разрыва соединения с базой данных
    public void disconnectFromBase() {
        try {
            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //метод для открытия соединения
    public void connectToBase() throws SQLException {
        connection = DriverManager.getConnection("jdbc:sqlite:users.db");
        statement = connection.createStatement();
    }

    //метод для автоматического создания таблицы
    private void creatTable() throws SQLException {
        statement.executeUpdate(
                "" + "CREATE TABLE IF NOT EXISTS users (" +
                        "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "login TEXT UNIQUE," +
                        "password TEXT," +
                        "nick TEXT" + ");"
        );
    }

    /**
     * Метод вставки данных в таблицу. Основной взаимодействующий метод с окном регистрации на клиентской стороне.
     *
     * @param login    - логин пользователя.
     * @param password - пароль пользователя
     * @param nick     - никнейм юзера.
     */
    private void insert(String login, String password, String nick) {
        try (PreparedStatement ps = connection.prepareStatement(
                "INSERT INTO clients (login,password,nick) VALUES (?,?,?)"
        )) {
            ps.setString(1, login);
            ps.setString(2, password);
            ps.setString(3, nick);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод выбора.
     * Логика: выбирается nick пользователя, где
     * @param login    - логин
     * @param password - пароль
     * соответствуют логину и паролю из таблицы в базе.
     */
    private String select(String login, String password) throws SQLException {
        try (final PreparedStatement ps = connection.prepareStatement(
                "SELECT nick FROM clients WHERE login = ? AND password = ?"
        )) {
            ps.setString(1, login);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString(1);
            }
            return null;
        }
    }

    /**
     * Метод для смены ника. Нужно доработать 07.05.2022
     */
//    public void changeNick(String nick, String login) {
//        try (PreparedStatement ps = connection.prepareStatement(
//                "UPDATE clients SET nick = ? WHERE login = ?"
//        )) {
//            ps.setString(1, nick);
//            ps.setString(2, login);
//            ps.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

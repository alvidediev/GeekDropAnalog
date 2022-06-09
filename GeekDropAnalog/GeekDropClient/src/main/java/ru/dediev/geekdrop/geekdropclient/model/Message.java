package ru.dediev.geekdrop.geekdropclient.model;

import java.util.Objects;

public class Message {

    private String name;
    private String password;
    private String login;

    public Message() {
    }

    public Message(String name, String password, String login) {
        this.name = name;
        this.password = password;
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message usersData = (Message) o;
        return Objects.equals(name, usersData.name) && Objects.equals(password, usersData.password) && Objects.equals(login, usersData.login);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, login);
    }

    @Override
    public String toString() {
        return "UsersData{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
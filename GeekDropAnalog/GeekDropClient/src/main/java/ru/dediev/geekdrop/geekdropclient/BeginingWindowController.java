package ru.dediev.geekdrop.geekdropclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class BeginingWindowController {
    @FXML
    public Button toLoginWindow;
    @FXML
    public Button to_register_window;

    public void login_window(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) toLoginWindow.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("loginWindow.fxml"));
        Parent root1 = fxmlLoader.load();
        stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Вход");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void rega(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) to_register_window.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registerWindow.fxml"));
        Parent root1 = fxmlLoader.load();
        stage = new Stage();
        stage.setResizable(false);
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(root1));
        stage.show();
    }
}

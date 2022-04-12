package ru.dediev.geekdrop.geekdropclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginWindowController {
    public Button registerBtn;

    public void toRegisterWindow(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) registerBtn.getScene().getWindow();
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("registerWindow.fxml"));
        Parent root1 = fxmlLoader.load();
        stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Регистрация");
        stage.setScene(new Scene(root1));
        stage.show();
    }

    public void login(ActionEvent actionEvent) {

    }
}
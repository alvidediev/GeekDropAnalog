package ru.dediev.geekdrop.geekdropclient;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterWindowController {
    @FXML
    public Button fromRegisterWindowToLoginBtn;
    @FXML
    public TextField passwordField;
    @FXML
    public TextField loginField;
    @FXML
    public Button regInDb;

    public void fromRegisterWindowToLogin(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) fromRegisterWindowToLoginBtn.getScene().getWindow();
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

    public void regInDbAction(ActionEvent actionEvent) {

    }
}

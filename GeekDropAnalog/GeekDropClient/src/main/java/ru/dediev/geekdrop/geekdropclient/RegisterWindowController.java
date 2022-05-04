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
import ru.dediev.geekdrop.geekdropclient.Controllers.NetworkConnector;

import java.io.IOException;

public class RegisterWindowController {
    NetworkConnector networker = new NetworkConnector();

    @FXML
    public Button fromRegisterWindowToLoginBtn;
    @FXML
    public TextField passwordField;
    @FXML
    public TextField loginField;
    @FXML
    public Button regInDb;

    //Форма перехода между окнами: с окна регистрации на окно входа
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

    /** Форма регистрации. Из полей ввода логина и пароля берется текст, к ним в начало добавляется ключевое
     * слово "/register". На сервер есть обработчик событий, который прочитал ключевое слово поймет, что данные
     * логин и пароль нужно занести в базу.
     */
    public void regInDbAction(ActionEvent actionEvent) {
            networker.sendMessage(loginField.getText());

    }
}

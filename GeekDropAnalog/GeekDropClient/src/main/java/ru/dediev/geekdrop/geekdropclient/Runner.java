package ru.dediev.geekdrop.geekdropclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.dediev.geekdrop.geekdropclient.Controllers.NetworkConnector;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Runner extends Application implements Initializable {
    private NetworkConnector network;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Runner.class.getResource("beginingWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 840, 680);
        stage.setResizable(false);
        stage.setTitle("GeekDrop");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        network = new NetworkConnector();
    }
}
package ru.dediev.geekdrop.geekdropclient;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Runner extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Runner.class.getResource("beginingWindow.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 440, 380);
        stage.setResizable(false);
        stage.setTitle("GeekDrop");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
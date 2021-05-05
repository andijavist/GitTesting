package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class FXMLExample extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL fxmlUrl = getClass().getResource("helloworld.fxml");
//        URL fxmlUrl = getClass().getResource("helloworld-controller.fxml");
        loader.setLocation(fxmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My First JavaFX Application");
        stage.show();
    }

    public static void main(String[] args) {
//        System.out.println(Font.getFontNames());
        launch();
    }

}
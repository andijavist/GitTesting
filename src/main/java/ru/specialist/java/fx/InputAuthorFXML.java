package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.URL;

public class InputAuthorFXML extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader();
        URL fxmlUrl = getClass().getResource("input_author.fxml");
        loader.setLocation(fxmlUrl);
        Parent root = loader.load();
        Scene scene = new Scene(root, 300, 120);

        scene.getStylesheets().add(getClass().getResource("input_author.css").toExternalForm());
        stage.setScene(scene);
        stage.setTitle("Insert Author FXML");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


//https://www.callicoder.com/javafx-css-tutorial/ Full Example
public class FXMLCSS extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL xmlUrl = getClass().getResource("demo.fxml");
        loader.setLocation(xmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root, 640, 480);
        scene.getStylesheets().add(getClass().getResource("demo.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        stage.setTitle("My First JavaFX App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}

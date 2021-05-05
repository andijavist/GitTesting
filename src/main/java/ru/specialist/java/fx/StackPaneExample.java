package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class StackPaneExample extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        Image image = new Image(getClass().getResourceAsStream("stonehenge.jpg"));
        ImageView imageView = new ImageView(image);
        Button button = new Button("Click me!");
//        button.setOnMouseClicked(e -> {});

        StackPane root = new StackPane(imageView, button);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My JavaFX Application");
        stage.show();
    }

    public static void main(String[] args) {
//        System.out.println(Font.getFontNames());
        launch();
    }

}
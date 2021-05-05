package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class HBoxExample extends Application {



    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox();
        root.getChildren().addAll(
                new Button("1"),
                new Button("2"),
                new Button("3"),
                new Button("4"),
                new Button("5")
        );

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(10, 10, 100, 10));

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
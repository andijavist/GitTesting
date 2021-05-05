package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class TextFieldExample extends Application {


    @Override
    public void start(Stage stage) throws IOException {
        Label label = new Label();
        TextField textField = new TextField("Enter text here");

        Button button = new Button("Click me!");
        button.setOnMouseClicked(mouseEvent ->
                label.setText(textField.getText().toUpperCase())
        );

        VBox root = new VBox(textField, button, label);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(50, 50, 50, 50));

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
package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        Label label = new Label("Hello JavaFX");
        label.setFont(new Font("Arial Bold Italic", 20));

        Button button = new Button("Click me!");
//        button.setOnMouseClicked(new MyEventHandler(label));
        button.setOnMouseClicked(mouseEvent ->
                label.setText("Button clicked!")
        );

        VBox root = new VBox(label, button);
//        root.getChildren().addAll(label, button);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My First JavaFX Application");
        stage.show();
    }

    public static void main(String[] args) {
        System.out.println(Font.getFontNames());
        launch();
    }

}
package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class VBoxAndHBoxExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        HBox hBox1 = new HBox(new Button("1"), new Button("2"));
        hBox1.setAlignment(Pos.TOP_LEFT);
        hBox1.setSpacing(20);

        HBox hBox2 = new HBox(new Label("3"));
        hBox2.setAlignment(Pos.CENTER);

        HBox hBox3 = new HBox(new Label("4"), new Button("5"), new Text("6"));
        hBox3.setAlignment(Pos.BOTTOM_RIGHT);
        hBox3.setSpacing(10);

        VBox root = new VBox(hBox1, hBox2, hBox3);
        root.setSpacing(50);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My JavaFX Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

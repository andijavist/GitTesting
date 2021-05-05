package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GridPaneExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        GridPane root = new GridPane();
        root.addRow(0, new Label("1"), new Button("2"), new Button("3"));
        root.addRow(1, new Button("4"), new Label("5"), new Button("6"));
        root.addRow(2, new Button("7"), new Button("8"), new Label("9"));

        root.setAlignment(Pos.CENTER);
        root.setVgap(20);
        root.setHgap(50);

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

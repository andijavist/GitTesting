package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneExample extends Application {
//    упорядочивает вложенные элементы в виде таблицы. Для каждого элемента можно задать в какой строке и каком столбце грида он будет располагаться.

//https://metanit.com/java/javafx/3.8.php
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

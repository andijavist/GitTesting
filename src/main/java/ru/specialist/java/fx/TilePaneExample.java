package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

public class TilePaneExample extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        TilePane root = new TilePane();
        root.setOrientation(Orientation.HORIZONTAL);
//        root.setOrientation(Orientation.VERTICAL);


        root.getChildren().addAll(
                new Button("1"){{setMinWidth(Math.random()*100);}},
                new Button("2"){{setMinWidth(Math.random()*100);}},
                new Button("3"){{setMinWidth(Math.random()*100);}},
                new Button("4"){{setMinWidth(Math.random()*100);}},
                new Button("5"){{setMinWidth(Math.random()*100);}},
                new Button("6"){{setMinWidth(Math.random()*100);}},
                new Button("7"){{setMinWidth(Math.random()*100);}},
                new Button("8"){{setMinWidth(Math.random()*100);}},
                new Button("9"){{setMinWidth(Math.random()*100);}}
        );
        root.setVgap(20);
        root.setHgap(50);
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

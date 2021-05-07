package org.example;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class FlowPaneExample extends Application {

//  понятно про флоупэйн  https://betacode.net/10627/javafx-flowpane
    @Override
    public void start(Stage stage) throws Exception {
        FlowPane root = new FlowPane();
        root.setOrientation(Orientation.HORIZONTAL);
//        root.setOrientation(Orientation.VERTICAL);
        root.getChildren().addAll(/* явное задание дочерних элементов, которые выравниваются по правилам -->
        root.setOrientation(Orientation.HORIZONTAL)
        root.setVgap(20);
        root.setHgap(50);
        root.setAlignment(Pos.TOP_LEFT);;*/
                new Button("1"){{setMinWidth(Math.random()*10);}/*просто блок внуктри класса*/},//анонимный класс! без лямбды
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
        stage.setResizable(true);
        stage.setTitle("My JavaFX Application");
        stage.show();
    }

    public static void main(String[] args) {
        launch();//вопрос! здесь не указывается имя классА, так как наш класс наследует Application?
    }
}

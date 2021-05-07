package org.example;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class HBoxExample extends Application {



//Класс javafx.scene.layout.HBox организует все вложенные элементы в виде горизонального ряда.
//Для создания объекта HBox можно использовать один из конструкторов класса:
//HBox(): определяет пустой объект HBox
//HBox(double spacing): определяет пустой объект HBox, в котором элеметы будут находиться друг от друга на расстоянии spacing
//HBox(double spacing, Node... children): определяет объект HBox, заполненный элементами nodes, которые находятся друг от друга на расстоянии spacing
//HBox(Node... children): определяет объект HBox, заполненный элементами nodes
    @Override
    public void start(Stage stage) throws IOException {
        HBox root = new HBox();
        //инфо с сайта -- https://metanit.com/java/javafx/4.1.php
        //Кнопки представлены классом javafx.scene.control.Button и позволяют по нажатию выполнять некоторые действия.
        //Класс Button имеет три конструктора:
        //Button(): создает кнопку без надписи
        //Button(String text): создает кнопку с определенной надписью
        //Button(String text, Node graphic): создает кнопку с определенной надписью и иконкой
        root.getChildren().addAll(
                new Button("1"),
                new Button("2"),
                new Button("3"),
                new Button("4"),
                new Button("5")
        );

        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.setPadding(new Insets(10, 10, 20, 10));//объект, устанавливающий отступы со всех сторон Insets(10, 10, 100, 10)

        Scene scene = new Scene(root, 300, 300);//размер окна
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("My First JavaFX Application");
        stage.show();
    }

    public static void main(String[] args) {
//        System.out.println(Font.getFontNames());
        launch();
    }

}
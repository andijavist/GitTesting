package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class FXMLExample2 extends Application {

    @Override
    public void start(Stage stage) throws IOException {
//        При компиляции и запуске приложения, которое применяет fxml-файлы, необходимо использовать модуль javafx.fxml ---- в сборке pom.xml

////////////////////////первый вариант///////////////////////////
//        FXMLLoader loader = new FXMLLoader();
//        URL fxmlUrl = getClass().getResource("/Test.fxml");
//        loader.setLocation(fxmlUrl);
//        Parent root = loader.load();
//////////////////////////второй вариант//////////////////////////
//        https://metanit.com/java/javafx/2.1.php
//        Метод FXMLLoader.load() возвращает объект типа Parent,
//        который мы можем передать в конструктор объекта Scene, и таким образом, наше приложение получит интерфейс из fxml.vvvvv
        Parent root = FXMLLoader.load(getClass().getResource("/Test.fxml"));
        stage.setWidth(250);//второй вариант с прямым заданием размера
        stage.setHeight(200);
        stage.show();
//      Scene scene = new Scene(root, 300, 300); первый вариант
        Scene scene = new Scene(root); //второй вариант с Parent root
        scene.getStylesheets().add(getClass().getResource("/pattern.css").toExternalForm());//установка css стилей на сцену
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("SelfMadeEx");
        stage.show();
    }

    public static void main(String[] args) {
//        System.out.println(Font.getFontNames());//вывод типов шрифтов
        launch();
    }

}
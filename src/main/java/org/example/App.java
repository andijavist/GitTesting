package org.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        Label label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        Scene scene = new Scene(new StackPane(label), 640, 480);
//        stage.setScene(scene);
//        stage.show();

    Label label = new Label("Добавьте пользователя");
        label.setFont(new Font("Arial Bold Italic", 20));

    Button button = new Button("Отправить в базуданных");
// button.setOnMouseClicked(new MyEventHandler(label));
// необходимо добавить в аргументы объект-обработчик события, в конструктор которому поставляется объект над которым будет производитьсяобработка
        button.setOnMouseClicked(mouseEvent ->
            label.setText("Пользователь добавлен в базу")//TODO добавить метод отправки в базу даннх
            );

    VBox root = new VBox(label, button); //корневой элемент - VBox
//        root.getChildren().addAll(label, button);//прямое добавление дочерних элементов

        root.setAlignment(Pos.CENTER);//
        root.setSpacing(20);

    Scene scene = new Scene(root, 300, 300);//задание сцены
        stage.setScene(scene);
        stage.setResizable(true);//возможность изменять размер окна
        stage.setTitle("добавляем пользователя");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}
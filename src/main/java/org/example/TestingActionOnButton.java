package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestingActionOnButton extends Application {
//    пример взят с сайнта VV
//    https://metanit.com/java/javafx/4.1.php
//    Класс Button имеет три конструктора:
//
//Button(): создает кнопку без надписи
//
//Button(String text): создает кнопку с определенной надписью
//
//Button(String text, Node graphic): создает кнопку с определенной надписью и иконкой
//
//Класс Label имеет три похожих конструктора:
//
//Label(): создает метку без надписи
//
//Label(String text): создает метку с определенной надписью
//
//Label(String text, Node graphic): создает метку с определенной надписью и иконкой
    public static void main(String[] args) {
        Application.launch();//можно не писать про Application.
    }
    private int i=0;
    @Override
    public void start(Stage primaryStage) throws Exception {
        Label mainLabel = new Label("Click");
        //Ключевой возможностью кнопки (Button) является способность реагировать
        // на нажатия пользователей и по нажтию выполнять некоторое действие.
        // Для обработки нажатий в базовом классе ButtonBase (класс Button является потомком этого класса)
        // определен метод setOnAction(), который устанавливает обработчик нажатия:
        //
        //final void setOnAction(EventHandler<ActionEvent> handler)
        //
        //В качестве параметра в этот метод передается реализация интерфейса EventHandler:
        //
        //public interface EventHandler<T extends Event>{void handle(T event);}
        //НИЖЕ ПРИМЕР ИСПОЛЬЗОВАНИЯ!!

//        mainLabel.setPrefWidth(10);//устанавливаме ширину лейбла, поумолчанию будет установлена ширина и размер надписи
        Button bt = new Button("Count");
//        bt.setPrefWidth(10);//устанавливаме ширину кнопки, поумолчанию будет установлена ширина и размер надписи (объекта внутри)
        ////////////////САМОЕ ВАЖНОЕ!////////////////////////
//        bt.setOnAction(new EventHandler<ActionEvent>() {
//          //созданем анонимного класса!
//            @Override
//            public void handle(ActionEvent actionEvent) {
//                i++;
//                mainLabel.setText("count started " + i);//устанавливается новое значение текста лэйбла
//                bt.setText("Clicked");
//            }
//        });
        //созданем анонимного класса при помощи лямбды
        bt.setOnAction(actionEvent -> {
            i++;
            mainLabel.setText("count started " + i);//устанавливается новое значение текста лэйбла
            bt.setText("Clicked");
        });
        //рутом является какой то элемент, типа VBOX или HBOX или FlowPane
        FlowPane root = new FlowPane(mainLabel,bt);//в конструктор кладем элементы
        root.setVgap(20);
        root.setHgap(50);
        root.setAlignment(Pos.CENTER);//
        Scene scene = new Scene(root, 200, 200);
        scene.setFill(Color.AQUA);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        primaryStage.setTitle("Testing button and Labels");
        primaryStage.show();

    }
}

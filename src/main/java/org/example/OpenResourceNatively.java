package org.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OpenResourceNatively extends Application {
    //https://metanit.com/java/javafx/4.5.php
    //JavaFX предоставляет ряд элементов управления для ввода текста:
    //TextField (для ввода однострочного текста),
    //TextArea (для ввода многострочного текста) и PasswordField (для ввода пароля).
    //
    //Все эти элементы управления наследуются от класса TextInputControl,
    //который определяет базовую функциональность.
    //Основные свойства:
    //BooleanProperty editable: указывает, можно ли редактировать текст в поле
    //
    //ObjectProperty<Font> font: определяет шрифт
    //
    //StringProperty promptText: определяет текст-приглашение к вводу
    //
    //ReadOnlyStringProperty selectedText: определяет выделенный текст
    //
    //ObjectProperty<TextFormatter<?>> textFormatter: определяет форматировщик текста
    //
    //StringProperty text: определяет текст в поле
    //
    //ReadOnlyBooleanProperty undoable: определяет, можно ли отменить последнее изменение содержимого в поле
    /////////////////////////////////////////Про TextField/////////////////////////////////////////////
    //Для создания однострочного текстового поля мы можем использовать один из двух его конструкторов:
    //
    //TextField(): создает пустое текстовое поле
    //
    //TextField(String text): создает текстовое поле с некоторым начальным текстом
    //
    //Большую часть функциональности TextField наследует от TextInputControl.
    //Из собственных методов у TextField следует отметить метод
    //void setPrefColumnCount(int columns)

    //Данный метод устанавливает количество столбцов, то есть по сути размер текстового поля.

    @Override
    public void start(Stage primaryStage) throws IOException, URISyntaxException {
        TextField textField = new TextField("http://stackoverflow.com/questions/39898704");
        Button openURLButton = new Button("Open URL");
        EventHandler<ActionEvent> handler = e/*событие*/ -> open(textField.getText());//открывает хлотс по полученному тексту ссылки
        textField.setOnAction(handler);
        openURLButton.setOnAction(handler);//здесь open работает как проводник по компу


//что то сложное, разобраться завтра
        FileChooser fileChooser = new FileChooser();

        Button openFileButton = new Button("Open File...");
        Files.list(Paths.get(".")).forEach(System.out::println);

        URL file = getClass().getResource("file/demo.css");

        System.out.println(file != null);
        openFileButton.setOnAction(e -> {
            if (file != null)
                getHostServices().showDocument(file.toExternalForm());
            //file.toExternalForm (метод класса URL) -- Constructs a string representation of this URL.
/*            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                open(file.toURI().toString());
            }*/
        });
        ///

        VBox root = new VBox(5,
                new HBox(new Label("URL:"), textField, openURLButton),
                new HBox(openFileButton)
        );

        root.setPadding(new Insets(20));
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    private void open(String resource) {

        getHostServices().showDocument(resource);
//        getHostServices()-->> унаследованный метод Application, получает класс HostServices для этого приложения.
//        showDocument(resource) -->> метод класса HostServices, открывает указанный URI в новом окне или вкладке браузера.

    }

    public static void main(String[] args) {
        launch(args);
    }
}
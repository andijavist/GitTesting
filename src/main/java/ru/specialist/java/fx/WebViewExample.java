package ru.specialist.java.fx;

import java.io.IOException;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class WebViewExample extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox root = new VBox();

        WebView view = new WebView();
        WebEngine engine = view.getEngine();
        engine.load("http://mvnrepository.com");

        Button b = new Button("JS");
        engine.setOnAlert(e -> {
            System.out.println(e.getData());
        });
        b.setOnMouseClicked(e -> {
            engine.executeScript("document.getElementById('header').hidden = true");
//            engine.executeScript("$('#header').hidden = true");
            engine.executeScript("alert('!!!')");

        });
        root.getChildren().addAll(view, b);
        
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        Application.launch(args);
    }
}
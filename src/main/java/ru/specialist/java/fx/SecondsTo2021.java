package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * JavaFX App
 */
public class SecondsTo2021 extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        Label label = new Label();
        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        root.getChildren().addAll(label);

        Scene scene = new Scene(root, 300, 300);

        Thread thread = new Thread(() -> {
            while (true) {
                long seconds = ChronoUnit.SECONDS.between(
                        LocalDateTime.now(),
                        LocalDateTime.of(2021,1,1,0,0));
                Platform.runLater(() -> label.setText(Long.toString(seconds)));
                try {
                    Thread.sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();



        stage.setScene(scene);
        stage.setTitle("My First App");
        stage.show();




    }


    public static void main(String[] args) {
        launch();
    }

}
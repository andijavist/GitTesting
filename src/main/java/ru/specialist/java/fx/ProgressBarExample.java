package ru.specialist.java.fx;


import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.stage.Stage;

public class ProgressBarExample extends Application {

    private static Scene scene;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Progress Bar");

        ProgressBar progressBar = new ProgressBar(0);

        Scene scene = new Scene(progressBar, 200, 50);

        primaryStage.setScene(scene);
        primaryStage.show();

        new Thread(() -> {
            double progress = 0;
            for(int i=0; i<10; i++){

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                progress += 0.1;
                final double reportedProgress = progress;

                Platform.runLater(() -> progressBar.setProgress(reportedProgress));
            }
        }).start();
    }


    public static void main(String[] args) {
        launch();
    }

}
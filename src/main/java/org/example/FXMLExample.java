package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

/**
 * JavaFX App
 */
public class FXMLExample extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL fxmlUrl = getClass().getResource("/helloworld.fxml");//очень странно, не понимаю почему без "/" не работает
        //ответ - мавен собирает так, что файлы ресурсов остаются вне папки example (где лежат классы, в соотвтетствии с деревом пакетов)! то есть в корень
        //если переместить helloworld.fxml а папку target/.../example то будет работать без "/"
        //дока по getResourse  https://docs.oracle.com/javase/6/docs/api/java/lang/Class.html#getResource%28java.lang.String%29
//        URL fxmlUrl = getClass().getResource("helloworld-controller.fxml");
        loader.setLocation(fxmlUrl);
        Parent root = loader.load();

        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.setTitle("My First JavaFX Application");
        stage.show();
    }

    public static void main(String[] args) {
//        System.out.println(Font.getFontNames());
        launch();
    }

}
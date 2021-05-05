package ru.specialist.java.fx.view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ListViewExample extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<String> langs = FXCollections.observableArrayList(
                "Java", "C++", "Javascript", "Kotlin");
        ListView<String> listView = new ListView<>(langs);
        listView.setPrefSize(250, 150);

        Label label = new Label();
        VBox root = new VBox(listView, label);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        listView.getSelectionModel().selectedItemProperty().addListener(
                (o, s, t1) -> label.setText(t1));
        Scene scene = new Scene(root, 250, 200);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("List View App");
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

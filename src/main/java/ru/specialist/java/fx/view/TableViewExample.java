package ru.specialist.java.fx.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewExample extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        ObservableList<Person> people = FXCollections.observableArrayList(
                new Person("Ivan", 34),
                new Person("Masha", 22),
                new Person("Sergey", 35),
                new Person("Alena", 29)
        );

        TableView<Person> tableView = new TableView<>(people);
        tableView.setPrefSize(250, 200);
//        tableView.setEditable(true);

        TableColumn<Person, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Person, Integer> ageColumn = new TableColumn<>("Age");
        ageColumn.setCellValueFactory(new PropertyValueFactory<>("age"));

        tableView.getColumns().addAll(nameColumn, ageColumn);

        VBox root = new VBox(tableView);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

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

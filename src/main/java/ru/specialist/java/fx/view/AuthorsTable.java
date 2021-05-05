package ru.specialist.java.fx.view;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.Comparator;
import java.util.Random;

public class AuthorsTable extends Application {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";
    public static final String UPDATE_AUTHOR_NAME = "update authors set author_name = ? where id = ?";
    public static final String UPDATE_LAST_NAME = "update authors set last_name = ? where id = ?";

    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) {

        ObservableList<Author> authors = FXCollections.observableArrayList();

        try(Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)){
            Statement statement = c.createStatement();
            ResultSet set = statement.executeQuery("select id, author_name, last_name from authors");
            while (set.next()){
                Author author = new Author();
                author.setId(set.getInt(1));
                author.setName(set.getString(2));
                author.setLastName(set.getString(3));
                author.setPath(new Random().nextInt() + "");
                authors.add(author);
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        TableView<Author> table = new TableView<>(authors.sorted(Comparator.comparingInt(Author::getId)));
        table.setPrefWidth(300);
        table.setPrefHeight(200);
        table.setEditable(true);

        TableColumn<Author, Number> idColumn = new TableColumn<>("Id");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
//        idColumn.setCellFactory(TextFieldTableCell.forTableColumn(new NumberStringConverter()));
        table.getColumns().add(idColumn);
        table.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    System.out.println("old path: " + (oldValue != null ? oldValue.getPath() : ""));
                    System.out.println("path: " + newValue.getPath());
                });

        TableColumn<Author, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setOnEditCommit(getCellEditEventEventHandler(UPDATE_AUTHOR_NAME));
        table.getColumns().add(nameColumn);

        TableColumn<Author, String> lastName = new TableColumn<>("Last Name");
        lastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastName.setCellFactory(TextFieldTableCell.forTableColumn());
        lastName.setOnEditCommit(getCellEditEventEventHandler(UPDATE_LAST_NAME));
        table.getColumns().add(lastName);


        FlowPane root = new FlowPane(10, 10, table);
        Scene scene = new Scene(root, 300, 250);
        stage.setResizable(false);

        stage.setScene(scene);
        stage.setTitle("TableView");
        stage.show();
    }

    private EventHandler<TableColumn.CellEditEvent<Author, String>> getCellEditEventEventHandler(String query) {
        return event -> {
            Author author = event.getRowValue();
            try(Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
                PreparedStatement statement = c.prepareStatement(query);
                statement.setString(1, event.getNewValue());
                statement.setInt(2, author.getId());
                statement.executeUpdate();
                System.out.println(statement);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        };
    }
}
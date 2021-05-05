package ru.specialist.java.fx.view;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookListViewExample extends Application {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";

    private static final String UPDATE = "update book set title = ? where book_id = ?";
    private static final String SELECT = "select book_id, title from book order by book_id";

    @Override
    public void start(Stage stage) {
        ObservableList<String> books = FXCollections.observableArrayList();
        Map<Integer, Integer> bookIndex2Id = new HashMap<>();

        loadBooks(books, bookIndex2Id);
        ListView<String> listView = new ListView<>(books);
        listView.setPrefSize(250, 150);
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());

        listView.setOnEditCommit(e -> {
            update(bookIndex2Id.get(e.getIndex()), e.getNewValue());
            loadBooks(books, bookIndex2Id);
        });

        Label label = new Label();
        VBox root = new VBox(listView, label);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 250, 200);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("List View App");
        stage.show();
    }

    private void loadBooks(List<String> books, Map<Integer, Integer> bookIndex2Id) {
        books.clear();
        bookIndex2Id.clear();

        try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)){
            Statement statement = c.createStatement();
            ResultSet set = statement.executeQuery(SELECT);
            while (set.next()){
                bookIndex2Id.put(books.size(), set.getInt(1));
                books.add(set.getString(2));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    private static void update(int bookId, String title) {
        try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement(UPDATE);
            statement.setString(1, title);
            statement.setInt(2, bookId);
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    public static void main(String[] args) {
        launch();
    }
}

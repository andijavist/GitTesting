package ru.specialist.java.fx.view.hw;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.cell.TextFieldListCell;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class BookView extends Application {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";
    private static final String UPDATE_TITLE = "update book set title = ? where book_id = ?";
    private static final String SELECT_QUERY = "select book_id, title from book";
    private static volatile ArrayList<Integer> booksId = new ArrayList<>();
    private static volatile ObservableList<String> books = FXCollections.observableArrayList();
    private static volatile ListView<String> listView;
    private static volatile VBox root;
    private static final Object monitor = new Object();

    @Override
    public void start(Stage stage) throws IOException {
        reloadFromDb();
        listView.setEditable(true);
        listView.setCellFactory(TextFieldListCell.forListView());
        listView.setPrefSize(300, 200);
        listView.setOnEditCommit(getEventHandler(UPDATE_TITLE));
        root.setSpacing(20);
        root.setAlignment(Pos.TOP_CENTER);
        Scene scene = new Scene(root, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    private static void reloadFromDb() {
        synchronized(monitor) {
            booksId.clear();
            books.clear();
            try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
                Statement statement = c.createStatement();
                ResultSet set = statement.executeQuery(SELECT_QUERY);
                while (set.next()) {
                    booksId.add(set.getInt("\"book_id"));
                    books.add(set.getString("title"));
                }
                listView = new ListView<>(books);
                root = new VBox(listView);
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private static EventHandler<ListView.EditEvent<String>> getEventHandler(String query) {
        synchronized (monitor) {
            return e -> {
                try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
                    PreparedStatement statement = c.prepareStatement(query);
                    statement.setString(1, e.getNewValue());
                    statement.setInt(2, booksId.get(e.getIndex()));
                    statement.executeUpdate();
                    reloadFromDb();
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            };
        }
    }

    public static void main(String[] args) {
        launch();
    }
}
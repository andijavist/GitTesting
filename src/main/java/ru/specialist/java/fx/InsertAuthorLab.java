package ru.specialist.java.fx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

/**
 * JavaFX App
 */
public class InsertAuthorLab extends Application {

    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";


    @Override
    public void start(Stage stage) throws IOException {

        Label labelName = new Label("Enter author name:");
        TextField fieldName = new TextField("name");
        Label labelLastName = new Label("Enter author last name:");
        TextField fieldLastName = new TextField("last name");

        Button button = new Button("Create author!");
        button.setOnMouseClicked(mouseEvent ->
                insertAuthor(fieldName.getText(), fieldLastName.getText())
        );

        GridPane grid = new GridPane();
        grid.addRow(0, labelName, fieldName);
        grid.addRow(1, labelLastName,fieldLastName);

        grid.setVgap(20);
        grid.setHgap(50);
        grid.setAlignment(Pos.CENTER);

        VBox root = new VBox(grid, button);
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);

        Scene scene = new Scene(root, 400, 200);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.setTitle("Create author");
        stage.show();
    }


    private static void insertAuthor(String firstName, String lastName) {
        try(Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement("insert into authors\n" +
                    "(author_name, last_name)\n" +
                    "values (?, ?)", Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, firstName);
            statement.setString(2, lastName);

            statement.executeUpdate();
            ResultSet set = statement.getGeneratedKeys();
            while (set.next()) {
                System.out.println("Добавлен автор, author_id: " + set.getInt(1));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }

}
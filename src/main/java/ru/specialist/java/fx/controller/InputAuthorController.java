package ru.specialist.java.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InputAuthorController {

    private static final String URL = "jdbc:postgresql://127.0.0.1:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";

    @FXML
    private TextField nameField;

    @FXML
    private TextField lastNameField;

    @FXML
    public void submit() throws SQLException {
        try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)){
            PreparedStatement statement = c.prepareStatement(
                    "insert into authors (author_name, last_name) values (?, ?)");
            String name = nameField.getText();
            String lastName = lastNameField.getText();

            if (name.isEmpty() || lastName.isEmpty()){
                throw new IllegalArgumentException("Wrong data");
            }

            statement.setString(1, name);
            statement.setString(2, lastName);
            statement.executeUpdate();
        } finally {
            Stage stage = (Stage) nameField.getScene().getWindow();
            stage.close();
        }
    }

}

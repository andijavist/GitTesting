package ru.specialist.java.fx.view.hw;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.sql.*;

public class HomeWork2208 extends Application {
    private static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    private static final String LOGIN = "postgres";
    private static final String PASSWORD = "postgres";

    @Override
    public void start(Stage stage) throws Exception {
        MenuBar menuBar = new MenuBar();
        Menu itemsMenu = new Menu("Menu");
        MenuItem editAuthorsItem = new MenuItem("Edit Authors");
        MenuItem editBooksItem = new MenuItem("Edit Books");
        MenuItem exitItem = new MenuItem("Exit");
        editAuthorsItem.setAccelerator(KeyCombination.keyCombination("Ctrl+1"));
        editBooksItem.setAccelerator(KeyCombination.keyCombination("Ctrl+2"));
        exitItem.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        itemsMenu.getItems().addAll(editAuthorsItem, editBooksItem, exitItem);

        menuBar.getMenus().addAll(itemsMenu);


        ObservableList<Author> authorsList = getAuthorsList();

        TableView<Book> tableBooks = createTableBooks(authorsList);
        TableView<Author> tableAuthors = createTableAuthors(authorsList);

        BorderPane borderPane = new BorderPane();
        borderPane.setTop(menuBar);
        borderPane.setCenter(tableAuthors);

        stage.setTitle("HomeWork 22/08/2020");

        Scene scene = new Scene(borderPane, 800, 600);

        editAuthorsItem.setOnAction(event -> borderPane.setCenter(tableAuthors));
        editBooksItem.setOnAction(event -> borderPane.setCenter(tableBooks));
        exitItem.setOnAction(event -> System.exit(0));

        stage.setScene(scene);
        stage.show();
    }

    private TableView<Author> createTableAuthors(ObservableList<Author> authorsList){
        TableView<Author> table = new TableView<Author>();
        table.setEditable(true);

        TableColumn<Author, String> nameTableCol
                = new TableColumn<Author, String>("Table AUTHORS");

        TableColumn<Author, Integer> authorIdCol = new TableColumn<Author, Integer>("AUTHOR_ID");
        authorIdCol.setCellValueFactory(new PropertyValueFactory<>("authorId"));
        authorIdCol.setSortType(TableColumn.SortType.ASCENDING);
        authorIdCol.setMinWidth(100);
        authorIdCol.setMaxWidth(100);

        TableColumn<Author, String> authorNameCol = new TableColumn<Author, String>("AUTHOR_NAME");
        authorNameCol.setCellValueFactory(new PropertyValueFactory<>("authorName"));
        authorNameCol.setCellFactory(TextFieldTableCell.<Author> forTableColumn());
        authorNameCol.setMinWidth(150);

        authorNameCol.setOnEditCommit((CellEditEvent<Author, String> event) -> {
            TablePosition<Author, String> pos = event.getTablePosition();
            String newAuthorName = event.getNewValue();
            int row = pos.getRow();
            Author author = event.getTableView().getItems().get(row);
            author.setAuthorName(newAuthorName);
            updateAuthorName(author.getAuthorId(),newAuthorName);
        });


        TableColumn<Author, String> lastNameCol = new TableColumn<Author, String>("LAST_NAME");
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        lastNameCol.setCellFactory(TextFieldTableCell.<Author> forTableColumn());
        lastNameCol.setMinWidth(150);

        lastNameCol.setOnEditCommit((CellEditEvent<Author, String> event) -> {
            TablePosition<Author, String> pos = event.getTablePosition();
            String newLastName = event.getNewValue();
            int row = pos.getRow();
            Author author = event.getTableView().getItems().get(row);
            author.setLastName(newLastName);
            updateLastName(author.getAuthorId(),newLastName);
        });

        table.setItems(authorsList);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        nameTableCol.getColumns().addAll(authorIdCol, authorNameCol, lastNameCol);

        table.getColumns().addAll(nameTableCol);
        return table;
    }

    private TableView<Book> createTableBooks(ObservableList<Author> authorsList){
        TableView<Book> table = new TableView<Book>();
        table.setEditable(true);

        TableColumn<Book, String> nameTableCol
                = new TableColumn<Book, String>("Table BOOKS");
        TableColumn<Book, Integer> bookIdCol = new TableColumn<Book, Integer>("BOOK_ID");
        bookIdCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        bookIdCol.setSortType(TableColumn.SortType.ASCENDING);
        bookIdCol.setMinWidth(100);
        bookIdCol.setMaxWidth(100);

        TableColumn<Book, String> titleCol = new TableColumn<Book, String>("TITLE");
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        titleCol.setCellFactory(TextFieldTableCell.<Book> forTableColumn());
        titleCol.setMinWidth(150);

        titleCol.setOnEditCommit((CellEditEvent<Book, String> event) -> {
            TablePosition<Book, String> pos = event.getTablePosition();
            String newTitle = event.getNewValue();
            int row = pos.getRow();
            Book book = event.getTableView().getItems().get(row);
            book.setTitle(newTitle);
            updateBookTitle(book.getBookId(),newTitle);
        });

        TableColumn<Book, Author> authorIdCol = new TableColumn<Book, Author>("AUTHOR");
        authorIdCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        authorIdCol.setCellFactory(ComboBoxTableCell.forTableColumn(authorsList));
        authorIdCol.setMinWidth(150);
        authorIdCol.setOnEditCommit((CellEditEvent<Book, Author> event) -> {
            TablePosition<Book, Author> pos = event.getTablePosition();
            Author newAuthor = event.getNewValue();
            int row = pos.getRow();
            Book book = event.getTableView().getItems().get(row);
            book.setAuthor(newAuthor);
            updateBookAuthor(book.getBookId(), newAuthor.getAuthorId());
        });



        nameTableCol.getColumns().addAll(bookIdCol, titleCol, authorIdCol);

        ObservableList<Book> list = getBooksList(authorsList);
        table.setItems(list);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        table.getColumns().addAll(nameTableCol);
        return table;
    }

    private ObservableList<Author> getAuthorsList() {
        ObservableList<Author> list = FXCollections.observableArrayList();

        try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement("select author_id, author_name, last_name from authors");

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                list.add(new Author(set.getInt("author_id"),
                        set.getString("author_name"),
                        set.getString("last_name")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    private ObservableList<Book> getBooksList(ObservableList<Author> authorsList) {
        ObservableList<Book> list= FXCollections.observableArrayList();

        try (Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement("select book_id, title, b.author_id, " +
                    "trim(a.author_name)||' '||trim(a.last_name) author_name " +
                    "from books b inner join authors a on a.author_id = b.author_id");

            ResultSet set = statement.executeQuery();
            while (set.next()) {
                list.add(new Book(set.getInt("book_id"),
                        set.getString("title"),
                        set.getInt("author_id"),
                        getAuthorFromList(authorsList, set.getInt("author_id"))
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return list;
    }

    private Author getAuthorFromList(ObservableList<Author> authorsList, int authorId) {
        return authorsList.filtered(a -> a.getAuthorId() == authorId).iterator().next();
    }

    private void updateAuthorName(int authorId, String newAuthorName){
        try(Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement("update authors set\n" +
                    "author_name = ?\n" +
                    "where author_id = ?");
            statement.setString(1, newAuthorName);
            statement.setInt(2, authorId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateLastName(int authorId, String newLastName){
        try(Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement("update authors set\n" +
                    "last_name = ?\n" +
                    "where author_id = ?");
            statement.setString(1, newLastName);
            statement.setInt(2, authorId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBookTitle(int bookId, String newTitle){
        try(Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement("update books set\n" +
                    "title = ?\n" +
                    "where book_id = ?");
            statement.setString(1, newTitle);
            statement.setInt(2, bookId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateBookAuthor(int bookId, int newAuthorId){
        try(Connection c = DriverManager.getConnection(URL, LOGIN, PASSWORD)) {
            PreparedStatement statement = c.prepareStatement("update books set\n" +
                    "author_id = ?\n" +
                    "where book_id = ?");
            statement.setInt(1, newAuthorId);
            statement.setInt(2, bookId);
            statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}

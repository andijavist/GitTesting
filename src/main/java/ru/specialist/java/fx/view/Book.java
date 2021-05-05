package ru.specialist.java.fx.view;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import ru.specialist.java.fx.view.hw.Author;

public class Book {

    private SimpleIntegerProperty bookId;
    private SimpleStringProperty title;

    public Book(int bookId, String title) {
        this.bookId = new SimpleIntegerProperty(bookId);
        this.title = new SimpleStringProperty(title);
    }

    public int getBookId() {
        return bookId.get();
    }

    public SimpleIntegerProperty bookIdProperty() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId.set(bookId);
    }

    public String getTitle() {
        return title.get();
    }

    public SimpleStringProperty titleProperty() {
        return title;
    }

    public void setTitle(String title) {
        this.title.set(title);
    }

}

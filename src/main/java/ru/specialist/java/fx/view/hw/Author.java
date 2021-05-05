package ru.specialist.java.fx.view.hw;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Author {
    private SimpleIntegerProperty authorId;
    private SimpleStringProperty authorName;
    private SimpleStringProperty lastName;

    public Author(Integer authorId, String authorName, String lastName) {
        this.authorId = new SimpleIntegerProperty(authorId);
        this.authorName = new SimpleStringProperty(authorName);
        this.lastName = new SimpleStringProperty(lastName);
    }

    public int getAuthorId() {
        return authorId.get();
    }

    public SimpleIntegerProperty authorIdProperty() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId.set(authorId);
    }

    public String getAuthorName() {
        return authorName.get();
    }

    public SimpleStringProperty authorNameProperty() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName.set(authorName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public SimpleStringProperty lastNameProperty() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    @Override
    public String toString() {
        return getAuthorName() + " " + getLastName();
    }

}

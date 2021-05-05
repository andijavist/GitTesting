package ru.specialist.java.fx.view.hw;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

public class Book {
    private SimpleIntegerProperty bookId;
    private SimpleStringProperty title;
    private SimpleIntegerProperty authorId;
//    private SimpleStringProperty authorName;
    private SimpleObjectProperty<Author> author;

    public Book(int bookId, String title, int authorId, Author author) {
        this.bookId = new SimpleIntegerProperty(bookId);
        this.title = new SimpleStringProperty(title);
        this.authorId = new SimpleIntegerProperty(authorId);
        this.author = new SimpleObjectProperty(author);
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

    public int getAuthorId() {
        return authorId.get();
    }

    public SimpleIntegerProperty authorIdProperty() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId.set(authorId);
    }

    public Author getAuthor() {
        return author.get();
    }

    public SimpleObjectProperty<Author> authorProperty() {
        return author;
    }

    public void setAuthor(Author author){
        this.authorId = new SimpleIntegerProperty(author.getAuthorId());
        this.author = new SimpleObjectProperty<>(author);
    }
}

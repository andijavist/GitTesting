package ru.specialist.java.fx;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

public class MyEventHandler implements EventHandler<MouseEvent> {

    private Label label;

    public MyEventHandler(Label label) {
        this.label = label;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        label.setText("Changed from MyEventHandler!");
    }
}

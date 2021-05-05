package ru.specialist.java.fx.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ButtonController {

    @FXML
    private Label myLabel;

    @FXML
    public void onButtonClick(){
        myLabel.setText("Changed from controller!");
    }
}

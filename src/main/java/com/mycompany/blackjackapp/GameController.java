package com.mycompany.blackjackapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController extends BlackjackApp {

    @FXML
    private Button playGameButton;
    @FXML
    private TextField wagerInput;
    @FXML
    private Label totalCredits;

//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary");
//    }
    @FXML
    private void playGame(ActionEvent event) {
    }
}

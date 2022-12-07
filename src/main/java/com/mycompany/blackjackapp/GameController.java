package com.mycompany.blackjackapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class GameController extends BlackjackApp {

    @FXML
    private Button playGameButton;
    @FXML
    private TextField wagerInput;
    @FXML
    private Label totalCredits;
    @FXML
    private AnchorPane wagerPane;

//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary");
//    }
    @FXML
    private void playGame(ActionEvent event) {
        wagerPane.setVisible(false);
    }
}

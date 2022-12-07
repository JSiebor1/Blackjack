package com.mycompany.blackjackapp;

import com.mycompany.blackjackapp.BlackjackApp;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController extends BlackjackApp{

    @FXML
    private Button playGameButton;
    @FXML
    private TextField wagerInput;
    @FXML
    private Label totalCredits = new Label("Total Credits: " + credits);

//    private void switchToPrimary() throws IOException {
//        App.setRoot("primary");
//    }

    @FXML
    private void playGame(ActionEvent event) {
    }
}
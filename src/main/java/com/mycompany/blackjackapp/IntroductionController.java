package com.mycompany.blackjackapp;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class IntroductionController {

    @FXML
    private Button continueButton;

    @FXML
    private void switchToGame() throws IOException {
        App.setRoot("game");
    }
}

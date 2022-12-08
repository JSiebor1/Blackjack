package com.mycompany.blackjackapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class GameController extends BlackjackApp {

    @FXML
    private Button playGameButton;
    @FXML
    private TextField wagerInput;
    @FXML
    private Label totalCredits;
    @FXML
    private AnchorPane wagerPane;
    @FXML
    private AnchorPane gamePane;
    @FXML
    private Button hitButton;
    @FXML
    private Button standButton;
    @FXML
    private HBox dealerHandHBox;
    @FXML
    private ImageView dCard1;
    @FXML
    private ImageView dCard2;
    @FXML
    private ImageView dCard3;
    @FXML
    private ImageView dCard4;
    @FXML
    private ImageView dCard5;
    @FXML
    private ImageView dCard6;
    @FXML
    private ImageView dCard7;
    @FXML
    private ImageView dCard8;
    @FXML
    private ImageView dCard9;
    @FXML
    private ImageView dCard10;
    @FXML
    private ImageView dCard11;
    @FXML
    private HBox playerHandHBox;
    @FXML
    private ImageView pCard1;
    @FXML
    private ImageView pCard2;
    @FXML
    private ImageView pCard3;
    @FXML
    private ImageView pCard4;
    @FXML
    private ImageView pCard5;
    @FXML
    private ImageView pCard6;
    @FXML
    private ImageView pCard7;
    @FXML
    private ImageView pCard8;
    @FXML
    private ImageView pCard9;
    @FXML
    private ImageView pCard10;
    @FXML
    private ImageView pCard11;

    int pHitCount = 1;

    @FXML
    private void playGame(ActionEvent event) {
        wager = Integer.parseInt(wagerInput.getText());
        if (wager >= 100 && wager <= credits) {
            credits -= wager;
            totalCredits.setText("Total Credits: " + credits);
            wagerPane.setVisible(false);
            gamePane.setVisible(true);

            deal();
            pCard1.setImage(playerHand.get(0).getImage());
            pCard2.setImage(playerHand.get(1).getImage());
            dCard1.setImage(dealerHand.get(0).getImage());
        }
    }

    @FXML
    private void hit(ActionEvent event) {
        super.hit(playerHand);
        pHitCount++;
        if (pHitCount == 2) {
            pCard3.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 3) {
            pCard4.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 4) {
            pCard5.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 5) {
            pCard6.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 6) {
            pCard7.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 7) {
            pCard8.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 8) {
            pCard9.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 9) {
            pCard10.setImage(playerHand.get(pHitCount).getImage());
        }
        if (pHitCount == 10) {
            pCard11.setImage(playerHand.get(pHitCount).getImage());
        }
    }

    @FXML
    private void stand(ActionEvent event) {
    }

}

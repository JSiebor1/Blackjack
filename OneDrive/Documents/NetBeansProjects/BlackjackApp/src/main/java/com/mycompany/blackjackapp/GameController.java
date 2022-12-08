package com.mycompany.blackjackapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class GameController extends BlackjackApp {

    int pHitCount = 1;
    int dHitCount = 1;

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
    @FXML
    private Label wagerDisplay;
    @FXML
    private Label displayText;
    @FXML
    private Button dealerDrawButton;
    @FXML
    private AnchorPane endPane;
    @FXML
    private Button continueButton;
    @FXML
    private Button exitButton;
    @FXML
    private Button goToEndButton;
    @FXML
    private Label outOfCredits;

    @FXML
    private void playGame(ActionEvent event) {
        wager = Integer.parseInt(wagerInput.getText());
        if (wager >= 100 && wager <= credits) {
            credits -= wager;
            totalCredits.setText("Total Credits: " + credits);
            wagerDisplay.setText("Wager: " + wager);
            wagerPane.setVisible(false);
            gamePane.setVisible(true);

            deal();
            pCard1.setImage(playerHand.get(0).getImage());
            pCard2.setImage(playerHand.get(1).getImage());
            dCard1.setImage(new Image(getClass().getResourceAsStream("images/back_of_card.png")));
            dCard2.setImage(dealerHand.get(1).getImage());
        }

        playerBlackjack = hasBlackjack(calcValue(playerHand));
        if (playerBlackjack) {
            hitButton.setVisible(false);
            standButton.setVisible(false);

            dealerTurn();
        }
    }

    @FXML
    private void hit(ActionEvent event) {
        super.hit(playerHand);

        if (hasSoftAce(playerHand) && over21(calcValue(playerHand))) {
            changeAceValue(playerHand);
        }

        if (!playerBust && !playerBlackjack) {
            playerBust = over21(calcValue(playerHand));

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

        if (playerBust) {
            hitButton.setVisible(false);
            standButton.setVisible(false);

            dealerTurn();
        }

        if (calcValue(playerHand) == 21) {
            playerStand = true;
            hitButton.setVisible(false);
            standButton.setVisible(false);

            dealerTurn();
        }

    }

    @FXML
    private void stand(ActionEvent event) {
        hitButton.setVisible(false);
        standButton.setVisible(false);

        playerStand = true;
        dealerTurn();
    }

    public void dealerTurn() {
        dCard1.setImage(dealerHand.get(0).getImage());

        dealerBlackjack = hasBlackjack(calcValue(dealerHand));
        if (over16(calcValue(dealerHand))) {
            calcWinner();
        } else if (dealerBlackjack) {
            calcWinner();
        } else if (playerBust) {
            calcWinner();
        } else {
            dealerDrawButton.setVisible(true);
        }
    }

    @FXML
    private void dealerDraw(ActionEvent event) {
        if (!playerBust || playerBlackjack || playerStand) {
            if (!over16(calcValue(dealerHand)) && !dealerBlackjack) {
                super.hit(dealerHand);

                if (hasSoftAce(dealerHand) && over21(calcValue(dealerHand))) {
                    changeAceValue(dealerHand);
                }

                dHitCount++;
                if (dHitCount == 2) {
                    dCard3.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 3) {
                    dCard4.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 4) {
                    dCard5.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 5) {
                    dCard6.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 6) {
                    dCard7.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 7) {
                    dCard8.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 8) {
                    dCard9.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 9) {
                    dCard10.setImage(dealerHand.get(dHitCount).getImage());
                }
                if (dHitCount == 10) {
                    dCard11.setImage(dealerHand.get(dHitCount).getImage());
                }

                if (hasSoftAce(dealerHand) && over21(calcValue(dealerHand))) {
                    changeAceValue(dealerHand);
                }
                dealerBust = over21(calcValue(dealerHand));
            }
            dealerDrawButton.setVisible(false);
            calcWinner();
        }
    }

    @Override
    public void calcWinner() {
        super.calcWinner();

        totalCredits.setText("Total Credits: " + credits);
        wagerDisplay.setText("Wager: " + 0);

        goToEndButton.setVisible(true);

        if (winner == 1) {
            displayText.setText("Player wins");
        } else if (winner == 2) {
            displayText.setText("Push");
        } else if (winner == 3) {
            displayText.setText("Dealer wins");
        }

    }

    @FXML
    private void goToEnd(ActionEvent event) {
        gamePane.setVisible(false);
        endPane.setVisible(true);
    }

    @FXML
    private void continuePlaying(ActionEvent event) {
        if (credits != 0) {
            displayText.setText("");
            wagerInput.setText("");

            dHitCount = 1;
            dCard1.setImage(null);
            dCard2.setImage(null);
            dCard3.setImage(null);
            dCard4.setImage(null);
            dCard5.setImage(null);
            dCard6.setImage(null);
            dCard7.setImage(null);
            dCard8.setImage(null);
            dCard9.setImage(null);
            dCard10.setImage(null);
            dCard11.setImage(null);

            pHitCount = 1;
            pCard1.setImage(null);
            pCard2.setImage(null);
            pCard3.setImage(null);
            pCard4.setImage(null);
            pCard5.setImage(null);
            pCard6.setImage(null);
            pCard7.setImage(null);
            pCard8.setImage(null);
            pCard9.setImage(null);
            pCard10.setImage(null);
            pCard11.setImage(null);

            newGame();

            endPane.setVisible(false);
            wagerPane.setVisible(true);
            goToEndButton.setVisible(false);

            hitButton.setVisible(true);
            standButton.setVisible(true);
        } else {
            continueButton.setVisible(false);
            outOfCredits.setVisible(true);
        }
    }

    @FXML
    private void exitGame(ActionEvent event) {
        System.exit(0);
    }
}

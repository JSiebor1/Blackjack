/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.blackjackgui;

import com.mycompany.blackjackgui.App;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
/**
 * FXML Controller class
 *
 * @author mazenkapadi
 */
public class HomeScreenController implements Initializable {
    
    


    @FXML
    private TextField plyrWager;
    @FXML
    private Button startBtn;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    

   

  
    
    public void startBtnClick(ActionEvent event)  throws IOException {
        App.setRoot("mainGame");
    }
   
    
}

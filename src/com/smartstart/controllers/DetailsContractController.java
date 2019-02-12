/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Contract;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 *
 * @author diabl
 */
public class DetailsContractController {

    @FXML
    private Label type;
    @FXML
    private Button CancelButton;
    @FXML
    private Label colStart;
    @FXML
    private Label colSum;
    @FXML
    private Label colPayment;
    @FXML
    private Label colFinish;
    @FXML
    private Label colFree;

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
    @FXML
    public void AfficherDetails(Contract c )
    { 
        
        colStart.setText(c.getStart_date().toString());
       
        colFinish.setText(c.getFinish_date().toString());
        colSum.setText(""+c.getSum());
        colPayment.setText(c.getPayment_method());
    }
    
}

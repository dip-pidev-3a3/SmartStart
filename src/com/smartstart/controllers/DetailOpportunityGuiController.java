/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Opportunity;
import com.smartstart.services.OpportunityService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acmou
 */
public class DetailOpportunityGuiController implements Initializable {
    private Opportunity O;
    @FXML
    private Label coljob_title;
    @FXML
    private Label colAdded_date;
    @FXML
    private Label colExpiry_Date;
    @FXML
    private Label coljob_category;
    @FXML
    private Button CancelButton;
    
    

    /**
     * Initializes the controller class.
     * @param Op
     */
   
    public void AfficherDetails(Opportunity Op)
    { O=Op;
    
        
        System.out.println(O.getJob_title()+"bij");
         System.out.println(O.getJob_title());
        coljob_title.setText(O.getJob_title());
       
        colAdded_date.setText(O.getAdded_date().toString());
        colExpiry_Date.setText(O.getExpiry_date().toString());
         coljob_category.setText(O.getJob_category());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    @FXML
     void annuler() 
    {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
    
}

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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acmou
 */
public class UpdateOpportunityGuiController implements Initializable {
    @FXML
    private Label type;
    @FXML
    private Button CancelButton;
    @FXML
    private TextField category;
    @FXML
    private TextField title;
    @FXML
    private TextField description;
    @FXML
    private DatePicker fin;
    @FXML
    private TextField budget;
    @FXML
    private TextField id;
    @FXML
    private Button update;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void annuler() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
     public void AfficherDetailsUpdate(Opportunity Op)
    { Opportunity O=Op;
    
        
        System.out.println(O.getJob_title()+"bij");
         System.out.println(O.getJob_title());
         id.setText(""+O.getId_Opp());
         id.setVisible(false);
        title.setText(O.getJob_title());
        budget.setText(""+O.getBudget());
         description.setText(O.getJob_description());
         category.setText(O.getJob_category());
         
         
    }

    @FXML
    private void Update(ActionEvent event) {
        System.out.println("bij");
       
        Opportunity O1=new Opportunity(title.getText(),category.getText(),description.getText(),java.sql.Date.valueOf(fin.getValue()),Float.parseFloat(budget.getText()));
        System.out.println(O1);
        System.out.println("bij");
        OpportunityService S=new OpportunityService();
        System.out.println("bij");
         S.update_opportunity(O1,Integer.valueOf(id.getText()));
    System.out.println("bij");
          annuler();
    }
    
}

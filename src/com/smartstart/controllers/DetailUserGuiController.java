/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.fos_user;
import com.smartstart.services.fos_userService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
public class DetailUserGuiController implements Initializable {
    private fos_user O;
    private Label coljob_title;
    private Label colAdded_date;
    private Label colExpiry_Date;
    private Label coljob_category;
    @FXML
    private Button CancelButton;
    @FXML
    private Label last_password_req;
    @FXML
    private Label registration_date;
    @FXML
    private Label type;
    @FXML
    private Label id;
    @FXML
    private Label username;
    @FXML
    private Label email;
    @FXML
    private Label firstname;
    @FXML
    private Label lastname;
    @FXML
    private Label enable;
    @FXML
    private Label password;
    @FXML
    private Label last_login;
    @FXML
    private Label location;
    @FXML
    private Label coljob_title2211;
    @FXML
    private Label birth_date;
    
    

    /**
     * Initializes the controller class.
     * @param Op
     */
   
    public void AfficherDetails(fos_user us)
    { 
    
        username.setText(us.getUsername());
        password.setText(us.getPassword());
    }
    
        @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.smartstart.entities.fos_user;
import com.smartstart.services.fos_userService;
import com.smartstart.controllers.Profile_usersController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class User_detailsController implements Initializable {

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
    private Button CancelButton;
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
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    } 
    
      @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }
       public void AfficherDetails(fos_user us)
    { 
        
        //id.setText(us.getId().);
        username.setText(us.getUsername());
        email.setText(us.getEmail());
        System.out.println(us.getName());
        // System.out.println(O.getJob_title());
        /*coljob_title.setText(O.getJob_title());
       
        colAdded_date.setText(O.getAdded_date().toString());
        colExpiry_Date.setText(O.getExpiry_date().toString());
         coljob_category.setText(O.getJob_category());*/
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Application;
import com.smartstart.entities.Opportunity;
import com.smartstart.services.ApplicationService;
import com.smartstart.services.OpportunityService;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acmou
 */
public class ShowApplicationGuiController implements Initializable {
    @FXML
    private Label type;
    @FXML
    private Button CancelButton;
    @FXML
    private TableView<Application> table;
    @FXML
    private TableColumn<Application,Integer> colapplication;
    @FXML
    private TableColumn<Application, Integer> id_opp;
    @FXML
    private TableColumn<Application, String> coljob_freelancer;
    @FXML
    private TableColumn<Application, String> colState;
    @FXML
    private Button Delete;
    @FXML
    private Button Add;
    private ObservableList<Application> data;
     private ObservableList<Application> data2;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reload();
    }    

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void DenyApp(ActionEvent event) {
         Application O=table.getSelectionModel().getSelectedItem();
       ApplicationService as = new ApplicationService();
        as.update_application(O.getId(),"DENIED");
        reload();
        
    }

    @FXML
    private void AcceptOpp(ActionEvent event) {
        Application O=table.getSelectionModel().getSelectedItem();
       ApplicationService as = new ApplicationService();
        as.update_application(O.getId(),"ACCEPTED");
        reload();
    }
     @FXML
    public void reload() {
        ApplicationService as = new ApplicationService();
        OpportunityService os=new OpportunityService();
        data = as.getApplicationsByEntrepriseId(1);
        

        colapplication.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_opp.setCellValueFactory(new PropertyValueFactory<>("opportunityId"));

        coljob_freelancer.setCellValueFactory(new PropertyValueFactory<>("freelancerId"));

        colState.setCellValueFactory(new PropertyValueFactory<>("state"));

        

        System.out.println(data);

        table.setItems(data);
         table.setEditable(true);

    }
    
}

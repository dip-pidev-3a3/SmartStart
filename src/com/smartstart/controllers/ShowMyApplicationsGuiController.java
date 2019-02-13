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
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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
public class ShowMyApplicationsGuiController implements Initializable {

    @FXML
    private Label type;
    @FXML
    private Button CancelButton;
    @FXML
    private TableView<Application> table;
    @FXML
    private TableColumn<Application, Integer> colapplication;
    @FXML
    private TableColumn<Application, Integer> id_opp;
    private TableColumn<Application, String> coljob_freelancer;
    @FXML
    private TableColumn<Application, String> colState;
    private ObservableList<Application> data;
    private ObservableList<Application> data2;
    @FXML
    private Button withdraw;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        reload();
    }

    @FXML
    private void annuler(ActionEvent event) throws IOException {
       
       
            Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/smartstart/gui/DisplayAllOpportunitiesGui.fxml"));
         Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewOpportunityScene);
    }

    public void reload() {
        ApplicationService as = new ApplicationService();
        OpportunityService os = new OpportunityService();
        data = as.getApplicationsByFreelancerId(1);

        colapplication.setCellValueFactory(new PropertyValueFactory<>("id"));
        id_opp.setCellValueFactory(new PropertyValueFactory<>("opportunityId"));

       

        colState.setCellValueFactory(new PropertyValueFactory<>("state"));

        System.out.println(data);

        table.setItems(data);
        table.setEditable(true);

    }

    private void alert(String Message) {
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("SUCESS!");
        a1.setHeaderText("WITHDRAWN FROM APPLICATION");
        a1.setContentText(Message);
        a1.showAndWait();
    }

    private void alert1(String Message) {
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("ERROR!");
        a1.setHeaderText("CAN'T WITHDRAW NOW");
        a1.setContentText(Message);
        a1.showAndWait();
    }

    @FXML
    private void withdraw(ActionEvent event) {
        Application O = table.getSelectionModel().getSelectedItem();
        ApplicationService as = new ApplicationService();
        if (O.getState().equals("APPLIED")) {
            as.delete_Application(O.getId());
            alert("YOU HAVE WITHDRAWN FROM THIS OPPORTUNITY");
            reload();
        } else {
            alert1("APPLICATION IS ALREADY ACCEPTED/DENIED");
        }

    }

}

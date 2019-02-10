/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Opportunity;
import com.smartstart.services.OpportunityService;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acmou
 */
public class Profile_OpportunitiesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Opportunity> table = new TableView<>();

    @FXML
    private TableColumn<Opportunity, String> coljob_title;
    @FXML
    private TableColumn<Opportunity, String> coljob_category;
    @FXML
    private TableColumn<Opportunity, String> coljob_description;
    @FXML
    private TableColumn<Opportunity, Float> colbudget;
    @FXML
    private TableColumn<Opportunity, Date> colDuration;
    @FXML
    private TableColumn<Opportunity, Date> colExpiry_Date;
    @FXML
    private TableColumn<Opportunity, Date> colAdded_date;
    

    private ObservableList<Opportunity> data;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpportunityService as = new OpportunityService();

        data = as.Display_Opportunity();
        table.setEditable(true);

      
        coljob_title.setCellValueFactory(new PropertyValueFactory<>("job_title"));

        coljob_category.setCellValueFactory(new PropertyValueFactory<>("job_category"));

        coljob_description.setCellValueFactory(new PropertyValueFactory<>("job_description"));

        colbudget.setCellValueFactory(new PropertyValueFactory<>("Budget"));

        colDuration.setCellValueFactory(new PropertyValueFactory<>("job_Duration"));

       colExpiry_Date.setCellValueFactory(new PropertyValueFactory<>("Expiry_date"));

        colAdded_date.setCellValueFactory(new PropertyValueFactory<>("added_date"));
        coljob_title.setSortType(TableColumn.SortType.DESCENDING);
        coljob_category.setSortType(TableColumn.SortType.DESCENDING);
        coljob_description.setSortType(TableColumn.SortType.DESCENDING);
        colbudget.setSortType(TableColumn.SortType.DESCENDING);
        colDuration.setSortType(TableColumn.SortType.DESCENDING);
        colExpiry_Date.setSortType(TableColumn.SortType.DESCENDING);
        colAdded_date.setSortType(TableColumn.SortType.DESCENDING);

        
        
       

       

        System.out.println(data);

        table.setItems(data);

    }

}

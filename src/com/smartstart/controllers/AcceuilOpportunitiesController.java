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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.Pagination;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author acmou
 */
public class AcceuilOpportunitiesController implements Initializable {
    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private Pagination pagination;
    @FXML
    private ListView<Opportunity> List;
    @FXML
    private ObservableList<Opportunity> data=FXCollections.observableArrayList();
     final Tooltip tooltip=new Tooltip();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        OpportunityService S=new OpportunityService();
        data=S.DisplayMy_Opportunities(2);
        List.setItems(data);
        
        List.setCellFactory(OpportunityListView -> new ListOpportunitiesCell());
        
        // TODO
    }    
    
}

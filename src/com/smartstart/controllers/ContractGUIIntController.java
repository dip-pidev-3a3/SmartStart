/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Contract;
import com.smartstart.services.ContractServiceImpl;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author diabl
 */
public class ContractGUIIntController implements Initializable {

    @FXML
    private ImageView Profile_pic;
    @FXML
    private Label username;
    @FXML
    private ImageView pic1;
    @FXML
    private Pane pnlCustomer;
    @FXML
    private Pane pnlOrders;
    @FXML
    private Pane pnlMenus;
    @FXML
    private Pane pnlOverview;
    @FXML
    private TextField filter;
    @FXML
    private Label count;
    @FXML
    private VBox pnItems;
    ObservableList<Contract> data;
    @FXML
    private ListView<Contract> List;

    /**
     * Initializes the controller class.
     */
   

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ContractServiceImpl S=new ContractServiceImpl();
        try {
            data=S.listContract(1);
             List.setItems(data);
             data.forEach(System.out::println);
        
        List.setCellFactory(ContractListView -> new ContractCellController());
        } catch (SQLException ex) {
            Logger.getLogger(ContractGUIIntController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
    }
    
}

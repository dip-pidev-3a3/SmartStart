/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Contract;
import com.smartstart.services.ContractServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

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
    private Label count;
    ObservableList<Contract> data;
    @FXML
    private ListView<Contract> List;
    @FXML
    private TextField recherche;
    @FXML
    private ListView<?> display;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ContractServiceImpl S = new ContractServiceImpl();

        int i = S.CountContracts(1);
        count.setText(String.valueOf(i));
        data = S.listContract(1);
        List.setItems(data);
        data.forEach(System.out::println);

        List.setCellFactory(ContractListView -> new ContractCellController());

        initFilter();


    }

    public void initFilter() {
        FilteredList<Contract> filteredData = new FilteredList<>(data, p -> true);
        recherche.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(cont -> {
                // If filter text is empty, display all persons.
                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if ((cont.getApplication().getOpportunity().getJob_title().toLowerCase().contains(lowerCaseFilter)) || (cont.getUser().getUsername().toLowerCase().contains(lowerCaseFilter))) {
                    return true; // Filter matches first name.
                }
                return false; // Does not match.
            });
        });
        SortedList<Contract> sortedData = new SortedList<>(filteredData);        
        List.setItems(sortedData);
        long s = filteredData.stream().count();
        count.setText(String.valueOf(s));
        

    }
}


    

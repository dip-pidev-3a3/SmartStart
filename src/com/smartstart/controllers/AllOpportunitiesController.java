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
import com.sun.rowset.internal.Row;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Date;
import java.net.URL;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.RichTextString;

import java.util.Optional;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acmou
 */
public class AllOpportunitiesController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML
    private TableView<Opportunity> table = new TableView<>();
    @FXML
    private TableColumn<Opportunity, Integer> colid_opportunity;
    @FXML
    private TableColumn<Opportunity, String> coljob_title;
    @FXML
    private TableColumn<Opportunity, String> coljob_category;
    @FXML
    private TableColumn<Opportunity, String> coljob_description;
    @FXML
    private TableColumn<Opportunity, Float> colbudget;
    @FXML
    private TableColumn<Opportunity, String> colDuration;
    @FXML
    private TableColumn<Opportunity, Date> colExpiry_Date;
    @FXML
    private TableColumn<Opportunity, Date> colAdded_date;

    private ObservableList<Opportunity> data;
    @FXML
    private AnchorPane parent;
    @FXML
    private TextField txtField;
    @FXML
    private Button displayopp;
    @FXML
    private Label Nombre_Opp;
    @FXML
    private Button reload1;
    @FXML
    private Button apply;

    @FXML
    public void displayDetails(ActionEvent event) {
        try {
            FXMLLoader detail = new FXMLLoader(getClass().getResource("/com/smartstart/gui/DetailOpportunityGui.fxml"));
            Parent root1 = (Parent) detail.load();
            Stage stage = new Stage();
            DetailOpportunityGuiController p = detail.getController();

            System.out.println(table.getSelectionModel().getSelectedItem());
            stage.setScene(new Scene(root1));
            stage.show();
            p.AfficherDetails(table.getSelectionModel().getSelectedItem());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        

        reload();
        //initFilter();

    }

    private void initFilter() {

        txtField.setPromptText("Filter");

        txtField.textProperty().addListener(new InvalidationListener() {

            @Override

            public void invalidated(Observable o) {

                if (txtField.textProperty().get().isEmpty()) {

                    table.setItems(data);

                    return;

                }

                ObservableList<Opportunity> tableItems = FXCollections.observableArrayList();

                ObservableList<TableColumn<Opportunity, ?>> cols = table.getColumns();

                for (int i = 0; i < data.size(); i++) {

                    for (int j = 0; j < cols.size(); j++) {

                        TableColumn col = cols.get(j);

                        String cellValue = col.getCellData(data.get(i)).toString();

                        cellValue = cellValue.toLowerCase();

                        if (cellValue.contains(txtField.textProperty().get().toLowerCase())) {

                            tableItems.add(data.get(i));

                            break;

                        }

                    }

                }

                table.setItems(tableItems);

            }

        });

    }

 



 

    @FXML
    public void reload() {
        OpportunityService as = new OpportunityService();

       

        data = as.Display_Opportunity();

        colid_opportunity.setCellValueFactory(new PropertyValueFactory<>("id_Opp"));
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

    private void alert1(String Message) {
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("SUCESS!");
        a1.setHeaderText("APPLICATION RECEIVED");
        a1.setContentText(Message);
        a1.showAndWait();
    }

    @FXML
    private void apply(ActionEvent event) {
        
        ApplicationService p1=new ApplicationService();
        if (p1.HasApplied(1,table.getSelectionModel().getSelectedItem().getId_Opp())==false)
        {
        if (p1.isApt(1,table.getSelectionModel().getSelectedItem().getId_Opp()))
        {
        Application app=new Application(table.getSelectionModel().getSelectedItem().getId_Opp(),1,"APPLIED"); 
        p1.create_application(app);
          alert1("YOUR APPLICATION HAS BEEN SENT");
        }
        
        else 
         alert1("YOU DON'T HAVE THE NECESSARY SKILLS TO APPLY");
        
         
    
    
    } else alert1("YOU HAVE ALREADY APPLIED TO THIS OPPORTUNITY");
    }
  

}

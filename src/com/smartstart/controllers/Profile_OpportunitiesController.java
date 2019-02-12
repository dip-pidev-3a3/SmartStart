/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Opportunity;
import com.smartstart.services.OpportunityService;
import com.sun.rowset.internal.Row;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import java.sql.Date;
import java.net.URL;
<<<<<<< HEAD
import org.apache.poi.hssf.usermodel.HSSFCell;
=======
>>>>>>> 9f71d8dd43a3ff6bae69928df92763b4f211e9c9
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
public class Profile_OpportunitiesController implements Initializable {

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
<<<<<<< HEAD
    private Button displayopp;
    @FXML
    private Label Nombre_Opp;
    @FXML
    private Button reload1;
    @FXML
=======
>>>>>>> 9f71d8dd43a3ff6bae69928df92763b4f211e9c9
    private Button DeleteOpp;
    @FXML
    private Button Add_Opportunity;
    @FXML
<<<<<<< HEAD
    private Button Show_My_Draft;
    @FXML
    private Button reload;
=======
    private Button displayopp;
    @FXML
    private Button Show_My_Draft;
    @FXML
    private Button reload;
    @FXML
    private Label Nombre_Opp;
>>>>>>> 9f71d8dd43a3ff6bae69928df92763b4f211e9c9

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
        OpportunityService s = new OpportunityService();
        int i = s.CountOpportunities(1);

        Nombre_Opp.setText("" + i + "");

        reload();
        initFilter();

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
    public void RemoveOpportunity(ActionEvent event) {
        if (table.getSelectionModel().getSelectedItem() == null) {
            alert1("PLEASE SELECT THE OPPORTUNITY THAT YOU WANT TO DELETE");
            return;
        } else {
            if (alert1Confirmation() == true) {
                int id_opp = 0;
                ObservableList<Opportunity> AllOp, SingleOp;
                AllOp = table.getItems();
                SingleOp = table.getSelectionModel().getSelectedItems();
                OpportunityService s = new OpportunityService();
                table.getSelectionModel().getSelectedItem();
                System.out.println("Value is in this row which" + table.getSelectionModel().getSelectedItem().getId_Opp());

                s.delete_opporunity(table.getSelectionModel().getSelectedItem().getId_Opp());
                SingleOp.forEach(AllOp::remove);
            } else {
                return;
            }

        }
    }

    @FXML
    public void Add_an_opportunity(ActionEvent event) {
        try {
            FXMLLoader detail = new FXMLLoader(getClass().getResource("/com/smartstart/gui/Add_OpportunityGui.fxml"));
            Parent root2 = (Parent) detail.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root2));
            stage1.show();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    @FXML
    public void Show_Draft(ActionEvent event) {
        try {
            FXMLLoader detail = new FXMLLoader(getClass().getResource("/com/smartstart/gui/ShowDraftGui.fxml"));
            Parent root2 = (Parent) detail.load();
            Stage stage1 = new Stage();
            stage1.setScene(new Scene(root2));
            stage1.show();

        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private boolean alert1Confirmation() {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
        a1.setTitle("CONFIRMATION DIALOG");
        a1.setHeaderText("SUPPRESSION CONFIRMATION");
        a1.setContentText("ARE YOU SURE THAT YOU WANT TO DELETE THIS OPPORTUNITY?");
        Optional<ButtonType> result = a1.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }

    }

    @FXML
    public void reload() {
        OpportunityService as = new OpportunityService();

        int i = as.CountOpportunities(1);

        Nombre_Opp.setText("" + i + "");

        data = as.DisplayMy_Opportunities(1);

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
        a1.setTitle("Alert");
        a1.setHeaderText("Champ Vide");
        a1.setContentText(Message);
        a1.showAndWait();
    }
    @FXML
    private void ExportToExcel() throws FileNotFoundException, IOException
    {
        HSSFRow row  =null;
        HSSFWorkbook workbook = new HSSFWorkbook();
        HSSFSheet spreadsheet = workbook.createSheet("sample");
        

        for(int i=0;i<table.getItems().size();i++){
             row= spreadsheet.createRow(i);          
             for(int j=0; j< table.getColumns().size();j++) {                
                 if(table.getColumns().get(j).getCellData(i) != null) {
                     row.createCell(j).setCellValue(table.getColumns().get(j).getCellData(i).toString());
                 }else{
                     row.createCell(j).setCellValue("");
                 }
             }
         }
        File File = new File("mounir.xlsx");
        FileOutputStream out = new FileOutputStream(File);
        workbook.write(out);
        out.close();
        System.out.println("Data is wrtten Successfully");
    }
    

}

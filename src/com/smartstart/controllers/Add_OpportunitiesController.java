/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Opportunity;
import com.smartstart.services.OpportunityService;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author acmou
 */
public class Add_OpportunitiesController implements Initializable {
    @FXML
    private AnchorPane parent;
    @FXML
    private Label type;
    @FXML
    private Button Save_and_exit;
    @FXML
    private Button Add_Opportunity;
    @FXML
    private Button CancelButton;
    @FXML
    private TextField job_title;
    @FXML
    private TextField Job_category;
    @FXML
    private TextArea job_description;
    @FXML
    private DatePicker Expiry_Date;
    @FXML
    private ComboBox<String> Needed_skills;
    @FXML
    private TextField Budget;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    @FXML
     public void annuler()
    {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
       
    }
    @FXML
    public void Add_OpportunityToDb()
    {
        if(job_title.getText().isEmpty())
            {
                alert1("Job Title Is Empty !!");
                Exception e=new Exception();
                showExceptionDialog(e);
              
                return;
            }
        if(Job_category.getText().isEmpty())
            {
                alert1("Job Category Is Empty !!");
                return;
            }
        if(job_description.getText().isEmpty())
            {
                alert1("Job Description Is Empty !!");
                return;
            }
        if(Budget.getText().isEmpty())
            {
                alert1("Budget Is Empty !!");
                return;
            }
         if(Expiry_Date.getValue().isBefore(LocalDate.now()))
            {
                alert1("La date d'expiration ne peut pas etre dans le passé !!");
                return;
            }
        Date date = java.sql.Date.valueOf(Expiry_Date.getValue());
  

        Opportunity O=new Opportunity(job_title.getText(),Job_category.getText().toString(),job_description.getText(),Float.parseFloat(Budget.getText()),0,date,1);
    
        
        OpportunityService Os=new OpportunityService();
        Os.create_Opportunity(O, 2);
        Profile_OpportunitiesController P=new Profile_OpportunitiesController();
        annuler();
        
    }
    @FXML
    public void SaveOpportunityAndExit()
    {if(job_title.getText().isEmpty())
            {
                alert1("Job Title Is Empty !!");
                return;
            }
        if(Job_category.getText().isEmpty())
            {
                alert1("Job Category Is Empty !!");
                return;
            }
        if(job_description.getText().isEmpty())
            {
                alert1("Job Description Is Empty !!");
                return;
            }
        if(Budget.getText().isEmpty())
            {
                alert1("Budget Is Empty !!");
                return;
            }
         if(Expiry_Date.getValue().isBefore(LocalDate.now()))
            {
                alert1("La date d'expiration ne peut pas etre dans le passé !!");
                return;
            }
        Date date = java.sql.Date.valueOf(Expiry_Date.getValue());

        Opportunity O=new Opportunity(job_title.getText(),Job_category.getText().toString(),job_description.getText(),Float.parseFloat(Budget.getText()),0,date,1);
        OpportunityService Os=new OpportunityService();
        Os.create_Opportunitydraft(O,2);
        annuler();
    }
    private void alert1(String Message)
    {
        Alert a1=new Alert(Alert.AlertType.ERROR);
        a1.setTitle("Alert");
        a1.setHeaderText("Champ Vide");
        a1.setContentText(Message);
        a1.showAndWait();
                
    }
     public static void showExceptionDialog(Exception e) {
    Alert alert = new Alert(Alert.AlertType.ERROR);

    alert.setTitle("Exception Dialog");
    alert.setHeaderText("An error occurred:");

    String content = "Error: ";
    if (null != e) {
        content += e.toString() + "\n\n";
    }

    alert.setContentText(content);

    Exception ex = new Exception(e);

    //Create expandable Exception.
    StringWriter sw = new StringWriter();
    PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);

    String exceptionText = sw.toString();

    //Set up TextArea
    TextArea textArea = new TextArea(exceptionText);
    textArea.setEditable(false);
    textArea.setWrapText(true);


    textArea.setPrefHeight(600);
    textArea.setPrefWidth(800);


    //Set expandable Exception into the dialog pane.
    alert.getDialogPane().setExpandableContent(textArea);


    alert.showAndWait();
}
   
    
    
}

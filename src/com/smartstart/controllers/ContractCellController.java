/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Contract;
import com.smartstart.entities.Opportunity;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import static jdk.nashorn.tools.ShellFunctions.input;

/**
 * FXML Controller class
 *
 * @author diabl
 */
public class ContractCellController extends ListCell<Contract>{

    @FXML
    private Label titles;
    @FXML
    private Label description;
    @FXML
    private Label username;
    @FXML
    private TextField sum;
    @FXML
    private DatePicker start;
    @FXML
    private DatePicker finish;
    @FXML
    private Label application_id;
    @FXML
    private Label contract_id;
    private FXMLLoader mLLoader;
    final Tooltip tooltip=new Tooltip();
    @FXML
    private AnchorPane gridPane;
    @FXML
    private Button update;
    @FXML
    private Button remove;

    
   @Override
    protected void updateItem(Contract student, boolean empty) {
        super.updateItem(student, empty);

        if(empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/com/smartstart/gui/ContractCellGui.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
           

            description.setText(student.getDescription());
            username.setText(student.getFreelancer());
            sum.setText(String.valueOf(student.getSum()));
            //LocalDate startdate = Instant.ofEpochMilli(student.getStart_date().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            //start.setValue(startdate);
            //LocalDate finishdate = Instant.ofEpochMilli(student.getFinish_date().getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
            //finish.setValue(finishdate);
            application_id.setText(String.valueOf(student.getId_application()));
            contract_id.setText(String.valueOf(student.getId_contract()));
            //Duration duration = Duration.between(student.getStart_date(), student.getFinish_date());
            //tooltip.setText("Duration of Contract :"+duration);
            titles.setTooltip(tooltip);

         

            setText(null);
            setGraphic(gridPane);
        }

    }
       
    
}

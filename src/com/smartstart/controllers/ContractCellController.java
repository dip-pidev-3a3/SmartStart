/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Contract;
import com.smartstart.services.ContractServiceImpl;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author diabl
 */
public class ContractCellController extends ListCell<Contract> {

    @FXML
    private Label titles;
    @FXML
    private Label description;
    @FXML
    private Label username;
    @FXML
    private TextField sum;
    @FXML
    private TextField start;
    @FXML
    private TextField finish;
    @FXML
    private Label application_id;
    @FXML
    private Label contract_id;
    private FXMLLoader mLLoader;
    final Tooltip tooltip = new Tooltip();
    @FXML
    private AnchorPane gridPane;
    @FXML
    private Button update;
    @FXML
    private Button remove;

    @Override
    protected void updateItem(Contract student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

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

            description.setText(student.getApplication().getOpportunity().getJob_title());
            username.setText(student.getUser().getUsername());
            sum.setText(String.valueOf(student.getSum()));

            start.setText(student.getStart_date().toString());

            finish.setText(student.getFinish_date().toString());
            application_id.setText(String.valueOf(student.getApplication().getId()));
            application_id.setVisible(false);
            contract_id.setText(String.valueOf(student.getId_contract()));
            contract_id.setVisible(false);

            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
            Date firstDate;
            try {
                firstDate = sdf.parse(student.getStart_date().toString());
                Date secondDate = sdf.parse(student.getFinish_date().toString());
                long diffInMillies = Math.abs(secondDate.getTime() - firstDate.getTime());
                long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
                tooltip.setText("Duration of Contract :" + diff + "  days");
                titles.setTooltip(tooltip);
            } catch (ParseException ex) {
                Logger.getLogger(ContractCellController.class.getName()).log(Level.SEVERE, null, ex);
            }

            remove.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {

                    if (alertConfirmation() == true) {
                        try {
                            ContractServiceImpl cs = new ContractServiceImpl();
                            cs.removeContract(student.getId_contract());

                        } catch (SQLException ex) {
                            Logger.getLogger(ContractCellController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Parent tableViewContract;
                        try {
                            tableViewContract = FXMLLoader.load(getClass().getResource("/com/smartstart/gui/ContractGUIInt.fxml"));
                            Scene tableViewContractScene = new Scene(tableViewContract);
                            Stage window = (Stage) ((Node) t.getSource()).getScene().getWindow();
                            window.setScene(tableViewContractScene);
                        } catch (IOException ex) {
                            Logger.getLogger(ContractCellController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            });
            
            update.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent t) {

                    ContractServiceImpl cs = new ContractServiceImpl();
                    student.setSum(Float.valueOf(sum.getText()));
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
                    try {
                        student.setStart_date(sdf.parse(start.getText()));
                        student.setFinish_date(sdf.parse(finish.getText()));
                    } catch (ParseException ex) {
                        alert("PLS Check That The Format Of The Start Date & Finish Date Is Like yyyy-MM-dd");
                    }
                    if (student.getFinish_date().before(student.getStart_date())) {
                        alert("PLS Check That The Finish Date Must Be After The Start Date");
                    } else {
                        try {
                            cs.updateContract(student);

                        } catch (SQLException ex) {
                            Logger.getLogger(ContractCellController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        Parent tableViewContract;
                        try {
                            tableViewContract = FXMLLoader.load(getClass().getResource("/com/smartstart/gui/ContractGUIInt.fxml"));
                            Scene tableViewContractScene = new Scene(tableViewContract);
                            Stage window = (Stage) ((Node) t.getSource()).getScene().getWindow();
                            window.setScene(tableViewContractScene);
                        } catch (IOException ex) {
                            Logger.getLogger(ContractCellController.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            });
        };

        setText(null);
        setGraphic(gridPane);
    }

    private void alert(String Message) {
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("Alert");
        a1.setHeaderText("Not Valid");
        a1.setContentText(Message);
        a1.showAndWait();

    }

    private boolean alertConfirmation() {
        Alert a1 = new Alert(Alert.AlertType.CONFIRMATION);
        a1.setTitle("CONFIRMATION DIALOG");
        a1.setHeaderText("SUPPRESSION CONFIRMATION");
        a1.setContentText("ARE YOU SURE THAT YOU WANT TO DELETE THIS CONTRACT ?");
        Optional<ButtonType> result = a1.showAndWait();
        if (result.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }

    }

}

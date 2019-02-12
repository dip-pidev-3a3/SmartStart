/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import static com.smartstart.controllers.Add_OpportunitiesController.showExceptionDialog;
import com.smartstart.entities.Contract;
import com.smartstart.entities.Opportunity;
import com.smartstart.services.ContractServiceImpl;
import com.smartstart.services.OpportunityService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author diabl
 */
public class AddContractController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private Label type;
    @FXML
    private DatePicker startDate;
    @FXML
    private Button addExport;
    @FXML
    private DatePicker finishDate;
    @FXML
    private TextField sum;
    @FXML
    private Button CancelButton;
    @FXML
    private TextField free;
    @FXML
    private Button add;
    @FXML
    private ComboBox<?> Payment;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void annuler(ActionEvent event) {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void AddContractandExport(ActionEvent event) {
        try {
            if (free.getText().isEmpty()) {
                alert1("The Freelancer Name Is Empty  !!");
                Exception e = new Exception();
                showExceptionDialog(e);
                return;
            }
            if (sum.getText().isEmpty()) {
                alert1("Sum Is Empty");
                return;
            }
            if (startDate.getValue().isBefore(LocalDate.now())) {
                alert1("La date de debut ne peut pas etre dans le passé !!");
                return;
            }
            if (finishDate.getValue().isBefore(LocalDate.now())) {
                alert1("The Finish Date Can't Be In The Past !!");
                return;
            }
            Date startdate = java.sql.Date.valueOf(startDate.getValue());
            Date finishdate = java.sql.Date.valueOf(finishDate.getValue());
            if (finishdate.before(startdate)) {
                alert1("The Finish Date Should Be After The Start Date  !!");
                return;
            }

            Contract c = new Contract();

            ContractServiceImpl cs = new ContractServiceImpl();
            cs.addContract(c);
            ContractController cc = new ContractController();
            cc.reload();
            annuler();
        } catch (SQLException ex) {
            Logger.getLogger(AddContractController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    public void annuler() {
        Stage stage = (Stage) CancelButton.getScene().getWindow();
        stage.close();

    }

    @FXML
    private void AddContract(ActionEvent event) {
        try {
            if (free.getText().isEmpty()) {
                alert1("The Freelancer Name Is Empty  !!");
                Exception e = new Exception();
                showExceptionDialog(e);
                return;
            }
            if (sum.getText().isEmpty()) {
                alert1("Sum Is Empty");
                return;
            }
            if (startDate.getValue().isBefore(LocalDate.now())) {
                alert1("La date de debut ne peut pas etre dans le passé !!");
                return;
            }
            if (finishDate.getValue().isBefore(LocalDate.now())) {
                alert1("The Finish Date Can't Be In The Past !!");
                return;
            }
            Date startdate = java.sql.Date.valueOf(startDate.getValue());
            Date finishdate = java.sql.Date.valueOf(finishDate.getValue());
            if (finishdate.before(startdate)) {
                alert1("The Finish Date Should Be After The Start Date  !!");
                return;
            }

            Contract c = new Contract();

            ContractServiceImpl cs = new ContractServiceImpl();
            cs.addContract(c);
            Profile_OpportunitiesController p = new Profile_OpportunitiesController();
            p.reload();
            Profile_OpportunitiesController P = new Profile_OpportunitiesController();
            annuler();
        } catch (SQLException ex) {
            Logger.getLogger(AddContractController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void alert1(String Message) {
        Alert a1 = new Alert(Alert.AlertType.ERROR);
        a1.setTitle("Alert");
        a1.setHeaderText("Champ Vide");
        a1.setContentText(Message);
        a1.showAndWait();

    }

}

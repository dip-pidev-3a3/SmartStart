/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Contract;
import com.smartstart.entities.fos_user;
import com.smartstart.services.ChatServiceImpl;
import com.smartstart.services.ContractServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author diabl
 */
public class ChatDiscCellController extends ListCell<fos_user> {

    @FXML
    private AnchorPane gridPane;
    @FXML
    private Button user;
    private FXMLLoader mLLoader;

    @Override
    protected void updateItem(fos_user student, boolean empty) {
        super.updateItem(student, empty);

        if (empty || student == null) {

            setText(null);
            setGraphic(null);

        } else {
            if (mLLoader == null) {
                mLLoader = new FXMLLoader(getClass().getResource("/com/smartstart/gui/ChatDiscCell.fxml"));
                mLLoader.setController(this);

                try {
                    mLLoader.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            user.setText(student.getName()+" "+student.getLast_name());

            user.setOnAction(new EventHandler<ActionEvent>() {

                @Override
                public void handle(ActionEvent t) {

                    ChatServiceImpl cs = new ChatServiceImpl();
                    try {
                        ChatController.dataMessage = cs.getMessages(1, 2);
                        

                    } catch (SQLException ex) {
                        Logger.getLogger(ContractCellController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Parent tableViewContract;
                        try {
                            tableViewContract = FXMLLoader.load(getClass().getResource("/com/smartstart/gui/ChatGui.fxml"));
                            Scene tableViewContractScene = new Scene(tableViewContract);
                            Stage window = (Stage) ((Node) t.getSource()).getScene().getWindow();
                            window.setScene(tableViewContractScene);
                        } catch (IOException ex) {
                            Logger.getLogger(ContractCellController.class.getName()).log(Level.SEVERE, null, ex);
                        }
               
         

                }

            });
        };

        setText(null);
        setGraphic(gridPane);
    }
    
}


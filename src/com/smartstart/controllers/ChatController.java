/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Message;
import com.smartstart.entities.Opportunity;
import com.smartstart.services.ChatServiceImpl;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 *
 * @author diabl
 */
public class ChatController implements Initializable {
    
    @FXML
    private TableView<Opportunity> chats = new TableView<>();
    @FXML
    private TableColumn<String, String> coljob_title;
    @FXML
    private TableColumn<Message, String> messages;
    private ObservableList<Message> data;
    ChatServiceImpl cs = new ChatServiceImpl();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}

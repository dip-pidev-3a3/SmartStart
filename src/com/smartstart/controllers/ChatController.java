/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Message;
import com.smartstart.entities.fos_user;
import com.smartstart.services.ChatServiceImpl;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

/**
 *
 * @author diabl
 */
public class ChatController implements Initializable {
    
    private ObservableList<fos_user> data;
    ChatServiceImpl cs = new ChatServiceImpl();
    @FXML
    private ListView<fos_user> List;
    @FXML
    private ImageView Profile_pic;
    @FXML
    private Label username;
    @FXML
    private ImageView pic1;
    @FXML
    private Label count;
    @FXML
    private TextField recherche;
    @FXML
    private TextField content;
    @FXML
    private Button send;
    @FXML
    private ListView<Message> messages;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        try {
            data = cs.discussionList(1);
        } catch (SQLException ex) {
            Logger.getLogger(ChatController.class.getName()).log(Level.SEVERE, null, ex);
        }
        count.setText(String.valueOf(data.size()));
        List.setItems(data);
        data.forEach(System.out::println);

        List.setCellFactory(ChatListView -> new ChatDiscCellController());
        
    }
    
}

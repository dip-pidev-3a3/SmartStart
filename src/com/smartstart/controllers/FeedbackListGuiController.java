/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Feedback;
import com.smartstart.services.FeedbackServiceImpl;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author dytcha
 */
public class FeedbackListGuiController implements Initializable {

    @FXML
    private ListView<Feedback> List;
    @FXML
    private ImageView Profile_pic;
    @FXML
    private Label username;
    @FXML
    private ImageView pic1;
    ObservableList<Feedback> data;
    @FXML
    private AnchorPane recherche;
    @FXML
    private TextField rechercheF;
    @FXML
    private Text count;
    @FXML
    private Button addF;
    

    /**
     * Initializes the controller class.
     */
   
    
      @Override
    public void initialize(URL location, ResourceBundle resources) {
        FeedbackServiceImpl S =new FeedbackServiceImpl();
        try {
            
            data=S.listerFeedback(1);
             List.setItems(data);
             data.forEach(System.out::println);
        
        List.setCellFactory(FeedbackListView -> new FeedbackCellGuiController());
       // initFilter();
        int i = S.CountFeedbacks(1);
        count.setText(String.valueOf(i));
        rechercheF.textProperty().addListener(new ChangeListener<String>(){
            @Override
            public void changed(ObservableValue<? extends String> observable, String oldValue, 
                String newValue) {
                ObservableList<Feedback> tmp = FXCollections.observableArrayList();
                for (Feedback feedback : data) {
                    if(feedback.getComment().toLowerCase().contains(newValue.toLowerCase())){
                        tmp.add(feedback);
                    }
                }
                List.setItems(null);

                count.setText(String.valueOf(tmp.stream().count()));
                                List.setItems(tmp);
                                    

                
            }});
        
        
      
        
        
        
        } catch (SQLException ex) {
        }
        
        
        
    }
    
    
    @FXML
    public void ShowAddF(ActionEvent event) throws IOException{
   
        Parent tableViewFeedback=FXMLLoader.load(getClass().getResource("/com/smartstart/gui/AddFeedbackGui.fxml"));
         Scene tableViewFeedbackScene=new Scene (tableViewFeedback);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewFeedbackScene);
        
    }
    
    
    }
    
    
    



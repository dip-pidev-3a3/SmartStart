/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.services.fos_userService;
import com.smartstart.util.ConnectionDb;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * FXML Controller class
 *
 * @author HP
 */
public class LoginController implements Initializable {

    @FXML
    private StackPane rootPane;
    @FXML
    private ImageView imgProgress;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private Button login;
    @FXML
    private Label isconnected;
    @FXML
    private Hyperlink Newaccount;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

     @FXML
    private void login(ActionEvent event) throws SQLException, IOException  {
          ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                PreparedStatement ps=null;
         //       System.out.println("CI BON ");
     /*   if (username.getText() =="yes" && password.getText()=="yes")
           { System.out.println("YES");
                    isconnected.setText("YES");} */ //les {PROBLEM}
          fos_userService fss = new fos_userService();
       
         if (fss.Authentification(username.getText(), password.getText()))
         {
             System.out.println("EY");
             isconnected.setText("connectééééééé");
            Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/smartstart/gui/Freelancerconnected.fxml"));
         Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewOpportunityScene);
             
             
             // scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
            // Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
             //window.setScene(tableViewOpportunityScene);
             
         }
         else isconnected.setText("introuvable");
         
       /*      try {
                      Statement statement = cn.createStatement();
                      String sql ="SELECT * FROM `fos_user` WHERE username = "+username.getText()+" and password = "+password.getText();
                      System.out.println(sql);
                   //   ps=cn.prepareStatement(sql);
                      ResultSet rs = statement.executeQuery(sql);
                      System.out.println(rs);
                      while (rs.next())
                      
                          System.out.println("CI BON ");
                          isconnected.setText("connecteey");
                      
                     //isconnected.setText("LAAAAAAA");
                     System.out.println("LA");
        } catch (Exception e) {
        } */
        
    }

    
   
    @FXML
    private void newaccount(ActionEvent event) throws IOException {
                 Parent tableViewOpportunity=FXMLLoader.load(getClass().getResource("/com/smartstart/gui/Freelancer_RegisterGUI.fxml"));
         Scene tableViewOpportunityScene=new Scene (tableViewOpportunity);
         Stage window=(Stage)((Node)event.getSource()).getScene().getWindow();
         window.setScene(tableViewOpportunityScene);
        
        
    }
    
}

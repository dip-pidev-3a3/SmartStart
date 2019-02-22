/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import static com.smartstart.controllers.Add_OpportunitiesController.showExceptionDialog;
import com.smartstart.entities.Application;
import com.smartstart.entities.Feedback;
import com.smartstart.entities.Opportunity;
import com.smartstart.entities.fos_user;
import com.smartstart.services.ApplicationService;
import com.smartstart.services.FeedbackServiceImpl;
import com.smartstart.services.OpportunityService;
import com.smartstart.services.fos_userService;
import java.net.URL;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.controlsfx.control.Rating;

/**
 * FXML Controller class
 *
 * @author dytcha
 */
public class AddFeedbackGuiController implements Initializable {

    @FXML
    private AnchorPane parent;
    @FXML
    private Label type;
    @FXML
    private Button addExport;
    @FXML
    private Rating rating;
    @FXML
    private TextField comment;
    @FXML
    private Button add;
    @FXML
    private Button CancelButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddFeedback(ActionEvent event) throws SQLException {
       
       
  fos_user u=new fos_user();
  fos_userService fu = new fos_userService();
  u=fu.get_user_by_id(1);
  
  
  
  Feedback f=new Feedback();
  FeedbackServiceImpl fs =new FeedbackServiceImpl();
  
  f.setUser(u);
  f.setComment(comment.getText());
  f.setRating((float) rating.getRating());
  fs.addFeedback(f);
    }

    @FXML
    private void annuler(ActionEvent event) {
    }
    
}

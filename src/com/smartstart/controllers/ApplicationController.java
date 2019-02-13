/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.controllers;

import com.smartstart.entities.Application;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.sql.Date;
import com.smartstart.entities.Opportunity;
import com.smartstart.services.ApplicationService;
import com.smartstart.services.OpportunityService;
import java.sql.SQLException;

/**
 *
 * @author Marr
 */
public class ApplicationController {
     public static void main(String[] args) throws SQLException  {
         ApplicationService p1=new ApplicationService();
         //p1.sendAcceptanceToUser("marouenedakhlaoui@gmail.com","REDUCED INEQUALITIES");
         p1.sendAppliedToUser("marouenedakhlaoui@gmail.com","WEB DEV");
//p1.showSuggestedOpps(1);
        // p1.getApplicationsByEntrepriseId(1);
//p1.clearSuggestions();
         //p1.fillSuggestions();
       
      // p1.Display_Application();
       
       //LocalDate today = LocalDate.now();
       //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
       //java.util.Date utilDate = new java.util.Date();
       //java.sql.Date date = new java.sql.Date(utilDate.getTime());

    
       //Application app=new Application(3,1,"ADDtest");
       //Application app1=new Application();
      
      // p1.create_application(app);
        
       //p1.delete_Application(8);
      //p1.update_application(1,"Completed");
      

     
        
    }
    
}

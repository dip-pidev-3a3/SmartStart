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
import com.smartstart.entities.fos_user;
import com.smartstart.services.fos_userService;
import com.smartstart.services.fos_userService;
import java.sql.SQLException;
import java.util.Base64;
import javafx.scene.control.TableView;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author Marr
 */
public class fos_userController {
     public static void main(String[] args) throws ParseException, SQLException {
   Date last_log = null;
    Date birthDAT = null;
    Date register_date = null;
    Date password_requested_at = null ;
    
        fos_user us1 = new fos_user(7 ,"Manadzadir","mani","mani@mail","son@sqsqdqdqon",1,"salt_hadhona","slt", last_log, "confirmatsion_token" ,
                password_requested_at,"freelancarji","minax","3edel", birthDAT,"bio","location",
                register_date, 1, 2, 3,"field_company") ; 
        
          fos_user us2 = new fos_user(2,"Adel","adaal","ad@ad","sonDD@son",1,"salt_hadhona","slt", last_log, "confirmation_token" ,
                password_requested_at,"freelancarji","minax","3edel", birthDAT,"bio","location",
                register_date, 1, 2, 3,"field_company") ;
           fos_userService fss = new fos_userService();
          
          
         System.out.println("dsdsd");
         System.out.println(fss.Authentification("manixd", "mounir"));
         System.out.println(fss.CountUsers());
       //  fss.sendmail();    
      String str = "77+9x6s=";
        // encode data using BASE64
        String encoded = DatatypeConverter.printBase64Binary(us1.getPassword().getBytes());
        System.out.println("encoded value is \t" + encoded);

        // Decode data 
        String decoded = new String(DatatypeConverter.parseBase64Binary(encoded));
        System.out.println("decoded value is \t" + decoded);

        System.out.println("original value is \t" + str);
        
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");  
Date date = new Date(System.currentTimeMillis());  
System.out.println(formatter.format(date));  
//code random
        // System.out.println(fss.random_code(7));
    //test email     fss.sendmail("marouene.dakhlaoui@esprit.tn","s");
        // System.out.println(encoded);
         
     //    System.out.println(fss.Authentification("manix", "mounir"));
         
    }
     
    
}

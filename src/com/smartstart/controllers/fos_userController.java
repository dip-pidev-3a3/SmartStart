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

/**
 *
 * @author Marr
 */
public class fos_userController {
     public static void main(String[] args) throws ParseException {
   Date last_log = null;
    Date birthDAT = null;
    Date register_date = null;
    Date password_requested_at = null ;
    
        /* fos_user us1 = new fos_user(1 ,"Manir","mani","mani@mail","son@son",1,"salt_hadhona","slt", last_log, "confirmation_token" ,
                password_requested_at,"freelancarji","minax","3edel", birthDAT,"bio","location",
                register_date, 1, 2, 3,"field_company") ; */
        
          fos_user us3 = new fos_user(2,"Adel","adaal","ad@ad","sonDD@son",1,"salt_hadhona","slt", last_log, "confirmation_token" ,
                password_requested_at,"freelancarji","minax","3edel", birthDAT,"bio","location",
                register_date, 1, 2, 3,"field_company") ;
           fos_userService fss = new fos_userService();
           fss.create_user(us3);
         
    }
    
}

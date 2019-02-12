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
import com.smartstart.services.HasSkillService;
import com.smartstart.services.OpportunityService;

/**
 *
 * @author Marr
 */
public class HasSkillController {
     public static void main(String[] args) throws ParseException {
         HasSkillService p1=new HasSkillService();
       p1.addHasSkill(1,1);
       
      
        
    }
    
}

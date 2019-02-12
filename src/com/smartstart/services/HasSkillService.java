/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.entities.Application;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.smartstart.entities.Opportunity;
import com.smartstart.entities.Skill;
import com.smartstart.util.ConnectionDb;

/**
 *
 * @author Marrr
 */
public class HasSkillService {
     public ConnectionDb cnx = ConnectionDb.getInstance();
     Connection connection=cnx.getCnx();
     public HasSkillService(){}
     Application app=new Application();
     List<Application> ListApp=new ArrayList<>();
    
 public void addHasSkill (int connectedUserId,int selectedSkillId){ //na3tiwha el id mta3 el skill eli bech najoutiwha lel freelancer
	
     
     PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		String query="select * from skills where id_skill="+selectedSkillId ;
		ps=connection.prepareStatement(query);
		
		System.out.println(ps);
		rs=ps.executeQuery();
		while(rs.next()){
                    Skill s=new Skill(rs.getInt(1));
                    
                    
                   PreparedStatement psx=null;
	try {
		String queryx="INSERT INTO `has_skill`(`id_freelancer`,`id_skill`) VALUES (?,?)";
		psx=connection.prepareStatement(queryx);
		psx.setInt(1,connectedUserId);
                psx.setInt(2, s.getId());
	        System.out.println(psx);
		psx.executeUpdate();
                
	} catch (Exception ex) {
		System.out.println(ex);
	}
                    
                    
                                        

		
		}
	} catch (Exception e) {
		System.out.println(e);
	}
       
     
     
     
     
   
	
	}



 
 
 
}

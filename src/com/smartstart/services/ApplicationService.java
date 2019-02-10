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
import com.smartstart.util.ConnectionDb;

/**
 *
 * @author Marr
 */
public class ApplicationService {
     public ConnectionDb cnx = ConnectionDb.getInstance();
     Connection connection=cnx.getCnx();
     public ApplicationService(){}
     Application app=new Application();
     List<Application> ListApp=new ArrayList<>();
    
     public void Display_Application(){     
        
       PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		String query="select * from application,opportunity,fos_user where ((application.id_opportunity=opportunity.id_opp) AND (application.id_freelancer=fos_user.id)) ";
		ps=connection.prepareStatement(query);
		
		System.out.println(ps);
		rs=ps.executeQuery();
		while(rs.next()){
                    
                   
                    
                    ListApp.add(new Application(rs.getInt("id_application"),rs.getInt("id_opportunity"),rs.getInt("id_freelancer"),rs.getString("state")));
                                        

		
		}
	} catch (Exception e) {
		System.out.println(e);
	}
        ListApp.forEach(e->System.out.println(e));
     
    }
    public void create_application(Application app){
	
	PreparedStatement ps=null;
	try {
		String query="INSERT INTO `application`(`id_opportunity`, `id_freelancer`, `state`) VALUES (?,?,?)";
		ps=connection.prepareStatement(query);
		ps.setInt(1, app.getOpportunityId());
		ps.setInt(2, app.getFreelancerId());
		ps.setString(3, app.getState());
                
                
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
}
 
    public void delete_Application(int id){
	
	PreparedStatement ps=null;
	try {
		String query="delete from application where id_application=?";
		ps=connection.prepareStatement(query);
		ps.setInt(1,id);
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}

}
    public void update_application (int id,String newState)
    {   
        PreparedStatement ps=null;
        try
        { 
            String query="UPDATE `application` SET `state`=? WHERE id_application="+id;
            ps=connection.prepareStatement(query);
		ps.setString(1,newState);
		System.out.println(ps);
		ps.executeUpdate();
            
        }
         catch (Exception e) {
		System.out.println(e);
	}
        
    }
    
    
}
    


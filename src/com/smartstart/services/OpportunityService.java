/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

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
 * @author acmou
 */
public class OpportunityService {
     public ConnectionDb cnx = ConnectionDb.getInstance();
     Connection connection=cnx.getCnx();
     public OpportunityService(){}
     Opportunity o=new Opportunity();
     List<Opportunity> Listeopp=new ArrayList<>();
    public void Display_Opportunity(){     
        
       PreparedStatement ps=null;
	ResultSet rs=null;
	try {
		String query="select * from opportunity";
		ps=connection.prepareStatement(query);
		//ps.setString(1, sl_no);
		System.out.println(ps);
		rs=ps.executeQuery();
		while(rs.next()){
                    
                   /* o.setId(rs.getInt(1));
                    o.setJob_title(rs.getString(2));
                    
                    
                    o.setJob_category(rs.getString(3));
                    o.setJob_description(rs.getString(4));
                    o.setBudget(rs.getFloat(5));
                    o.setJob_draft(rs.getInt(6));
                    o.setJob_Duration(rs.getTimestamp(7));
                    o.setExpiry_date(rs.getDate(8));
                    o.setAdded_date(rs.getDate(9));
                    o.setIdEntreprise(rs.getInt(10));
                    System.out.println("bij");*/
                    
                    Listeopp.add(new Opportunity(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getFloat(5),rs.getInt(6),rs.getDate(7),rs.getDate(8),rs.getDate(9),rs.getInt(10)));
                                        

		
		}
	} catch (Exception e) {
		System.out.println(e);
	}
        Listeopp.forEach(e->System.out.println(e));
     
    }
    public void create_Opportunity(Opportunity o){
	
	PreparedStatement ps=null;
	try {
		String query="INSERT INTO `opportunity`(`job_title`, `job_category`, `job_description`, `Budget`, `job_Draft`, `job_Duration`, `Expiry_date`, `added_date`, `id_entreprise`) VALUES (?,?,?,?,?,?,?,?,?)";
		ps=connection.prepareStatement(query);
		ps.setString(1, o.getJob_title());
		ps.setString(2, o.getJob_category());
		ps.setString(3, o.getJob_description());
                ps.setFloat(4, o.getBudget());
                ps.setInt(5, 0);
                ps.setDate(6, (Date) o.getJob_Duration());
                ps.setDate(7, (Date) o.getExpiry_date());
                ps.setDate(8, (Date) o.getAdded_date());
                ps.setInt(9, o.getId_Entreprise());
                
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
}
     public void create_Opportunitydraft(Opportunity o){
	
	PreparedStatement ps=null;
	try {
		String query="INSERT INTO `opportunity`(`job_title`, `job_category`, `job_description`, `Budget`, `job_Draft`, `job_Duration`, `Expiry_date`, `added_date`, `id_entreprise`) VALUES (?,?,?,?,?,?,?,?,?)";
		ps=connection.prepareStatement(query);
		ps.setString(1, o.getJob_title());
		ps.setString(2, o.getJob_category());
		ps.setString(3, o.getJob_description());
                ps.setFloat(4, o.getBudget());
                ps.setInt(5, 1);
                ps.setDate(6, (Date) o.getJob_Duration());
                ps.setDate(7, (Date) o.getExpiry_date());
                ps.setDate(8, (Date) o.getAdded_date());
                ps.setInt(9, o.getId_Entreprise());
                
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}
}
    public void delete_opporunity(int id_opp){
	
	PreparedStatement ps=null;
	try {
		String query="delete from opportunity where id_opp=?";
		ps=connection.prepareStatement(query);
		ps.setInt(1, id_opp);
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}

}
    public void update_opportunity (Opportunity o,int id_opportunityC)
    {
        PreparedStatement ps=null;
        try
        {
            String query="UPDATE `opportunity` SET `job_title`=?,`job_category`=?,`job_description`=?,"
                    + "`Budget`=?,`job_Draft`=?,"
                    + "`job_Duration`=?,`Expiry_date`=?,`added_date`=?,`id_entreprise`=? WHERE id_opp="+id_opportunityC;
            ps=connection.prepareStatement(query);
		ps.setString(1, o.getJob_title());
		ps.setString(2, o.getJob_category());
		ps.setString(3, o.getJob_description());
                ps.setFloat(4, o.getBudget());
                ps.setInt(5, 1);
                ps.setDate(6, (Date) o.getJob_Duration());
                ps.setDate(7, (Date) o.getExpiry_date());
                ps.setDate(8, (Date) o.getAdded_date());
                ps.setInt(9, o.getId_Entreprise());
                
		System.out.println(ps);
		ps.executeUpdate();
            
        }
         catch (Exception e) {
		System.out.println(e);
	}
        
    }
    
    
}
    


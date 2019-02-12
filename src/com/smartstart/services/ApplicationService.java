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
<<<<<<< HEAD
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
=======
>>>>>>> 9f71d8dd43a3ff6bae69928df92763b4f211e9c9

/**
 *
 * @author Marr
 */
public class ApplicationService {
<<<<<<< HEAD

    private ObservableList<Application> ListeApp;

    public ConnectionDb cnx = ConnectionDb.getInstance();
    Connection connection = cnx.getCnx();

    public ApplicationService() {
    }
    Application app = new Application();
    List<Application> ListApp = new ArrayList<>();

    public void Display_Application() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from application,opportunity,fos_user where ((application.id_opportunity=opportunity.id_opp) AND (application.id_freelancer=fos_user.id)) ";
            ps = connection.prepareStatement(query);

            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {

                ListApp.add(new Application(rs.getInt("id_application"), rs.getInt("id_opportunity"), rs.getInt("id_freelancer"), rs.getString("state")));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        ListApp.forEach(e -> System.out.println(e));

    }

    public Application getApplicationById(int searchedapp) {

        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from application where id_application=" + searchedapp;
            ps = connection.prepareStatement(query);

            System.out.println(ps);
            rs = ps.executeQuery();
            if (rs.next()) {
                Application app = new Application(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4));

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return app;
    }

    public void create_application(Application app) {

        PreparedStatement ps = null;
        try {
            String query = "INSERT INTO `application`(`id_opportunity`, `id_freelancer`, `state`) VALUES (?,?,?)";
            ps = connection.prepareStatement(query);
            ps.setInt(1, app.getOpportunityId());
            ps.setInt(2, app.getFreelancerId());
            ps.setString(3, app.getState());

            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void delete_Application(int id) {

        PreparedStatement ps = null;
        try {
            String query = "delete from application where id_application=?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void update_application(int id, String newState) {  //Hedhi eli bech testa3melha bech tbadel state mta3 APP
        PreparedStatement ps = null;
        try {
            String query = "UPDATE `application` SET `state`=? WHERE id_application=" + id;
            ps = connection.prepareStatement(query);
            ps.setString(1, newState);
            System.out.println(ps);
            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void fillSuggestions() {

        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rsx = null;
        ResultSet rsy = null;

        try {
            String query = "select * from has_skill";
            ps = connection.prepareStatement(query);
            //ps.setString(1, sl_no);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {

                PreparedStatement psx = null;
                try {
                    String queryx = "select * from needed_skills where id_skill=" + rs.getInt("id_skill");
                    psx = connection.prepareStatement(queryx);
                    System.out.println(psx);
                    rsx = psx.executeQuery();
                    while (rsx.next()) {

                        PreparedStatement psz = null;
                        try {
                            String queryz = "INSERT INTO `suggestedopps`(`freelancerId`,`opportunityId`) VALUES (?,?)";
                            System.out.println(psz);
                            psz = connection.prepareStatement(queryz);
                            psz.setInt(1, rs.getInt("id_freelancer"));
                            psz.setInt(2, rsx.getInt("id_opp"));
                            System.out.println("ADDED");

                            System.out.println(psz);
                            psz.execute();

                        } catch (Exception ex) {
                            System.out.println(ex);
                        }

                    }

                } catch (Exception ex) {
                    System.out.println(ex);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void clearSuggestions() {

        PreparedStatement ps = null;
        try {
            String query = "delete from suggestedopps";
            ps = connection.prepareStatement(query);
            System.out.println(ps);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public boolean isApt(int freelancerId, int oppId) {
        int test = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from suggestedopps where freelancerId=" + freelancerId;
            ps = connection.prepareStatement(query);

            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(2) == oppId) {
                    test++;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (test == 0) {
            return false;
        } else {
            return true;
        }

    }

    public boolean HasApplied(int freelancerId, int oppId) {
        int test = 0;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            String query = "select * from application where id_freelancer=" + freelancerId;
            ps = connection.prepareStatement(query);

            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getInt(2) == oppId) {
                    test++;
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }

        if (test == 0) {
            return false;
        } else {
            return true;
        }

    }

    public ObservableList<Application> getApplicationsByEntrepriseId(int searchedEntreprise) { //hedhi eli w7elna fiha f e5er eliil

        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        ListeApp = FXCollections.observableArrayList();
        try {
            String query = "select * from opportunity where id_entreprise=" + searchedEntreprise;
            ps = connection.prepareStatement(query);
            System.out.println(ps);
            rs = ps.executeQuery();
            while (rs.next()) {

                try {
                    String query2 = "select * from application where id_opportunity=" + rs.getInt(1);
                    ps2 = connection.prepareStatement(query2);
                    System.out.println(ps);
                    rs2 = ps2.executeQuery();
                    while (rs2.next()) {

           ListeApp.add(new Application(rs2.getInt(1),rs.getInt(1), rs2.getInt(3), rs2.getString(4)));

                    }
                } catch (Exception e) {
                    System.out.println(e);
                }

            }
        } catch (Exception e) {
            System.out.println(e);
        }
        ListeApp.forEach(e -> System.out.println(e));
        return ListeApp;

    }

}
=======
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
    

>>>>>>> 9f71d8dd43a3ff6bae69928df92763b4f211e9c9

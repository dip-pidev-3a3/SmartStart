/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;
import com.smartstart.util.ConnectionDb;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.smartstart.entities.fos_user;


/**
 *
 * @author HP
 */
public class fos_userService {
    ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
    public void create_user(fos_user u)
    {
        
        
        try {
            String query ="insert into fos_user (id,username,username_canonical, email,email_canonical,"
                    + "enabled,salt,password,last_login,confirmation_token,password_requested_at,roles,"
                    + "name,last_name,birth_date,bio,location,register_date,earnings,expenses, budget, field_company)"
                    + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps=cn.prepareStatement(query) ;
             ps.setInt(1, u.getId() );
             ps.setString(2, u.getUsername());
             ps.setString(3, u.getUsername_canonical());
             ps.setString(4, u.getEmail());
             ps.setString(5, u.getEmail_canonical());
             ps.setInt(6, u.getEnabled());
             ps.setString(7, u.getSalt());  
             ps.setString(8, u.getPassword());  
             ps.setDate(9, u.getLast_login());  
             ps.setString(10, u.getConfirmation_token());  
             ps.setDate(11, u.getPassword_requested_at());  
             ps.setString(12, u.getRoles());  
             ps.setString(13, u.getName());  
             ps.setString(14, u.getLast_name());  
             ps.setDate(15, u.getBirth_date());  
             ps.setString(16, u.getBio());  
             ps.setString(17, u.getLocation());  
             ps.setDate(18, u.getRegister_date());  
             ps.setFloat(19, u.getEarnings()); 
             ps.setFloat(20, u.getExpenses()); 
             ps.setFloat(21, u.getBudget()); 
             ps.setString(22, u.getField_company()); 
             
              ps.executeUpdate();
               System.out.println("ci bon ");
        } catch (Exception e){
            System.out.println(e);
        }
        
    }
    
  public   ArrayList<fos_user>  read_all_users() throws SQLException{
           
         ArrayList<fos_user> retour = new ArrayList<>();
          Statement stm = cn.createStatement() ;
          String req = "SELECT * FROM fos_user ";
        ResultSet resultat = stm.executeQuery(req);
          
        while(resultat.next()){
           int id= resultat.getInt(1);
            String username = resultat.getString("username");
           String username_canonical= resultat.getString("username_canonical");
            String email= resultat.getString("email");
           String email_canonical= resultat.getString("email_canonical");
           int enabled = resultat.getInt("enabled");
           String salt= resultat.getString("salt");
           String password= resultat.getString("password");
           Date last_login = resultat.getDate("last_login");
           String confirmation_token= resultat.getString("confirmation_token");
           Date Password_requested_at= resultat.getDate("password_requested_at");
           String roles= resultat.getString("roles");
           String name= resultat.getString("name");
           String last_name= resultat.getString("last_name");
           String Bio= resultat.getString("Bio");
            Date Birth_date = resultat.getDate("Birth_date");
           String location= resultat.getString("location");
            Date Register_Date = resultat.getDate("Register_Date");
           float Earnings = resultat.getFloat("Earnings");
           float Expenses = resultat.getFloat("Expenses");
           float Budget = resultat.getFloat("Budget");
           String field_company= resultat.getString("field_company");
             retour.add(new fos_user( id,username,username_canonical,email, email_canonical,enabled,salt,password,
                   last_login, confirmation_token, Password_requested_at , roles, name, last_name, Birth_date, 
                   Bio,location,  Register_Date, Earnings,  Expenses,  Budget,  field_company));
            
        }
        return retour ;
    }
  
 public void delete_user(int id){
	
	PreparedStatement ps=null;
	try {
		String query="delete from fos_user where id=?";
		ps=cn.prepareStatement(query);
		ps.setInt(1,id);
		System.out.println(ps);
		ps.executeUpdate();
	} catch (Exception e) {
		System.out.println(e);
	}

}
  public fos_user get_user_by_id(int searched ) throws SQLException
  {//zid thabet
      PreparedStatement ps=null;
	ResultSet rs=null;
        fos_user newus = new fos_user() ;
        newus.setId(searched);
       
          ps = cn.prepareStatement("select * from fos_user where id="+searched);
        rs = ps.executeQuery();
        System.out.println("Execute statement");
       while(rs.next()) 
       {
           newus.setUsername(rs.getString("username"));
           newus.setUsername_canonical(rs.getString("username_canonical"));
           newus.setEmail(rs.getString("email"));
           newus.setEmail_canonical(rs.getString("email_canonical"));
           newus.setEnabled(rs.getInt("enabled"));
           newus.setSalt(rs.getString("salt"));
           newus.setPassword(rs.getString("password"));
           newus.setLast_login(rs.getDate("last_login"));
           newus.setConfirmation_token(rs.getString("confirmation_token"));
           newus.setPassword_requested_at(rs.getDate("password_requested_at"));
           newus.setRoles(rs.getString("roles"));
           newus.setName(rs.getString("name"));
           newus.setLast_name(rs.getString("last_name"));
           newus.setBirth_date(rs.getDate("Birth_date"));
           newus.setBio(rs.getString("Bio"));
           newus.setLocation(rs.getString("location"));
           newus.setRegister_date(rs.getDate("Register_Date"));
           newus.setEarnings(rs.getFloat("Earnings"));
           newus.setExpenses(rs.getFloat("Expenses"));
           newus.setBudget(rs.getFloat("Budget"));
           newus.setField_company(rs.getString("field_company"));
           //      Date birth_date, String bio,* String location, Date register_date, float earnings, float expenses, float budget, String field_company) {

           return newus;
       }
   //     cb.setLastName(rs.getString(3));
        
       return newus;
      
  }
    
    
    
}

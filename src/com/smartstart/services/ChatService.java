/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.util.ConnectionDb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diabl
 */
public class ChatService implements ChatServiceInterface {
        
    
    @Override
    public void addMsg() {
        try {
                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "Select * From application";
			Statement st = cn.createStatement();
			ResultSet rst = st.executeQuery(query);
			
			if(!rst.next())
			{
				System.out.println("it's ok");	
			}
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

    }

    @Override
    public void sendMsg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

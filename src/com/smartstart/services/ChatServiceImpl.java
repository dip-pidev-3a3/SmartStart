/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.util.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author diabl
 */
public class ChatServiceImpl implements ChatServiceInterface {
        
    
    @Override
    public void addMsg() throws SQLException {
       
                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "INSERT INTO `messages`(`id_message`, `message_from`, `message_to`, `content`, `id_chat`, `attachement`) VALUES (?,?,?,?,?,?)";
		PreparedStatement st  = cn.prepareStatement(query);
                st.setString(1, "");
           

    }

    @Override
    public void sendMsg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

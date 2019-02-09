/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.entities.Message;
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
    public void addMsg(Message m) throws SQLException {
       
                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "INSERT INTO `messages`(`message_from`, `message_to`, `content`, `attachement` , `date_message` , `viewed`) VALUES (?,?,?,?,?,?)";
		PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, m.getMessage_from());
                st.setInt(2,m.getMessage_to());
                st.setString(3,m.getContent());
                st.setString(4,m.getAttachment());
                java.sql.Date date = new java.sql.Date(m.getDate_message().getTime());
                st.setDate(5,date );
                st.setInt(6,m.getViewed());
                
           

    }

    @Override
    public void sendMsg() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.entities.Contract;
import com.smartstart.entities.Feedback;
import com.smartstart.util.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author dytcha
 */
public class FeedbackServiceImpl  implements FeedbackServiceInterface{

    @Override
    public void addFeedback(Feedback f) throws SQLException {
         ConnectionDb db = ConnectionDb.getInstance();
         Connection cn = db.getCnx();
         String query="INSERT INTO `feedback` (`id_user` , `Rating`, `comment` , `added_date` , `id_application`) VALUES (?,?,?,?,?)";
         PreparedStatement st  = cn.prepareStatement(query);
                st.setInt(1, f.getId_user());
                st.setFloat(2,f.getRating());
                st.setString(3,f.getComment());
                java.sql.Date date = new java.sql.Date(f.getAdded_date().getTime());
                st.setDate(4,date);
                st.setInt(5,f.getId_application());
                st.execute();
               

    }

    @Override
    public ObservableList<Feedback> listerFeedback(int id) throws SQLException {


                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `feedback`";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Feedback> lf = new ArrayList<Feedback>();
                Feedback f = new Feedback();
                while(rs.next()){
                    f.setId_user(rs.getInt("id_user"));
                    f.setRating(rs.getFloat("Rating"));                    
                    f.setComment(rs.getString("comment"));
                    f.setAdded_date(rs.getDate("added_date"));
                    f.setId_application(rs.getInt("id_application"));
                    lf.add(f);
                }
                ObservableList lf_final = FXCollections.observableArrayList(lf);
                return lf_final;
    }

    @Override
    public void removeFeedback(int id) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `feedback` WHERE `id_feedback` = "+id;
		PreparedStatement st  = cn.prepareStatement("DELETE FROM `feedback` WHERE `id_feedback` = ?");  
                    st.setInt(1, id);


    }

    @Override
    public void updateFeedback(Feedback f) throws SQLException {

                ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `feedback` SET `Rating`=?,`comment`=?,`added_date`=? WHERE `id_feedback` =? ";
                       
		PreparedStatement st  = cn.prepareStatement(query);
                st.setFloat(1, f.getRating());
                st.setString(2, f.getComment());
                java.sql.Date d1 = new java.sql.Date((new java.util.Date()).getTime());
                st.setDate(3,d1);
                st.setInt(4, f.getId_feedback()); 

        

    }
    

    
    
}

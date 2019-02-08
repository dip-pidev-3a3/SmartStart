package com.smartstart.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ConnectionDb {
    
    public Connection cnx;
    public static ConnectionDb instance;
    String url = "jdbc:mysql://localhost:3306/smartstart";
    String login = "root";
    String mdp = "";
    private ConnectionDb(){
        
        try {
            cnx = DriverManager.getConnection(url,login,mdp);
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDb.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static ConnectionDb getInstance(){
        if (instance == null)
            instance = new ConnectionDb();
        return instance;
    }
    public Connection getCnx(){
        return cnx;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import java.sql.SQLException;

/**
 *
 * @author diabl
 */
public interface ChatServiceInterface {
    
    public void addMsg() throws SQLException;
    public void sendMsg();
    
}

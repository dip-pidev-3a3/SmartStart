/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.entities.Message;
import java.sql.SQLException;

/**
 *
 * @author diabl
 */
public interface ChatServiceInterface {
    
    public void addMsg(Message m) throws SQLException;
    public void sendMsg();
    
}

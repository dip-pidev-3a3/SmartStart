/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.entities.Message;
import java.sql.SQLException;
import javafx.collections.ObservableList;

/**
 *
 * @author diabl
 */
public interface ChatServiceInterface {
    
    public void addMsg(Message m) throws SQLException;
    public void sendMsgOnline() throws SQLException;
    public void sendMsgOffline(Message m) throws SQLException;
    public ObservableList<Integer> discussionList(int id) throws SQLException;
    
    
}

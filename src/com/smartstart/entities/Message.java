/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.entities;

import java.sql.Date;

/**
 *
 * @author diabl
 */
public class Message {
    
    private int id_message;
    private int message_from;
    private int message_to;
    private String content;
    private String attachment;
    private Date date_message;
    private int viewed;
    
    public Message() {}
    public Message(int id_message,int message_from,int message_to,String content,String attachment,Date date_message,int viewed){
    this.id_message = id_message;
    this.message_from = message_from;
    this.message_to = message_to;
    this.content = content;
    this.attachment = attachment;
    this.viewed = 0;
    
    }

    
    
    
    
}

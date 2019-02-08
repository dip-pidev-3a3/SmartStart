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

    public int getId_message() {
        return id_message;
    }

    public void setId_message(int id_message) {
        this.id_message = id_message;
    }

    public int getMessage_from() {
        return message_from;
    }

    public void setMessage_from(int message_from) {
        this.message_from = message_from;
    }

    public int getMessage_to() {
        return message_to;
    }

    public void setMessage_to(int message_to) {
        this.message_to = message_to;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public Date getDate_message() {
        return date_message;
    }

    public void setDate_message(Date date_message) {
        this.date_message = date_message;
    }

    public int getViewed() {
        return viewed;
    }

    public void setViewed(int viewed) {
        this.viewed = viewed;
    }
    

    
    
    
    
}

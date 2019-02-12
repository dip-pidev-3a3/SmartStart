/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.entities;

import java.util.Date;

/**
 *
 * @author dytcha
 */
public class Feedback {
    private int id_feedback;
    private int id_user;
    private float Rating;
    private String comment;
    private Date added_date;
    private int id_application;
    

   public Feedback(){
   
   }
   public Feedback(int id_feedback,int id_user ,float Rating ,String comment,Date added_date,int id_application){
       this.id_feedback=id_feedback;
       this.id_user=id_user;
       this.Rating=Rating;
       this.comment=comment;
       this.added_date=added_date;
       this.id_application=id_application;
        
       
   
   }

    public int getId_feedback() {
        return id_feedback;
    }

    public void setId_feedback(int id_feedback) {
        this.id_feedback = id_feedback;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public float getRating() {
        return Rating;
    }

    public void setRating(float Rating) {
        this.Rating = Rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Date added_date) {
        this.added_date = added_date;
    }

    public int getId_application() {
        return id_application;
    }

    public void setId_application(int id_application) {
        this.id_application = id_application;
    }
    
    
    
    
    
}


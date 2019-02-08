/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.entities;

import java.sql.Date;
/**
 *
 * @author acmou
 */
public class Opportunity {
    
    
    private int id_opp;
    private String job_title;
    private String job_category;
    private String job_description;
    private float budget;
    private int job_Draft;
    private Date job_duration;
    private Date Expiry_Date;
    private Date added_date;
    private int id_entreprise;
    
    public Opportunity(){}
    public Opportunity(int id_opp,String job_title,String job_category,String job_description,float budget,int job_draft,Date job_duration,Date Expiry_date,Date Added_date,int id_entreprise){
        this.id_opp=id_opp;
        this.job_title = job_title;
        this.job_category = job_category;
        this.job_description=job_description;
        this.budget=budget;
        this.job_duration=job_duration;
        this.Expiry_Date=Expiry_date;
        this.added_date=Added_date;
        this.id_entreprise=id_entreprise;
        this.job_Draft=job_draft;
    }
    

    public int getId_Opp() {
        return id_opp;
    }

    public void setId(int id_opp) {
        this.id_opp = id_opp;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getJob_category() {
        return job_category;
    }

    public void setJob_category(String job_category) {
        this.job_category= job_category;
    }
      public float getBudget() {
        return budget;
    }

    public void setBudget(float budget) {
        this.budget= budget;
    }
     public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_category= job_description;
    }
    public int getJob_draft() {
        return job_Draft;
    }

    public void setJob_draft(int job_draft) {
        this.job_Draft=job_draft;
    }
     public Date getAdded_date() {
        return added_date;
    }

    public void setAdded_date(Date d) {
        this.added_date=d;
    }
    public Date getExpiry_date() {
        return Expiry_Date;
    }

    public void setExpiry_date(Date d) {
        this.Expiry_Date=d;
    }
    public Date getJob_Duration() {
        return job_duration;
    }

    public void setJob_Duration(Date d) {
        this.job_duration=d;
    }
    public int getId_Entreprise() {
        return id_entreprise;
    }

    public void setIdEntreprise(int id) {
        this.id_entreprise = id;
    }
    @Override
    public String toString()
    {
        return "id opp :"+id_opp+" Job Title :"+job_title+" Job Category : "+job_category+" Job Description : "+job_description+" Budget : "+budget+" Draft : "+job_Draft+" Job Duration :"+job_duration+" Expiry Date : "+Expiry_Date+" Added Date : "+added_date+ "Id Entreprise : "+id_entreprise;
    }
    
    
}

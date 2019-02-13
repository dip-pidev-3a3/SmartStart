/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.entities;

/**
 *
 * @author Marrr
 */
public class Application {
    private int id;
    private Opportunity opp;
    //private Fos_user freelancer;
    private String state;
    private int opportunityId;
    private int freelancerId;
public Application(){}

public Application(int id,Opportunity opp/*,Fos_user freelancer*/,String state)
{this.id=id;
this.opp=opp;
//this.freelancer=freelancer;
this.state=state;

}
public Application(int id, int opportunityId,int freelancerId,String state) {
       this.id=id;
       this.opportunityId=opportunityId;
       this.freelancerId=freelancerId;
       this.state=state;
    }
public Application(int opportunityId,int freelancerId,String state) {
       
       this.opportunityId=opportunityId;
       this.freelancerId=freelancerId;
       this.state=state;
    }

public Application(int opportunityId,int freelancerId) {
       
       this.opportunityId=opportunityId;
       this.freelancerId=freelancerId;
       this.state="APPLIED";
    }


   
    public int getOpportunityId()
    {return opportunityId;}
    
     public int getFreelancerId()
    {return freelancerId;}
    
public int getId()
{return id;}

public Opportunity getOpp()
{return opp;}

//public Fos_user getFreelancer()
//{return freelancer;}

public String getState()
{return state;}


@Override
    public String toString()
    {
        return "Application id :"+id+" Opportunity Id :"+opportunityId+" Freelancer Id: "+freelancerId+" State : "+state;
    }





}

package com.smartstart.services;

import com.smartstart.entities.Opportunity;
import java.util.List;
import javafx.collections.ObservableList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author acmou
 */
public interface OpporunityServiceInterface {

    public ObservableList<Opportunity> Display_Opportunity();

    public ObservableList<Opportunity> DisplayMy_Opportunities(int id_user);

    public void create_Opportunity(Opportunity o);

    public void create_Opportunitydraft(Opportunity o);

    public void delete_opporunity(int id_opp);

    public void update_opportunity(Opportunity o, int id_opportunityC);

}

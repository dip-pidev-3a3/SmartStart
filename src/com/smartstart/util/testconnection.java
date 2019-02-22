/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.util;

import com.smartstart.entities.Application;
import com.smartstart.entities.Contract;
import com.smartstart.entities.Message;
import com.smartstart.services.ChatServiceImpl;
import com.smartstart.services.ContractServiceImpl;
import com.smartstart.services.OpportunityService;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import com.smartstart.entities.Opportunity;
import com.smartstart.services.ApplicationService;

/**
 *
 * @author diabl
 */
public class testconnection {

    public static void main(String[] args) throws ParseException {
        try {
            ChatServiceImpl cs = new ChatServiceImpl();
            Date ds = new Date();
            Date df = new Date();
            try {
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                ds = dateFormat.parse("2019-02-13");
                ds = dateFormat.parse("2019-02-17");
            } catch (Exception e) {
                Logger.getLogger(testconnection.class.getName()).log(Level.SEVERE, null, e);
            }
            
            //Contract c1 = new Contract(2, "en ligne", ds, df, (float) 700.89, 10);
           ObservableList<Message> listContract = cs.getMessages(1, 2);
           //listContract.stream().forEach(con -> System.out.println(con.getContent()));
            ContractServiceImpl s = new ContractServiceImpl();
            OpportunityService os = new OpportunityService();
            ApplicationService as = new ApplicationService();
            Opportunity o = os.Display_One_Opportunity(3);
            Application a = new Application();
            a = as.getApplicationById(9);
            Contract c = new Contract(1, "cheque", ds, df, (float) 548.23, a);
            //s.addContract(c);
            System.out.println(a.getId());
            //OpportunityService os=new OpportunityService();
            // Opportunity o = os.Display_One_Opportunity(3);
            //System.out.println(o.getId_Opp());
            
        } catch (SQLException ex) {
            Logger.getLogger(testconnection.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

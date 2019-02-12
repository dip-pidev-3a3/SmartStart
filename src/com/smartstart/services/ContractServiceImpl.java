/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smartstart.services;

import com.smartstart.entities.Contract;
import com.smartstart.util.ConnectionDb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author diabl
 */
public class ContractServiceImpl implements ContractServiceInterface {
    java.util.Date utilDate = new java.util.Date();
 java.sql.Date date = new java.sql.Date(utilDate.getTime());

    @Override
    public void addContract(Contract c) throws SQLException {
        ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "INSERT INTO `contract`(`payment_method`, `Start_date`, `finish_date`, `sum`, `id_application`) VALUES (?,?,?,?,?)";
		PreparedStatement st  = cn.prepareStatement(query);
                st.setString(1, c.getPayment_method());
                java.sql.Date dateS = new java.sql.Date(c.getStart_date().getTime());
                st.setString(2, dateS.toString());
                java.sql.Date dateF = new java.sql.Date(c.getStart_date().getTime());
                st.setString(3, dateF.toString());
                st.setString(4, ""+c.getSum());
                st.setString(5, ""+c.getId_application());                
    }

    @Override
    public void updateContract(Contract c) throws SQLException {
        ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "UPDATE `contract` SET `Start_date`=?,`finish_date`=?,`sum`=? WHERE `id_contract` = "+c.getId_contract();
		PreparedStatement st  = cn.prepareStatement(query);
                java.sql.Date dateS = new java.sql.Date(c.getStart_date().getTime());
                st.setString(1, dateS.toString());
                java.sql.Date dateF = new java.sql.Date(c.getStart_date().getTime());
                st.setString(3, dateF.toString());
                st.setString(4, ""+c.getSum());
    }

    @Override
    public void removeContract(int id) throws SQLException {
       ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "DELETE FROM `contract` WHERE `id_contract` = "+id;
		PreparedStatement st  = cn.prepareStatement(query);
    }

    @Override
    public ObservableList<Contract> listContract(int idEntreprise) throws SQLException {
        ConnectionDb db = ConnectionDb.getInstance();
                Connection cn = db.getCnx();
                String query = "SELECT * FROM `contract`,`application`,`opportunity` WHERE ((contract.id_application = application.id_application) AND (application.id_opportunity = opportunity.id_opp) AND (opportunity.id_entreprise = "+idEntreprise+"))";
		Statement st  = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                List<Contract> lc = new ArrayList<Contract>();
                Contract c = new Contract();
                while(rs.next()){
                    c.setId_contract(rs.getInt("id_contract"));
                    c.setPayment_method(rs.getString("payment_method"));
                    c.setStart_date(rs.getDate("Start_date"));
                    c.setFinish_date(rs.getDate("finish_date"));
                    c.setSum(rs.getFloat("sum"));
                    c.setId_application(rs.getInt("id_application"));
                    lc.add(c);
                }
                System.out.println("bij");
                ObservableList lcf = FXCollections.observableArrayList(lc);
                return lcf;
                
    }

    @Override
    public List<Contract> listContractOrdred(int idEntreprise) throws SQLException {
        List<Contract> lco = listContract(idEntreprise);
        lco = lco.stream().sorted((a,b)->{if(a.getId_contract()>b.getId_contract())
                                   return 1;
                                   if(a.getId_contract()<b.getId_contract())
                                   return -1;
                                   else 
                                   return 0;}).collect(Collectors.toList());
        return lco;
    }

    @Override
    public int CountContracts(int id_user) {
        int toretrun=0;
         PreparedStatement ps=null;
         try
         {
             ConnectionDb db = ConnectionDb.getInstance();
             Connection cn = db.getCnx();
             String query="Select Count(*) from contract,application where ="+id_user;
             ps=cn.prepareStatement(query);
             System.out.println(ps);
            ResultSet rs= ps.executeQuery();
             while(rs.next())
             {
                 toretrun= rs.getInt(1);
             }
             
         } catch(Exception e)
         {
             System.out.println(e);
         }
         return toretrun;
    }
    
}

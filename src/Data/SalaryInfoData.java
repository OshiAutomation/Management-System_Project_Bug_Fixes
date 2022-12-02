/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import Data.DB_Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gallelaptop.lk
 */
public class SalaryInfoData {
    
    private DB_Access dba = null;

    public SalaryInfoData() {
        dba = new DB_Access();
    }
        
    public ArrayList getDesignation() {
        
        ArrayList desig = null;
        
        try {
            String sql = "select distinct designation from riyoma.salary_info";
            ResultSet rs = dba.getData(sql);
            
            desig = new ArrayList();
            
            while(rs.next()) {
                String desRow = rs.getString(1);
                desig.add(desRow);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Select query failed");
        } 
        return desig;
    }
    
    public double getOtRate(String desig) {
        
        double otRate = 0;

        try {
            String sql = "select otRate from riyoma.salary_info where designation='"+desig+"'";
            System.out.println(sql);
            
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                otRate = Double.parseDouble(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return otRate;
    }
}

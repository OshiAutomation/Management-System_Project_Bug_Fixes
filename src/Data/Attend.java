/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import Data.DB_Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gallelaptop.lk
 */
public class Attend {

    DB_Access dba = null;
    
    public Attend() {
        dba = new DB_Access();
    } 
    
    public int getOtHours(String eid,String yearMonth) {       
        int otHours = 0;
        try {
            String sql = "select empID,sum(otHours) from riyoma.attendance where empID='"+eid+"' and date like '"+yearMonth+"%' group by empID";
            System.out.println(sql);
                        
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                otHours = Integer.parseInt(rs.getString(2));  
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return otHours;
    }
    
    public void markCheckIn(String eid) {
        
        SalaryCalc sc = new SalaryCalc();;
        String month = sc.getMonth();
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    	String time = sdf1.format(cal.getTime());
        
        if(!chkAttend(eid)) {  
            try {
                String sql = "insert into riyoma.attendance(empID,date,month,checkin,checkout) values('"+eid+"','"+date+"','"+month+"','"+time+"','00:00:00')";
                
                dba.setData(sql);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Already checked in");
            }
        }
    }
    
     public void markCheckOut(String eid) {
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    	String time = sdf1.format(cal.getTime());
        
            try {
                String sql = "update riyoma.attendance set checkout='"+time+"' where empID='"+eid+"' and date='"+date+"'";
                dba.setData(sql);

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"Already checked out");
            }
    }
    
    public boolean chkAttend(String eid) {
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        boolean result = false;
 
        try {
            String sql = "select * from riyoma.attendance where empID='"+eid+"' and date='"+date+"'"; 
            
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Attend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public void setOtHours() {
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());

        try {
            String sql = "select empID,checkout from riyoma.attendance where date='"+date+"'";
            
            ResultSet rs = dba.getData(sql);
            
            while(rs.next()) {
                String empID = rs.getString(1);
                String chkout = rs.getString(2);
                
                calcOtHours(empID, chkout);
            }
            
            JOptionPane.showMessageDialog(null,"Checkout closed");
        } catch (SQLException ex) {
            Logger.getLogger(Attend.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void calcOtHours(String eid, String chkout) {
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());

        int noofHours = 0;
        
        int chkoutHr = Integer.parseInt(chkout.substring(0,2));
        
        if(chkoutHr > 18) {
            noofHours = chkoutHr - 18;
            
            String sql = "update riyoma.attendance set otHours="+noofHours+" where date='"+date+"' and empID='"+eid+"'";
            System.out.println(sql);
            
            try {  
                dba.setData(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Attend.class.getName()).log(Level.SEVERE, null, ex);
            }
        }   
        else {
            String sql = "update riyoma.attendance set otHours='0' where date='"+date+"' and empID='"+eid+"'";
            System.out.println(sql);
            
            try {  
                dba.setData(sql);
            } catch (SQLException ex) {
                Logger.getLogger(Attend.class.getName()).log(Level.SEVERE, null, ex);
            }
            System.out.println();
        } 
    }
    
    public boolean dayMarked() {
        
        boolean result = false;
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        try {
            String sql = "select * from riyoma.attendance where date='"+date+"'";
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Attend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean checkInMarked() {
        
        boolean result = false;
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        try {
            String sql = "select * from riyoma.attendance where date='"+date+"' and checkout='00:00:00'";
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Attend.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    public boolean submitLeave(String name, String date) {
        String eid = null;
        boolean result = false;
        try {
            String sql = "select empID from riyoma.employee where empName='"+name+"'";
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                eid = rs.getString(1);
            }
            
            String sql1 = "insert into riyoma.employee_leaves(empID,date) values('"+eid+"','"+date+"')";
            dba.setData(sql1);
            result = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in submitting");
        }
        return result;
    }
    
    public boolean deleteLeave(String eid, String date) {

        boolean result = false;
        try {
            String sql = "delete from riyoma.employee_leaves where empID='"+eid+"' and date='"+date+"'";
            System.out.println(sql);
            dba.setData(sql);
            result = true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error in deleting");
        }
        return result;
    }
}

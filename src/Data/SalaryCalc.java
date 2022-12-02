/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import Data.DBConnManager;
import Data.DB_Access;
import Data.loanInfo;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author gallelaptop.lk
 */

public class SalaryCalc {
    
    DB_Access dba = null;

    public SalaryCalc() {
        dba = new DB_Access();
    }
    
    public double calculate(String eid, double bonus, double ot, double loanR) {
        
        double total;
        double basicSal = getBasicSalary(eid);
        
        total = (bonus + ot + basicSal) - loanR;
        
        return total;
    }
    
    public double getBasicSalary(String eid) {
        //JOptionPane.showMessageDialog(null, eid);
        double basicSalary = 0;
        try {
            String sql = "select si.basicSalary from riyoma.salary_info si, riyoma.employee e where e.empID='"+eid+"' and e.designation=si.designation";
            //JOptionPane.showMessageDialog(null, sql);
            ResultSet rs = dba.getData(sql);
            
            while(rs.next()) {
                basicSalary = Double.parseDouble(rs.getString(1));
            }   
        } catch (SQLException ex) {
            Logger.getLogger(SalaryCalc.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Select query failed");
        }
        
        return basicSalary;
    }
    
    public String getMonth() {
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
       
        int mnth = Integer.parseInt(date.substring(5,7));
        String month = null;
        
        if(mnth==1) {
            month = "January";
        }
        else if(mnth==2) {
            month = "February";
        }
        else if(mnth==3) {
            month = "March";
        }
        else if(mnth==4) {
            month = "April";
        }
        else if(mnth==5) {
            month = "May";
        }
        else if(mnth==6) {
            month = "June";
        }
        else if(mnth==7) {
            month = "July";
        }
        else if(mnth==8) {
            month = "August";
        }
        else if(mnth==9) {
            month = "September";
        }
        else if(mnth==10) {
            month = "October";
        }
        else if(mnth==11) {
            month = "November";
        }
        else if(mnth==12) {
            month = "December";
        }
        return month;
    }
    
    public boolean checkSalary(String id) {
        
        boolean result = false;
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
       
        String yearMonth = date.substring(0,7);
        
        try {
            String sql = "select * from riyoma.salary where empID='"+id+"' and date like '"+yearMonth+"%'";
            System.out.println(sql);
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryCalc.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    /*to take time 
        Calendar cal = Calendar.getInstance();
    	SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
    	String time = sdf.format(cal.getTime());
    */
    public double getOtAmount (String eid, String desig) {
        
        SalaryInfoData sid = new SalaryInfoData();
        Attend att = new Attend();
        
        double amount;
        double otRate;
        int otHours;
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
       
        String yearMonth = date.substring(0,7);
        
        otRate = sid.getOtRate(desig);
        otHours = att.getOtHours(eid, yearMonth);
        
        amount = otRate * otHours;
        
        return amount;
    }
    
    public double getloanAmount(String eid) {
        
        loanInfo lf = new loanInfo();
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        String yearMonth = date.substring(0,7);
        
        double loanAmount = 0, amount = 0, deductionAmount = 0;
        double lefttoPay = 0;
        int loanID = lf.getLoanID(eid, yearMonth);

        try {
            
            String sql = "select loanAmount,leftToPay from riyoma.loans where loanID="+loanID;
            System.out.println(sql);
            
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                loanAmount = Double.parseDouble(rs.getString(1));
                lefttoPay = Double.parseDouble(rs.getString(2));
            }
            
            deductionAmount = (loanAmount/100);
            
            if(lefttoPay < deductionAmount) {
                amount = lefttoPay;
            }
            else {
                amount = deductionAmount;
            }
            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return amount;
    }
    
    public void setleftToPay(int lid, double amount) {
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        double left  = 0;
        
        try {
            String sql = "select leftToPay from riyoma.loans where loanID="+lid;
            
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                left = Double.parseDouble(rs.getString(1));
            }
            
            left = left - amount;
            
            String sql1 = "";
            
            if(left == 0) {                
                sql1 = "update riyoma.loans set leftToPay="+left+",datePaidBack='"+date+"',status='Received' where loanID="+lid;
            }
            else {
                sql1 = "update riyoma.loans set leftToPay="+left+" where loanID="+lid;
            }
            
            dba.setData(sql1);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    public void generatePaySlip(String sid) {
        DBConnManager dbconn = new DBConnManager();
        
        try
        {   
            Connection conn = dbconn.connect();
            JasperDesign jd = JRXmlLoader.load("E:\\\\PROJECT\\\\Riyoma System\\\\src\\\\IReports\\\\PaySlip.jrxml");
            String sql = "select s.salaryID,s.empID,e.empName,s.date,s.month,si.basicSalary,s.bonuses,s.otAmount,s.loanReductions,s.totalSalary from riyoma.employee e,riyoma.salary s,riyoma.salary_info si where e.empID=s.empID and e.designation=si.designation and s.salaryID='"+sid+"'";
            
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
           
            JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
            JasperViewer.viewReport(jp,false); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void generateReport() {
        DBConnManager dbconn = new DBConnManager();
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy");
        String year = sdf.format(new Date());
        
        try
        {   
            Connection conn = dbconn.connect();
            JasperDesign jd = JRXmlLoader.load("E:\\\\PROJECT\\\\Riyoma System\\\\src\\\\IReports\\\\SalaryAnnum.jrxml");
            String sql = "select s.empID,e.empName,sum(s.totalSalary) as 'Total' from riyoma.employee e,riyoma.salary s where e.empID=s.empID and s.date like '"+year+"%' group by s.empID";
            
            JRDesignQuery newQuery = new JRDesignQuery();
            newQuery.setText(sql);
            jd.setQuery(newQuery);
            JasperReport jr = JasperCompileManager.compileReport(jd);
           
            JasperPrint jp = JasperFillManager.fillReport(jr, null,conn);
            JasperViewer.viewReport(jp,false); 
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    public void autoGenPaySlip(String empID, String date) {
        try {
            String sid = "";
            String sql = "select salaryID from riyoma.salary where empID='"+empID+"' and date='"+date+"'";
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                sid = rs.getString(1);
            }
            
            generatePaySlip(sid);
        } catch (SQLException ex) {
            Logger.getLogger(SalaryCalc.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

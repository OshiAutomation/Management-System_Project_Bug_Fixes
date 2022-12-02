/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import Data.DBConnManager;
import Data.DB_Access;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
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
public class loanInfo {

    DB_Access dba = null;
    
    public loanInfo() {
        dba = new DB_Access();
    }
    
    public int getLoanID(String eid, String yearMonth) {
        
        int loanid = 0;
        String dueDate;
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        try {
            
            String sql = "select loanID,dueDate from riyoma.loans where empID='"+eid+"' and dueDate like '"+yearMonth+"%' and status='Paid'";
            System.out.println(sql);
            
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                loanid = Integer.parseInt(rs.getString(1));
                dueDate = rs.getString(2);
                
                if(Integer.parseInt(date.substring(8)) < Integer.parseInt(dueDate.substring(8))) {
                    loanid = -1;
                }
            }
              
        } catch (SQLException ex) {
            Logger.getLogger(loanInfo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loanid;
    }

    public String getDueDate(Double amount) {
        
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        int year = Integer.parseInt(date.substring(0,4));
        String monthDate = date.substring(4);
        String dueDate = null;
        
        if(amount<=100000) {
            year = year + 1;
        }
        else if((amount>100000)&&(amount<=500000)) {
            year = year + 2;
        }
        
        dueDate=year+monthDate;
        return dueDate;
    }
    
    public int getLoanID(String ename) {
        
        int lid = 0;
        
        try {
            String sql = "select loanID from riyoma.loans l,riyoma.employee e where e.empID=l.empID and l.status='Paid' and e.empName='"+ename+"'";
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                lid = Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException ex) {
            System.out.println("Sql error");
        }
        return lid;
    }
    
    public boolean setRetLoan(int lid) {
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(new Date());
        
        boolean result = false;
        
        try {
            String sql = "update riyoma.loans set leftToPay='0',datePaidBack='"+date+"',status='Received' where loanID="+lid;
            dba.setData(sql);
            
            result = true;
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public boolean checkAvailabillity(String ename) {
        boolean result = false;
        int lid = getLoanID(ename);
        
        if(lid > 0) {
            result = true;
        }
        return result;
    }
    
    public void generateReport() {
        DBConnManager dbconn = new DBConnManager();
        
        try
        {   
            Connection conn = dbconn.connect();
            JasperDesign jd = JRXmlLoader.load("E:\\\\PROJECT\\\\Riyoma System\\\\src\\\\IReports\\\\LoanAnnum.jrxml");
            String sql = "select l.loanID,l.empID,e.empName,l.loanAmount,l.datePaid,l.dueDate,l.leftToPay,l.datePaidBack,l.status from riyoma.employee e,riyoma.loans l where e.empID=l.empID";
            
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
}

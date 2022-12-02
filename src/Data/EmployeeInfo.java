/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Data;

import Data.DB_Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

/**
 *
 * @author gallelaptop.lk
 */
public class EmployeeInfo {

    DB_Access dba = null;
    
    public EmployeeInfo() {
        dba = new DB_Access();
    }
    
    public ArrayList getEmpID() {
        
        ArrayList eid = null;
        
        try {
            String sql = "select distinct empID from riyoma.employee";
            ResultSet rs = dba.getData(sql);
            
            eid = new ArrayList();
            
            while(rs.next()) {
                String desRow = rs.getString(1);
                eid.add(desRow);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Select query failed");
        } 
        return eid;
    }
    
    public ArrayList getEmpName() {
        
        ArrayList ename = null;
        
        try {
            String sql = "select distinct empName from riyoma.employee";
            ResultSet rs = dba.getData(sql);
            
            ename = new ArrayList();
            
            while(rs.next()) {
                String desRow = rs.getString(1);
                ename.add(desRow);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Select query failed");
        } 
        return ename;
    }
    
     public ArrayList getLoanID() {
        
        ArrayList lid = null;
        
        try {
            String sql = "select distinct loanID from riyoma.loans where status='Paid'";
            ResultSet rs = dba.getData(sql);
            
            lid = new ArrayList();
            
            while(rs.next()) {
                String desRow = rs.getString(1);
                lid.add(desRow);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Select query failed");
        } 
        return lid;
    }     
    
    public ArrayList getEmpNameLoans() {
        
        ArrayList eid = null;
        
        try {
            String sql = "select distinct empName from riyoma.loans l,riyoma.employee e where e.empID=l.empID and status='Paid'";
            ResultSet rs = dba.getData(sql);
            
            eid = new ArrayList();
            
            while(rs.next()) {
                String desRow = rs.getString(1);
                eid.add(desRow);
            }
        } catch (SQLException ex) {
            System.out.println("Select query failed");            
        } 
        return eid;
    }
    
    public boolean empAvailable(String eid) {
        
        boolean result = false;
        
        try {
            String sql = "select * from riyoma.employee where empID='"+eid+"'";
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                result = true;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        return result;
    }
    
    public String getName(String eid) {
        String name = null;

        try {          
            String sql = "select empName from riyoma.employee where empID='"+eid+"'";
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                name = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error....");
        }
        return name;
    }
    
     public String getempID(String ename) {
        String eid = null;

        try {          
            String sql = "select empID from riyoma.employee where empName='"+ename+"'";
            System.out.println(sql);
            ResultSet rs = dba.getData(sql);
            
            if(rs.next()) {
                eid = rs.getString(1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error....");
        }
        return eid;
    }

    public String getRandomString(int length, char[] characterSet) {
        StringBuilder sb = new StringBuilder();

        for (int loop = 0; loop < length; loop++) {
            int index = new Random().nextInt(characterSet.length);
            sb.append(characterSet[index]);
        }
        String nonce = sb.toString();
        return nonce;
    }
    
    public void sendMail(String email, String password) throws MessagingException {
        
        Properties emailProperties;
        Session mailSession;
        MimeMessage message;

        // gmail's smtp port
        String emailPort = "587";

        emailProperties = System.getProperties();
        emailProperties.put("mail.smtp.port", emailPort);
        emailProperties.put("mail.smtp.auth", "true");
        emailProperties.put("mail.smtp.starttls.enable", "true");
        emailProperties.put("mail.smtp.ssl.trust", "smtp.gmail.com");


        String toEmail = email;
        String emailSubject = "Riyoma International (Pvt) Ltd.";
        String emailBody = "Your password is : "+password;

        mailSession = Session.getDefaultInstance(emailProperties, null);
        message = new MimeMessage(mailSession);

        message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail)); 
        message.setSubject(emailSubject);

        // for a html email
        message.setContent(emailBody, "text/html");
        // emailMessage.setText(emailBody);// for a text email
        String emailHost = "smtp.gmail.com";

        //String senderUsername = "thepiratzrox@gmail.com";
         String senderUsername = "oshinijayasekara4@gmail.com";

        //String senderEmailPassword = "80723560piratz";//insert the password
        String senderEmailPassword = "oshanilakchanipiumiwathsala";//insert the password


        Transport transport = mailSession.getTransport("smtp");
        transport.connect(emailHost, senderUsername, senderEmailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
        System.out.println("Email sent successfully.");
    }
}

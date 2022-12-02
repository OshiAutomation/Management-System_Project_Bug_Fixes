/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Oshani
 */
public class Deliverydetails {
    
   
    // constructor 
    private int agentId;  
    private String agentName;
    private String company;
    private String location;
    private String phone;
    private float chargingRate;
    private int rating;
    
    
    
    Data.DB_Access dbAccess = new Data.DB_Access();

    public Deliverydetails(String agentName, String company, String location, String phone, float chargingRate, int rating) {
        this.agentName = agentName;
        this.company = company;
        this.location = location;
        this.phone = phone;
        this.chargingRate = chargingRate;
        this.rating = rating;
    }
    

    
    
    
    public Deliverydetails (int agentId, String agent, String company, String location, String phone, float chargingRate, int rating) {
        this.agentId = agentId;
        this.agentName = agent;
        this.company = company;
        this.location = location;
        this.phone = phone;
        this.chargingRate = chargingRate;
        this.rating = rating;
  

    }
    
    public boolean addAgent() {
        
        boolean result=true;
        
        try {
            dbAccess.setData("insert into delivery_agent (agentId ,name,company,phone,location,chargingRate,rating) "
                            + "values ('" + agentId + "','" + agentName + "','" + company + "','" + phone + "','" + location + "','" + chargingRate + "','" + rating + "')");
        
        } catch (SQLException ex) {
            
            System.out.println(ex+"-----------Insertion filuer!!!");
            result = false;
        }
        
        return result;
    }
      
    
    
    
    public boolean updateAgent() {
        
        boolean result=true;
        
        try {
            dbAccess.setData("update delivery_agent set agentId='" + agentId + "', name='" + agentName + "',company='" + company + "',location='" + location + "',phone='" + phone + "',chargingRate='" + chargingRate + "' where agentId='" + agentId + "'");
        
        } catch (SQLException ex) {
            
            System.out.println(ex+"-----------Update filuer!!!");
            result = false;
        }
        
        return result;
    }
    
    
    
//    public boolean deleteAgent() {
//        
//        boolean result=true;
//        
//        try {
//          
//        
//        } catch (SQLException ex) {
//            
//            System.out.println(ex+"-----------Update filuer!!!");
//            result = false;
//        }
//        
//        return result;
//    }
//    
//    
    
    
}
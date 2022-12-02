/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Senali
 */
public class ShippingDetails {
    
    private String shipID;
    private String shipCompany;
    private String shipName;
    private String address;
    private String email;
    private int orderID;
    private String shpdDate;
    private String landDate;
    private double shipCharge;
    DB_Access dbAccess = new DB_Access();

    public ShippingDetails(String shipID, String shipCompany, String shipName, String address, String email) {
        this.shipID = shipID;
        this.shipCompany = shipCompany;
        this.shipName = shipName;
        this.address = address;
        this.email = email;
    }

    public ShippingDetails(String shipID, int orderID, String shpdDate, String landDate, double shipCharge) {
        this.shipID = shipID;
        this.orderID = orderID;
        this.shpdDate = shpdDate;
        this.landDate = landDate;
        this.shipCharge = shipCharge;
    }

    public ShippingDetails() {
    }
    
    public boolean addShipCompanyDetails() {
        
        boolean result = true;
        
        try {
            dbAccess.setData("insert into ship values('"+this.shipCompany+"', '"+this.shipID+"', '"+this.shipName+"', '"+this.email+"', '"+this.address+"')");
        
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Insertion Failure");
            result = false;
        }
        
        return result;
    }
    
    public ResultSet getShipCompanies() {
        
        ResultSet rst = null;
        
        try {
            rst = dbAccess.getData("select * from ship");
            
        } catch (SQLException ex) {       
            
            System.out.println(ex + "Error of retrieving data-----------");
        }
        
        return rst;
    }
    
    public ResultSet searchShipCompany(String shipId) {
        
        
        ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select * from ship where shipID LIKE '%"+shipId+"%'");
            
            
        } catch (SQLException ex) {
            
             System.out.println(ex + "Error of retieving data------Search key is not exist");
        }
        
        return rst;
    }
    
    public boolean updateShipCompanyDetails() {
        
        boolean result = true;
        
        try {
            
            dbAccess.setData("update ship set company = '"+this.shipCompany+"', shipName = '"+this.shipName+"', email = '"+this.email+"', address = '"+this.address+"' " +
                             "where shipID = '"+this.shipID+"'");
                   
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Updation Failure");
            result = false;
        }
        
        return result;

    }
    
    public boolean removeShipCompany(String shipId) {
        
        boolean result = true;
        
        try {
            
            dbAccess.setData("delete from ship where shipID = '"+shipId+"'");
                   
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Deletion Failure");
            result = false;
        }
        
        return result;
        
    }
    
    public ResultSet getShippedOrders(String shipId) {
        
        ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select orderID, shipID, loadDate, landDate, charges from order_ship where shipID LIKE '%"+shipId+"%'");
            
            
        } catch (SQLException ex) {
            
             System.out.println(ex + "Error of retieving data------Search key is not exist");
        }
        
        return rst;
    }
    
    public boolean addShippedOrders() {
        
        boolean result = true;
        
        try {
            dbAccess.setData("insert into order_ship(shipID, orderID, loadDate, landDate, charges) "
                             + "values('"+this.shipID+"', '"+this.orderID+"', '"+this.shpdDate+"', '"+this.landDate+"', '"+this.shipCharge+"')");
        
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Insertion Failure");
            result = false;
        }
        
        return result;
        
    }
    
    public ResultSet searchShippedOrders(int orderId) {
        
        ResultSet rst = null;
        String id = String.valueOf(orderId);
        
        try {
            
            rst = dbAccess.getData("select orderID, shipID, loadDate, landDate, charges from order_ship where orderID LIKE '%"+id+"%'");
            
            
        } catch (SQLException ex) {
            
             System.out.println(ex + "Error of retieving data------Search key is not exist");
        }
        
        return rst;
    }
    
     public ResultSet getAllshippedOrders() {
        
        ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select orderID, shipID, loadDate, landDate, charges from order_ship");
            
            
        } catch (SQLException ex) {
            
             System.out.println(ex + "Error of retieving data------Search key is not exist");
        }
        
        return rst;
    }
     
    public boolean updateShippedOrders() {
        
        boolean result = true;
        
        try {
            
            dbAccess.setData("update order_ship set shipID = '"+this.shipID+"', loadDate = '"+this.shpdDate+"', landDate = '"+this.landDate+"', charges = '"+this.shipCharge+"' " +
                             "where orderID = '"+this.orderID+"'");
                   
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Updation Failure");
            result = false;
        }
        
        return result;

    }
    
    
    public boolean removeShippedOrder(int orderId) {
        
        boolean result = true;
        
        try {
            
            dbAccess.setData("delete from order_ship where orderID = '"+orderId+"'");
                   
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Deletion Failure");
            result = false;
        }
        
        return result;
        
    }
    
    public ArrayList getShippedOrderIds() {
        
        ArrayList orderIds = new ArrayList();
        ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select orderID from order_ship");
            
            while(rst.next()) {
                
                orderIds.add(rst.getString(1));
            }
            
            
        } catch (SQLException ex) {
            
             System.out.println(ex + "Error of retieving data------Search key is not exist");
        }
        
        return orderIds;
    }
    
    public String getShipID(int orderId) {
        
        ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select shipID from order_ship where orderID = '"+orderId+"'");
            
            if(rst.next())
                shipID = rst.getString(1);
            
        } catch (SQLException ex) {
            
             System.out.println(ex + "Error of retieving data------Search key is not exist");
        }
        
        return shipID;
    }
    
    public double getShippingCharge(int orderId) {
        
         ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select charges from order_ship where orderID = '"+orderId+"'");
            
            if(rst.next())
                shipCharge = rst.getDouble(1);
            
            
        } catch (SQLException ex) {
            
             System.out.println(ex + "Error of retieving data------Search key is not exist");
        }
        
        return shipCharge;
    }
    
    public void addOtherCharges(double otherCharges, int orderId) {
               
        try {
            
            dbAccess.setData("update order_ship set otherCharges = '"+otherCharges+"'" +
                             "where orderID = '"+orderId+"'");
                   
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Updation Failure");
        }
        
    }
}

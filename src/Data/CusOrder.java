/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Senali
 */
public class CusOrder {
    
    private int orderID;
    private String machineName;
    private int quantity;
    private double unitPrice;
    private double totPrice;
    
    DB_Access dbAccess = new DB_Access();

    public CusOrder() {
        
    }
    
    public boolean addOrder(int orderID, Vector order) {
        
        boolean result = true;
        
        for(int i=0; i<order.size(); i++) {
            
            Vector<String> newOrder = new Vector<String>();
            newOrder = (Vector<String>) order.get(i);
            
            machineName = newOrder.get(0);
            unitPrice = Double.parseDouble(newOrder.get(1));
            quantity = Integer.parseInt(newOrder.get(2));
            totPrice = Double.parseDouble(newOrder.get(3));
            
            try {
                
                dbAccess.setData("insert into item values('"+orderID+"', '"+machineName+"', '"+unitPrice+"', '"+quantity+"', '"+totPrice+"')");
                
            } catch (SQLException ex) {
                
                System.out.println(ex+"-------------Insertion failure");
                result = false;
                break;
            }
        }
        
        return result;
    }
    
    public ResultSet getOrderDetails(int orderID) {
        
        ResultSet rst = null;
        
        try {
            rst = dbAccess.getData("select i.MachineID, i.UnitPrice, i.Quantity, i.TotAmount " +
                                   "from item i where CusOrderID = '"+orderID+"'");
            
        } catch (SQLException ex) {
            
            System.out.println(ex+"-------------Insertion failure");
            rst = null;
        }
        
        return rst;
        
    }
    
    public ResultSet getCusDetails(int orderID) {
        
        ResultSet rst = null;
        
        try {
            rst = dbAccess.getData("select sum(i.TotAmount), co.orderAmount, od.deliveryCost " +
                                   "from item i, customer_order co, order_delivery od where i.CusOrderID = '"+orderID+"'");
            
        } catch (SQLException ex) {
            
            System.out.println(ex+"-------------Insertion failure");
            rst = null;
        }
        
        return rst;
    }
    
}

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
public class SuppliedOrder {

    private int orderID;
    private String orderedDate;
    private String supName;
    private int supPhone;
    private double orderPrice;
    private String modelName;
    private int quantity;
    private double unitPrice;
    private double totalPrice;
    private DB_Access dbAccess = new DB_Access();

    public SuppliedOrder(String orderedDate, String supName, int supPhone, double orderPrice) {
        this.orderedDate = orderedDate;
        this.supName = supName;
        this.supPhone = supPhone;
        this.orderPrice = orderPrice;
    }

    public SuppliedOrder() {
    }

    public boolean addSupplliedOrders() {

        boolean result = true;

        try {

            dbAccess.setData("insert into client_order (orderDate, supName, supPhone, orderAmount) "
                    + "values ('" + this.orderedDate + "','" + this.supName + "','" + this.supPhone + "','" + this.orderPrice + "')");

        } catch (SQLException ex) {

            System.out.println(ex + "-----------Insertion Failure");
            result = false;
        }

        return result;
    }

    public SuppliedOrder(String modelName, int quantity, double unitPrice, double totalPrice) {
        this.modelName = modelName;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
    }

    public int getOrderID(String orderDate, String supName) {

        ResultSet rst = null;
        int orderId = 0;

        try {

            rst = dbAccess.getData("select orderID from client_order where orderDate='" + orderDate + "' AND supName='" + supName + "'");
            while (rst.next()) {
                orderId = rst.getInt(1);
            }

        } catch (SQLException ex) {

            System.out.println(ex + "----------Error of in retrieving data-----------Searching ID is not exist");
            orderId = 0;

        }

        return orderId;
    }

    public ResultSet SearchOrders(int orderID) {

        ResultSet rst = null;
        String id = String.valueOf(orderID);

        try {

            rst = dbAccess.getData("select orderID, orderDate, orderAmount, supName, supPhone from client_order where orderID LIKE '%" + id + "%'");


        } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data------Search key is not exist");

        }

        return rst;


    }

    public ResultSet getOrders() {

        ResultSet rst = null;

        try {

            rst = dbAccess.getData("select orderID, orderDate, orderAmount, supName, supPhone from client_order");

        } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data-----------");

        }

        return rst;
    }

    public boolean updateOrder(int orderID) {

        boolean result = true;

        try {

            dbAccess.setData("update client_order set orderDate='" + this.orderedDate + "', orderAmount='" + this.orderPrice + "', supName='" + this.supName + "', supPhone='" + this.supPhone + "' "
                    + "where orderID='" + orderID + "'");

        } catch (SQLException ex) {

            System.out.println(ex + "Error in updating----------");
            result = false;
        }

        return result;
    }

    public boolean removeOrder(int orderId) {

        boolean result = true;

        try {

            dbAccess.setData("delete from client_order where orderID='" + orderId + "'");

        } catch (SQLException ex) {

            System.out.println(ex + "Error of deleting record........");
            result = false;

        }

        return result;
    }

    public boolean addModels(int orderId, String modelName, int quantity, double unitPrice, double totalPrice) {

        boolean result = true;

        try {

            dbAccess.setData("insert into ordered_machine(orderID, machine, quantity, buyingPrice, buyingCost) "
                    + "values('" + orderId + "', '" + modelName + "', '" + quantity + "', '" + unitPrice + "', '" + totalPrice + "')");

        } catch (SQLException ex) {

            System.out.println(ex + "-----------Insertion Failure");
            result = false;
        }

        return result;
    }

    public ResultSet getModels(int orderId) {

        ResultSet rst = null;

        try {

            rst = dbAccess.getData("select machine, quantity, buyingPrice, buyingCost from ordered_machine where orderID='" + orderId + "'");
            return rst;

        } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data-----------");
            return null;
        }

    }

    public boolean updateModels(int orderID) {

        boolean result = true;

        try {

            dbAccess.setData("update ordered_machine set quantity='" + this.quantity + "', buyingPrice='" + this.unitPrice + "', buyingCost='" + this.totalPrice + "' "
                    + "where orderID='" + orderID + "' AND machine='" + this.modelName + "'");

        } catch (SQLException ex) {

            System.out.println(ex + "Error in updating----------");
            result = false;
        }

        return result;
    }

    public boolean removeModel(int orderId, String model) {

        boolean result = true;

        try {

            dbAccess.setData("delete from ordered_machine where orderID='" + orderId + "' AND machine='" + model + "'");

        } catch (SQLException ex) {

            System.out.println(ex + "Error of deleting record........");
            result = false;

        }

        return result;
    }
    
     public ArrayList getOrderIDs(){
       
       ArrayList orderIDs = new ArrayList();
       
        try {

            ResultSet rst = dbAccess.getData("select orderID from client_order");
            
            while(rst.next()) {
                
                orderIDs.add(rst.getString(1));
            }

        } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data-----------");
            orderIDs = null;

        }
        
        return orderIDs;
   }
     
   public double getOrderPrice(int orderId) {

        ResultSet rst = null;

        try {

            rst = dbAccess.getData("select orderAmount from client_order where orderID = '"+orderId+"'");
            
            if(rst.next())
                orderPrice = rst.getDouble(1);

        } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data-----------");

        }

        return orderPrice;
    }  
   
   public boolean addOrderCost(int orderID, double orderCost) {

        boolean result = true;

        try {

            dbAccess.setData("update client_order set orderCost = '"+orderCost+"'" +
                             "where orderID='" + orderID + "'");

        } catch (SQLException ex) {

            System.out.println(ex + "Error in updating----------");
            result = false;
        }

        return result;
    }
   
   public Vector getModelPrices(int orderId) {

        ResultSet rst = null;
        Vector<Vector<String>> modelVector = new Vector<Vector<String>>();
        

        try {

            rst = dbAccess.getData("select machine, buyingPrice from ordered_machine where orderID='" + orderId + "'");
            
            while(rst.next()) {
                
                Vector<String> models = new Vector<String>();
                models.add(rst.getString(1));
                models.add(rst.getString(2));
                
                modelVector.add(models);
            }

        } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data-----------");
            modelVector = null;
        }

        return modelVector;
    }
   
   public boolean addSellingPrice(int orderID, String modelName, double sellingPrice) {

        boolean result = true;

        try {

            dbAccess.setData("update ordered_machine set sellingPrice='" + sellingPrice + "' " +
                             "where orderID='" + orderID + "' AND machine='" + modelName + "'");

        } catch (SQLException ex) {

            System.out.println(ex + "Error in updating----------");
            result = false;
        }

        return result;
    }
   
   public ResultSet searchModel(int orderId, String modelName) {
       
       ResultSet rst = null;
       
       try {
     
           rst = dbAccess.getData("select DISTINCT machine, buyingPrice, sellingPrice from ordered_machine where orderID='" + orderId + "' AND machine LIKE'%" + modelName + "%'");
   
       } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data-----------");
       }
       
       return rst;
   }
   
   public ArrayList getSupplier(int orderID) {

        ArrayList supplier = new ArrayList();

        try {

            ResultSet rst = dbAccess.getData("select supName, supPhone from client_order where orderID = '" + orderID + "'");
            
            if(rst.next()) {
                
                supplier.add(rst.getString(1));
                supplier.add(rst.getString(2));
            }

        } catch (SQLException ex) {

            System.out.println(ex + "Error of retrieving data------Search key is not exist");
            supplier = null;

        }

        return supplier;

    }
}
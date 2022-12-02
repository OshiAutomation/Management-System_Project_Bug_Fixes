/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Senali
 */
public class Supplier {
    
    private String name;
    private String company;
    private int phone;
    private String address;
    private String email;
    private DB_Access dbAccess=new DB_Access();

    public Supplier(String name, String company, int phone, String address, String email) {
        
        this.name = name;
        this.company = company;
        this.phone = phone;
        this.address = address;
        this.email = email;
    }

    public Supplier() {
        
    }
    
    public boolean addSuppliers() {
        
        boolean result=true;
        
        try {
            
            dbAccess.setData("insert into supplier values ('"+this.name+"','"+this.phone+"','"+this.company+"','"+this.email+"','"+this.address+"')");
            
        } catch (SQLException ex) {
            
            System.out.println(ex + "-----------Insertion Failure");
            result = false;
        } 
        
        return result;
    }


    public ResultSet getSupplierDetails() {
        
        ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select name, company, phone, address, email from supplier");
            
        } catch (SQLException ex) {
            
            System.out.println(ex + "Error of retrieving data-----------");
     
        }
       
        return rst;
    }
    
    public ResultSet SearchSuppliers(String supName) {
        
        ResultSet rst = null;
        
        try {
            
            rst = dbAccess.getData("select name, company, phone, address, email from supplier where name LIKE '%"+supName+"%'");
            
            
        } catch (SQLException ex) {
           
            System.out.println(ex + "Error of retieving data------Search key is not exist");
            
        }
        
        return rst;
        
   }
    
   public boolean updateSuppliers() {
       
       boolean result = true;
       
       try {
          
           dbAccess.setData("update supplier set company='"+this.company+"', address='"+this.address+"', email='"+this.email+"'"+
                            "where name='"+this.name+"' AND phone='"+this.phone+"'");
        
       } catch (SQLException ex) {
           
           System.out.println(ex + "Error in updating----------");
           result = false;
       }
       
       return result;
   }
   
   public boolean removeSupplier(String supName) {
       
       boolean result = true;
       
       try {
           
            dbAccess.setData("delete from supplier where name='"+supName+"'");
            
        } catch (SQLException ex) {
            
           System.out.println(ex + "Error of deleting record........");
           result = false;
            
        }
       
       return result;
   }
   
   public boolean checkSupplierName(String supName) {
       
       boolean result =true;
       
       try {
            
            dbAccess.getData("select name from supplier where name = '"+supName+"'");
            
            
        } catch (SQLException ex) {
           
            System.out.println(ex + "Error of retieving data------Search key is not exist");
            result =false;
            
        }
       
       return result;
   }
   
}
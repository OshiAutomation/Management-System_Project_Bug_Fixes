/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;


import Data.DB_Access;
//import com.mysql.cj.jdbc.StatementImpl;
//import com.mysql.jdbc.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author Eranga M
 */
public class SellingCombo {
    
    DB_Access dbAccess = new DB_Access();
    
    public DefaultComboBoxModel getList(String name)
    {
        DefaultComboBoxModel model=new DefaultComboBoxModel();
        try {
            
            System.out.println("select cusName from customer where cusName LIKE '"+name+"%'");
            ResultSet rs = dbAccess.getData("select cusName from customer where cusName LIKE '"+name+"%'");
            
            while(rs.next())
            {
                model.addElement(rs.getString("cusName"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SellingCombo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return model;
    }
    
    public String[] filltextField(String name)
    {
       
        String [] data=new String[2];
        try {
            
            ResultSet rs = dbAccess.getData("select cusOrderID,company from customer where cusName='"+name+"' ");
            while(rs.next())
            {
                for (int i = 0; i < data.length; i++) {
                    data[i]=rs.getString(i+1);
                
                    
                }
            
            }
        } catch (SQLException ex) {        
            return null;
        }
        return data;
    }
 
}

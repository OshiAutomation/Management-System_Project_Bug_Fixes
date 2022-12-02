/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oshani se
 */
public class DBConnManager {
    
    String sourceURL;
    
    public DBConnManager() {
        try {
            //Load JDBC Driver
           // Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Create Connection URL
            sourceURL = new String("jdbc:mysql://localhost:3306/riyoma");
            
        } catch (ClassNotFoundException ex) {
            
            System.out.println(ex + "------------Unable to load Database Driver Class");
            
        }
        
    }
    
    public Connection connect() {
        
        Connection dbConn = null;
        
        try {
            //Create connection
            dbConn = DriverManager.getConnection(sourceURL,"root","Dev@1234");
            
        } catch (SQLException ex) {
            
            System.out.println(ex + "-------------DB Connection Failure");
            
        }
        
        return dbConn;    
    
    }
    
    void con_Close(Connection dbConn) {
        
        try {
            
            dbConn.close();
            
        } catch (SQLException ex) {
            
            System.out.println(ex + "-------------DB Connection Closing Failure");
            
        }
    }

}
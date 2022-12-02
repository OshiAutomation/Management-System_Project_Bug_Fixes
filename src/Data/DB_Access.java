/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Senali
 */
public class DB_Access {
    
    private DBConnManager dbConnManager=null;
    
    public DB_Access() {
        
        dbConnManager=new DBConnManager();
    }
        
    String q;
    
    public ResultSet getData(String query) throws SQLException {
        
        Connection dbConn;    
        dbConn = dbConnManager.connect();
        Statement st = dbConn.createStatement();
        ResultSet rs = st.executeQuery(query);
        //dbConnManager.con_Close(dbConn);
        return rs;      
    }
    
    public void setData(String query) throws SQLException {
         
        Connection dbConn = dbConnManager.connect();   
        Statement st = dbConn.createStatement();
        st.executeUpdate(query);
        dbConnManager.con_Close(dbConn);
                 
    }
    
}

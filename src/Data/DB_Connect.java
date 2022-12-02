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
 * @author Senali
 */
public class DB_Connect {
    
    public static Connection getConnection() throws SQLException {
        Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/riyoma", "root", "Dev@1234");
        return conn;
        
    }
    
    public static void con_close(Connection dbConn) {
        try {
            
            dbConn.close();
            
        } catch (SQLException sQLException) {
            
            System.out.println(sQLException + "-----------DB connection closing failure");
            
        }
    }
    
}

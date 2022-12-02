/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 *
 *
 * ********************************************first DBConnection..!!!
 */
package ryomainternational.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Oshani mi
 */
public class DBConnection {

    private static Connection connection;
    private static DBConnection dbConnection;

    private DBConnection() throws ClassNotFoundException, SQLException {
        //Class.forName("com.mysql.jdbc.Driver");
        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/riyoma", "root", "Dev@1234");
    }

    private static DBConnection createConnection() throws ClassNotFoundException, SQLException {
        return new DBConnection();
    }

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        return createConnection().connection;
    }
}

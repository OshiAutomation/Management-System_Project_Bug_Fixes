/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ryomainternational.connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author minura
 *
 * ******************************************************first DBHandler...!!!!
 */
public class DBHandler {

    public static int setData(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement();
        int response = statement.executeUpdate(query);
        return response;
    }

    public static ResultSet getData(Connection connection, String query) throws SQLException {
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
        ResultSet resultSetObject = statement.executeQuery(query);
        return resultSetObject;
    }
}

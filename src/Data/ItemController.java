/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Data.DB_Access;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import ryomainternational.connection.DBConnection;
import ryomainternational.connection.DBHandler;

/**
 *
 * @author HP
 */
public class ItemController {

    public static ArrayList viewItemData() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "select * from stock";
        ResultSet resultSetObject = DBHandler.getData(connection, query);
        ArrayList itemList = new ArrayList();
        while (resultSetObject.next()) {
            itemList.add(new Item(resultSetObject.getString(0), resultSetObject.getString("description"), resultSetObject.getDouble("unitPrice"), resultSetObject.getInt("qtyOnHand")));
        }
        return itemList;
    }

    public static int addItem(Item item) {
        DB_Access acc = new DB_Access();
        int responce;
        try {

            // first insert data (Supp.name and Supp.Phone to supplier table)
            System.out.println(item.getSupName());
            acc.setData("insert into supplier(name,phone) values('" + item.getSupName() + "','" + item.getSupPhone() + "')");
            //then add values to the stock table
            acc.setData("insert into stock(modelID,machineName,maufactYear,noAvailable,sellingPrice,supName,supPhone,remarks) values('" + item.getModID() + "','" + item.getMachineName() + "','" + item.getManuYear() + "','" + item.getNoAvailable() + "','" + item.getSellingPrice() + "','" + item.getSupName() + "','" + item.getSupPhone() + "','" + item.getRemarks() + "')");
            responce = 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            responce = 0;
        }
        return responce;
    }

    //Update Item ...!!!
    public static int UpdateItem(Item item) {
        DB_Access acc = new DB_Access();
        int responce;
        try {
            int a = Integer.parseInt(item.getSupPhone());

            // first insert data (Supp.name and Supp.Phone to supplier table)
            System.out.println(item.getSupName());

            acc.setData("update supplier set name='" + item.getSupName() + "', phone= '" + a + "' where phone = '" + a + "'");
            //then add values to the stock table

            acc.setData("update  stock set modelID='" + item.getModID() + "',machineName='" + item.getMachineName() + "' ,maufactYear ='" + item.getManuYear() + "',noAvailable='" + item.getNoAvailable() + "',sellingPrice='" + item.getSellingPrice() + "',supName='" + item.getSupName() + "',supPhone='" + a + "', remarks='" + item.getRemarks() + "' where modelID='" + item.getModID() + "'");
            responce = 1;
        } catch (SQLException ex) {
            System.out.println(ex);
            responce = 0;
        }
        return responce;
    }

    public static int deleteItem(String modID) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        DB_Access acc = new DB_Access();
        String query = "delete from stock  where modelID='" + modID + "'";
        int response = DBHandler.setData(connection, query);

        return response;
    }

    public static Item searchItem(String Iname) throws SQLException, ClassNotFoundException {

        DB_Access acc = new DB_Access();

        Item itm = null;

        ResultSet resultSetObject = acc.getData("select * from stock where machineName='" + Iname + "'");
        while (resultSetObject.next()) {
            itm = new Item();
            itm.setModID(resultSetObject.getString("modelID"));
            itm.setMachineName(resultSetObject.getString("machineName"));
            itm.setManuYear(resultSetObject.getInt("maufactYear"));
            itm.setNoAvailable(resultSetObject.getInt("noAvailable"));
            itm.setSellingPrice(resultSetObject.getDouble("sellingPrice"));
            itm.setSupName(resultSetObject.getString("supName"));
            itm.setSupPhone(resultSetObject.getString("supPhone"));
            itm.setRemarks(resultSetObject.getString("remarks"));
        }

        return itm;
    }
    ResultSet rst = null;

    public static ArrayList getMachinaryName() throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT distinct(machineName) FROM stock";
        ResultSet resultSetObject = DBHandler.getData(connection, query);
        ArrayList machinaryName = new ArrayList();
        while (resultSetObject.next()) {
            machinaryName.add(resultSetObject.getString("machineName"));
        }
        return machinaryName;
    }

    public static ArrayList viewItems(String machinaryName) throws ClassNotFoundException, SQLException {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM stock where machineName='" + machinaryName + "'";
        ResultSet rst = DBHandler.getData(connection, query);
        ArrayList itemList = new ArrayList();
        while (rst.next()) {
            itemList.add(new Item(rst.getString(1), rst.getString(2), rst.getInt(3), rst.getInt(4), rst.getDouble(5), rst.getString(6), rst.getString(7), rst.getString(8)));
        }
        return itemList;
    }
}

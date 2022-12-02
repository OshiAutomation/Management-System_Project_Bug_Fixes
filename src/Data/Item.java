/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Data.DB_Access;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class Item {

    private String modID;
    private String machineName;
    private String supName;
    private String supPhone;
    private String remarks;
    private String description;
    private int manuYear;
    private double sellingPrice;
    private double unitPrice;
    private int noAvailable;
    private int qtyOnHand;

    public Item() {
    }
    DB_Access dbAcess = new DB_Access();

    public Item(String machineName) {
        this.machineName = machineName;
    }

    public Item(String modID, String description, double unitPice, int qtyOnHand) {
        this.modID = modID;
        this.description = description;
        this.unitPrice = unitPice;
        this.qtyOnHand = qtyOnHand;
    }

    public Item(String modID, String machineName, int manuYear, int noAvailable, double sellingPrice, String supName, String supPhone, String remarks) {
        this.modID = modID;
        this.machineName = machineName;
        this.supName = supName;
        this.supPhone = supPhone;
        this.remarks = remarks;
        this.manuYear = manuYear;
        this.sellingPrice = sellingPrice;
        this.noAvailable = noAvailable;
    }

    public String getModID() {
        return modID;
    }

    public void setModID(String modID) {
        this.modID = modID;
    }

    public String getMachineName() {
        return machineName;
    }

    public void setMachineName(String machineName) {
        this.machineName = machineName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getQtyOnHand() {
        return qtyOnHand;
    }

    public void setQtyOnHand(int QtyOnHand) {
        this.qtyOnHand = QtyOnHand;
    }

    public int getManuYear() {
        return manuYear;
    }

    public int getNoAvailable() {
        return noAvailable;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public String getSupName() {
        return supName;
    }

    public String getSupPhone() {
        return supPhone;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setManuYear(int manuYear) {
        this.manuYear = manuYear;
    }

    public void setNoAvailable(int noAvailable) {
        this.noAvailable = noAvailable;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setSupName(String supName) {
        this.supName = supName;
    }

    public void setSupPhone(String supPhone) {
        this.supPhone = supPhone;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public ResultSet viewItems() {
        ResultSet rst = null;
        try {
            rst = dbAcess.getData("select * from stock");
        } catch (SQLException ex) {
            System.out.println(ex + "Error of retrieving data------Search key is not exist");
        }
        return rst;
    }

    public ResultSet viewItemsChange(String machinaryName) {
        ResultSet rst = null;
        try {
            rst = dbAcess.getData("SELECT * FROM stock where machineName='" + machinaryName + "'");
        } catch (SQLException ex) {
            System.out.println(ex + "Error of retrieving data------Search key is not exist");
        }
        return rst;
    }
}

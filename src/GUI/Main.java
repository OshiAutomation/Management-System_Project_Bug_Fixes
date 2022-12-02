/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import Data.DB_Access;
import com.sun.jdi.connect.spi.Connection;
import data.Item;
import data.ItemController;
import java.awt.Color;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.print.PrinterAbortException;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
////import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;       
import java.util.ArrayList;

import java.util.Iterator;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;
import data.ComboSearch;
import ryomainternational.Validation;
import data.Item;
import data.ItemController;
import gui.EmpMng.Home;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

/**
 *
 * @author Oshani
 */
public class Main extends javax.swing.JFrame {

    boolean result;
  // DB_Access dba = new DB_Access();
 //  DBConnManager dbm = new DBConnManager();
    // [01] .. Delivery_Agent ******************
    public Main() {
        initComponents();
        setLocationRelativeTo(null);
        getMachinaryName();
        viewItems();
        ComboSearch.getSearchableComboBox(machineNameComboBox, true, "Not Found");
        jTextField1.hide();

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();
        jTextField6 = new javax.swing.JTextField();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        machineNameComboBox = new javax.swing.JComboBox();
        jButton8 = new javax.swing.JButton();
        printButton = new javax.swing.JButton();
        jTextField7 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 700));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);
        getContentPane().add(jSeparator1);
        jSeparator1.setBounds(42, 166, 1170, 12);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Machine Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(50, 210, 110, 15);

        table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Machine model ID", "Machine Name", "Manu. Year", "Number avail.", "Selling Price", "Supplier Name", "Supp. Cont", "Remark"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 250, 1136, 221);

        jButton1.setText("ADD ITEM");
        jButton1.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(40, 580, 100, 30);

        jButton2.setText("DELETE ITEM");
        jButton2.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton2.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(170, 580, 110, 30);

        jButton4.setText("CANCEL");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(970, 580, 90, 30);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 10, 1180, 150);
        getContentPane().add(jTextField2);
        jTextField2.setBounds(40, 490, 150, 40);

        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField3KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField3);
        jTextField3.setBounds(200, 490, 120, 40);

        jTextField4.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField4FocusLost(evt);
            }
        });
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField4KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField4);
        jTextField4.setBounds(330, 490, 140, 40);

        jTextField5.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField5FocusLost(evt);
            }
        });
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField5KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField5);
        jTextField5.setBounds(480, 490, 140, 40);

        jButton6.setText("UPDATE ITEM");
        jButton6.setMaximumSize(new java.awt.Dimension(80, 30));
        jButton6.setMinimumSize(new java.awt.Dimension(80, 30));
        jButton6.setPreferredSize(new java.awt.Dimension(80, 30));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(310, 580, 130, 30);

        jTextField6.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField6FocusLost(evt);
            }
        });
        jTextField6.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField6KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField6);
        jTextField6.setBounds(630, 490, 130, 40);

        jTextField8.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField8FocusLost(evt);
            }
        });
        jTextField8.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField8KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField8);
        jTextField8.setBounds(900, 490, 140, 40);

        jTextField9.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField9FocusLost(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField9KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField9);
        jTextField9.setBounds(1050, 490, 130, 40);

        machineNameComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        machineNameComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                machineNameComboBoxItemStateChanged(evt);
            }
        });
        machineNameComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                machineNameComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(machineNameComboBox);
        machineNameComboBox.setBounds(160, 200, 220, 30);

        jButton8.setText("CLEAR");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8);
        jButton8.setBounds(470, 580, 80, 30);

        printButton.setText("PRINT");
        printButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printButtonActionPerformed(evt);
            }
        });
        getContentPane().add(printButton);
        printButton.setBounds(1090, 580, 80, 30);

        jTextField7.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField7FocusLost(evt);
            }
        });
        jTextField7.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField7KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField7);
        jTextField7.setBounds(770, 490, 120, 40);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel5);
        jLabel5.setBounds(0, 0, 1320, 740);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("VIEW ITEM");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(64, 184, 99, 39);

        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(550, 200, 110, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // GO to ADD ITEM form..!!!
        AddItem add = new AddItem();
        add.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (table.getSelectedRow() == -1) {
            JOptionPane.showMessageDialog(this, "Please select an Item");
        } else {
            if (JOptionPane.showConfirmDialog(this, "Are you sure ?", "Delete Item", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                try {
                    if (ItemController.deleteItem(table.getValueAt(table.getSelectedRow(), 0).toString()) == 1) {
                        JOptionPane.showMessageDialog(this, "Deleted successfully");
                        DefaultTableModel defaultTableableModel = (DefaultTableModel) table.getModel();
                        int row = table.getSelectedRow();
                        defaultTableableModel.removeRow(row);
                        jTextField2.setText(null);
                        jTextField3.setText(null);
                        jTextField4.setText(null);
                        jTextField5.setText(null);
                        jTextField6.setText(null);
                        jTextField7.setText(null);
                        jTextField8.setText(null);
                        jTextField9.setText(null);
                        viewItems();
                    }
                } catch (ClassNotFoundException  ex) {
                    Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                } catch (SQLException ex) {
                    
                    System.out.println(ex);
                }
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //  this form....!!!
        dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
    }//GEN-LAST:event_formWindowOpened

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Update button..!!!
        Boolean valid = false;
        if (jTextField2.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Model ID is Empty,Please Enter the model ID ");
        } else if (jTextField3.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Machine name is Empty,Please Enter the machine name ");
        } else if (jTextField4.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Manufacture year is Empty,Please Enter the Manufacture year ");
        } else if (jTextField5.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Number available is Empty,Please Enter the Number Available ");
        } else if (jTextField6.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Selling Price is Empty,Please Enter the Selling Price ");
        } else if (jTextField7.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Supplier Name is Empty,Please Enter the Supplier Name ");
        } else if (jTextField8.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Supplier Contact Number is Empty,Please Enter the Supplier Contact Number ");
        } else if (jTextField9.getText().isEmpty()) {
            valid = false;
            JOptionPane.showMessageDialog(this, "Remark is Empty,Please Enter the Remark ");
        } else {
            valid = true;
        }
        if (valid) {
            if (JOptionPane.showConfirmDialog(this, "Are you sure ?", "Update Item", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
                if (ItemController.UpdateItem(new Item(jTextField2.getText(), jTextField3.getText(), Integer.parseInt(jTextField4.getText()), Integer.parseInt(jTextField5.getText()), Double.parseDouble(jTextField6.getText()), jTextField7.getText(), jTextField8.getText(), jTextField9.getText())) == 1) {
                    JOptionPane.showMessageDialog(this, "Item Updated succesfully..!!");
                    jTextField2.setText(null);
                    jTextField3.setText(null);
                    jTextField4.setText(null);
                    jTextField5.setText(null);
                    jTextField6.setText(null);
                    jTextField7.setText(null);
                    jTextField8.setText(null);
                    jTextField9.setText(null);
                    viewItems();
                } else {
                    JOptionPane.showMessageDialog(this, "Update is NOT succesfull..!!");
                }
            }
        }
        //end of update button..!!
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jTextField1.setText(null);
        jTextField2.setText(null);
        jTextField3.setText(null);
        jTextField4.setText(null);
        jTextField5.setText(null);
        jTextField6.setText(null);
        jTextField7.setText(null);
        jTextField8.setText(null);
        jTextField9.setText(null);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void machineNameComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_machineNameComboBoxItemStateChanged

        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (machineNameComboBox.getSelectedIndex() == -1) {
                viewItems();
            } else {
                DefaultTableModel defaultTableableModel = (DefaultTableModel) table.getModel();
                defaultTableableModel.setNumRows(0);
                String machinaryName = (String) machineNameComboBox.getSelectedItem();
                viewItemsForChange(machinaryName);
            }
        }
    }//GEN-LAST:event_machineNameComboBoxItemStateChanged

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        jTextField2.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        jTextField3.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        jTextField4.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        jTextField5.setText(table.getValueAt(table.getSelectedRow(), 3).toString());
        jTextField6.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
        jTextField7.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
        jTextField8.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
        jTextField9.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
    }//GEN-LAST:event_tableMouseClicked

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField1FocusLost
    }//GEN-LAST:event_jTextField1FocusLost

    private void printButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printButtonActionPerformed
        try {
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            JRTableModelDataSource dataSource = new JRTableModelDataSource(model);
            Map parameters = new HashMap();
            parameters.put("grandTotal", "Rs ");
            InvoiceDocumentPrinter.printInvoice(dataSource, parameters);
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (JRException ex) {
            System.out.println(ex+"-------------------cannot load the report");
        } catch (PrinterAbortException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_printButtonActionPerformed

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField3FocusLost
        if (!jTextField3.getText().isEmpty() && !Validation.validateStringTestResults(jTextField3.getText())) {
            jTextField3.requestFocus();
        }
    }//GEN-LAST:event_jTextField3FocusLost

    private void jTextField3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_DOWN:
                if (Validation.validateStringTestResults(jTextField3.getText()) || jTextField3.getText().isEmpty()) {
                    jTextField3.requestFocus();
                }
                break;
            default:
                if (Validation.validateStringTestResults(jTextField3.getText())) {
                    jTextField3.setForeground(Color.BLACK);
                } else {
                    jTextField3.setForeground(Color.RED);
                }
                break;
        }
    }//GEN-LAST:event_jTextField3KeyReleased

    private void jTextField4FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField4FocusLost
        if (!jTextField4.getText().isEmpty() && !Validation.validateYear(jTextField4.getText())) {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField4FocusLost

    private void jTextField4KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_DOWN:
                if (Validation.validateYear(jTextField4.getText()) || jTextField4.getText().isEmpty()) {
                    jTextField4.requestFocus();
                }
                break;
            default:
                if (Validation.validateYear(jTextField4.getText())) {
                    jTextField4.setForeground(Color.BLACK);
                } else {
                    jTextField4.setForeground(Color.RED);
                }
                break;
        }
    }//GEN-LAST:event_jTextField4KeyReleased

    private void jTextField5FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField5FocusLost
        if (!jTextField4.getText().isEmpty() && !Validation.validateIntegerUpdate(jTextField4.getText())) {
            jTextField4.requestFocus();
        }
    }//GEN-LAST:event_jTextField5FocusLost

    private void jTextField5KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_DOWN:
                if (Validation.validateIntegerUpdate(jTextField5.getText()) || jTextField5.getText().isEmpty()) {
                    jTextField5.requestFocus();
                }
                break;
            default:
                if (Validation.validateIntegerUpdate(jTextField5.getText())) {
                    jTextField5.setForeground(Color.BLACK);
                } else {
                    jTextField5.setForeground(Color.RED);
                }
                break;
        }
    }//GEN-LAST:event_jTextField5KeyReleased

    private void jTextField6FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField6FocusLost
        if (!jTextField6.getText().isEmpty() && !Validation.validatePrice(jTextField6.getText())) {
            jTextField6.requestFocus();
        }
    }//GEN-LAST:event_jTextField6FocusLost

    private void jTextField6KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField6KeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_DOWN:
                if (Validation.validatePrice(jTextField6.getText()) || jTextField6.getText().isEmpty()) {
                    jTextField6.requestFocus();
                }
                break;
            default:
                if (Validation.validatePrice(jTextField6.getText())) {
                    jTextField6.setForeground(Color.BLACK);
                } else {
                    jTextField6.setForeground(Color.RED);
                }
                break;
        }

    }//GEN-LAST:event_jTextField6KeyReleased

    private void jTextField7FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField7FocusLost
        if (!jTextField7.getText().isEmpty() && !Validation.validateStringTestResults(jTextField7.getText())) {
            jTextField7.requestFocus();
        }
    }//GEN-LAST:event_jTextField7FocusLost

    private void jTextField7KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField7KeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_DOWN:
                if (Validation.validateStringTestResults(jTextField7.getText()) || jTextField7.getText().isEmpty()) {
                    jTextField7.requestFocus();
                }
                break;
            default:
                if (Validation.validateStringTestResults(jTextField7.getText())) {
                    jTextField7.setForeground(Color.BLACK);
                } else {
                    jTextField7.setForeground(Color.RED);
                }
                break;
        }
    }//GEN-LAST:event_jTextField7KeyReleased

    private void jTextField8FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField8FocusLost
        if (!jTextField8.getText().isEmpty() && !Validation.validateTelephoneNumber(jTextField8.getText())) {
            jTextField8.requestFocus();
        }
    }//GEN-LAST:event_jTextField8FocusLost

    private void jTextField8KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField8KeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_DOWN:
                if (Validation.validateTelephoneNumber(jTextField8.getText()) || jTextField8.getText().isEmpty()) {
                    jTextField8.requestFocus();
                }
                break;
            default:
                if (Validation.validateTelephoneNumber(jTextField8.getText())) {
                    jTextField8.setForeground(Color.BLACK);
                } else {
                    jTextField8.setForeground(Color.RED);
                }
                break;
        }

    }//GEN-LAST:event_jTextField8KeyReleased

    private void jTextField9FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField9FocusLost
        if (!jTextField9.getText().isEmpty() && !Validation.validateStringTestResultsWithDot(jTextField9.getText())) {
            jTextField9.requestFocus();
        }
    }//GEN-LAST:event_jTextField9FocusLost

    private void jTextField9KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyReleased
        switch (evt.getKeyCode()) {
            case KeyEvent.VK_ENTER:
            case KeyEvent.VK_DOWN:
                if (Validation.validateStringTestResultsWithDot(jTextField9.getText()) || jTextField9.getText().isEmpty()) {
                    jTextField9.requestFocus();
                }
                break;
            default:
                if (Validation.validateStringTestResultsWithDot(jTextField9.getText())) {
                    jTextField9.setForeground(Color.BLACK);
                } else {
                    jTextField9.setForeground(Color.RED);
                }
                break;
        }
    }//GEN-LAST:event_jTextField9KeyReleased

    private void machineNameComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_machineNameComboBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_machineNameComboBoxActionPerformed

    public void close(){  
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;


                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField7;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JComboBox machineNameComboBox;
    private javax.swing.JButton printButton;
    private javax.swing.JTable table;
    // End of variables declaration//GEN-END:variables
 
    private void getMachinaryName() {
      
        try {
            ArrayList itemList = ItemController.getMachinaryName();
            machineNameComboBox.addItem("All");
            for (Object itemCategory : itemList) {
                machineNameComboBox.addItem(itemCategory);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
 

    public void viewItems() {
        // System.out.println("kkkhk");
        Item it = new Item();
        ResultSet rst = it.viewItems();
        DefaultTableModel dtm = (DefaultTableModel) table.getModel();
        int row = dtm.getRowCount();
        for (int i = 0; i < row; i++) {
            dtm.removeRow(0);
        }
        try {
            while (rst.next()) {
                Object ob[] = {rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8)};
                dtm.addRow(ob);
            }
        } catch (SQLException ex) {
            System.out.println(ex + "------------Failure of retriving data");
        }
    }

    private void viewItemsForChange(String machinaryName) {
        ResultSet rst = new Item().viewItemsChange(machinaryName);
        ((DefaultTableModel) table.getModel()).setRowCount(0);
        try {
            while (rst.next()) {
                Object ob[] = {rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8)};
                ((DefaultTableModel) table.getModel()).addRow(ob);
            }
        } catch (SQLException ex) {
            System.out.println(ex + "------------Failure of retriving data");
        }
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Data.ShippingDetails;
import Data.SuppliedOrder;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Senali
 */
public class DamagedProducts extends javax.swing.JFrame {
    
    int orderID;

    /**
     * Creates new form DamagedProducts
     */
    public DamagedProducts() {
        initComponents();
        
        fillComboBox();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Damaged = new javax.swing.JTable();
        jTextField_SearchDOrderID = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jTextField_DSupPhone = new javax.swing.JTextField();
        jTextField_DSupName = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jButton_SearchDmgd = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel18 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jTextField_DQuantity = new javax.swing.JTextField();
        jLabel26 = new javax.swing.JLabel();
        jComboBox_DStatus = new javax.swing.JComboBox();
        jTextField_DLossAmt = new javax.swing.JTextField();
        jLabel27 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jComboBox_DOrderID = new javax.swing.JComboBox();
        jButton_AddOS = new javax.swing.JButton();
        jButton_UpdateOS = new javax.swing.JButton();
        jButton_RemoveOS = new javax.swing.JButton();
        jButton_ClearOS = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(1300, 700));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 0, 1280, 150);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1300, 160);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1130, 160, 170, 540);

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(204, 0, 0));
        jLabel9.setText("Rs.");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(660, 300, 40, 20);

        jTable_Damaged.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Model Name", "Quantity", "Loss Amount", "Status"
            }
        ));
        jScrollPane1.setViewportView(jTable_Damaged);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(100, 480, 820, 210);

        jTextField_SearchDOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_SearchDOrderIDActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_SearchDOrderID);
        jTextField_SearchDOrderID.setBounds(410, 440, 230, 30);

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel15.setText("Order Id :");
        getContentPane().add(jLabel15);
        jLabel15.setBounds(340, 450, 80, 15);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel17.setText("Phone Number : ");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(120, 350, 110, 15);

        jTextField_DSupPhone.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DSupPhoneActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_DSupPhone);
        jTextField_DSupPhone.setBounds(220, 340, 230, 30);

        jTextField_DSupName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DSupNameActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_DSupName);
        jTextField_DSupName.setBounds(220, 290, 230, 30);

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel16.setText("Supplier Name : ");
        getContentPane().add(jLabel16);
        jLabel16.setBounds(120, 300, 110, 15);

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel14.setText("Model Name : ");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(120, 400, 100, 15);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel13.setText("Order Id : ");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(120, 250, 90, 15);

        jButton_SearchDmgd.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_SearchDmgd.setText("View All");
        jButton_SearchDmgd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_SearchDmgdActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_SearchDmgd);
        jButton_SearchDmgd.setBounds(810, 440, 80, 30);
        getContentPane().add(jSeparator3);
        jSeparator3.setBounds(200, 220, 210, 10);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel18.setText("Damaged Products");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(80, 210, 250, 17);

        jLabel25.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel25.setText("Status : ");
        getContentPane().add(jLabel25);
        jLabel25.setBounds(560, 350, 100, 15);

        jTextField_DQuantity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DQuantityActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_DQuantity);
        jTextField_DQuantity.setBounds(660, 240, 230, 30);

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Quantity : ");
        getContentPane().add(jLabel26);
        jLabel26.setBounds(560, 250, 100, 15);

        jComboBox_DStatus.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "<Select>", "Re-usable", "Un-usable" }));
        jComboBox_DStatus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DStatusActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_DStatus);
        jComboBox_DStatus.setBounds(690, 340, 200, 30);

        jTextField_DLossAmt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_DLossAmtActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_DLossAmt);
        jTextField_DLossAmt.setBounds(690, 290, 200, 30);

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Loss Amount : ");
        getContentPane().add(jLabel27);
        jLabel27.setBounds(560, 300, 100, 15);

        getContentPane().add(jComboBox1);
        jComboBox1.setBounds(220, 390, 230, 30);

        jComboBox_DOrderID.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DOrderIDActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_DOrderID);
        jComboBox_DOrderID.setBounds(220, 240, 230, 30);

        jButton_AddOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_AddOS.setText("Insert ");
        jButton_AddOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_AddOSActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_AddOS);
        jButton_AddOS.setBounds(970, 290, 80, 30);

        jButton_UpdateOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_UpdateOS.setText("Update");
        jButton_UpdateOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_UpdateOSActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_UpdateOS);
        jButton_UpdateOS.setBounds(970, 350, 80, 30);

        jButton_RemoveOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_RemoveOS.setText("Remove");
        jButton_RemoveOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_RemoveOSActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_RemoveOS);
        jButton_RemoveOS.setBounds(970, 410, 77, 30);

        jButton_ClearOS.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_ClearOS.setText("Clear");
        jButton_ClearOS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_ClearOSActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_ClearOS);
        jButton_ClearOS.setBounds(970, 470, 80, 30);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton2.setText("Refersh");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(970, 530, 80, 30);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_SearchDOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_SearchDOrderIDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_SearchDOrderIDActionPerformed

    private void jTextField_DSupPhoneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DSupPhoneActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DSupPhoneActionPerformed

    private void jTextField_DSupNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DSupNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DSupNameActionPerformed

    private void jButton_SearchDmgdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_SearchDmgdActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton_SearchDmgdActionPerformed

    private void jTextField_DQuantityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DQuantityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DQuantityActionPerformed

    private void jComboBox_DStatusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DStatusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_DStatusActionPerformed

    private void jTextField_DLossAmtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_DLossAmtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_DLossAmtActionPerformed

    private void jButton_AddOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_AddOSActionPerformed
        // TODO add your handling code here:
//        if (supplier) {
//            if (jTextField_SupName.getText().isEmpty() || jTextField_SupPhone.getText().isEmpty() || jTextField_SupEmail.getText().isEmpty()
//                || jTextField_SupAddress.getText().isEmpty() || jTextField_SupCompany.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please fill the neccessary fields!");
//            } else {
//                supName = jTextField_SupName.getText();
//                supCompany = jTextField_SupCompany.getText();
//                supPhone = Integer.parseInt(jTextField_SupPhone.getText());
//                supAddress = jTextField_SupAddress.getText();
//                supEmail = jTextField_SupEmail.getText();
//
//                Supplier sup = new Supplier(supName, supCompany, supPhone, supAddress, supEmail);
//                result = sup.addSuppliers();
//
//                if (result) {
//                    JOptionPane.showMessageDialog(this, "Insertion is Successful!");
//                } else {
//                    JOptionPane.showMessageDialog(this, "Insertion is not Successful!");
//                }
//
//                ResultSet rst = sup.SearchSuppliers(supName);
//                showTable(rst, true);
//            }
//
//        } else if (!supplier) {
//
//            if (jTextField_OPrice.getText().isEmpty() || jTextField_OSName.getText().isEmpty() || jTextField_OSPhone.getText().isEmpty()
//                || jTextField_SOdrDate.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please fill the neccessary fields!");
//            } else {
//
//                orderdDate = jTextField_SOdrDate.getText();
//                supName = jTextField_OSName.getText();
//                supPhone = Integer.parseInt(jTextField_OSPhone.getText());
//                orderPrice = Double.parseDouble(jTextField_OPrice.getText());
//
//                SuppliedOrder so = new SuppliedOrder(orderdDate, supName, supPhone, orderPrice);
//                result = so.addSupplliedOrders();
//
//                if (result) {
//                    JOptionPane.showMessageDialog(this, "Insertion is Successful!");
//                } else {
//                    JOptionPane.showMessageDialog(this, "Insertion is not Successful!");
//                }
//
//                orderID = so.getOrderID(orderdDate, supName);
//                ResultSet rst = so.SearchOrders(orderID);
//                showTable(rst, false);
//
//            }
//
//        }
    }//GEN-LAST:event_jButton_AddOSActionPerformed

    private void jButton_UpdateOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_UpdateOSActionPerformed
        // TODO add your handling code here:
//
//        ResultSet rst;
//
//        if (supplier) {
//
//            if (jTextField_SupName.getText().isEmpty() || jTextField_SupPhone.getText().isEmpty() || jTextField_SupEmail.getText().isEmpty()
//                || jTextField_SupAddress.getText().isEmpty() || jTextField_SupCompany.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please fill the neccessary fields!");
//            } else {
//                supName = jTextField_SupName.getText();
//                supCompany = jTextField_SupCompany.getText();
//                supPhone = Integer.parseInt(jTextField_SupPhone.getText());
//                supAddress = jTextField_SupAddress.getText();
//                supEmail = jTextField_SupEmail.getText();
//
//                Supplier sup = new Supplier(supName, supCompany, supPhone, supAddress, supEmail);
//                result = sup.updateSuppliers();
//
//                if (result) {
//                    JOptionPane.showMessageDialog(this, "Updating is Successful!");
//                } else {
//                    JOptionPane.showMessageDialog(this, "Updating is not Successful!");
//                }
//
//                rst = sup.SearchSuppliers(supName);
//                showTable(rst, true);
//
//                jTextField_SupName.setEnabled(true);
//                jTextField_SupPhone.setEnabled(true);
//            }
//        } else if (!supplier) {
//
//            if (jTextField_OPrice.getText().isEmpty() || jTextField_OSName.getText().isEmpty() || jTextField_OSPhone.getText().isEmpty()
//                || jTextField_SOdrDate.getText().isEmpty()) {
//                JOptionPane.showMessageDialog(this, "Please fill the neccessary fields!");
//            } else {
//                int row = jTable_SupOrder.getSelectedRow();
//
//                if (jTable_Supplier.getRowSelectionAllowed()) {
//                    orderID = Integer.parseInt(jTable_SupOrder.getValueAt(row, 0).toString());
//                }
//
//                orderdDate = jTextField_SOdrDate.getText();
//                orderPrice = Double.parseDouble(jTextField_OPrice.getText());
//                supName = jTextField_OSName.getText();
//                supPhone = Integer.parseInt(jTextField_OSPhone.getText());
//
//                SuppliedOrder so = new SuppliedOrder(orderdDate, supName, supPhone, orderPrice);
//                result = so.updateOrder(orderID);
//
//                if (result) {
//                    JOptionPane.showMessageDialog(this, "Updating is Successful!");
//                } else {
//                    JOptionPane.showMessageDialog(this, "Updating is not Successful!");
//                }
//
//                rst = so.SearchOrders(orderID);
//                showTable(rst, false);
//            }
//        }
//
    }//GEN-LAST:event_jButton_UpdateOSActionPerformed

    private void jButton_RemoveOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_RemoveOSActionPerformed
        // TODO add your handling code here:
//        if (supplier) {
//            supName = jTable_Supplier.getValueAt(0, 0).toString();
//            Supplier sp = new Supplier();
//            result = sp.removeSupplier(supName);
//
//            if (result) {
//                JOptionPane.showMessageDialog(this, "Successfully Deleted!");
//            } else {
//                JOptionPane.showMessageDialog(this, "Deleting is not Successful!");
//            }
//
//            ResultSet rst = sp.getSupplierDetails();
//            showTable(rst, true);
//        } else if (!supplier) {
//
//            orderID = Integer.parseInt(jTextField_SearchOID.getText());
//            SuppliedOrder so = new SuppliedOrder();
//            result = so.removeOrder(orderID);
//
//            if (result) {
//                JOptionPane.showMessageDialog(this, "Successfully Deleted!");
//            } else {
//                JOptionPane.showMessageDialog(this, "Deleting is not Successful!");
//            }
//
//            ResultSet rst = so.getOrders();
//            showTable(rst, false);
//        }
    }//GEN-LAST:event_jButton_RemoveOSActionPerformed

    private void jButton_ClearOSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_ClearOSActionPerformed
        // TODO add your handling code here:

//        setClear();
    }//GEN-LAST:event_jButton_ClearOSActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:

//        setClear();
//        DefaultTableModel dtm = (DefaultTableModel) jTable_Supplier.getModel();
//        int row = dtm.getRowCount();
//
//        for (int i = 0; i < row; i++) {
//
//            dtm.removeRow(0);
//        }
//
//        dtm = (DefaultTableModel) jTable_SupOrder.getModel();
//        row = dtm.getRowCount();
//
//        for (int i = 0; i < row; i++) {
//
//            dtm.removeRow(0);
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jComboBox_DOrderIDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DOrderIDActionPerformed
        // TODO add your handling code here:
        
        orderID = Integer.parseInt(jComboBox_DOrderID.getSelectedItem().toString());
        
        SuppliedOrder so = new SuppliedOrder();
        ArrayList supplier = so.getSupplier(orderID);
    }//GEN-LAST:event_jComboBox_DOrderIDActionPerformed

    
    private void fillComboBox() {
         
         ShippingDetails sd = new ShippingDetails();
         ArrayList orderIDs = sd.getShippedOrderIds();
        
         Iterator i = orderIDs.iterator();
        
         while(i.hasNext()) {
            
            jComboBox_DOrderID  .addItem(i.next());
         }
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
            java.util.logging.Logger.getLogger(DamagedProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DamagedProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DamagedProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DamagedProducts.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DamagedProducts().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton_AddOS;
    private javax.swing.JButton jButton_ClearOS;
    private javax.swing.JButton jButton_RemoveOS;
    private javax.swing.JButton jButton_SearchDmgd;
    private javax.swing.JButton jButton_UpdateOS;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JComboBox jComboBox_DOrderID;
    private javax.swing.JComboBox jComboBox_DStatus;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTable jTable_Damaged;
    private javax.swing.JTextField jTextField_DLossAmt;
    private javax.swing.JTextField jTextField_DQuantity;
    private javax.swing.JTextField jTextField_DSupName;
    private javax.swing.JTextField jTextField_DSupPhone;
    private javax.swing.JTextField jTextField_SearchDOrderID;
    // End of variables declaration//GEN-END:variables
}

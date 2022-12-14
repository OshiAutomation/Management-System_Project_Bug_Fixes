/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.EmpMng;

import Data.DB_Access;
import data.SalaryInfoData;
import Data.Validator;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gallelaptop.lk
 */
public class SalaryInfo extends javax.swing.JFrame {

    /**
     * Creates new form SalaryInfo
     */
    //DBConnManager conn = null;
    DB_Access dba = null;
    Validator valid = null;
    int index = 0;
    
    public SalaryInfo() {
        initComponents();
        
        //conn = new DBConnManager();
        dba = new DB_Access();
        valid = new Validator();
        
        readtable();
        fillDesignation();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")        
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_home = new javax.swing.JButton();
        jButton_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField_OTr = new javax.swing.JTextField();
        jTextField_bSal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_sInfo = new javax.swing.JTable();
        jButton_refresh = new javax.swing.JButton();
        jButton_add = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jTextField_desig = new javax.swing.JTextField();
        jComboBox_Desig = new javax.swing.JComboBox();
        jButton_demo = new javax.swing.JButton();
        jButton1_demoUp = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1260, 724));
        setPreferredSize(new java.awt.Dimension(1260, 724));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_home.setBackground(new java.awt.Color(0, 153, 204));
        jButton_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home1.png"))); // NOI18N
        jButton_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_homeActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_home, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 630, 40, 40));

        jButton_back.setBackground(new java.awt.Color(0, 153, 204));
        jButton_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        jButton_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 630, 40, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 920, 140));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 170));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Salary Information");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1044, 154, 220, 570));

        jLabel5.setText("Designation");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, -1, -1));

        jLabel6.setText("O/T Rate");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 290, -1, -1));

        jLabel7.setText("Basic Salary");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 330, -1, -1));
        getContentPane().add(jTextField_OTr, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 290, 140, -1));

        jTextField_bSal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_bSalActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField_bSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 330, 140, -1));

        jTable_sInfo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Designation", "O/T Rate", "Basic Salary"
            }
        ));
        jTable_sInfo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_sInfoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable_sInfoMouseEntered(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_sInfo);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 470, -1, 190));

        jButton_refresh.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_refresh.setText("Refresh");
        jButton_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_refreshActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 390, 110, 40));

        jButton_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_add.setLabel("Insert");
        jButton_add.setPreferredSize(new java.awt.Dimension(77, 23));
        jButton_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_addActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 240, 110, 40));

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 290, 110, 40));

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 340, 110, 40));
        getContentPane().add(jTextField_desig, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 140, -1));

        jComboBox_Desig.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_DesigMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox_DesigMouseEntered(evt);
            }
        });
        jComboBox_Desig.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_DesigActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_Desig, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 170, 30));

        jButton_demo.setText("Demo");
        jButton_demo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_demoActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_demo, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 610, 80, 20));

        jButton1_demoUp.setText("Demo u");
        jButton1_demoUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1_demoUpActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1_demoUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 640, 80, 20));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel8.setText("Search");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, -1, -1));

        jLabel9.setText("Designation");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 490, -1, 20));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_bSalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_bSalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_bSalActionPerformed

    private void jButton_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_refreshActionPerformed
        //clearing the text fields
        jButton_add.setEnabled(true);
        jButton_update.setEnabled(true);
        jButton_delete.setEnabled(true);
        jTextField_desig.setEnabled(true);
        jTextField_desig.setText("");
        jTextField_bSal.setText("");
        jTextField_OTr.setText("");
        index = 0;
        cleartable();
        readtable();
    }//GEN-LAST:event_jButton_refreshActionPerformed

    private void jButton_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_addActionPerformed
        
        String desig = jTextField_desig.getText();
        String ot = jTextField_OTr.getText();
        String bsic = jTextField_bSal.getText();

        if(!empty(desig, ot, bsic)) {
            if(valid.isNumber(ot)&&valid.isNumber(bsic)) {
        try {
            //adding new record
            
            double otRate = Double.parseDouble(ot);
            double basic = Double.parseDouble(bsic);
            
            String sql = "insert into riyoma.salary_info values('"+desig+"',"+otRate+","+basic+")";
            //JOptionPane.showMessageDialog(null,sql);
            
            dba.setData(sql);
            
            //refreshing the table
            cleartable();
            readtable();
            fillDesignation();
        } catch (SQLException ex) {
            Logger.getLogger(SalaryInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Insertion failed");
        }
        
        JOptionPane.showMessageDialog(null, "Record added successfully");
        
        jTextField_desig.setText("");
        jTextField_bSal.setText("");
        jTextField_OTr.setText("");
            }
            else {
                JOptionPane.showMessageDialog(null, "Numeric value should be entered to O/T Rate and Basic Salary");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please fill all the fields");
        }
    }//GEN-LAST:event_jButton_addActionPerformed

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
        
        String desig = jTextField_desig.getText();
        String ot = jTextField_OTr.getText();
        String bsic = jTextField_bSal.getText();
        
        if(!empty(desig, ot, bsic)) {
            if(valid.isNumber(ot)&&valid.isNumber(bsic)) {
        try {
            // TODO add your handling code here:
            
            double otRate = Double.parseDouble(ot);
            double basic = Double.parseDouble(bsic);
            
            String sql = "update riyoma.salary_info set otRate="+otRate+",basicSalary="+basic+" where designation='"+desig+"'";
            //JOptionPane.showMessageDialog(null,sql);
            
            dba.setData(sql);
            
            //refreshing the table
            cleartable();
            readtable();
            fillDesignation();
        } catch (SQLException ex) {
            Logger.getLogger(SalaryInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Cannot update a non existing record");
        }
        JOptionPane.showMessageDialog(null, "Record updated successfully");
        jTextField_desig.setEditable(true);
        jTextField_desig.setText("");
        jTextField_bSal.setText("0");
        jTextField_OTr.setText("0");
            }
            else {
                JOptionPane.showMessageDialog(null, "Numeric value should be entered to O/T Rate and Basic Salary");
            }
        }
        else {
            JOptionPane.showMessageDialog(null, "Please search designation and click on the record in table to update");
        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        
        String desig = jTextField_desig.getText();
        
        if(!desig.isEmpty()) {                   
        try {
            // TODO add your handling code here:
   
            String sql = "delete from riyoma.salary_info where designation='"+desig+"'";
            
            dba.setData(sql);
        } catch (SQLException ex) {
            Logger.getLogger(SalaryInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"delete query failed");
        }
        
        jTextField_desig.setText("");
        jTextField_bSal.setText("");
        jTextField_OTr.setText("");
        jTextField_desig.setEditable(true);
        
        cleartable();
        readtable();
        fillDesignation();
        JOptionPane.showMessageDialog(null,"Successful deletion");
        }
        else {
            JOptionPane.showMessageDialog(null, "Please search designation and click the on record in table to delete");
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jTable_sInfoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_sInfoMouseClicked
        // TODO add your handling code here:
        jTextField_desig.setEnabled(false);
        jButton_add.setEnabled(false);
        jButton_delete.setEnabled(true);
        jButton_update.setEnabled(true);
        
        int row = jTable_sInfo.getSelectedRow();
        jTextField_desig.setText(jTable_sInfo.getModel().getValueAt(row,0).toString());
        jTextField_OTr.setText(jTable_sInfo.getModel().getValueAt(row,1).toString());
        jTextField_bSal.setText(jTable_sInfo.getModel().getValueAt(row,2).toString());
    }//GEN-LAST:event_jTable_sInfoMouseClicked

    private void jButton_demoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_demoActionPerformed
        // TODO add your handling code here:
        jTextField_desig.setText("Front Office Manager");
        jTextField_bSal.setText("75000");
        jTextField_OTr.setText("800");
    }//GEN-LAST:event_jButton_demoActionPerformed

    private void jButton1_demoUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1_demoUpActionPerformed
        // TODO add your handling code here:
        jTextField_bSal.setText("65000");
        jTextField_OTr.setText("900");
    }//GEN-LAST:event_jButton1_demoUpActionPerformed

    private void jTable_sInfoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_sInfoMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable_sInfoMouseEntered

    private void jComboBox_DesigActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_DesigActionPerformed
        if(index == 1) {
            jButton_update.setEnabled(false);
            jButton_delete.setEnabled(false);
            String desig = jComboBox_Desig.getSelectedItem().toString();
            readSpeRecord(desig);
            index = 0;
        }
    }//GEN-LAST:event_jComboBox_DesigActionPerformed

    private void jComboBox_DesigMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_DesigMouseClicked
         index = 1;
    }//GEN-LAST:event_jComboBox_DesigMouseClicked

    private void jComboBox_DesigMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_DesigMouseEntered

    }//GEN-LAST:event_jComboBox_DesigMouseEntered

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        close();
        new Employee().setVisible(true);
    }//GEN-LAST:event_jButton_backActionPerformed

    private void jButton_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_homeActionPerformed
        close();
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton_homeActionPerformed

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
            java.util.logging.Logger.getLogger(SalaryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SalaryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SalaryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SalaryInfo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SalaryInfo().setVisible(true);
            }
        });
    }
    
    private void readtable(){
        try {
            DefaultTableModel model = (DefaultTableModel) jTable_sInfo.getModel();
            
            String query = "select * from riyoma.salary_info";
            
            ResultSet rs = dba.getData(query);
            while(rs.next())
            {
                String d1 = rs.getString("designation");
                String d2 = rs.getString("otRate");
                String d3 = rs.getString("basicSalary");
              
                model.addRow(new Object[]{d1,d2,d3});             
            }
        } catch (SQLException ex) {
           System.out.println(ex + "-----------Select query failed");
        } 
    }
    
    private void readSpeRecord(String desig) {
        try {
            cleartable();
            DefaultTableModel dm = (DefaultTableModel) jTable_sInfo.getModel();
            
            String sql = "select * from riyoma.salary_info where designation='"+desig+"'";
            ResultSet rs = dba.getData(sql);
            
            while(rs.next()) {
                String d1 = rs.getString("designation");
                String d2 = rs.getString("otRate");
                String d3 = rs.getString("basicSalary");
              
                dm.addRow(new Object[]{d1,d2,d3});
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalaryInfo.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null,"Select query failed");
        }
    }
    
    private void cleartable(){
        DefaultTableModel dm = (DefaultTableModel)jTable_sInfo.getModel();
        for(int i=0;i<dm.getRowCount();i++) {
            for(int j=0;j<dm.getColumnCount();j++) {
                dm.setValueAt("", i, j);
            }
        }     
        dm.setColumnCount(3);
        dm.setRowCount(0);
    }
    
    private void fillDesignation() {
        jComboBox_Desig.removeAllItems();
   
        SalaryInfoData sid = new SalaryInfoData();
        ArrayList desig = sid.getDesignation();
        
        Iterator i = desig.iterator();
        
        while(i.hasNext()) {
            jComboBox_Desig.addItem(i.next());
        }
    }
    
    private boolean empty(String a, String b,String c) {
        boolean result = true;
        if(a.isEmpty()||b.isEmpty()||c.isEmpty()) {
            return result;
        }
        else
            return result = false;
    }
    
    public void close(){  
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);  
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1_demoUp;
    private javax.swing.JButton jButton_add;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_demo;
    private javax.swing.JButton jButton_home;
    private javax.swing.JButton jButton_refresh;
    private javax.swing.JButton jButton_update;
    private javax.swing.JComboBox jComboBox_Desig;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable_sInfo;
    private javax.swing.JTextField jTextField_OTr;
    private javax.swing.JTextField jTextField_bSal;
    private javax.swing.JTextField jTextField_desig;
    // End of variables declaration//GEN-END:variables
}

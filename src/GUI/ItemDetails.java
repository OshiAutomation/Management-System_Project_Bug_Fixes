/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import Data.DB_Access;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author kushi
 */
public class ItemDetails extends javax.swing.JFrame {
    
//create array lists fro get item details
    ArrayList machineName = new ArrayList();
    ArrayList unitPrice = new ArrayList();
    ArrayList noAvailable = new ArrayList();
    int count;
    
    DB_Access dba =new DB_Access();
    
     
    /**1119630
     * Creates new form ItemDetails
     */
    public ItemDetails() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_back = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(960, 510));
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(null);

        btn_back.setText("Back");
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        getContentPane().add(btn_back);
        btn_back.setBounds(750, 354, 80, 40);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Model ID", "Machine Name", "Unit Price", "Availability"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(141, 144, 582, 153);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Stock Items");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(286, 51, 281, 38);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(0, 0, 960, 510);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
      getModels();
      //Order_Process ord=new Order_Process();
      
      details.setModelDetails(machineName, unitPrice, count);
    //  ord.setVisible(true);
  //    this.dispose();
      this.setVisible(false);
        
      
        
    }//GEN-LAST:event_btn_backActionPerformed

    public Order_Process details;
    
    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        // TODO add your handling code here:
        //selectRow();
    }//GEN-LAST:event_formMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        
        try {
            ResultSet rst = dba.getData("select modelID, MachineName, sellingPrice,noAvailable from stock");
            
            DefaultTableModel dtm= (DefaultTableModel) jTable2.getModel();
            int row=dtm.getRowCount();
            
            for(int i=0; i<row; i++) {
                
                dtm.removeRow(0);    
            }

                while(rst.next()) {
                    
                Object ob[]={rst.getString(1), rst.getString(2), rst.getString(3),rst.getString(4)};
                dtm.addRow(ob);    
                }   
            
        } catch (SQLException ex) {
            
           System.out.println(ex);
        }
    }//GEN-LAST:event_formWindowOpened

    public void getModels() {
        
        count = jTable2.getSelectedRowCount();
        int rowNo[] = jTable2.getSelectedRows();
      
           for(int rows=0; rows<count; rows++) {
              
               machineName.add(jTable2.getValueAt(rowNo[rows], 1).toString());
               unitPrice.add((jTable2.getValueAt(rowNo[rows], 2).toString()));
               //noAvailable.add((jTable2.getValueAt(rowNo[rows], 2).toString()));
               
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
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ItemDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ItemDetails().setVisible(true);
            }
        });
    }
   
   

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    // End of variables declaration//GEN-END:variables
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.EmpMng;

import GUI.Charge;
import Gui.Order_Process;
import gui.Selling;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;

/**
 *
 * @author gallelaptop.lk
 */
public class ReceptionistHome extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public ReceptionistHome() {
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

        jLabel7 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton_logout = new javax.swing.JButton();
        jButton_orderp = new javax.swing.JButton();
        jButton_dilivery = new javax.swing.JButton();
        jButton_selling = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/order.png"))); // NOI18N
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 70, 40));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/sales.png"))); // NOI18N
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 310, 50, 50));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/dilivery.png"))); // NOI18N
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 80, 70));

        jButton_logout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/button_logout.png"))); // NOI18N
        jButton_logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_logoutActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_logout, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 630, 40, 20));

        jButton_orderp.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_orderp.setText("Order Processing");
        jButton_orderp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_orderp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_orderpActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_orderp, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 210, 280, 70));

        jButton_dilivery.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_dilivery.setText("Delivery Management");
        jButton_dilivery.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_dilivery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_diliveryActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_dilivery, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 390, 280, 70));

        jButton_selling.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton_selling.setText("Sales Management");
        jButton_selling.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jButton_selling.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_sellingActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_selling, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, 280, 70));

        jLabel3.setFont(new java.awt.Font("Space Bd BT", 0, 48)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 255, 204));
        jLabel3.setText("HOME");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(760, 590, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, 940, 170));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 690));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_orderpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_orderpActionPerformed
        // TODO add your handling code here:
        close();
        new Order_Process().setVisible(true);
    }//GEN-LAST:event_jButton_orderpActionPerformed

    private void jButton_logoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_logoutActionPerformed
        // TODO add your handling code here:
        close();
        new Login().setVisible(true);
    }//GEN-LAST:event_jButton_logoutActionPerformed

    private void jButton_sellingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_sellingActionPerformed
        // TODO add your handling code here:
        close();
        new Selling().setVisible(true);
    }//GEN-LAST:event_jButton_sellingActionPerformed

    private void jButton_diliveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_diliveryActionPerformed
        // TODO add your handling code here:
        close();
        new Charge().setVisible(true);
    }//GEN-LAST:event_jButton_diliveryActionPerformed

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
            java.util.logging.Logger.getLogger(ReceptionistHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReceptionistHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReceptionistHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReceptionistHome.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReceptionistHome().setVisible(true);
            }
        });
    }
    
    public void close(){
    
        WindowEvent winClosingEvent = new WindowEvent(this,WindowEvent.WINDOW_CLOSING);
        Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(winClosingEvent);
         
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_dilivery;
    private javax.swing.JButton jButton_logout;
    private javax.swing.JButton jButton_orderp;
    private javax.swing.JButton jButton_selling;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    // End of variables declaration//GEN-END:variables
}

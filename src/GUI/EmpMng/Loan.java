/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui.EmpMng;

import Data.DB_Access;
import Data.EmployeeInfo;
import Data.Validator;
import Data.loanInfo;
import gui.DatePicker;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author gallelaptop.lk
 */
public class Loan extends javax.swing.JFrame {

    DB_Access dba = null;
    Validator valid = null;
    private String lID = "";
    int index = 0;
    
    public Loan() {
        initComponents();
        
        dba = new DB_Access();
        valid = new Validator();
        
        readtable();
        fillEmpName();
        
        jTextField_dueDate.setEnabled(false);
        jButton_slctDate.setEnabled(false);
        jTextField_loanidR.setEnabled(false);
        
        jComboBox_retEname.setEnabled(false);
        jButton_rSubmit.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton_back = new javax.swing.JButton();
        jButton_home2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_emp = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jTextField_amount = new javax.swing.JTextField();
        jButton_slctDate = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jTextField_dueDate = new javax.swing.JTextField();
        jButton_insert = new javax.swing.JButton();
        jButton_update = new javax.swing.JButton();
        jButton_delete = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox_retEname = new javax.swing.JComboBox();
        jButton_clr = new javax.swing.JButton();
        jButton_rSubmit = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_loan = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jRadioButton_return = new javax.swing.JRadioButton();
        jComboBox_searchLoan = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jButton_demoUp = new javax.swing.JButton();
        jTextField_loanidR = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jSeparator4 = new javax.swing.JSeparator();
        jButton_report = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1260, 700));
        setPreferredSize(new java.awt.Dimension(1260, 710));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_back.setBackground(new java.awt.Color(0, 153, 204));
        jButton_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        jButton_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(1090, 630, 40, 40));

        jButton_home2.setBackground(new java.awt.Color(0, 153, 204));
        jButton_home2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home1.png"))); // NOI18N
        jButton_home2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_home2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_home2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_home2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 630, 40, 40));

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/a (2).png"))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 930, 130));

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1260, 170));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel4.setText("Loan Management");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, 200, 30));

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1044, 154, 220, 570));

        jLabel8.setText("Employee Name");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, -1, -1));

        getContentPane().add(jComboBox_emp, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 240, 140, -1));

        jLabel5.setText("Amount");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 280, -1, -1));

        jTextField_amount.setText("0");
        jTextField_amount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField_amountActionPerformed(evt);
            }
        });
        jTextField_amount.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField_amountFocusLost(evt);
            }
        });
        jTextField_amount.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField_amountKeyPressed(evt);
            }
        });
        getContentPane().add(jTextField_amount, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, 140, -1));

        jButton_slctDate.setText("Select");
        jButton_slctDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_slctDateActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_slctDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 70, -1));

        jLabel7.setText("Due Date");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 320, -1, -1));
        getContentPane().add(jTextField_dueDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 320, 140, -1));

        jButton_insert.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_insert.setText("Insert");
        jButton_insert.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_insertActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_insert, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 220, 110, 40));

        jButton_update.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_update.setText("Update");
        jButton_update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_updateActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_update, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 270, 110, 40));

        jButton_delete.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_delete.setText("Delete");
        jButton_delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_deleteActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_delete, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 320, 110, 40));

        jLabel11.setText("Employee Name");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 420, -1, -1));

        jLabel12.setText("Loan ID");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 460, -1, -1));

        jComboBox_retEname.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox_retEnameMouseEntered(evt);
            }
        });
        jComboBox_retEname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_retEnameActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_retEname, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 420, 140, -1));

        jButton_clr.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_clr.setText("Refresh");
        jButton_clr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_clrActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_clr, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 440, 110, 40));

        jButton_rSubmit.setText("Submit");
        jButton_rSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_rSubmitActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_rSubmit, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, 90, 30));

        jTable_loan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Loan ID", "Employee ID", "Loan Amount", "Date Paid", "Due Date", "Left To Play", "Returned Date", "Status"
            }
        ));
        jTable_loan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable_loanMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable_loan);
        if (jTable_loan.getColumnModel().getColumnCount() > 0) {
            jTable_loan.getColumnModel().getColumn(5).setResizable(false);
            jTable_loan.getColumnModel().getColumn(6).setResizable(false);
        }

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 540, 810, 130));

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel14.setText("Search");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 470, -1, -1));

        jLabel15.setText("Employee Name");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 490, -1, 20));

        jRadioButton_return.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jRadioButton_return.setText("Return Loan");
        jRadioButton_return.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton_returnActionPerformed(evt);
            }
        });
        getContentPane().add(jRadioButton_return, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jComboBox_searchLoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jComboBox_searchLoanMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jComboBox_searchLoanMouseEntered(evt);
            }
        });
        jComboBox_searchLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox_searchLoanActionPerformed(evt);
            }
        });
        getContentPane().add(jComboBox_searchLoan, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 490, 140, -1));

        jButton1.setText("Demo");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 550, 80, -1));

        jButton_demoUp.setText("Demo u");
        jButton_demoUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_demoUpActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_demoUp, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 580, 80, -1));
        getContentPane().add(jTextField_loanidR, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 460, 140, -1));
        getContentPane().add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 510, 460, 10));

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 10, 120));
        getContentPane().add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, 460, 10));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        getContentPane().add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 390, 10, 120));

        jButton_report.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton_report.setText("Report");
        jButton_report.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_reportActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_report, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 390, 110, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField_amountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField_amountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField_amountActionPerformed

    private void jRadioButton_returnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton_returnActionPerformed
        // TODO add your handling code here:
        if(jRadioButton_return.isSelected()) {
            jComboBox_retEname.setEnabled(true);
            jButton_rSubmit.setEnabled(true);
        }
        else {
            jComboBox_retEname.setEnabled(false);
            jButton_rSubmit.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton_returnActionPerformed

    private void jButton_clrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_clrActionPerformed
        jTextField_amount.setEnabled(true);
        jComboBox_emp.setEnabled(true);
        jTextField_amount.setText("0");
        jTextField_dueDate.setText("");
        jComboBox_searchLoan.setSelectedIndex(0);
        jTextField_amount.setEnabled(true);
        jButton_insert.setEnabled(true);
        jTextField_dueDate.setEnabled(false);
        jButton_slctDate.setEnabled(false);
        jTextField_loanidR.setText("");
        jButton_delete.setEnabled(true);
        jButton_update.setEnabled(true);
        index = 0;
        cleartable();
        readtable();
        jComboBox_emp.removeAllItems();
        jComboBox_retEname.removeAllItems();
        jComboBox_searchLoan.removeAllItems();
        fillEmpName();
    }//GEN-LAST:event_jButton_clrActionPerformed

    private void jTable_loanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable_loanMouseClicked
        // TODO add your handling code here:
        EmployeeInfo ei = new EmployeeInfo();
        int row = jTable_loan.getSelectedRow();
        lID = jTable_loan.getModel().getValueAt(row, 0).toString();
        String name = ei.getName(jTable_loan.getModel().getValueAt(row, 1).toString());
        jTextField_amount.setText(jTable_loan.getModel().getValueAt(row, 2).toString());
        jTextField_dueDate.setText(jTable_loan.getModel().getValueAt(row, 4).toString());
        jComboBox_emp.setSelectedItem(name);
        jTextField_amount.setEnabled(false);
        jButton_insert.setEnabled(false);
        jTextField_dueDate.setEnabled(true);
        jButton_slctDate.setEnabled(true);
        jButton_update.setEnabled(true);
        jButton_delete.setEnabled(true);
        jTable_loan.setEnabled(false);
        jComboBox_emp.setEnabled(false);
    }//GEN-LAST:event_jTable_loanMouseClicked

    private void jButton_updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_updateActionPerformed
       
        String amount = jTextField_amount.getText();
        String dateDue = jTextField_dueDate.getText();
        
        if(!lID.equals("")) {
            if(!empty(amount, dateDue)) {
                if(valid.isNumber(amount)) {
                    if(Double.parseDouble(amount)<500000) {
                        try {
                            double amnt = Double.parseDouble(amount);
            
                            String sql = "update riyoma.loans set loanAmount="+amnt+", dueDate='"+dateDue+"' where loanID='"+lID+"'";
            
                            dba.setData(sql);
                        } catch (SQLException ex) {
                            Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
                        }
       
                        cleartable();
                        readtable();
                        fillEmpName();
                        lID = "";
        
                        JOptionPane.showMessageDialog(null, "Successfully updated");
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Maximum loan amount is Rs. 500,000");
                        jTextField_amount.setText("0");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null,"Numeric value should be entered to amount");
                }
            }
            else {
                JOptionPane.showMessageDialog(null,"Please select a record from the table to update");
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please select loan to be updated");
        }
    }//GEN-LAST:event_jButton_updateActionPerformed

    private void jButton_insertActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_insertActionPerformed
        EmployeeInfo ei = new EmployeeInfo();
        loanInfo lf =new loanInfo();
        
        String ename = jComboBox_emp.getSelectedItem().toString();
        String empID = ei.getempID(ename);
        String amount = jTextField_amount.getText();
        String dateDue = jTextField_dueDate.getText();
                 
        SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        String datePaid = sdf.format(new Date());
        
        if(!empty(amount,dateDue)) {
            if(valid.isNumber(amount)) {
                if(!lf.checkAvailabillity(ename)) {
                    double amnt = Double.parseDouble(amount);
                    if(amnt < 500000) {
                        try {        
                            String sql = "insert into riyoma.loans(empID,loanAmount,datePaid,dueDate,leftToPay,status) values('"+empID+"',"+amnt+",'"+datePaid+"','"+dateDue+"',"+amnt+",'Paid')";
                            dba.setData(sql);
                        
                            JOptionPane.showMessageDialog(null, "Loan recorded successfully");
                        } catch (SQLException ex) {
                            System.out.println(ex);
                        }
                    } 
                    else {
                        JOptionPane.showMessageDialog(null, "Maximum loan amount is Rs. 500,000");
                    }
                }
                else {
                    JOptionPane.showMessageDialog(null, "This employee has already taken a loan");
                }
                cleartable();
                readtable();
                fillEmpName();
        
                jComboBox_emp.setSelectedIndex(0);
                jTextField_amount.setText("0");
                jTextField_dueDate.setText("");
                index  = 0;
            }
            else {
                JOptionPane.showMessageDialog(null,"Numeric value should be entered to amount");
            }
        }
        else {
            JOptionPane.showMessageDialog(null,"Please fill all the fields");
        }
    }//GEN-LAST:event_jButton_insertActionPerformed

    private void jButton_deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_deleteActionPerformed
        
        if(!lID.equals("")) {
            int res = JOptionPane.showConfirmDialog(null,"Are you sure you want to continue","Warning",0,2);
            if(res == 0) {
                try {
                    String sql = "delete from riyoma.loans where loanID='"+lID+"'";
                    dba.setData(sql);
                    
                    JOptionPane.showMessageDialog(null, "Record deleted successfully");
                } catch (SQLException ex) {
                    Logger.getLogger(Loan.class.getName()).log(Level.SEVERE, null, ex);
                }   
            }    
        cleartable();
        readtable();
        fillEmpName();
        lID = "";
        
        jTextField_amount.setText("0");
        jTextField_dueDate.setText("");
        

        }
        else {
            JOptionPane.showMessageDialog(null, "Please select a loan to be deleted");
        }
    }//GEN-LAST:event_jButton_deleteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        jComboBox_emp.setSelectedItem("Sheetal Vishwanathan");
        jTextField_amount.setText("150000");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton_demoUpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_demoUpActionPerformed
        // TODO add your handling code here:
        jTextField_dueDate.setText("2022-07-10");
    }//GEN-LAST:event_jButton_demoUpActionPerformed

    private void jButton_slctDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_slctDateActionPerformed
        // TODO add your handling code here:
        DatePicker dp = new DatePicker(this);
        jTextField_dueDate.setText(dp.setPickedDate());
    }//GEN-LAST:event_jButton_slctDateActionPerformed

    private void jTextField_amountKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField_amountKeyPressed
        // TODO add your handling code here:
        loanInfo lf = new loanInfo();
        Validator valid = new Validator();
        String date = null;
        String amount = jTextField_amount.getText();
        
        if((!amount.isEmpty())&&(valid.isNumber(amount))) {
            double amnt = Double.parseDouble(amount);
            
            date = lf.getDueDate(amnt);
        }
        jTextField_dueDate.setText(date);
    }//GEN-LAST:event_jTextField_amountKeyPressed

    private void jTextField_amountFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jTextField_amountFocusLost

    }//GEN-LAST:event_jTextField_amountFocusLost

    private void jComboBox_searchLoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_searchLoanActionPerformed
        // TODO add your handling code here:
        if(index == 1) {
            jButton_delete.setEnabled(false);
            jButton_update.setEnabled(false);
            String empName = jComboBox_searchLoan.getSelectedItem().toString();
        
            String sql = "select * from riyoma.loans l,riyoma.employee e where e.empID=l.empID and empName='"+empName+"'";
            cleartable();
            readspetable(sql);
            index = 0;
        }
    }//GEN-LAST:event_jComboBox_searchLoanActionPerformed

    private void jComboBox_searchLoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_searchLoanMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBox_searchLoanMouseEntered

    private void jComboBox_retEnameMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_retEnameMouseEntered
        // TODO add your handling code here:
        index = 2;
    }//GEN-LAST:event_jComboBox_retEnameMouseEntered

    private void jComboBox_retEnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox_retEnameActionPerformed
        // TODO add your handling code here:
        loanInfo lf = new loanInfo();
        if(index == 2) {
            String name = jComboBox_retEname.getSelectedItem().toString();
            
            int lid = lf.getLoanID(name);
            
            jTextField_loanidR.setText(String.valueOf(lid));
        }
    }//GEN-LAST:event_jComboBox_retEnameActionPerformed

    private void jButton_rSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_rSubmitActionPerformed
        // TODO add your handling code here:
        loanInfo lf = new loanInfo();
        String lnid = jTextField_loanidR.getText();
        boolean res; 
        if(!lnid.isEmpty()) {
            int lid = Integer.parseInt(lnid);
            res = lf.setRetLoan(lid);
            
            if(res) {
                JOptionPane.showMessageDialog(null,"Loan amount received");
            }
            else {
                JOptionPane.showMessageDialog(null,"Error in receiving");
            }
            cleartable();
            readtable();
        }
        else {
            JOptionPane.showMessageDialog(null,"Please select the employee name and set loan ID");
        }
        
        
    }//GEN-LAST:event_jButton_rSubmitActionPerformed

    private void jComboBox_searchLoanMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jComboBox_searchLoanMouseClicked
        // TODO add your handling code here:
        index = 1;
    }//GEN-LAST:event_jComboBox_searchLoanMouseClicked

    private void jButton_reportActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_reportActionPerformed
        loanInfo lf = new loanInfo();
        
        lf.generateReport();
    }//GEN-LAST:event_jButton_reportActionPerformed

    private void jButton_home2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_home2ActionPerformed
        close();
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton_home2ActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        close();
        new Employee().setVisible(true);
    }//GEN-LAST:event_jButton_backActionPerformed

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
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Loan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Loan().setVisible(true);
            }
        });
    }
    
    private void readtable(){
        try {
            DefaultTableModel model = (DefaultTableModel) jTable_loan.getModel();
            
            String query = "select * from riyoma.loans";
            //JOptionPane.showMessageDialog(null,query1);
            
            ResultSet rs = dba.getData(query);
            //JOptionPane.showMessageDialog(null,rs1);
            while(rs.next())
            {
                String d1 = rs.getString("loanID");
                String d2 = rs.getString("empID");
                String d3 = rs.getString("loanAmount");
                String d4 = rs.getString("datePaid");
                String d5 = rs.getString("dueDate");
                String d6 = rs.getString("leftToPay");
                String d7 = rs.getString("datePaidBack");
                String d8 = rs.getString("status");

                model.addRow(new Object[]{d1,d2,d3,d4,d5,d6,d7,d8});             
            }
        } catch (SQLException ex) {
           System.out.println(ex + "-----------Select query failed");
        } 
    }
    
    private void readspetable(String sql){
        try {
            DefaultTableModel model = (DefaultTableModel) jTable_loan.getModel();
 
            ResultSet rs = dba.getData(sql);
            //JOptionPane.showMessageDialog(null,rs1);
            while(rs.next())
            {
                String d1 = rs.getString("loanID");
                String d2 = rs.getString("empID");
                String d3 = rs.getString("loanAmount");
                String d4 = rs.getString("datePaid");
                String d5 = rs.getString("dueDate");
                String d6 = rs.getString("leftToPay");
                String d7 = rs.getString("datePaidBack");
                String d8 = rs.getString("status");

                model.addRow(new Object[]{d1,d2,d3,d4,d5,d6,d7,d8});             
            }
        } catch (SQLException ex) {
           System.out.println(ex + "-----------Select query failed");
        } 
    }
    
     private void cleartable(){
        DefaultTableModel dm = (DefaultTableModel)jTable_loan.getModel();
        for(int i=0;i<dm.getRowCount();i++) {
            for(int j=0;j<dm.getColumnCount();j++) {
                dm.setValueAt("", i, j);
            }
        }     
        dm.setColumnCount(8);
        dm.setRowCount(0);
    }
     
    private void fillEmpName() {
        jComboBox_emp.removeAllItems();
        jComboBox_retEname.removeAllItems();
        jComboBox_searchLoan.removeAllItems();
   
        EmployeeInfo ei = new EmployeeInfo();
        ArrayList ename = ei.getEmpName();
        
        Iterator i = ename.iterator();
        
        while(i.hasNext()) {
            jComboBox_emp.addItem(i.next());
            
        }
        
        ArrayList eid1 = ei.getEmpNameLoans();
        
        Iterator ii = eid1.iterator();
        while(ii.hasNext()) {
           
            jComboBox_retEname.addItem(ii.next());
        }
        
        
        Iterator iii = eid1.iterator();
        while(iii.hasNext()) {
           
            jComboBox_searchLoan.addItem(iii.next());
        }
        
    }   
    
    private boolean empty(String a, String b) {
        boolean result = true;
        if(a.isEmpty()||b.isEmpty()) {
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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_clr;
    private javax.swing.JButton jButton_delete;
    private javax.swing.JButton jButton_demoUp;
    private javax.swing.JButton jButton_home2;
    private javax.swing.JButton jButton_insert;
    private javax.swing.JButton jButton_rSubmit;
    private javax.swing.JButton jButton_report;
    private javax.swing.JButton jButton_slctDate;
    private javax.swing.JButton jButton_update;
    private javax.swing.JComboBox jComboBox_emp;
    private javax.swing.JComboBox jComboBox_retEname;
    private javax.swing.JComboBox jComboBox_searchLoan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JRadioButton jRadioButton_return;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTable jTable_loan;
    private javax.swing.JTextField jTextField_amount;
    private javax.swing.JTextField jTextField_dueDate;
    private javax.swing.JTextField jTextField_loanidR;
    // End of variables declaration//GEN-END:variables
}
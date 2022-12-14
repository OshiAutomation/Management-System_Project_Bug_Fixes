/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gui.DropShipping;

import Data.DB_Access;
import gui.EmpMng.Home;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Disala Reyhart
 */
public class AddFCustomer extends javax.swing.JFrame {

    /**
     * Creates new form AddFCustomer
     */
    public AddFCustomer() {
        initComponents();
        txt_cusID.setText(Integer.toString(getCusID()+1)); //Increment text box value acording to database last entered value+1
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
        jButton_home = new javax.swing.JButton();
        jButton_back = new javax.swing.JButton();
        txt_Name = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_eMail = new javax.swing.JTextField();
        txt_Phone = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txt_Company = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txt_postalCode = new javax.swing.JTextField();
        cmb_Country = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_state = new javax.swing.JTextField();
        txt_city = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txt_street = new javax.swing.JTextField();
        txt_lane = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txt_no = new javax.swing.JTextField();
        btn_add = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        txt_cusID = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txt_PCountryCode = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(610, 450));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Name");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 110, 50, 14);

        jButton_home.setBackground(new java.awt.Color(0, 153, 204));
        jButton_home.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/home1.png"))); // NOI18N
        jButton_home.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_homeActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_home);
        jButton_home.setBounds(520, 390, 63, 35);

        jButton_back.setBackground(new java.awt.Color(0, 153, 204));
        jButton_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/back.png"))); // NOI18N
        jButton_back.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_backActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_back);
        jButton_back.setBounds(450, 390, 61, 33);

        txt_Name.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_NameFocusGained(evt);
            }
        });
        txt_Name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_NameActionPerformed(evt);
            }
        });
        getContentPane().add(txt_Name);
        txt_Name.setBounds(90, 110, 148, 19);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("e-Mail");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 150, 50, 14);
        getContentPane().add(txt_eMail);
        txt_eMail.setBounds(90, 150, 148, 19);

        txt_Phone.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_PhoneFocusGained(evt);
            }
        });
        getContentPane().add(txt_Phone);
        txt_Phone.setBounds(130, 190, 113, 19);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Phone");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(19, 190, 50, 14);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Company");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(14, 230, 70, 14);
        getContentPane().add(txt_Company);
        txt_Company.setBounds(90, 230, 146, 19);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel5.setText("Postal Code");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 210, 60, 14);

        txt_postalCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_postalCodeFocusGained(evt);
            }
        });
        jPanel1.add(txt_postalCode);
        txt_postalCode.setBounds(101, 211, 112, 19);

        cmb_Country.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua & Deps", "Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan", "Bolivia", "Bosnia Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde", "Central African Rep", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo", "Congo {Democratic Rep}", "Costa Rica", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland {Republic}", "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea North", "Korea South", "Kosovo", "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar, {Burma}", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Palau", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russian Federation", "Rwanda", "St Kitts & Nevis", "St Lucia", "Saint Vincent & the Grenadines", "Samoa", "San Marino", "Sao Tome & Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands", "Somalia", "South Africa", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden", "Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad & Tobago", "Tunisia", "Turkey", "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States", "Uruguay", "Uzbekistan", "Vanuatu", "Vatican City", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe" }));
        cmb_Country.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_CountryActionPerformed(evt);
            }
        });
        jPanel1.add(cmb_Country);
        cmb_Country.setBounds(101, 180, 112, 19);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel6.setText("Country");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(10, 180, 50, 14);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel7.setText("State");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(10, 150, 50, 14);
        jPanel1.add(txt_state);
        txt_state.setBounds(101, 149, 112, 19);
        jPanel1.add(txt_city);
        txt_city.setBounds(101, 111, 112, 19);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel8.setText("City");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(10, 110, 50, 14);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel9.setText("Street");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(10, 80, 50, 14);
        jPanel1.add(txt_street);
        txt_street.setBounds(101, 73, 112, 19);
        jPanel1.add(txt_lane);
        txt_lane.setBounds(101, 42, 112, 19);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel10.setText("Lane");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(10, 40, 50, 14);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel11.setText("No");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(13, 17, 40, 14);
        jPanel1.add(txt_no);
        txt_no.setBounds(101, 11, 112, 19);

        btn_add.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        btn_add.setText("Add Customer");
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });
        jPanel1.add(btn_add);
        btn_add.setBounds(101, 249, 113, 23);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(290, 70, 290, 300);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Add New Forign Customer");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(160, 10, 270, 30);

        txt_cusID.setEditable(false);
        txt_cusID.setBackground(new java.awt.Color(255, 255, 255));
        getContentPane().add(txt_cusID);
        txt_cusID.setBounds(90, 70, 148, 19);

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 11)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Cus ID");
        getContentPane().add(jLabel13);
        jLabel13.setBounds(20, 70, 50, 13);

        txt_PCountryCode.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_PCountryCodeActionPerformed(evt);
            }
        });
        txt_PCountryCode.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txt_PCountryCodeFocusGained(evt);
            }
        });
        getContentPane().add(txt_PCountryCode);
        txt_PCountryCode.setBounds(87, 190, 40, 19);

        jLabel14.setForeground(new java.awt.Color(255, 255, 255));
        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/background.jpg"))); // NOI18N
        getContentPane().add(jLabel14);
        jLabel14.setBounds(-10, 0, 610, 450);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_PhoneFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_PhoneFocusGained
        // TODO add your handling code here:
        txt_Phone.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar()))
                    e.consume();
        }
        });
        
    }//GEN-LAST:event_txt_PhoneFocusGained

    private void txt_postalCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_postalCodeFocusGained
        // TODO add your handling code here:
        txt_postalCode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                if(!Character.isDigit(e.getKeyChar()))
                    e.consume();
        }
        });
    }//GEN-LAST:event_txt_postalCodeFocusGained

    private void txt_NameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_NameFocusGained
        // TODO add your handling code here:
        txt_Name.addKeyListener(new KeyAdapter() {
        @Override
        public void keyTyped(KeyEvent e) {
            if(!Character.isLetter(e.getKeyChar()) && !(e.getKeyChar()=='.') && !(Character.isWhitespace(e.getKeyChar())))
                e.consume();
        }
        });
    }//GEN-LAST:event_txt_NameFocusGained

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        // TODO add your handling code here:
        
         try {
        
        String Name=txt_Name.getText();
        String email=txt_eMail.getText();
        String Phone=txt_Phone.getText();
        String Company=txt_Company.getText();
        int PostalCode=Integer.parseInt(txt_postalCode.getText());
        String Country=cmb_Country.getSelectedItem().toString(); //object
        String State=txt_state.getText();
        String City=txt_city.getText();
        String Street=txt_street.getText();
        String Lane=txt_lane.getText();
        String No=txt_no.getText();
        
       
        
        //validate later
        
       
       if(Validate()){
       
        DB_Access dba=new DB_Access();
        
        
        String quary="INSERT INTO `dropshipping`.`foreigncustomer` (`name`, `email`, `phone`, `company`, `postalCode`, `number`, `lane`, `street`, `city`, `state`, `country`) VALUES ('"+Name+"', '"+email+"', '"+Phone+"', '"+Company+"', '"+PostalCode+"', '"+No+"', '"+Lane+"', '"+Street+"', '"+City+"', '"+State+"', '"+Country+"');";
       
       
       
            dba.setData(quary);
           //JOptionPane.showMessageDialog(this, "Sucess!!");
            int confirm=JOptionPane.showConfirmDialog(rootPane, " Sucessfully Entered \n Do you want to add More Customers ?");
                if(confirm==1 ||confirm==2){
                   this.dispose();
                }
                else if(confirm==0){
                    
                    Clear();
                    txt_cusID.setText(Integer.toString(getCusID()+1)); //Increment text box value acording to database last entered value+1
                }
            
            
            
       }
       else
       {
           JOptionPane.showMessageDialog(this, "Please Enter Valid Values");
       
       }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }catch (NumberFormatException ex){
             JOptionPane.showMessageDialog(this, "Please Enter Valid Number");
        
        }
       
       
        
        
        
    }//GEN-LAST:event_btn_addActionPerformed

    private void txt_PCountryCodeFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txt_PCountryCodeFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PCountryCodeFocusGained

    private void cmb_CountryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_CountryActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cmb_CountryActionPerformed

    private void txt_NameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_NameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_NameActionPerformed

    private void txt_PCountryCodeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_PCountryCodeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_PCountryCodeActionPerformed

    private void jButton_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_homeActionPerformed
        this.dispose();
        new Home().setVisible(true);
    }//GEN-LAST:event_jButton_homeActionPerformed

    private void jButton_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_backActionPerformed
        this.dispose();
        new Dropshipping().setVisible(true);
    }//GEN-LAST:event_jButton_backActionPerformed

    
    public boolean Validate(){
        boolean val=false;
           
        String Name=txt_Name.getText();
        String email=txt_eMail.getText();
        String Phone=txt_Phone.getText();
        String Company=txt_Company.getText();
        int PostalCode=Integer.parseInt(txt_postalCode.getText());
        String Country=cmb_Country.getSelectedItem().toString();
        String State=txt_state.getText();
        String City=txt_city.getText();
        String Street=txt_street.getText();
        String Lane=txt_lane.getText();
        String No=txt_no.getText();
        
        
        if(Name.isEmpty()||email.isEmpty()||Phone.isEmpty()||Company.isEmpty()
                ||PostalCode<0||Country.isEmpty()||State.isEmpty()||City.isEmpty()||Street.isEmpty()||Lane.isEmpty()||No.isEmpty())
        {
           return false;
        //falied
        }
        else 
    {
        return true;
        //validation passed
        
    }
        

    }
    public void Clear(){
    
        txt_Name.setText(null);
        txt_eMail.setText(null);
        txt_Phone.setText(null);
        txt_Company.setText(null);
        txt_postalCode.setText(null);
        cmb_Country.setSelectedIndex(0);
        txt_state.setText(null);
        txt_city.setText(null);
        txt_street.setText(null);
        txt_lane.setText(null);
        txt_no.setText(null);
    
    }
    
    public int getCusID(){  //to get the last customer Id of the database
    
         DB_Access dba = new DB_Access();
        int cID=-1;
        
         try {
             ResultSet rst = dba.getData("SELECT fcID FROM dropshipping.foreigncustomer");
             
             rst.last();
                 
             cID=rst.getInt(1);
            
             
   
         } catch (SQLException ex) {
             
             System.out.println(ex.getMessage());
             
             
         }
         return cID;
    
    
    }
    
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
            java.util.logging.Logger.getLogger(AddFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFCustomer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JComboBox cmb_Country;
    private javax.swing.JButton jButton_back;
    private javax.swing.JButton jButton_home;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txt_Company;
    private javax.swing.JTextField txt_Name;
    private javax.swing.JTextField txt_PCountryCode;
    private javax.swing.JTextField txt_Phone;
    private javax.swing.JTextField txt_city;
    private javax.swing.JTextField txt_cusID;
    private javax.swing.JTextField txt_eMail;
    private javax.swing.JTextField txt_lane;
    private javax.swing.JTextField txt_no;
    private javax.swing.JTextField txt_postalCode;
    private javax.swing.JTextField txt_state;
    private javax.swing.JTextField txt_street;
    // End of variables declaration//GEN-END:variables
}

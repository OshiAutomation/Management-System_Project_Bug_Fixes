/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DATA;

import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JRViewer;

/**
 *
 * @author Oshani
 */
public class report extends JFrame{
    
    
    public report(String fileName,HashMap parameter) throws JRException, ClassNotFoundException, SQLException
    {
        super("Rioyoma International");
        try 
        {
           // Class.forName("com.mysql.jdbc.Driver").newInstance();
          // DB_Access dba=new DB_Access();
           //Connection con=dba.getConnection();
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/riyoma", "root", "Dev@1234");
            JasperPrint print =JasperFillManager.fillReport(fileName, parameter,con);
            
            JRViewer viwer=new JRViewer(print);
            Container c=getContentPane();
            c.add(viwer);
            
        } catch (InstantiationException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(report.class.getName()).log(Level.SEVERE, null, ex);
        }
         catch (JRException jrException)
         {
             
        }
        setBounds(10, 10, 1000, 900);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
       
}

package gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.print.PrinterAbortException;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.type.OrientationEnum;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Supun Lakshan
 */
public abstract class AbstractDocumentPrinter {

	/**
	 * Sole constructor. (For invocation by subclass constructors, typically
	 * implicit.)
	 */
	protected AbstractDocumentPrinter() {
	}

	protected void performPrintOperation(final JasperPrint fillReport) throws PrinterAbortException {
		new Thread() {
			@Override
			public void run() {
				try {
					fillReport.setOrientation(OrientationEnum.PORTRAIT);
					JasperPrintManager.printReport(fillReport, false);
				} catch (JRException ex) {
					Logger.getLogger(AbstractDocumentPrinter.class.getName()).log(Level.SEVERE, null, ex);
				}
			}
		}.start();
	}

	protected void performViewOperation(final JasperPrint fillReport) throws PrinterAbortException {
		new Thread() {
			@Override
			public void run() {
				fillReport.setOrientation(OrientationEnum.PORTRAIT);
				JasperViewer.viewReport(fillReport, false);
			}
		}.start();
	}

	protected JasperReport performReadWriteOperation(File compiledReport, File unCompiledReport) throws IOException, ClassNotFoundException, JRException {
		if (!compiledReport.exists()) {
			BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(compiledReport));
			BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(unCompiledReport));
			JasperCompileManager.compileReportToStream(bufferedInputStream, bufferedOutputStream);
		}
		BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(compiledReport));
		ObjectInputStream objectInputStream = new ObjectInputStream(bufferedInputStream);
		return (JasperReport) objectInputStream.readObject();
	}
}

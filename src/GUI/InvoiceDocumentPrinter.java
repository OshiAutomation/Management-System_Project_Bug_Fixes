package gui;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.print.PrinterAbortException;
import java.io.File;
import java.io.IOException;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRTableModelDataSource;

/**
 *
 * @author Oshani
 */
public class InvoiceDocumentPrinter extends AbstractDocumentPrinter {

    private static InvoiceDocumentPrinter documentController;
    private JasperReport invoiceReport;

    private InvoiceDocumentPrinter() {
    }

    public static synchronized void printInvoice(JRTableModelDataSource dataSource, Map parameters) throws IOException, ClassNotFoundException, JRException, PrinterAbortException {
        if (documentController == null) {
            documentController = new InvoiceDocumentPrinter();
        }
        if (documentController.invoiceReport == null) {
            documentController.invoiceReport = documentController.loadInvoiceReport();
        }
        JasperPrint fillReport = JasperFillManager.fillReport(documentController.invoiceReport, parameters, dataSource);
        //documentController.performPrintOperation(fillReport);
        documentController.performViewOperation(fillReport);
    }

    private JasperReport loadInvoiceReport() throws IOException, ClassNotFoundException, JRException {
        File compiledReport = new File("./lib/resources/report/bill.report");
        File unCompiledReport = new File("./lib/resources/report/bill.jrxml");
        return performReadWriteOperation(compiledReport, unCompiledReport);
    }
}

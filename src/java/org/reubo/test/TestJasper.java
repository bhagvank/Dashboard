/*
 * TestJasper.java
 *
 * Created on March 21, 2006, 10:30
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */

package org.reubo.test;

import org.reubo.util.DBUtil;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.*;
import java.util.*;
import java.sql.*;
import java.io.*;
/**
 *
 * @author bhagvank
 */
public class TestJasper {

    /** Creates a new instance of TestJasper */
public TestJasper() {
    }

     public static ByteArrayOutputStream loadXML(String template) throws Exception
     {

            // First, load JasperDesign from XML and compile it into JasperReport
            JasperDesign jasperDesign = JasperManager.loadXmlDesign("D:\\basic.xml");
            JasperReport jasperReport = JasperManager.compileReport(jasperDesign);

            // Second, create a map of parameters to pass to the report.
            Map parameters = new HashMap();
            parameters.put("Title", "Basic JasperReport");
            //parameters.put("MaxSalary", new Double(25000.00));

            Connection conn = null;
            try
            {
            // Third, get a database connection
             conn = DBUtil.getConnection();

            // Fourth, create JasperPrint using fillReport() method
            JasperPrint jasperPrint = JasperManager.fillReport(jasperReport,
               parameters, conn);

            // You can use JasperPrint to create PDF
   //         JasperManager.printReportToPdfFile(jasperPrint, "D:\\BasicReport.pdf");

               //JRXlsExporter exporter = new JRXlsExporter();

               //ByteArrayOutputStream xlsReport = new ByteArrayOutputStream();
               //exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
               //exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, xlsReport);

               //exporter.exportReport();



            // Or to view report in the JasperViewer
  //          JasperViewer.viewReport(jasperPrint);

            }
            catch(Exception exception)
            {
                exception.printStackTrace();
            }
            finally
            {
                if(conn != null)
                {
                    try
                    {
                      conn.close();
                    }
                    catch(Exception exception)
                    {
                        exception.printStackTrace();
                    }
                }
            }

            return null;
     }
}

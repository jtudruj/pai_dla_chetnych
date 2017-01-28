/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.imageio.stream.ImageOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

/**
 *
 * @author linuxlite
 */
public class ChartGenerator extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("image/jpeg");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            JFreeChart chart = this.createChart(this.createDataset());
            
            
            BufferedImage img = chart.createBufferedImage(500, 500, BufferedImage.TYPE_INT_RGB, null);
            javax.imageio.ImageIO.write(img, "jpg", (ImageOutputStream) out);
//            out.close;
            
        }
    }
    
    private PieDataset createDataset() {
        HashMap hashMap = Helper.readResults();
        
        DefaultPieDataset dataset = new DefaultPieDataset();
        
        Iterator iterator = hashMap.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry record = (Map.Entry) iterator.next();
            dataset.setValue("123", 3.3);
//            dataset.setValue((String)record.getKey(), (Double)record.getValue());
        }
        return dataset;         
     }

    private JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Ankieta",  // chart title 
         dataset,        // data    
         true,           // include legend   
         true, 
         false);
      
      JFreeChart chart2 = ChartFactory.createBarChart("Ankieta",
              null,
              null, 
              (CategoryDataset) dataset,
              PlotOrientation.VERTICAL,
              true,
              false,
              false
      );
              

      return chart2;
   }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}

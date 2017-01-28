/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.pollub;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author linuxlite
 */
public class PollServlet extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PollServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Wybrales nastepujace technologie:</h1>");
            
            
            HashMap oldResults = Helper.readResults();
            
            
            Enumeration paramNames = request.getParameterNames();
            if (!paramNames.hasMoreElements()) {
                out.println("Brak danych");
            }
            while(paramNames.hasMoreElements()) {
                String paramName = (String)paramNames.nextElement();
//                out.print(paramName);
                String[] paramValues = request.getParameterValues(paramName);
                HashMap results = new HashMap();
                if (paramValues.length == 1) {
                    String paramValue=paramValues[0];
                    if(paramValue.length() == 0) {
                        out.println("Brak danych");
                    } else {
                        out.println(""+paramValue);
                        results.put(paramValue, 1);
                    }
                } else {
                    out.println("<ul>");
                    for(int i=0; i<paramValues.length; i++) {
                        out.println("<li>"+paramValues[i]+"</li>");
                        results.put(paramValues[i], 1);
                    }
                    out.println("</ul>");
                }
                results = Helper.mergeHashMaps(results, oldResults);
                Helper.writeResults(results);
            }
            
            out.println("<h1>Zobaczy wyniki ankiety: </h1>");
            
            out.print(Helper.hashMapToString(Helper.readResults()));
            out.println("<a href=\"ExcelGenerator\">Wygeneruj Excel</a>");
            out.println("<a href=\"ChartGenerator\">Wygeneruj Wykres</a>");
            
            
            out.println("</body>");
            out.println("</html>");
        }
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

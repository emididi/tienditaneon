/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Modelo.Array_2;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gamae
 */
@WebServlet(name = "Svconsultar", urlPatterns = {"/Svconsultar"})
public class Sercheck extends HttpServlet {

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
            out.println("<title>Servlet Svconsultar</title>");    
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>");
            out.println("</head>");
            out.println("<body>");
            boolean encontrado=false;
            String nombrebuscar=request.getParameter("nombrebuscar").toUpperCase();
            if (!nombrebuscar.matches("^[a-zA-Z\\s]+$")) {
                out.println("<h3>Error: El nombre del producto solo pueden ser letras y espacios</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            else
            {
                if(nombrebuscar.length()<=0)
                        {
                            out.println("<h3>Error: El nombre del producto no puede quedarse vacío</h3>");
                            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                }
                else
                {
                    for(Producto objetoproducto:Array_2.arrayproducto)
                    {
                        if(objetoproducto.getNombre().equals(nombrebuscar))
                        {
                            out.println("<h2>Producto</h2>");
                            out.println("<p>Nombre del producto: "+objetoproducto.getNombre()+"</p>");
                            out.println("<br>");
                            out.println("<p>Precio del producto: $"+objetoproducto.getPrecio()+"</p>");
                            out.println("<br>");
                            out.println("<p>Existencia del producto: "+objetoproducto.getExistencia()+"</p>");
                            out.println("<br>");
                            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                            encontrado=true;
                        }
                    }
            if (!encontrado)
            {
                out.println("<h3>Error: Ese producto no esta registrado</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
                }

            }
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

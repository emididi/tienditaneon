/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Modelo.Array_1;
import Modelo.Cliente;
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
@WebServlet(name = "SvConsultarcliente", urlPatterns = {"/SvConsultarcliente"})
public class Sercheckclient extends HttpServlet {

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
            out.println("<title>Servlet SvConsultarcliente</title>");            
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>");
            out.println("</head>");
            out.println("<body>");
            boolean encontrado=false;
            String nombrebuscar=request.getParameter("nombreconsultar").toUpperCase();
            if (!nombrebuscar.matches("^[a-zA-Z\\s]+$")) {
                out.println("<h3>Error: El nombre del cliente solo pueden ser letras y espacios</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            else
            {
                if(nombrebuscar.length()<=0)
                        {
                            out.println("<h3>Error: El nombre no puede estar vacío</h3>");
                        }
                else
                {
                    for(Cliente objetocliente:Array_1.arrayclientes)
                    {
                        if(objetocliente.getNombre().equals(nombrebuscar))
                        {
                            out.println("<h2>Cliente</h2>");
                            out.println("<p>Nombre: "+objetocliente.getNombre()+"</p>");
                            out.println("<br>");
                            out.println("<p>Teléfono: "+objetocliente.getTelefono()+"</p>");
                            out.println("<br>");
                            out.println("<p>Correo electrónico: "+objetocliente.getCorreo()+"</p>");
                            out.println("<br>");
                            out.println("<p>Saldo: $"+objetocliente.getSaldo()+"</p>");
                            out.println("<br>");
                            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                            encontrado=true;
                        }
                    }
                    if (!encontrado)
                    {
                        out.println("<h3>Error: Ese cliente no esta registrado</h3>");
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

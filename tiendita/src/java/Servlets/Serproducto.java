/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Modelo.Array_2;
import Modelo.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author gamae
 */
@WebServlet(name = "SvProductos", urlPatterns = {"/SvProductos"})
public class Serproducto extends HttpServlet {

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
        
        
        String nombre=request.getParameter("nombre").toUpperCase(); 
        String precioStr = request.getParameter("precio").trim();
        String existenciaStr = request.getParameter("existencia").trim();
        
        if (!nombre.matches("^[a-zA-Z\\s]+$")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El nombre del producto solo pueden ser letras y espacios</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (nombre.length()<=0) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El nombre del producto no puede estar vacío</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        
        
        if (!existenciaStr.matches("^[1-9]\\d{0,6}$")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: La existencia solo pueden ser numeros enteros positivos y maximo 7 numeros</h3></h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if(existenciaStr.length()<=0)
        {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: La existencia no puede quedarse vacia</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        
        int existencia=Integer.parseInt(existenciaStr);
        
        if (!precioStr.matches("^[0-9]{0,7}(\\.[0-9]+)?$")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El precio solo pueden ser numeros positivos (Incluidos decimales) y máximo 7 digitos</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (precioStr.length()<=0)
        {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El precio no puede quedarse vacia</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }

        float precio = Float.parseFloat(precioStr);
        
        
        boolean encontrado=false;
        for(Producto objetoproducto:Array_2.arrayproducto)
        {
            if(objetoproducto.getNombre().equals(nombre))
                        {
                        try (PrintWriter out = response.getWriter()) {
                            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                            out.println("<h3>Error: Ya hay un producto registrado con ese nombre</h3>");
                            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                        }
                        return;
            }
        }
        if(!encontrado)
        {
        Producto objetoproducto=new Producto(nombre,precio,existencia);
        Array_2.arrayproducto.add(objetoproducto);
        }

        
        
        
        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvProductos</title>"); 
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Producto registrado correctamente</h2>");
            out.println("<p>Producto: "+nombre+"</p>");
            out.println("<br>");
            out.println("<p>Precio: $"+precio+"</p>");
            out.println("<br>");
            out.println("<p>Existencia: "+existencia+"</p>");
            out.println("<br>");
            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
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

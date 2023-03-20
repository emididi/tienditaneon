/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Modelo.Array_1;
import Modelo.Cliente;
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
@WebServlet(name = "SvCliente", urlPatterns = {"/SvCliente"})
public class Sercli extends HttpServlet {

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
        String telefonoStr = request.getParameter("telefono").trim();
        String correo=request.getParameter("correo").toLowerCase().trim();
        String saldostr=request.getParameter("saldo").trim();
        if (!nombre.matches("[a-zA-Z\\s]+")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El nombre solo puede contener letras y espacios en blanco</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (nombre.length()<=0) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El nombre no puede estar vacio</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (!telefonoStr.matches("\\d{10}")) {
        try (PrintWriter out = response.getWriter()) {
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
            out.println("<h3>Error: El teléfono debe ser un número entero de 10 dígitos</h3>");
            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
        }
        return;
        }
        if (telefonoStr.length()<=0) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El teléfono debe ser un número entero positivo de 10 dígitos</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (!correo.matches("\\w+@\\w+\\.\\w+")) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El correo electrónico no tiene un formato válido</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (correo.length()<=0) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El correo no puede estar vacio</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (!saldostr.matches("^[0-9]{1,7}(\\.[0-9]+)?$")) {
            try (PrintWriter out = response.getWriter()) {
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El saldo debe ser un número positivo con máximo 7 dígitos (incluidos decimales)</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        if (saldostr.length()<=0) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                out.println("<h3>Error: El saldo no puede estar vacio</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            return;
        }
        float saldo=Float.parseFloat(saldostr);
        boolean encontrado=false;
        for(Cliente objetocliente:Array_1.arrayclientes)
        {
            if(objetocliente.getNombre().equals(nombre))
                        {
                        try (PrintWriter out = response.getWriter()) {
                            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
                            out.println("<h3>Error: Ya hay un cliente registrado con ese nombre</h3>");
                            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                        }
                        return;
            }
        }
        if(!encontrado)
        {
        Cliente objetocliente=new Cliente(nombre,telefonoStr,correo,saldo);
        Array_1.arrayclientes.add(objetocliente);
        }

        
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet SvCliente</title>");  
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>Usuario registrado correctamente</h2>");
            out.println("<p>El nombre del cliente es: "+nombre+"</p>");
            out.println("<br>");
            out.println("<p>El teléfono del cliente es: "+telefonoStr+"</p>");
            out.println("<br>");
            out.println("<p>El correo electrónico del cliente es: "+correo+"</p>");
            out.println("<br>");
            out.println("<p>El saldo del cliente es: $"+saldo+"</p>");
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

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Servlets;

import Modelo.Array_1;
import Modelo.Array_2;
import Modelo.Cliente;
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
@WebServlet(name = "SvComprar", urlPatterns = {"/SvComprar"})
public class Serbuy extends HttpServlet {

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
            out.println("<title>Servlet SvComprar</title>");          
            out.println("<link rel=\"stylesheet\" href=\"./css/style.css\"/>"); 
            out.println("</head>");
            out.println("<body>");
            String nombrebuscar=request.getParameter("nombrebuscar").toUpperCase();
            String existenciacomprarStr=request.getParameter("existenciacomprar").trim();
            String nombrecc=request.getParameter("nombrecc").toUpperCase();
            boolean encontrado=false;
            boolean encontradonombre=false;
            if (!nombrebuscar.matches("^[a-zA-Z\\s]+$")) {
                out.println("<h3>Error: El nombre del producto solo pueden ser letras y espacios</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
            }
            else
            {
                if (!existenciacomprarStr.matches("^[1-9]\\d{0,6}$")) 
                {
                out.println("<h3>Error: La existencia solo pueden ser numeros enteros positivos y maximo 7 numeros</h3>");
                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                }
                else
                {
                    if(!nombrecc.matches("^[a-zA-Z\\s]+$"))
                            {
                                out.println("<h3>Error: El nombre del cliente solo pueden ser letras y espacios</h3>");
                                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                            }
                    else
                    {
                        int existenciacomprar=Integer.parseInt(existenciacomprarStr);
                        for(Producto objetoproducto:Array_2.arrayproducto)
                                {
                                    if(objetoproducto.getNombre().equals(nombrebuscar))
                                    {
                                        int existenciaactual=objetoproducto.getExistencia();
                                        if(existenciaactual>=existenciacomprar)
                                        {
                                            int existenciaqueda=existenciaactual-existenciacomprar;
                                            float precio=objetoproducto.getPrecio();
                                            float pago=existenciacomprar*precio;
                                            for(Cliente objetocliente:Array_1.arrayclientes)
                                            {
                                                if(objetocliente.getNombre().equals(nombrecc))
                                                {
                                                  float saldoactual=objetocliente.getSaldo();

                                                   if(saldoactual>=pago)
                                                   {
                                                       float saldoqueda=saldoactual-pago;
                                                       objetoproducto.setExistencia(existenciaqueda);
                                                       objetocliente.setSaldo(saldoqueda);
                                                       out.println("<h2>Compra exitosa</h2>");
                                                       out.println("<p>Compro: "+existenciacomprar+" existencias de "+objetoproducto.getNombre()+"</p>");
                                                       out.println("<br>");
                                                       out.println("<p>Debe pagar: $"+pago+"</p>");
                                                       out.println("<br>");
                                                       out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");

                                                   }
                                                   else
                                                   {
                                                    out.println("<h3>Error: No tiene suficiente saldo para realizar la compra, solo tiene"+saldoactual+"</h3>");
                                                    out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                                                   }
                                                   encontradonombre=true;

                                                }

                                            }
                                            if (!encontradonombre)
                                            {
                                                out.println("<h3>Error: Ese cliente no esta registrado</h3>");
                                                out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                                            }
                                        } 
                                        else 
                                        {
                                            out.println("<h3>Error: No hay suficientes existencias para realizar la compra, solo hay "+existenciaactual+" existencias de "+objetoproducto.getNombre()+"</h3>");
                                            out.println("<button onclick=\"location.href='index.html'\">Regresar</button>");
                                        }
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

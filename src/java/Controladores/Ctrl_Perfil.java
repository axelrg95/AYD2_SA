/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;

import Modelos.Modelo_Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author tosh
 */
public class Ctrl_Perfil extends HttpServlet {

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

            Modelo_Usuario regModel = new Modelo_Usuario();

            RequestDispatcher rd = null;
            int resultado = 0;
            String nombre;
            String apellido;
            String correo;
            String password;
            String password_conf;
            String edad;
            String sexo;
            String tipo_usuario;
            if (request.getParameter("btn_guardar") != null) {
                nombre = request.getParameter("txt_nombre");
                apellido = request.getParameter("txt_apellido");
                correo = request.getParameter("txt_correo");
                password = request.getParameter("txt_password");
                password_conf = request.getParameter("txt_password_conf");
                edad = request.getParameter("txt_edad");
                sexo = request.getParameter("sexo");
                tipo_usuario = request.getParameter("tipo");

                resultado = regModel.actualizarUsuario(nombre, apellido, correo, password, edad, sexo, tipo_usuario);

                rd = request.getRequestDispatcher("perfil.jsp");
            } else {
                rd = request.getRequestDispatcher("perfil.jsp");
            }

            rd.forward(request, response);

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

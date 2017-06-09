package ofelia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.dao.impl.UsuarioDaoImpl;
import ofelia.model.entity.Usuario;

public class action extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String user = request.getParameter("user");
        user = request.getParameter("user") == null ? "" : user;

        String pass = request.getParameter("pass");
        pass = request.getParameter("pass") == null ? "" : pass;

        UsuarioDAO udao = new UsuarioDaoImpl();
        Usuario us = udao.validarUsuario(user, pass);

        String alertaError = "errorCampo();";
        System.out.println("usuario  " + user + "clave  " + pass);
        System.out.println("saasasaassasa  " + user + "asasaasas  " + pass);
        if (us != null) {
            //Trabajando con Sesiones*
            HttpSession session = request.getSession();
            session.setAttribute("usuarioSesion", us.getUsuario());
            session.setAttribute("rol", us.getIdrol());
            //Trabajando con Sesiones*
            System.out.println("soy la seccion" + us.getUsuario());//CONSOLA
            switch (us.getIdrol()) {
                case 1:
                    request.getRequestDispatcher("Inicio.jsp").forward(request, response);
                    break;
                case 2:
                    request.getRequestDispatcher("Otro.jsp").forward(request, response);
                    break;
            }
        } else {
            request.setAttribute("alerta", alertaError);
            request.getRequestDispatcher("login.jsp").forward(request, response);
            System.out.println("Se mando la alerta de error corectamente: " + alertaError);//CONSOLA
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

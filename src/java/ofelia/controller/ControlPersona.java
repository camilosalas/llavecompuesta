/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import ofelia.model.dao.PersonaDAO;
import ofelia.model.dao.impl.PersonaDaoImpl;
import ofelia.model.entity.Persona;

/**
 *
 * @author Alexander_BV
 */
public class ControlPersona extends HttpServlet {

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
        
        String idpersona = request.getParameter("idpersona");
        idpersona = idpersona == null ? "" : idpersona;

        String nombres = request.getParameter("nombres");
        nombres = nombres == null ? "" : nombres;

        String apellidos = request.getParameter("apellidos");
        apellidos = apellidos == null ? "" : apellidos;

        String genero = request.getParameter("genero");
        genero = genero == null ? "" : genero;

        String fecha_nac = request.getParameter("fecha_nac");
        fecha_nac = fecha_nac == null ? "" : fecha_nac;

        String idtipo_doc = request.getParameter("idtipo_doc");
        idtipo_doc = idtipo_doc == null ? "" : idtipo_doc;

        String nro_doc = request.getParameter("nro_doc");
        nro_doc = nro_doc == null ? "" : nro_doc;

        String direccion = request.getParameter("direccion");
        direccion = direccion == null ? "" : direccion;

        String condicion = request.getParameter("condicion");
        condicion = condicion == null ? "" : condicion;

        String telefono = request.getParameter("telefono");
        telefono = telefono == null ? "" : telefono;

        String op = request.getParameter("op");

        Persona p = new Persona();
        PersonaDAO pdao = new PersonaDaoImpl();

        switch (op) {
            case "add_Docente":
                p.setNombres(nombres);
                p.setApellidos(apellidos);
                p.setGenero(genero);
                p.setFecha_nac(fecha_nac);
                p.setIdtipo_doc(Integer.parseInt(idtipo_doc));
                p.setNro_doc(nro_doc);
                p.setDireccion(direccion);
                p.setCondicion(condicion);
                p.setTelefono(telefono); 
                if (pdao.agregarPersona(p)) {
                    response.sendRedirect("ListarPersona");
                    System.out.println("SE AGREGO CORRECTAMENTE ");
                }else{
                   response.sendRedirect("ListarPersona");
                    System.out.println("NO SE PUDO AGREGAR PERSSONA");
                }
                
                break;
            case "add_Alumno":
                p.setNombres(nombres);
                p.setApellidos(apellidos);
                p.setGenero(genero);
                p.setFecha_nac(fecha_nac);
                p.setIdtipo_doc(Integer.parseInt(idtipo_doc));
                p.setNro_doc(nro_doc);
                p.setDireccion(direccion);
                if (pdao.agregarPersona(p)) {
                    response.sendRedirect("ListarAlumno");
                    System.out.println("SE AGREGO CORRECTAMENTE ");              
                }
                break;
                
             case "delete_Docente":
                 if (pdao.eliminarPersona(Integer.parseInt(idpersona))) {
                     System.out.println("SE ELIMINO EXITOSAMENTE");
                     response.sendRedirect("ListarPersona");
                 }else{
                     System.out.println("NO SE ELIMINO NADA");
                     response.sendRedirect("ListarPersona");
                    
                 }
                 
                 break;
            default:
                break;

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

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
import ofelia.model.dao.LectorDAO;
import ofelia.model.dao.impl.LectorDaoImpl;
import ofelia.model.entity.Lector;

/**
 *
 * @author CamiloST
 */
public class ControlLector extends HttpServlet {
     
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
        
        String idperiodo = request.getParameter("idperiodo");
       idperiodo = idperiodo == null ? "" : idperiodo;
        
        String idpersona = request.getParameter("idpersona");
        idpersona = idpersona == null ? "" : idpersona;
                
        String idturno = request.getParameter("idturno");
       idturno = idturno == null ? "" : idturno;

        String idtipo = request.getParameter("idtipo");
        idtipo = idtipo == null ? "" : idtipo;

        String estado_habil = request.getParameter("estado_habil");
       estado_habil = estado_habil == null ? "" : estado_habil;

        String nivel = request.getParameter("nivel");
        nivel = nivel == null ? "" : nivel;
                
        String grado = request.getParameter("grado");
       grado = grado == null ? "" : grado;

        String seccion = request.getParameter("seccion");
        seccion = seccion == null ? "" : seccion;

        String condicion = request.getParameter("condicion");
        condicion = condicion == null ? "" : condicion;
        
        String op = request.getParameter("op");
       
        Lector l = new Lector();
        LectorDAO ldao = new LectorDaoImpl();
        
        switch(op){
            
            case "add_Lector":
                l.setIdperiodo(Integer.parseInt(idperiodo));
                l.setIdpersona(Integer.parseInt(idpersona));
                l.setIdturno(Integer.parseInt(idturno));
                l.setIdtipo(Integer.parseInt(idtipo));
                l.setEstado_habil(Integer.parseInt(estado_habil));
                l.setNivel(nivel);
                l.setGrado(grado);
                l.setSeccion(seccion);
                l.setCondicion(condicion);
                if (ldao.agregarLector(l)) {
                    response.sendRedirect("ListarLector");
                    System.out.println("SE AGREGO CORRECTAMENTE ");              
                }
                break;
                        
        case "delete_lector":
            if (ldao.eliminarLector(Integer.parseInt(idperiodo), Integer.parseInt(idpersona))){
                response.sendRedirect("ListarLector");
                System.out.println("se elimino");
                
            }else{
                     System.out.println("NO SE ELIMINO NADA");
                     response.sendRedirect("ListarLector");
                    
                 }  
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

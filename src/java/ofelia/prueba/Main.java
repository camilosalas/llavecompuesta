/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.prueba;

import ofelia.model.dao.LibroDAO;
import ofelia.model.dao.ProveedorDAO;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.dao.impl.LibroDaoImpl;
import ofelia.model.dao.impl.ProveedorDaoImpl;
import ofelia.model.dao.impl.UsuarioDaoImpl;
import ofelia.model.entity.Libro;
import ofelia.model.entity.Proveedor;
import java.util.List;
import ofelia.model.dao.LectorDAO;
import ofelia.model.dao.PersonaDAO;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.dao.impl.PersonaDaoImpl;
import ofelia.model.dao.impl.UsuarioDaoImpl;
import ofelia.model.entity.Persona;
import ofelia.model.dao.UbigeoDAO;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.dao.impl.LectorDaoImpl;
import ofelia.model.dao.impl.UbigeoDaoImpl;
import ofelia.model.dao.impl.UsuarioDaoImpl;
import ofelia.model.entity.Lector;
import ofelia.model.entity.Ubigeo;
import ofelia.model.entity.Usuario;

/**
 *
 * @author Emmanuel
 */
public class Main {

    public static void main(String[] args) {
        Main m = new Main();
//        m.validarUsuario("lt49", "123");
//        m.listarUsuarios();
//        m.listarProveedor();
//        m.listarLibro();
//        m.validarUsuario("lt49", "123");
//        m.TestListarUsuario();
//        m.TestAgregarUsuario();
//        m.TestEditarUsuario();
//        m.TestEliminarUsuario();
//        -----PERSONA
        //m.TestListarPersona();
//        m.TestAgregarPersona();
//        m.TestEliminarPersona();
//        m.TestEditarPersona();
         //m.validarUsuario("isai", "isa123");
        //m.listarUsuarios();
//        m.listarUbigeo();
         //m.agregarUbigeo();
         //m.actualizarUbigeo();
//         m.eliminarUbigeo();
//        ------LECTOR
        m.agregarLector();
//         m.listarLector();
//         m.eliminarLector();
//           m.EditarLector();
    }
    public void validarUsuario(String user, String pass) {
        UsuarioDAO dao = new UsuarioDaoImpl();
        Usuario u = dao.validarUsuario(user, pass);
        System.out.println("Usuario: " + u.getUsuario());
    }
    
    public void TestListarUsuario() {
        UsuarioDAO dao = new UsuarioDaoImpl();
        List<Usuario> u = dao.listarUsuario();
        for (Usuario us : u) {
            System.out.println("Nombre :" + us.getUsuario() + " Clave: " + us.getClave());
        }
    }
    
    public void TestAgregarUsuario() {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDaoImpl();
        u.setUsuario("Lavado");
        u.setClave("123");
        u.setIdrol(1);
        u.setIdpersona(3);
        if (dao.agregarUsuario(u)) {
            System.out.println("Se agrego correctamente");
        } else {
            System.out.println("Noooo agrego correctamente");
        }
        
    }
    
    public void TestEditarUsuario() {
        Usuario u = new Usuario();
        UsuarioDAO dao = new UsuarioDaoImpl();
        u.setIdusuario(3);
        u.setUsuario("Lavado Lokito");
        u.setClave("123");
        u.setIdrol(1);
        u.setIdpersona(3);
        if (dao.editarUsuario(u)) {
            System.out.println("Se edito correctamente");
        } else {
            System.out.println("Noooo edito correctamente");
        }
    }
    
    public void TestEliminarUsuario() {
        UsuarioDAO dao = new UsuarioDaoImpl();
        if (dao.eliminarUsuario(4)) {
            System.out.println("Se elimino Correctaamente SIIIIIIIIIIIII");
        } else {
            System.out.println("No se elimino Noooo xQQQ no te lo puedo Creer ");
        }
    }
    
    public void TestListarPersona() {
        PersonaDAO pdao = new PersonaDaoImpl();
        List<Persona> p = pdao.listarPersona();
        for (Persona per : p) {
            System.out.println("Nombre :" + per.getNombres() + " Apellido: " + per.getApellidos());
        }
    }
    
    public void TestAgregarPersona() {
        Persona p = new Persona();
        PersonaDAO pdao = new PersonaDaoImpl();
        p.setNombres("Jhonerly");
        p.setApellidos("Bustamente");
        p.setIdtipo_doc(1);
        p.setNro_doc("27672610");
        p.setFecha_nac("2017/10/06");
        p.setDireccion("Encuentrame si puedes");
        p.setCondicion("En buen estado");
        if (pdao.agregarPersona(p)) {
            System.out.println("Se agrego correctamente");
        } else {
            System.out.println("Noooo agrego correctamente");
        }
    }
    
    public void TestEditarPersona() {
        Persona p = new Persona();
        PersonaDAO pdao = new PersonaDaoImpl();
        p.setIdpersona(6);
        p.setNombres("Jhonerly Lokita");
        p.setApellidos("Bustamente");
        p.setIdtipo_doc(1);
        p.setNro_doc("27672610");
        p.setFecha_nac("2017/10/06");
        p.setDireccion("Encuentrame si puedes");
        p.setCondicion("En buen estado");
        if (pdao.editarPersona(p)) {
            System.out.println("Se edito correctamente");
        } else {
            System.out.println("Noooo edito correctamente");
        }
        
    }
    
    public void TestEliminarPersona() {
           PersonaDAO pdao = new PersonaDaoImpl();
        if (pdao.eliminarPersona(5)) {
            System.out.println("Se elimino Correctaamente SIIIIIIIIIIIII");
        } else {
            System.out.println("No se elimino Noooo xQQQ no te lo puedo Creer ");
        }
    }
    public void listarUsuarios() {
        UsuarioDAO dao = new UsuarioDaoImpl();
        for (Usuario usuario : dao.listarUsuario()) {
            System.out.println("Usuario: " + usuario.getUsuario());
        }
    }

    public void listarProveedor() {
        ProveedorDAO dao = new ProveedorDaoImpl();
        for (Proveedor proveedor : dao.listarProveedor()) {
            System.out.println("Proveedor: " + proveedor.getNombre());
        }
    }

    public void listarLibro() {
        LibroDAO dao = new LibroDaoImpl();
        for (Libro libro : dao.listarLibro()) {
            System.out.println("Titulo: " + libro.getTitulo() + " | Paginas: " + libro.getPaginas() + " | Cantidad: " + libro.getCantidad());
        }
    }
    
    public void listarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        for(Ubigeo ubigeo : dao.listarUbigeo()){
            System.out.println("Ubigeo: "+ubigeo.getNombre());
        }
    }
    
    public void agregarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        Ubigeo ubigeo = new Ubigeo();
        ubigeo.setNombre("New York");
        if(dao.agregarUbigeo(ubigeo)){
            System.out.println("exito");
        }
    }
    
    public void actualizarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        Ubigeo ubigeo = new Ubigeo();
        ubigeo.setIdubigeo(15);
        ubigeo.setNombre("actualizado");
        if(dao.editarUbigeo(ubigeo)){
            System.out.println("exito");
        }
    }
    
    public void eliminarUbigeo(){
        UbigeoDAO dao = new UbigeoDaoImpl();
        Ubigeo ubigeo = new Ubigeo();
        ubigeo.setIdubigeo(15);
        if(dao.eliminarUbigeo(15)){
            System.out.println("Eliminado");
        }
    }
//------------------------LECTOR----------------------------    
    public void agregarLector(){
        LectorDAO dao = new LectorDaoImpl();
        Lector lec = new Lector();
        lec.setIdperiodo(1);
        lec.setIdpersona(2);
        lec.setIdtipo(3);
        lec.setIdturno(1);
        lec.setGrado("6");
        lec.setNivel("2");
        lec.setSeccion("C");
        if (dao.agregarLector(lec)) {
            System.out.println("Se agrego");
        } else {
            System.out.println("NO Se agrego");
        }
    } 
    
     public void listarLector() {
       LectorDAO dao = new LectorDaoImpl();
        for (Lector lector : dao.listarLector()) {
            System.out.println("Lector: " + lector.getSeccion());
        }
    }
     
    public void eliminarLector(){
        LectorDAO dao = new LectorDaoImpl();
        if (dao.eliminarLector(1,2)) {
            System.out.println("Se Elimino");
        } else {
            System.out.println("NO Se Elimino");
        }
    } 
    
    public void EditarLector() {
        Lector lector = new Lector();
        LectorDAO dao = new LectorDaoImpl();
        lector.setIdperiodo(1);
        lector.setIdpersona(1);
        
        lector.setSeccion("b");
        if(dao.editarLector(lector)){
            System.out.println("Se edito con exito");
        } else {
            System.out.println("Noooo edito correctamente");
        }
    }
    
}

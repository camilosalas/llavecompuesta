/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import ofelia.model.dao.PersonaDAO;
import ofelia.model.entity.Persona;
import ofelia.model.entity.Usuario;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Alexander_BV
 */
public class PersonaDaoImpl implements PersonaDAO {

    @Override
    public List<Persona> listarPersona() {
        SessionFactory sf = null;
        Session session = null;
        List<Persona> lista = null;
        Query query = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            lista = new ArrayList<>();
            query = session.createQuery("FROM Persona");
            lista = query.list();
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            session.close();
        }
        return lista;
    }

    @Override
    public boolean agregarPersona(Persona ps) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(ps);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean editarPersona(Persona ps) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Persona p = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            p = new Persona();
            p = (Persona) session.get(Persona.class, ps.getIdpersona());
            p.setNombres(ps.getNombres());
            p.setApellidos(ps.getApellidos());
            p.setIdtipo_doc(ps.getIdtipo_doc());
            p.setNro_doc(ps.getNro_doc());
            p.setFecha_nac(ps.getFecha_nac());
            p.setDireccion(ps.getDireccion());
            p.setCondicion(ps.getCondicion());
            session.update(p);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean eliminarPersona(int id) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Persona p = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            p = new Persona();
            p = (Persona) session.get(Persona.class, id);
            session.delete(p);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public Persona buscarPersona(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

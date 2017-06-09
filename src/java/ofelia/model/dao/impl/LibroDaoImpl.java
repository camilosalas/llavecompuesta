/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.LibroDAO;
import ofelia.model.entity.Libro;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author user
 */
public class LibroDaoImpl implements LibroDAO{

    @Override
    public List<Libro> listarLibro() {
        List<Libro> lista = null;
        SessionFactory sf = null;
        Session session = null;
        Criteria criteria = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            criteria = session.createCriteria(Libro.class);
            lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error listarLibro: "+e.getMessage());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public boolean agregarLibro(Libro li) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(li);
            tx.commit();
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR :" + e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean editarLibro(Libro li) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Libro lib = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            lib = new Libro();
            lib = (Libro) session.get(Libro.class, lib.getIdlibro());
            lib.setIdcategoria(lib.getIdcategoria());
            lib.setIdeditorial(lib.getIdeditorial());
            lib.setIdpersona_autor(lib.getIdpersona_autor());
            lib.setTitulo(lib.getTitulo());
            lib.setYear_publicacion(lib.getYear_publicacion());
            lib.setPaginas(lib.getPaginas());
            lib.setCantidad(lib.getCantidad());
            session.update(lib);
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
    public boolean eliminarLibro(int id) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Libro li = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            li = new Libro();
            li = (Libro) session.get(Libro.class, id);
            session.delete(li);
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
    public Libro buscarLibro(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

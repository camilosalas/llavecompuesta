/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import ofelia.model.dao.LectorDAO;
import ofelia.model.entity.Lector;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Emmanuel
 */
public class LectorDaoImpl implements LectorDAO{

    @Override
    public List<Lector> listarLector() {
        SessionFactory sf = null;
        Session session = null;
        List<Lector> lista = null;
        Query query = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            lista = new ArrayList<>();
            query = session.createQuery("FROM Lector");
            lista = query.list();
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR listarLector():" + e.getMessage());
            session.close();
        }
        return lista;
    }

    @Override
    public boolean agregarLector(Lector le) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(le);
            tx.commit();
            session.close();
            flat=true;
        } catch (Exception e) {
            System.out.println("ERROR agregarLector:"+e.getMessage());
            tx.rollback();
            session.close();
            flat=false;
        }
        return flat;
    }

    @Override
    public boolean editarLector(Lector le) {
         boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Lector lect = null;
        try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tx=session.beginTransaction();
            lect=new Lector();
           ///lect= (Lector) session.get(Lector.class, le.getIdpersona());
            lect.setIdperiodo(lect.getIdperiodo());
            lect.setIdpersona(lect.getIdpersona());
            lect.setIdturno(le.getIdturno());
            lect.setIdtipo(le.getIdtipo());
            lect.setEstado_habil(le.getEstado_habil());
            lect.setNivel(le.getNivel());
            lect.setGrado(le.getGrado());
            lect.setSeccion(le.getSeccion());
            lect.setCondicion(le.getCondicion());
            session.update(lect);
            tx.commit();
            session.close();
            flat=true;
        } catch (Exception e) {
            System.out.println("ERROR EditarLector:"+e.getMessage());
            tx.rollback();
            session.close();
            flat=false;
        }
        return flat;
    }
    @Override
    public boolean eliminarLector(int idperiodo, int idpersona) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Lector lec = null;
        Query query;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            lec = new Lector();
            query = session.createQuery("Delete from Lector where idperiodo = :idperiodo and idpersona = :idpersona");
            query.setParameter("idperiodo", idperiodo);
            query.setParameter("idpersona", idpersona);
            query.executeUpdate();
            tx.commit();
            session.close();
            flat=true;
        } catch (Exception e) {
            System.out.println("ERROR eliminarLector:"+e.getMessage());
            tx.rollback();
            session.close();
            flat=false;
        }
        return flat;
    }

    @Override
    public Lector buscarLector(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

  }

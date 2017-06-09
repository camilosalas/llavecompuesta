/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.ArrayList;
import java.util.List;
import ofelia.model.dao.PeriodoDAO;
import ofelia.model.entity.Periodo;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author FIORELLA S
 */
public class PeriodoDaoImpl implements PeriodoDAO {

    @Override
    public List<Periodo> listarperiodo() {
        SessionFactory sf = null;
        Session session = null;
        List<Periodo> lista = null;
        Query query = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            lista = new ArrayList<>();
            query = session.createQuery("FROM Periodo");
            lista = query.list();
            session.close();
        } catch (Exception e) {
            System.out.println("ERROR:" + e.getMessage());
            session.close();
        }
        return lista;

    }

    @Override
    public boolean agregarPeriodo(Periodo pe) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(pe);
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
    public boolean editarPeriodo(Periodo pe) {
         boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Periodo per = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            per = new Periodo();
            per = (Periodo) session.get(Periodo.class, pe.getIdperiodo());
            per.setPeriodo(pe.getPeriodo());
            session.update(per);
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
    public boolean eliminarPeriodo(int id) {
    boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Periodo p = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            p = new Periodo();
            p = (Periodo) session.get(Periodo.class, id);
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
    public Periodo buscarPeriodo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

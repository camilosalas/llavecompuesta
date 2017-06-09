/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.UbigeoDAO;
import ofelia.model.entity.Ubigeo;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author CAMILO SALAS
 */
public class UbigeoDaoImpl implements UbigeoDAO{

    @Override
    public List<Ubigeo> listarUbigeo() {
        SessionFactory sf = null;
        Session session = null;
        List<Ubigeo> lista = null;
        Criteria criteria = null;
       
        try {
            sf = HibernateUtil.getSessionFactory();
           session = sf.openSession();
           criteria = session.createCriteria(Ubigeo.class);
           lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error listarUbigeo: "+e.getStackTrace());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public boolean agregarUbigeo(Ubigeo ub) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            //Establesco la comunicacion con el framework
            sf = HibernateUtil.getSessionFactory();
            //Abro una conexion con hibernate
            session = sf.openSession();
            //para poder finalizar transacciones con la DB
            tx = session.beginTransaction();
            //inserta los datos que contiene el objeto Cliente
            session.save(ub);
            //se hace el commit
            tx.commit();
            //cerramos la conexion
            session.close();
            flat = true;
        } catch (Exception e) {
            System.out.println("ERROR: "+e.getMessage());
            tx.rollback();
            session.close();
            flat = false;
        }
        return flat;
    }

    @Override
    public boolean editarUbigeo(Ubigeo ub) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Ubigeo ubi = null;
        try {
            sf=HibernateUtil.getSessionFactory();
            session=sf.openSession();
            tx=session.beginTransaction();
            ubi=new Ubigeo();
            ubi=(Ubigeo)session.get(Ubigeo.class, ub.getIdubigeo());
            ubi.setNombre(ub.getNombre());
            session.update(ubi);
            tx.commit();
            session.close();
            flat=true;
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            tx.rollback();
            session.close();
            flat=false;
        }
        return flat;
    }

    @Override
    public boolean eliminarUbigeo(int id) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Ubigeo ubi = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            ubi = new Ubigeo();
            ubi = (Ubigeo)session.get(Ubigeo.class, id);
            session.delete(ubi);
            tx.commit();
            session.close();
            flat=true;
        } catch (Exception e) {
            System.out.println("ERROR:"+e.getMessage());
            tx.rollback();
            session.close();
            flat=false;
        }
        return flat;
    }

    @Override
    public Ubigeo buscarUbigeo(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

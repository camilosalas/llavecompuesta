/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao.impl;

import java.util.List;
import ofelia.model.dao.ProveedorDAO;
import ofelia.model.util.HibernateUtil;
import ofelia.model.entity.Proveedor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


/**
 *
 * @author user
 */
public class ProveedorDaoImpl implements ProveedorDAO{

    @Override
    public List<Proveedor> listarProveedor() {
        List<Proveedor> lista = null;
        SessionFactory sf = null;
        Session session = null;
        Criteria criteria = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            criteria = session.createCriteria(Proveedor.class);
            lista = criteria.list();
        } catch (Exception e) {
            System.out.println("Error listarProveedor: "+e.getMessage());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        
        return lista;
    }

    @Override
    public boolean agregarProveedor(Proveedor pro) {
    boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(pro);
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
    public boolean editarProveedor(Proveedor pro) {
boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Proveedor prov = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            prov = new Proveedor();
            prov = (Proveedor) session.get(Proveedor.class, prov.getIdproveedor());
            prov.setNombre(prov.getNombre());
            session.update(prov);
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
    public boolean eliminarProveedor(int id) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Proveedor pro = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            pro = new Proveedor();
            pro = (Proveedor) session.get(Proveedor.class, id);
            session.delete(pro);
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
    public Proveedor buscarProveedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}

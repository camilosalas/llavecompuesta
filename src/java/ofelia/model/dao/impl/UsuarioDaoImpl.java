package ofelia.model.dao.impl;


import java.util.List;
import ofelia.model.entity.Usuario;
import ofelia.model.dao.UsuarioDAO;
import ofelia.model.util.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;




public class UsuarioDaoImpl implements UsuarioDAO{

//    private Connection cn;
    
    @Override
    public List<Usuario> listarUsuario() {
        SessionFactory sf = null;
        Session session = null;
        List<Usuario> lista = null;
        Criteria criteria = null;
        Query query = null;
        try {
           sf = HibernateUtil.getSessionFactory();
           session = sf.openSession();
           criteria = session.createCriteria(Usuario.class);
           lista = criteria.list();
           //Usuario user = (Usuario)session.get(Usuario.class, 1);
           
//           query = session.createQuery("from Usuario"); 
//           lista = query.list();
        } catch (Exception e) {
            System.out.println("Error listarUsuario: "+e.getMessage());
        }finally{
            if (session!=null) {
                session.close();
            }
        }
        return lista;
    }

    @Override
    public boolean agregarUsuario(Usuario us) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            session.save(us);
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
    public boolean editarUsuario(Usuario us) {
        boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Usuario u = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            u = new Usuario();
            u = (Usuario) session.get(Usuario.class, us.getIdusuario());
            u.setUsuario(us.getUsuario());
            u.setClave(us.getClave());
            u.setIdrol(us.getIdrol());
            u.setIdpersona(us.getIdpersona());
            session.update(u);
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
    public boolean eliminarUsuario(int id) {
       boolean flat = false;
        SessionFactory sf = null;
        Session session = null;
        Transaction tx = null;
        Usuario u = null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            tx = session.beginTransaction();
            u = new Usuario();
            u = (Usuario) session.get(Usuario.class, id);
            session.delete(u);
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
    public Usuario buscarrUsuario(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Usuario validarUsuario(String usuario, String clave) {
        SessionFactory sf = null;
        Session session = null;  
        Query query = null;
        Usuario usu=null;
        try {
            sf = HibernateUtil.getSessionFactory();
            session = sf.openSession();
            query = session.createQuery("from Usuario where usuario = :user and clave = :pass");
            query.setParameter("user", usuario);
            query.setParameter("pass", clave);
            usu = new Usuario();
            usu = (Usuario)query.uniqueResult();
        } catch (Exception e) {
            System.out.println("Error validarUsuario: "+e.getMessage());
        }
        finally{
            if (session!=null) {
                session.close();
            }            
        }
        return usu;
    }
    
}

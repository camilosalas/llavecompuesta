package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Proveedor;

/**
 *
 * @author isai
 */
public interface ProveedorDAO {
   
    
    public List<Proveedor> listarProveedor();
    public boolean agregarProveedor(Proveedor pro);
    public boolean editarProveedor(Proveedor pro);
    public boolean eliminarProveedor(int id);
    public Proveedor buscarProveedor(int id);

}

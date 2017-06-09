
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Lector;

/**
 *
 * @author isai
 */
public interface LectorDAO {
    public List<Lector>listarLector();
    public boolean agregarLector(Lector le);
    public boolean editarLector(Lector le);
    public boolean eliminarLector(int idperiodo, int idpersona);
    public Lector buscarLector(int id);
}

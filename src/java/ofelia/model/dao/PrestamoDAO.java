
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Prestamo;

public interface PrestamoDAO {
    public List<Prestamo> listarPrestamo();
    public boolean agregarPrestamo(Prestamo pre);
    public boolean editarPrestamo(Prestamo pre);
    public boolean eliminarPrestamo(int id);
    public Prestamo buscarPrestamo(int id);
}

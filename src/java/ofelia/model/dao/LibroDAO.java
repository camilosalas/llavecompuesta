package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Libro;



/**
 *
 * @author isai
 */
public interface LibroDAO {
    public List<Libro> listarLibro();
    public boolean agregarLibro(Libro li);
    public boolean editarLibro(Libro li);
    public boolean eliminarLibro(int id);
    public Libro buscarLibro(int id);
}

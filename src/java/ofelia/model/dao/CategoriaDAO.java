package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Categoria;

/**
 *
 * @author isai
 */
public interface CategoriaDAO {
    public List<Categoria> listarCategoria();
    public boolean agregarCategoria(Categoria ca);
    public boolean editarCategoria(Categoria ca);
    public boolean eliminarCategoria(int id);
    public Categoria buscarCategoria(int id);
}

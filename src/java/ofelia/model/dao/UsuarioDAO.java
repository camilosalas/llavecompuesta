package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Usuario;
/**
 *
 * @author isai
 */
public interface UsuarioDAO {
    public List<Usuario> listarUsuario();
    public boolean agregarUsuario(Usuario us);
    public boolean editarUsuario (Usuario us);
    public boolean eliminarUsuario(int id);
    public Usuario buscarrUsuario(int id);
    public Usuario validarUsuario(String usuario, String clave);
}

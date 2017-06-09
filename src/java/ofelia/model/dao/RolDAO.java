/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Rol;

/**
 *
 * @author isai
 */
public interface RolDAO {
    
    public List<Rol> listarRol();
    public boolean agregarRol(Rol rl);
    public boolean editarRol(Rol rl);
    public boolean eliminarRol(int id);
    public Rol buscarRol(int id);
    
}

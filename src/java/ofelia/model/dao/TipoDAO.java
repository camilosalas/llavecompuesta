/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Tipo;

/**
 *
 * @author isai
 */
public interface TipoDAO {
    
    public List<Tipo> listarTipo();
    public boolean agregarTipo (Tipo ti);
    public boolean editarTipo(Tipo ti);
    public boolean eliminarTipo(int id);
    public boolean buscarTipo(int id);

}

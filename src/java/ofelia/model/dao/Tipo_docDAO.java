/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Tipo_doc;

/**
 *
 * @author user
 */
public interface Tipo_docDAO {
    
    public List<Tipo_doc>listarTipo_doc();
    public boolean agreagarTipo_doc(Tipo_doc td);
    public boolean editarTipo_doc(Tipo_doc td);
    public boolean eliminarTipo_doc(int id);
    public Tipo_doc buscarTipo_doc(int id);
}

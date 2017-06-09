/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Editorial;

/**
 *
 * @author user
 */
public interface EditorialDAO {
    
    public List<Editorial> listarEditorial();
    public boolean agregarEditorial(Editorial ed);
    public boolean editarEditorial(Editorial ed);
    public boolean eliminarEditorial(int id);
    public Editorial buscarEditorial(int id);
    
}

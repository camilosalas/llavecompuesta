/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Ubigeo;

/**
 *
 * @author user
 */
public interface UbigeoDAO {
    
    public List<Ubigeo> listarUbigeo();
    public boolean agregarUbigeo(Ubigeo ub);
    public boolean editarUbigeo(Ubigeo ub);
    public boolean eliminarUbigeo(int id);
    public Ubigeo buscarUbigeo(int id);
    
}

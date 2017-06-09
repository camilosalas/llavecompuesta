/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;
import java.util.List;
import ofelia.model.entity.Ejemplar;

/**
 *
 * @author isai
 */
public interface EjemplarDAO {
    public List<Ejemplar> listarEjemplar();
    public boolean agregarEjemplar(Ejemplar ej);
    public boolean editarEjemplar (Ejemplar ej);
    public boolean eliminarEjemplar(int id);
    public Ejemplar buscarEjemplar(int id);
}

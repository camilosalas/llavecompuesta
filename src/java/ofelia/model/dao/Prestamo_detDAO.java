/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

/**
 *
 * @author isai
 */
import java.util.List;
import ofelia.model.entity.Prestamo_det;

public interface Prestamo_detDAO {
   
    public List<Prestamo_det> listarPrestamo_det();
    public boolean agregarPrestamo_det(Prestamo_det pd);
    public boolean editarPrestamo_det(Prestamo_det pd);
    public boolean eliminarPrestamo_det(int id);
    public Prestamo_det buscarPrestamo_det(int id);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Periodo;

/**
 *
 * @author isai
 */
public interface PeriodoDAO {
    public List<Periodo> listarperiodo();
    public boolean agregarPeriodo(Periodo pe);
    public boolean editarPeriodo(Periodo pe);
    public boolean eliminarPeriodo(int id);    
    public Periodo buscarPeriodo(int id);
}

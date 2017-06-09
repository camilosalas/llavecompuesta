/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Turno;

/**
 *
 * @author isai
 */
public interface TurnoDAO {
    public List<Turno>listarTurno();
    public boolean agregarTurno(Turno tr);
    public boolean editarTurno (Turno tr);
    public boolean eliminarTurno (int id);
    public Turno buscarTurno(int id);
}

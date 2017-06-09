/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.dao;

import java.util.List;
import ofelia.model.entity.Persona;

/**
 *
 * @author isai
 */
public interface PersonaDAO {

    public List<Persona> listarPersona();
    public boolean agregarPersona(Persona ps);
    public boolean editarPersona(Persona ps);
    public boolean eliminarPersona(int id);
    public Persona buscarPersona(int id);
}

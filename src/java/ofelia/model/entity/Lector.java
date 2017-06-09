
package ofelia.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author isai
 */
@Entity
public class Lector {
    @Id
   private int idperiodo;
   private int idpersona;
   private int idturno;
   private int idtipo;
   private int estado_habil;
   private String nivel;
   private String grado;
   private String seccion;
   private String condicion;

    public Lector() {
    }

    public Lector(int idperiodo, int idpersona, int idturno, int idtipo, int estado_habil, String nivel, String grado, String seccion, String condicion) {
        this.idperiodo = idperiodo;
        this.idpersona = idpersona;
        this.idturno = idturno;
        this.idtipo = idtipo;
        this.estado_habil = estado_habil;
        this.nivel = nivel;
        this.grado = grado;
        this.seccion = seccion;
        this.condicion = condicion;
    }

    public int getIdperiodo() {
        return idperiodo;
    }

    public void setIdperiodo(int idperiodo) {
        this.idperiodo = idperiodo;
    }

    public int getIdpersona() {
        return idpersona;
    }

    public void setIdpersona(int idpersona) {
        this.idpersona = idpersona;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public int getEstado_habil() {
        return estado_habil;
    }

    public void setEstado_habil(int estado_habil) {
        this.estado_habil = estado_habil;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }

    public String getSeccion() {
        return seccion;
    }

    public void setSeccion(String seccion) {
        this.seccion = seccion;
    }

    public String getCondicion() {
        return condicion;
    }

    public void setCondicion(String condicion) {
        this.condicion = condicion;
    }

    
   
}

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
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idcategoria;
    @Column(length = 15)
    private String nro;
    @Column(length = 50)
    private String nombre;
    @Column(length = 100)
    private String descripcion;
    private int idcategoria_sup;

    public Categoria() {
    }

    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdcategoria_sup() {
        return idcategoria_sup;
    }

    public void setIdcategoria_sup(int idcategoria_sup) {
        this.idcategoria_sup = idcategoria_sup;
    }
    
    
    
}

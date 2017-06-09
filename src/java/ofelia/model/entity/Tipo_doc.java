package ofelia.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Tipo_doc {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idtipo_doc;
    @Column(length = 45)
    private String nombre;

    public Tipo_doc() {
    }

    public Tipo_doc(int idtipo_doc, String nombre) {
        this.idtipo_doc = idtipo_doc;
        this.nombre = nombre;
    }

    public int getIdtipo_doc() {
        return idtipo_doc;
    }

    public void setIdtipo_doc(int idtipo_doc) {
        this.idtipo_doc = idtipo_doc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
}

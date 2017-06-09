package ofelia.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Turno {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idturno;
    @Column(length = 15)
    private String turno;

    public Turno() {
    }

    public Turno(int idturno, String turno) {
        this.idturno = idturno;
        this.turno = turno;
    }

    public int getIdturno() {
        return idturno;
    }

    public void setIdturno(int idturno) {
        this.idturno = idturno;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
    
    
    
}

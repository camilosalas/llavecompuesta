/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ofelia.model.entity;

/**
 *
 * @author isai
 */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Prestamo_det {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idprestamo;
    private int idlibro;
    private int idejemplar;
    @Column(length = 45)
    private String fechadev_programada;
    @Column(length = 10)
    private String horadev_programada;
    @Column(length = 2)
    private char devuelta;
    @Column(length = 45)
    private String fechadev_efectiva;
    @Column(length = 10)
    private String horadev_efectiva;
    
    public Prestamo_det() {
    }

    public int getIdprestamo() {
        return idprestamo;
    }

    public void setIdprestamo(int idprestamo) {
        this.idprestamo = idprestamo;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public int getIdejemplar() {
        return idejemplar;
    }

    public void setIdejemplar(int idejemplar) {
        this.idejemplar = idejemplar;
    }

    public String getFechadev_programada() {
        return fechadev_programada;
    }

    public void setFechadev_programada(String fechadev_programada) {
        this.fechadev_programada = fechadev_programada;
    }
    
    public void setFechadev_efectiva(String fechadev_efectiva) {
        this.fechadev_efectiva = fechadev_efectiva;
    }

    public String getHoradev_programada() {
        return horadev_programada;
    }

    public char getDevuelta() {
        return devuelta;
    }

    public void setDevuelta(char devuelta) {
        this.devuelta = devuelta;
    }

    public String getFechadev_efectiva() {
        return fechadev_efectiva;
    }

    public void setHoradev_programada(String horadev_programada) {
        this.horadev_programada = horadev_programada;
    }

    public String getHoradev_efectiva() {
        return horadev_efectiva;
    }

    public void setHoradev_efectiva(String horadev_efectiva) {
        this.horadev_efectiva = horadev_efectiva;
    }
    
}

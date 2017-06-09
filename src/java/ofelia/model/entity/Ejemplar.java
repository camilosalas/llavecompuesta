/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class Ejemplar {

    public Ejemplar() {
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idejemplar;
    private int idlibro;
    private int idproveedor;
    @Column(length = 45)
    private String serie_registro;
    @Column(length = 10)
    private char estado;
    @Column(length = 45)
    private String fecha_ingreso;
    private double precio;
    @Column(length = 45)
    String notacion_interna;
    
    public int getIdejemplar() {
        return idejemplar;
    }

    public void setIdejemplar(int idejemplar) {
        this.idejemplar = idejemplar;
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }

    public String getSerie_registro() {
        return serie_registro;
    }

    public void setSerie_registro(String serie_registro) {
        this.serie_registro = serie_registro;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public int getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(int idproveedor) {
        this.idproveedor = idproveedor;
    }
    
    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public String getNotacion_interna() {
        return notacion_interna;
    }

    public void setNotacion_interna(String notacion_interna) {
        this.notacion_interna = notacion_interna;
    }
    
}

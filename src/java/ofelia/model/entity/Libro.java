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
public class Libro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idlibro;
    private int idcategoria;
    private int ideditorial;
    private int idpersona_autor;
    @Column(length = 100)
    private String titulo;
    @Column(length = 10)
    private String year_publicacion;
    @Column(length = 45)
    private String paginas;
    private int cantidad;

    public Libro() {
    }

    public int getIdlibro() {
        return idlibro;
    }

    public void setIdlibro(int idlibro) {
        this.idlibro = idlibro;
    }
    
    public int getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(int idcategoria) {
        this.idcategoria = idcategoria;
    }

    public int getIdeditorial() {
        return ideditorial;
    }

    public void setIdeditorial(int ideditorial) {
        this.ideditorial = ideditorial;
    }
    
    public int getIdpersona_autor() {
        return idpersona_autor;
    }

    public void setIdpersona_autor(int idpersona_autor) {
        this.idpersona_autor = idpersona_autor;
    }
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear_publicacion() {
        return year_publicacion;
    }

    public void setYear_publicacion(String year_publicacion) {
        this.year_publicacion = year_publicacion;
    }

    public String getPaginas() {
        return paginas;
    }

    public void setPaginas(String paginas) {
        this.paginas = paginas;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


}

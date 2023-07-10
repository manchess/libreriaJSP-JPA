package modelos;

import javax.persistence.*;

@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Basic
    private long ISBN;
    @Basic
    private String titulo;
    @Basic
    private Integer anio;
    @Basic
    private Integer ejemplares;
    @Basic
    private Boolean alta;

    public Libro() {
    }

    public Libro(Long ISBN, String titulo, Integer anio, Integer ejemplares, Boolean alta) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.anio = anio;
        this.ejemplares = ejemplares;
        this.alta = alta;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public Integer getEjemplares() {
        return ejemplares;
    }

    public void setEjemplares(Integer ejemplares) {
        this.ejemplares = ejemplares;
    }

    public Boolean getAlta() {
        return alta;
    }

    public void setAlta(Boolean alta) {
        this.alta = alta;
    }
}

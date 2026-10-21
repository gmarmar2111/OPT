package tema1.taquilla.controllers;

public class Obra {
    private Integer id;
    private String titulo;
    private Double precio;
    private Integer asientosDisponibles;

    public Obra() {
    }

    public Obra(Integer id, String titulo, Double precio, Integer asientosDisponibles) {
        this.id = id;
        this.titulo = titulo;
        this.precio = precio;
        this.asientosDisponibles = asientosDisponibles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getAsientosDisponibles() {
        return asientosDisponibles;
    }

    public void setAsientosDisponibles(Integer asientosDisponibles) {
        this.asientosDisponibles = asientosDisponibles;
    }

    public void restarAsientos(Integer asientos){
        this.asientosDisponibles -= asientos;
    }
}

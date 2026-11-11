package aplicacionesspring.actividad2.dto;

import aplicacionesspring.actividad2.models.Libro;

public class LibroDto {

    private final Long id;
    private final String titulo;
    private final String autor;
    private final String isbn;
    private final Integer anioPublicacion;
    private final Boolean prestado;

    public LibroDto(Libro libro) {
        this.id = libro.getId();
        this.titulo = libro.getTitulo();
        this.autor = libro.getAutor();
        this.isbn = libro.getIsbn();
        this.anioPublicacion = libro.getAnioPublicacion();
        this.prestado = libro.getPrestado();
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getAutor() {
        return autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public Boolean getPrestado() {
        return prestado;
    }

}

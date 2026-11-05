package aplicacionesspring.actividad2.dto;

public class LibroDto {

    private final Long id;
    private final String titulo;
    private final String autor;
    private final String isbn;
    private final Integer anioPublicacion;
    private final Boolean prestado;

    public LibroDto(Long id, String titulo, String autor, String isbn, Integer anioPublicacion, Boolean prestado) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.anioPublicacion = anioPublicacion;
        this.prestado = prestado;
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

package aplicacionesspring.actividad2.models;

public class Libro {
    private Long id;
    private String titulo;
    private String autor;
    private String isbn;
    private Integer anioPublicacion;
    private Boolean prestado;
    private String notasInternas;

    public Libro(Long id, String titulo, String autor, String isbn, Integer anioPublicacion, Boolean prestado,String notasInternas) {
        this.id = id;
        if (titulo.equals("")){
            throw new IllegalArgumentException("El titulo no puede estar vacio");
        }
        this.titulo = titulo;
        if (autor.equals("")){
            throw new IllegalArgumentException("El autor no puede estar vacio");
        }
        this.autor = autor;
        this.isbn = isbn;
        if (anioPublicacion < 0){
            throw new IllegalArgumentException("El año no puede ser menor que 0");
        }
        this.anioPublicacion = anioPublicacion;
        this.prestado = prestado;
        this.notasInternas = notasInternas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
    }

    public Boolean getPrestado() {
        return prestado;
    }

    public void setPrestado(Boolean prestado) {
        if (prestado && getPrestado()){
            throw new IllegalArgumentException("El libro ya está prestado");
        }
        if (!prestado && !getPrestado()){
            throw new IllegalArgumentException("El libro no se ha prestado todavía");
        }
        this.prestado = prestado;
    }

    public String getNotasInternas() {
        return notasInternas;
    }

    public void setNotasInternas(String notasInternas) {
        this.notasInternas = notasInternas;
    }
}

package aplicacionesspring.actividad2.dto;

public class LibroResumenDto {
    private Long id;
    private String titulo;

    public LibroResumenDto(Long id, String titulo) {
        this.id = id;
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }
}

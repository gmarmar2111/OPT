package aplicacionesspring.actividad2.service;

import aplicacionesspring.actividad2.dto.LibroCrearDto;
import aplicacionesspring.actividad2.dto.LibroDto;
import aplicacionesspring.actividad2.dto.LibroResumenDto;
import aplicacionesspring.actividad2.models.Libro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LibroService {
    private final List<Libro> libros = new ArrayList<>();
    private Long siguienteId = 1L;

    public List<LibroResumenDto> listarLibros() {
        List<LibroResumenDto> libroDtos = new ArrayList<>();
        for (Libro libro : libros){
            libroDtos.add(new LibroResumenDto(libro.getId(), libro.getTitulo()));
        }
        return libroDtos;
    }

    public Libro crearLibro(LibroCrearDto libroDto) throws Exception {

        for (Libro libro : libros) {
            if (libro.getIsbn().equals(libroDto.getIsbn())) {
                throw new Exception("Un libro con ese ISBN ya existe ");
            }
        }
        if (libroDto.getTitulo() == null || libroDto.getTitulo().trim().isEmpty() || libroDto.getAutor() == null || libroDto.getAutor().trim().isEmpty() || libroDto.getAnioPublicacion() <= 0) {
            throw new IllegalArgumentException("Los datos no son validos");
        }

        Libro nuevoLibro = new Libro(siguienteId++, libroDto.getTitulo(), libroDto.getAutor(), libroDto.getIsbn(), libroDto.getAnioPublicacion(), false , "Notas internas");
        libros.add(nuevoLibro);
        return nuevoLibro;
    }

    public Libro buscarLibroId(Long id){
        for (Libro libro : libros) {
            if (libro.getId().equals(id)) {
                return libro;
            }
        }
        throw new RuntimeException("El libro con ID " + id + " no existe.");
    }

    public Libro prestarLibro(Long id) throws Exception  {
        Libro libro = null;
        try {
            libro = buscarLibroId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        if (libro.getPrestado()) {
            throw new Exception("El libro ya esta prestado");
        }
        libro.setPrestado(true);
        return libro;
    }

    public Libro devolverLibro(Long id) throws Exception {
        Libro libro = null;
        try {
            libro = buscarLibroId(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (!libro.getPrestado()) {
            throw new Exception("El libro ya esta devuelto");
        }

        libro.setPrestado(false);
        return libro;
    }

    public void eliminarLibro(Long id) throws Exception{
        Libro libro = buscarLibroId(id);

        if (libro.getPrestado()) {
            throw new Exception("El libro esta prestado");
        }
        libros.remove(libro);
    }
}

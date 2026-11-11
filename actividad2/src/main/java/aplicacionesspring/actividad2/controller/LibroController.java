package aplicacionesspring.actividad2.controller;

import aplicacionesspring.actividad2.dto.ErrorDto;
import aplicacionesspring.actividad2.dto.LibroCrearDto;
import aplicacionesspring.actividad2.dto.LibroDto;
import aplicacionesspring.actividad2.models.Libro;
import aplicacionesspring.actividad2.service.LibroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibroController {
    private final LibroService libroService;

    public LibroController(LibroService libroService) {
        this.libroService = libroService;
    }

    @PostMapping("/libros")
    public ResponseEntity<Object> crearLibro(@RequestBody LibroCrearDto libro){
        try {
            Libro libroNuevo = libroService.crearLibro(libro);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LibroDto(libroNuevo));

        } catch (IllegalArgumentException e) {
            ErrorDto error = new ErrorDto(e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
        } catch (Exception e) {
            ErrorDto error = new ErrorDto(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }

    @GetMapping("/libros")
    public ResponseEntity<Object> listarLibros(){
        return ResponseEntity.status(HttpStatus.OK).body(libroService.listarLibros());
    }

    @GetMapping("/libros/{id}")
    public ResponseEntity<Object> buscarPorId(@PathVariable Long id){
        try {
            Libro libroBuscado = libroService.buscarLibroId(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LibroDto(libroBuscado));

        } catch (RuntimeException e) {
            ErrorDto error = new ErrorDto(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
        }
    }

    @PostMapping("/libros/{id}/prestamo")
    public ResponseEntity<Object> prestarLibro(@PathVariable Long id){
        try {
            Libro libroAPrestar = libroService.prestarLibro(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LibroDto(libroAPrestar));

        } catch (Exception e) {
            ErrorDto error = new ErrorDto(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }
    }

    @PostMapping("/libros/{id}/devolucion")
    public ResponseEntity<Object> devolucionLibro(@PathVariable Long id){
        try {
            Libro libroPrestado = libroService.devolverLibro(id);
            return ResponseEntity.status(HttpStatus.CREATED).body(new LibroDto(libroPrestado));

        } catch (Exception e) {
            ErrorDto error = new ErrorDto(e.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
        }

    }



}

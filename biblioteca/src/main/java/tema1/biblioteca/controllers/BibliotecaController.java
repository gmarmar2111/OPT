package tema1.biblioteca.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import tema1.biblioteca.enums.Estado;
import tema1.biblioteca.models.Libro;
import tema1.biblioteca.models.Prestamo;
import tema1.biblioteca.models.Respuesta;

import java.util.ArrayList;
import java.util.List;

@Controller
public class BibliotecaController {
    List<Libro> libros = new ArrayList<>(List.of(
            new Libro(1, "El principito", "Un Señor", "Ficcion", 3),
            new Libro(2, "El camino", "Jack Kerouac", "Filosofia", 0),
            new Libro(3, "El Quijote", "Cervantes", "Vida", 4),
            new Libro(4, "El Extranjero", "Otro Señor", "Filosofia", 6),
            new Libro(5, "El Señor de los Anillos", "Kotlin", "Ficcion", 10)));

    @GetMapping("/prestamo")
    public String mostrarFormulario(){
        return "prestamo";
    }

    @PostMapping("/prestamo")
    @ResponseBody
    public Respuesta procesarPrestamo(@ModelAttribute Prestamo prestamo){
        int idElegido = prestamo.getLibroId();
        Libro libroElegido = null;

        for (Libro libro : libros){
            if (idElegido == libro.getId()){
                libroElegido = libro;
            }
        }

        if (libroElegido == null){
            return new Respuesta(Estado.DENEGADO, "No existe el libro");
        }

        if (libroElegido.getEjemplaresDisponibles() == 0){
            return new Respuesta(Estado.DENEGADO, "Sin ejemplares disponibles");
        }

        if (prestamo.getDiasPrestamo() < 1 || prestamo.getDiasPrestamo() > 30){
            return new Respuesta(Estado.DENEGADO, "Duración no válida (1-30 días)");
        }
        libroElegido.setEjemplaresDisponibles(libroElegido.getEjemplaresDisponibles() - 1);

        return new Respuesta(Estado.CONCEDIDO, "Concedido");
    }
}

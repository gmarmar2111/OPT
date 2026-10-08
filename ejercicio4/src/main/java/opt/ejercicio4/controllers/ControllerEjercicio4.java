package opt.ejercicio4.controllers;

import org.jspecify.annotations.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEjercicio4 {



    // Dos Argumentos
    @GetMapping("/tabla")
    public String tabla(@RequestParam(name = "filas", required = false) Integer filas,
                      @RequestParam(name = "columnas", required = false) Integer columnas){

        // Validaciones
        if (filas < 1 || filas >20 || filas == null){
            filas = 1;
        }
        if (columnas < 1 || columnas >20 || columnas == null){ //  Fuera de rango = 1
            columnas = 1;
        }

        return crearTabla(filas, columnas);
    }



    // Metodo para crear la tabla
    private static String crearTabla(Integer filas, Integer columnas) {
        // Creación de la tabla
        String tabla = "<table>";

        // Encabezado
        tabla += "<tr>";
        for (int i = 1; i <= columnas; i++){
            tabla += "<th>Columna" + i + "</th>";
        }
        tabla += "<tr>";

        for (int i = 1; i <= filas; i++){
            tabla += "<tr>";
            for (int j = 1; j <= columnas; j++){
                tabla += "<td>Fila " + i + ", Columna " + j + "</td>";

            }
            tabla += "</tr>";
        }
        tabla += "</table>";

        return tabla;
    }
}

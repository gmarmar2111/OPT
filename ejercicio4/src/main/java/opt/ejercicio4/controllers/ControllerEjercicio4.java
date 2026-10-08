package opt.ejercicio4.controllers;

import org.jspecify.annotations.NonNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerEjercicio4 {

    @GetMapping("/tabla")
    public String tabla(@RequestParam(name = "filas", required = false) String filas,
                      @RequestParam(name = "columnas", required = false) String columnas){

        Integer numFilas;
        Integer numColumnas;

        // Validaciones
        try {
            numFilas = Integer.parseInt(filas);
        }catch (NumberFormatException e){
            numFilas = 1;
        }
        try {
            numColumnas = Integer.parseInt(columnas);
        }catch (NumberFormatException e){
            numColumnas = 1;
        }

            if (numFilas < 1 || numFilas > 20 ) {
                numFilas = 1;
            }
            if (numColumnas < 1 || numColumnas > 20) { //  Fuera de rango = 1
                numColumnas = 1;
            }

            return crearTabla(numFilas, numColumnas);
    }

    // Metodo para crear la tabla
    private static String crearTabla(Integer filas, Integer columnas) {
        // Creación de la tabla
        String tabla = "<table>";

        // Encabezado
        tabla += "<tr>";
        for (int i = 1; i <= columnas; i++){
            tabla += "<th style=\"border:solid\">Columna" + i + "</th>";
        }
        tabla += "<tr>";

        for (int i = 1; i <= filas; i++){
            tabla += "<tr>";
            for (int j = 1; j <= columnas; j++){
                tabla += "<td style=\"border:solid\">Fila " + i + ", Columna " + j + "</td>";

            }
            tabla += "</tr>";
        }
        tabla += "</table>";

        return tabla;
    }
}

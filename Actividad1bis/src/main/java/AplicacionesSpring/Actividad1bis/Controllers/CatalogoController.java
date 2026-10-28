package AplicacionesSpring.Actividad1bis.Controllers;

import AplicacionesSpring.Actividad1bis.Model.Producto;
import AplicacionesSpring.Actividad1bis.Model.Respuesta;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.util.ArrayList;

@RestController
public class CatalogoController {
    static ArrayList<Producto> productos = new ArrayList<>();

    CatalogoController() {
        productos.add(new Producto(1 , "Bicicleta", 2.20));
        productos.add(new Producto(2 , "Pelota", 3.20));
    }

    @GetMapping("/productos")
    public ResponseEntity<?> mostrarProductos(){
        if (productos.size() == 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Respuesta("No hay productos"));
        }
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/productos/buscar")
    public ResponseEntity<?> buscar(@RequestParam Integer id){
        ArrayList<Producto> productosFiltro = new ArrayList<>();

        for (Producto producto : productos){
            if (producto.getId() == id){
                productosFiltro.add(producto);
            }
        }
        if (productosFiltro.size() == 0){
            return ResponseEntity.badRequest().body(new Respuesta("No existe ese producto"));
        }
        return ResponseEntity.ok().body(productosFiltro);

    }

    @GetMapping("/productos/resumen")
    public ResponseEntity<Respuesta> resumen(){

        return ResponseEntity.ok().build();
    }
}

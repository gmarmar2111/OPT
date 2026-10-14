package tema1.actividad5.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tema1.actividad5.Pedido;

@RestController
public class PostController {
    @PostMapping("/pedido")
    public String pedido(@RequestBody Pedido pedido){
        String respuesta = """
                {
                  "cliente": "$s",
                  "totalProductos": 4,
                  "precioTotal": 216.00,
                  "mensaje": "Pedido recibido correctamente"
                }
                """.formatted();
        String respuesta = String.format()
        return

    }

}

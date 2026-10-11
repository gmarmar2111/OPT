package tema1.actividad5.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tema1.actividad5.Pedido;

@RestController
public class PostController {
    @PostMapping("/pedido")
    public String pedido(@RequestBody Pedido pedido){
        return "Pedido creado con exito. Cliente :" + pedido.getCliente().getNombre() + " Correo " + pedido.getCliente().getCorreo();
    }

}

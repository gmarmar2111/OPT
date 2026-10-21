package tema1.Minijuego.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/juegos")
public class MinijuegosController {

    @GetMapping("/dados")
    public String dados(@RequestParam(name="cantidad", required=false, defaultValue = "2")Integer cantidad,
                        @RequestParam(name = "caras", required = false, defaultValue = "6") Integer caras){

        Random random = new Random();
        if (cantidad < 1 || cantidad > 10){
            return "La cantidad debe de ser del 1 al 10";
        }

        List<Integer> carasValidas = new ArrayList<>(List.of(4, 6 , 8, 10, 12 , 20));

        if (!carasValidas.contains(caras)){
            return "Las caras deben de ser 4 - 6 - 8 - 10 - 12 - 20";
        }

        List<Integer> tiradas = new ArrayList<>();
        Integer sum = 0;
        String mensaje = "Tiradas:";
        Integer tmp = 0;
        Boolean dobles = true;

        for (int i = 1; i <= cantidad; i++){
            int tirada = random.nextInt(caras) + 1;
            if (i != 1 && tmp != tirada){
               dobles = false;
            }
            tmp = tirada;
            sum += tirada;
            mensaje += " " + tirada;
            tiradas.add(tirada);
        }
        mensaje += " Suma: " + sum;

        if (cantidad > 1 && dobles){
            mensaje += " Dobles!";
        }

        return mensaje;
    }

    @GetMapping("/moneda")
    public String moneda(@RequestParam( name="lanzamientos") Integer lanzamientos){
        if (lanzamientos < 1 || lanzamientos > 100){
            return "Numero no valido";
        }
        Random random = new Random();
        int cara = 0;
        int cruz = 0;

        for (int i = 1 ; i <= lanzamientos; i++){
            int num = random.nextInt(2);
            if (num == 0){
                cara++;
            }
            else {
                cruz++;
            }
        }
        return "Cara: " + cara + " Cruz: " + cruz;

    }

}

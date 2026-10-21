package tema1.taquilla.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TaquillaController {
    public static ArrayList<Obra> obras = new ArrayList<>(
            List.of(new Obra(101, "La casa de Bernarda Alba", 25.0, 10),
                    new Obra(102, "Yerma", 32.0, 5),
                    new Obra(103, "El tragaluz", 18.0, 20)
            ));

    @GetMapping("/reserva")
    public String showForm(){
        return "reserva";
    }

    @PostMapping("/reserva")
    @ResponseBody
    public Respuesta processForm(@ModelAttribute Reserva reserva){
        Obra obraSeleccionada = new Obra();
        String cliente = reserva.getNombreCliente();
        Integer entradas = reserva.getEntradas();
        Integer asientosDisponibles;
        Double precioUnitario;
        Double subtotal;
        Double descuentoTotal = 0.0;
        Boolean rechazada = false;


        for (Obra obra : obras){
            if (obra.getId().toString().equals(reserva.getEventoId())){
                obraSeleccionada = obra;
            }
        }
        precioUnitario = obraSeleccionada.getPrecio();
        asientosDisponibles = obraSeleccionada.getAsientosDisponibles();


        // Procesador de compras
        if (reserva.getEntradas() > obraSeleccionada.getAsientosDisponibles()){
            rechazada = true;
        }
        obraSeleccionada.restarAsientos(reserva.getEntradas());
        Double importe = obraSeleccionada.getPrecio() * reserva.getEntradas();

        if (reserva.getTipoEntrada().toString().equals("VIP")){
            importe += (importe * 20 / 100);
        }
        subtotal = importe;

        if (reserva.getEntradas() >= 4){
            descuentoTotal += (importe * 10 / 100);
            importe -= (importe * 10 / 100);
        }

        if (reserva.getCupon().equals("DESCUENTO15")){
            descuentoTotal += (importe * 15 / 100);
            importe -= (importe * 15 / 100);
        }


        if (rechazada){
            return new Respuesta("RECHAZADA", "Aforo Insuficiente, asientos disponibles " + asientosDisponibles);
        }
        return new Respuesta("CONFIRMADA", cliente, entradas, precioUnitario, subtotal, importe, descuentoTotal);

    }

    @GetMapping("/cartelera")
    @ResponseBody
    public RespuestaBusqueda buscadorObras(@RequestParam(name = "precioMax" , required = false) String precioMax,
                                           @RequestParam(name = "soloDisponibles", required = false) String soloDisponibles){
        try {
            ArrayList<Obra> obrasFiltro = new ArrayList<>();
            Double precioMaxD = Double.parseDouble(precioMax);
            Boolean soloDisponiblesB = Boolean.parseBoolean(soloDisponibles);
            Boolean cumple = true;

            for (Obra obra : obras) {
                if (obra.getPrecio() > precioMaxD || (obra.getAsientosDisponibles() == 0 && soloDisponiblesB)) {
                    cumple = false;
                }
                if (cumple) {
                    obrasFiltro.add(obra);
                }
            }
            return new RespuestaBusqueda(obrasFiltro);

        } catch (NullPointerException e) {
            return new RespuestaBusqueda(obras);
        }
    }
}

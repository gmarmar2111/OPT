package otravez.actividad1.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import otravez.actividad1.enums.Estado;
import otravez.actividad1.models.Obra;
import otravez.actividad1.models.Reserva;
import otravez.actividad1.models.Respuesta;

import java.awt.*;
import java.util.*;
import java.util.List;

@Controller
public class TaquillaController {
    public static ArrayList<Obra> obras = new ArrayList<>(
            List.of(new Obra(101, "La casa de Bernarda Alba", 25.0, 10),
                    new Obra(102, "Yerma", 32.0, 5),
                    new Obra(103, "El tragaluz", 18.0, 20)
            ));

    @GetMapping("/reserva")
    public String reserva(){
        return "reserva";
    }

    @PostMapping("/reserva")
    @ResponseBody
    public Respuesta procesarReserva(@ModelAttribute Reserva reserva){
        Integer idReserva = reserva.getEventoId();
        String clienteReserva = reserva.getNombreCliente();
        Integer entradasReserva = reserva.getCantidad();
        String cuponEntrada = reserva.getCodigoCupon();
        Double precioUnitario = 0.0;
        Double subtotal = 0.0;
        Double descuentoTotal = 0.0;
        Double totalAPagar = 0.0;
        String tipoEntradaReserva = reserva.getTipoEntrada().toString();

        Obra obraElegida = null;

        for (Obra obra : obras){
            if (idReserva == obra.getId()){
                obraElegida = obra;
            }
        }
        if (obraElegida == null){
            return new Respuesta(Estado.RECHAZADA, "La obra seleccionada no existe");
        }

        if (obraElegida.getAsientosDisponibles() < entradasReserva){
            return new Respuesta(Estado.RECHAZADA, "No hay asientos suficientes");
        }

        obraElegida.setAsientosDisponibles(obraElegida.getAsientosDisponibles() - entradasReserva);
        precioUnitario = obraElegida.getPrecio();


        if (tipoEntradaReserva.equals("VIP")){
            precioUnitario *=  1.2;
        }

        subtotal = precioUnitario * entradasReserva;

        if (entradasReserva >= 4){
            descuentoTotal += subtotal * 0.1;
        }

        totalAPagar = subtotal - descuentoTotal;

        if (cuponEntrada.equals("DESCUENTO15")){
            double descuentoCupon = totalAPagar * 0.15;
            descuentoTotal += descuentoCupon;
            totalAPagar -= descuentoCupon;
        }

        return new Respuesta(Estado.CONFIRMADA, clienteReserva, entradasReserva, precioUnitario, subtotal, descuentoTotal, totalAPagar);
    }


    @GetMapping("/cartelera")
    @ResponseBody
    public ArrayList<Obra> mostrarCartelera(@RequestParam(required = false) Double precioMax,
                                            @RequestParam(required = false) Boolean soloDisponibles){
        ArrayList<Obra> obrasFiltro = new ArrayList<>();
        if (precioMax == null){
            precioMax = 0.0;
        }
        if (soloDisponibles == null){
            soloDisponibles = false;
        }

        for (Obra obra : obras){
            boolean pasaFiltro = true;
            if (obra.getPrecio() > precioMax && precioMax != 0.0){
                pasaFiltro = false;
            }
            if (obra.getAsientosDisponibles() <= 0 && soloDisponibles){
                pasaFiltro = false;
            }
            if (pasaFiltro){
                obrasFiltro.add(obra);
            }

        }

        return obrasFiltro;
    }
}

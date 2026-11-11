package otravez.actividad1.models;

import otravez.actividad1.enums.Zona;

public class Reserva {
    private Integer eventoId;
    private String nombreCliente;
    private Zona tipoEntrada;
    private Integer cantidad;
    private String codigoCupon;

    public Reserva() {
    }

    public Integer getEventoId() {
        return eventoId;
    }

    public void setEventoId(Integer eventoId) {
        this.eventoId = eventoId;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public Zona getTipoEntrada() {
        return tipoEntrada;
    }

    public void setTipoEntrada(Zona tipoEntrada) {
        this.tipoEntrada = tipoEntrada;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getCodigoCupon() {
        return codigoCupon;
    }

    public void setCodigoCupon(String codigoCupon) {
        this.codigoCupon = codigoCupon;
    }
}

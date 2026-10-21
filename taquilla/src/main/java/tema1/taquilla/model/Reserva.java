package tema1.taquilla.model;


public class Reserva {
    public enum Zona{
        GENERAL, VIP
    }

    private String eventoId;
    private String nombreCliente;
    private Zona tipoEntrada;
    private Integer entradas;
    private String cupon;

    public Reserva() {
    }

    public String getEventoId() {
        return eventoId;
    }

    public void setEventoId(String eventoId) {
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

    public Integer getEntradas() {
        return entradas;
    }

    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    public String getCupon() {
        return cupon;
    }

    public void setCupon(String cupon) {
        this.cupon = cupon;
    }
}

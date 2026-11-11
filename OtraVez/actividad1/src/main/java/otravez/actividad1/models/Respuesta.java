package otravez.actividad1.models;

import otravez.actividad1.enums.Estado;

public class Respuesta {
    private Estado estado;
    private String cliente;
    private Integer entradas;
    private Double precioUnitario;
    private Double subtotal;
    private Double descuentoTotal;
    private Double totalAPagar;
    private String motivo;

    public Respuesta() {
    }

    public Respuesta(Estado estado, String cliente, Integer entradas, Double precioUnitario, Double subtotal, Double descuentoTotal, Double totalAPagar) {
        this.estado = estado;
        this.cliente = cliente;
        this.entradas = entradas;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.descuentoTotal = descuentoTotal;
        this.totalAPagar = totalAPagar;
    }

    public Respuesta(Estado estado, String motivo) {
        this.estado = estado;
        this.motivo = motivo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public Integer getEntradas() {
        return entradas;
    }

    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(Double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public Double getTotalAPagar() {
        return totalAPagar;
    }

    public void setTotalAPagar(Double totalAPagar) {
        this.totalAPagar = totalAPagar;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }
}

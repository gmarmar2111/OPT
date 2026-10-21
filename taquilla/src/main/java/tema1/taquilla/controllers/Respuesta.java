package tema1.taquilla.controllers;

public class Respuesta {
    private String estado;
    private String cliente;
    private Integer entradas;
    private Double precioUnitario;
    private Double subtotal;
    private Double descuentoTotal;
    private Double totalAPagar;
    private String motivo;

    public Respuesta() {
    }

    public Respuesta(String estado, String cliente, Integer entradas, Double precioUnitario, Double subtotal, Double totalAPagar, Double descuentoTotal) {
        this.estado = estado;
        this.cliente = cliente;
        this.entradas = entradas;
        this.precioUnitario = precioUnitario;
        this.subtotal = subtotal;
        this.totalAPagar = totalAPagar;
        this.descuentoTotal = descuentoTotal;
    }

    public Respuesta(String estado, String motivo) {
        this.estado = estado;
        this.motivo = motivo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
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

    public Double getDescuentoTotal() {
        return descuentoTotal;
    }

    public void setDescuentoTotal(Double descuentoTotal) {
        this.descuentoTotal = descuentoTotal;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getEntradas() {
        return entradas;
    }

    public void setEntradas(Integer entradas) {
        this.entradas = entradas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
}

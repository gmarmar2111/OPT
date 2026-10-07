package prueba.prueba;

public class Direccion {
    private String calle;
    private Integer numero;

    public Direccion(Integer numero, String calle) {
        this.numero = numero;
        this.calle = calle;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }
}

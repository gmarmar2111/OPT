package tema1.biblioteca.models;

public class Prestamo {
    private Integer libroId;
    private String nombreSocio;
    private Integer diasPrestamo;
    private Boolean carnetPremium;

    public Prestamo() {
    }

    public Integer getLibroId() {
        return libroId;
    }

    public void setLibroId(Integer libroId) {
        this.libroId = libroId;
    }

    public String getNombreSocio() {
        return nombreSocio;
    }

    public void setNombreSocio(String nombreSocio) {
        this.nombreSocio = nombreSocio;
    }

    public Integer getDiasPrestamo() {
        return diasPrestamo;
    }

    public void setDiasPrestamo(Integer diasPrestamo) {
        this.diasPrestamo = diasPrestamo;
    }

    public Boolean getCarnetPremium() {
        return carnetPremium;
    }

    public void setCarnetPremium(Boolean carnetPremium) {
        this.carnetPremium = carnetPremium;
    }
}

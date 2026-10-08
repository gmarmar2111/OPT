package prueba.prueba;

import java.lang.reflect.Array;

public class Persona {
    private String nombre;
    private Integer edad;
    private Boolean esEstudiante;
    private Array hobbies;
    private Direccion direccion;

    public Persona(String nombre, Direccion direccion, Array hobbies, Boolean esEstudiante, Integer edad) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.hobbies = hobbies;
        this.esEstudiante = esEstudiante;
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public Boolean getEsEstudiante() {
        return esEstudiante;
    }

    public void setEsEstudiante(Boolean esEstudiante) {
        this.esEstudiante = esEstudiante;
    }

    public Array getHobbies() {
        return hobbies;
    }

    public void setHobbies(Array hobbies) {
        this.hobbies = hobbies;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
}

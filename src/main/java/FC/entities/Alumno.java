package FC.entities;

import java.util.ArrayList;
import java.util.List;

public class Alumno {

    private String nombre;
    private String ciudad;
    private String pais;
    private String email;
    private String telefono;
    private String precensialidad;
    private boolean traslado;

    List<Etiqueta> etiquetas = new ArrayList<>();

    public List<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(List<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Alumno(){}

    public void setName(String nombre) {
        this.nombre = nombre;
    }

    public void setCity(String ciudad) {
        this.ciudad = ciudad;
    }

    public void setCountry(String pais) {
        this.pais = pais;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTel(String telefono) {
        this.telefono = telefono;
    }

    public void setPresenciality(String precensialidad) {
        this.precensialidad = precensialidad;
    }

    public void setTraslate(boolean traslado) {
        this.traslado = traslado;
    }


    @Override
    public String toString() {
        return "Alumno{" +
                "nombre='" + nombre + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", pais='" + pais + '\'' +
                ", email='" + email + '\'' +
                ", telefono='" + telefono + '\'' +
                ", precensialidad='" + precensialidad + '\'' +
                ", traslado=" + traslado +
                ", etiquetas=" + etiquetas +
                '}';
    }
}



package dgtic.modelo;

import java.util.ArrayList;
import java.util.List;

public class Profesor {

    private String nombre;
    private List<Responsabilidades> responsabilidades = new ArrayList<>();

    public Profesor() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Responsabilidades> getResponsabilidades() {
        return responsabilidades;
    }

    //public void setResponsabilidades(List<Responsabilidades> responsabilidades) {
        //this.responsabilidades = responsabilidades;
    //}
}

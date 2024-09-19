package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.Collection;

public class Empleado {

    private String nombre;
    private Integer edad;
    private ArrayList<Actividades> actividades;

    public Empleado() {}

    public Empleado(String nombre) {
        this.nombre = nombre;
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

    public ArrayList<Actividades> getActividades() {
        return actividades;
    }

    public void setActividades(ArrayList<Actividades> actividades) {
        this.actividades = actividades;
    }

    @Override
    public String toString() {
        return "Empleado{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", actividades=" + actividades +
                '}';
    }

}

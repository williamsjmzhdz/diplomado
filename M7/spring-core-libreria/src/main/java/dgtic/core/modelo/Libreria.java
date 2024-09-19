package dgtic.core.modelo;

import java.util.ArrayList;

public class Libreria {

    private String nombre;
    private String correoElectronico;
    private ArrayList<Libro> libros = new ArrayList<>();

    public Libreria() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return "Libreria{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                '}';
    }
}

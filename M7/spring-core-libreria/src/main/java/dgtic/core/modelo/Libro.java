package dgtic.core.modelo;

public class Libro {

    private String nombre;
    private Double precio;
    private Autor autor;

    public Libro() {}

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", autor=" + autor +
                '}';
    }
}

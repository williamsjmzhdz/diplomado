package M8E1.datos;

import jakarta.persistence.*;
import java.util.Objects;


/**
 * Alumno: FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
 * Asignación: Ejercicio 1
 * Fecha de realización: 24/09/2024
 */
@Entity
@Table(name = "Marcas")
public class Marca {

    @Id
    @Column(name = "marca_id")
    private Integer marcaId;
    private String nombre;

    public Marca() {
    }

    public Marca(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public Marca(Integer marcaId, String nombre) {
        this.marcaId = marcaId;
        this.nombre = nombre;
    }

    public Integer getMarcaId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Marca{" +
                "marcaId=" + marcaId +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca = (Marca) o;
        return Objects.equals(marcaId, marca.marcaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marcaId);
    }
}


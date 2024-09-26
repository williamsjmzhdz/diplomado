package M8E1.datos;

import jakarta.persistence.*;
import java.util.Objects;


/**
 * Alumno: FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
 * Asignación: Ejercicio 1
 * Fecha de realización: 24/09/2024
 */
@Entity
@Table(name = "Categorias")
public class Categoria {

    @Id
    @Column(name = "categoria_id")
    private Integer categoriaId;
    private String nombre;

    public Categoria() {
    }

    public Categoria(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Categoria(Integer categoriaId, String nombre) {
        this.categoriaId = categoriaId;
        this.nombre = nombre;
    }

    public Integer getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Categoria{" +
                "categoriaId=" + categoriaId +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return Objects.equals(categoriaId, categoria.categoriaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoriaId);
    }
}

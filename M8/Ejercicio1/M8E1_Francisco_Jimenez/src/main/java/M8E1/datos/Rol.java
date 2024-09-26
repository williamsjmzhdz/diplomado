package M8E1.datos;

import jakarta.persistence.*;
import java.util.Objects;


/**
 * Alumno: FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
 * Asignación: Ejercicio 1
 * Fecha de realización: 24/09/2024
 */
@Entity
@Table(name = "Roles")
public class Rol {

    @Id
    @Column(name = "rol_id")
    private Integer rolId;
    private String nombre;
    private String descripcion;

    public Rol() {
    }

    public Rol(Integer rolId) {
        this.rolId = rolId;
    }

    public Rol(Integer rolId, String nombre, String descripcion) {
        this.rolId = rolId;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getRolId() {
        return rolId;
    }

    public void setRolId(Integer rolId) {
        this.rolId = rolId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "rolId=" + rolId +
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(rolId, rol.rolId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rolId);
    }
}

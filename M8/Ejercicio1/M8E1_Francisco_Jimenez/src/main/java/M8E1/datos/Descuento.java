package M8E1.datos;

import jakarta.persistence.*;
import java.util.Objects;


/**
 * Alumno: FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
 * Asignación: Ejercicio 1
 * Fecha de realización: 24/09/2024
 */
@Entity
@Table(name = "Descuentos")
public class Descuento {

    @Id
    @Column(name = "descuento_id")
    private Integer descuentoId;
    private Integer porcentaje;
    private String nombre;

    public Descuento() {
    }

    public Descuento(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Descuento(Integer descuentoId, Integer porcentaje, String nombre) {
        this.descuentoId = descuentoId;
        this.porcentaje = porcentaje;
        this.nombre = nombre;
    }

    public Integer getDescuentoId() {
        return descuentoId;
    }

    public void setDescuentoId(Integer descuentoId) {
        this.descuentoId = descuentoId;
    }

    public Integer getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(Integer porcentaje) {
        this.porcentaje = porcentaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Descuento{" +
                "descuentoId=" + descuentoId +
                ", porcentaje=" + porcentaje +
                ", nombre='" + nombre + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Descuento descuento = (Descuento) o;
        return Objects.equals(descuentoId, descuento.descuentoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(descuentoId);
    }
}


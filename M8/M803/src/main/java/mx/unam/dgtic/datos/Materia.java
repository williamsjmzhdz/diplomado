package mx.unam.dgtic.datos;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * Autor: Jiménez Hernández Francisco Williams
 * Fecha de realización: 28 de septiembre de 2024
 */
@Entity
@Table(name = "materia")

@NamedQuery(
        name = "Materia.buscarPorCreditosMayores",
        query = "SELECT m FROM Materia m WHERE m.creditos >= :creditos"
)
@NamedQuery(
        name = "Materia.buscarPorHoras",
        query = "SELECT m FROM Materia m WHERE m.horas = :horas"
)
@NamedQuery(
        name = "Materia.buscarPorMateriaContiene",
        query = "SELECT m FROM Materia m WHERE m.materia LIKE CONCAT('%', :nombre, '%')"
)

@NamedNativeQuery(
        name = "Materia.buscarMateriasConMasHorasPromedio",
        query = "SELECT * FROM materia WHERE horas > (SELECT AVG(horas) FROM materia)",
        resultClass = Materia.class
)
@NamedNativeQuery(
        name = "Materia.contarMateriasPorCreditos",
        query = "SELECT COUNT(*) FROM materia WHERE creditos = :creditos"
)

public class Materia {

    @Id
    @Column(name = "clave_materia")
    private String claveMateria;
    private String materia;
    private int creditos;
    private int horas;

    public Materia() {}

    public Materia(String claveMateria, String materia, int creditos, int horas) {
        this.claveMateria = claveMateria;
        this.materia = materia;
        this.creditos = creditos;
        this.horas = horas;
    }

    // Getters y setters

    public String getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public int getHoras() {
        return horas;
    }

    public void setHoras(int horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "claveMateria='" + claveMateria + '\'' +
                ", materia='" + materia + '\'' +
                ", creditos=" + creditos +
                ", horas=" + horas +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Materia materia1 = (Materia) o;
        return claveMateria.equals(materia1.claveMateria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(claveMateria);
    }
}

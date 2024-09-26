package mx.unam.dgtic.datos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Objects;

// FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
@Entity
public class Materia {

    @Id
    @Column(name = "clave_materia")
    private String claveMateria;
    private String materia;
    private Integer creditos;
    private Integer horas;

    public Materia() {
    }

    public Materia(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public Materia(String claveMateria, String materia, Integer creditos, Integer horas) {
        this.claveMateria = claveMateria;
        this.materia = materia;
        this.creditos = creditos;
        this.horas = horas;
    }

    public String getClaveMateria() {
        return claveMateria;
    }

    public void setClaveMateria(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    public Integer getCreditos() {
        return creditos;
    }

    public void setCreditos(Integer creditos) {
        this.creditos = creditos;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
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
        if (!(o instanceof Materia materia1)) return false;
        return Objects.equals(getClaveMateria(), materia1.getClaveMateria()) && Objects.equals(getMateria(), materia1.getMateria()) && Objects.equals(getCreditos(), materia1.getCreditos()) && Objects.equals(getHoras(), materia1.getHoras());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClaveMateria(), getMateria(), getCreditos(), getHoras());
    }
}

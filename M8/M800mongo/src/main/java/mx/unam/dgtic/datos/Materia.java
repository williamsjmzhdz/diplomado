package mx.unam.dgtic.datos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;
import java.util.Objects;


// FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
@Document(collection = "materias")
public class Materia {

    @Id
    private String id;
    @Field("clave_materia")
    private String claveMateria;
    private String materia;
    private double creditos;
    private double horas;
    private List<Tema> temas;
    private Detalle detalle;

    public Materia() {
    }

    public Materia(String claveMateria) {
        this.claveMateria = claveMateria;
    }

    public Materia(String claveMateria, String materia, double creditos, double horas) {
        this.claveMateria = claveMateria;
        this.materia = materia;
        this.creditos = creditos;
        this.horas = horas;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public double getCreditos() {
        return creditos;
    }

    public void setCreditos(double creditos) {
        this.creditos = creditos;
    }

    public double getHoras() {
        return horas;
    }

    public void setHoras(double horas) {
        this.horas = horas;
    }

    public List<Tema> getTemas() {
        return temas;
    }

    public void setTemas(List<Tema> temas) {
        this.temas = temas;
    }

    public Detalle getDetalle() {
        return detalle;
    }

    public void setDetalle(Detalle detalle) {
        this.detalle = detalle;
    }

    @Override
    public String toString() {
        return "Materia{" +
                "id='" + id + '\'' +
                ", claveMateria='" + claveMateria + '\'' +
                ", materia='" + materia + '\'' +
                ", creditos=" + creditos +
                ", horas=" + horas +
                ", temas=" + temas +
                ", detalle=" + detalle +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Materia materia)) return false;
        return Objects.equals(getId(), materia.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}

package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "Grupos")
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_grupo")
    protected int id;
    protected String grupo;
    @ManyToMany(mappedBy = "grupos")
    private Collection<Alumno> alumnos;

    public Grupo() {
        alumnos = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public Collection<Alumno> getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Collection<Alumno> alumnos) {
        this.alumnos = alumnos;
    }

    public void addAlumno(Alumno alumno) {
        if (!getAlumnos().contains(alumno)) {
            getAlumnos().add(alumno);
        }
        if (!alumno.getGrupos().contains(this)) {
            alumno.getGrupos().add(this);
        }
    }

    public void removeAlumno(Alumno alumno) {
        if (alumnos.contains(alumno)) {
            alumnos.remove(alumno);
            alumno.getGrupos().remove(this);
        }
    }

    public String toString() {
        return "Grupo id: " + getId() + ", grupo: " + getGrupo() +
                " con alumnos " + getAlumnos().size() + " alumnos";
    }
}

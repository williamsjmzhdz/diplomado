package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Alumnos")
@NamedQueries({
        @NamedQuery(name = "Alumno.buscarTodosConCalificaciones",
        query = "SELECT DISTINCT a FROM Alumno a JOIN FETCH a.calificaciones")
})
public class Alumno {

    @Id
    private String matricula;
    private String nombre;
    private String paterno;
    private Date fnac;
    private double estatura;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @OneToMany(mappedBy = "alumno")
    private List<Calificacion> calificaciones = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "Alumnos_Grupos",
            joinColumns = @JoinColumn(name = "matricula", referencedColumnName = "matricula"),
            inverseJoinColumns = @JoinColumn(name = "id_grupo", referencedColumnName = "id_grupo")
    )
    private List<Grupo> grupos = new ArrayList<>();

    public Alumno() {}

    public Alumno(String matricula, String nombre, String paterno, Date fnac, double estatura) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.estatura = estatura;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaterno() {
        return paterno;
    }

    public void setPaterno(String paterno) {
        this.paterno = paterno;
    }

    public Date getFnac() {
        return fnac;
    }

    public void setFnac(Date fnac) {
        this.fnac = fnac;
    }

    public double getEstatura() {
        return estatura;
    }

    public void setEstatura(double estatura) {
        this.estatura = estatura;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public List<Calificacion> getCalificaciones() {
        return calificaciones;
    }

    public void setCalificaciones(List<Calificacion> calificaciones) {
        this.calificaciones = calificaciones;
    }

    public List<Grupo> getGrupos() {
        return grupos;
    }

    public void setGrupos(List<Grupo> grupos) {
        this.grupos = grupos;
    }

    public void addGrupo(Grupo grupo) {
        if (!grupos.contains(grupo)) {
            grupos.add(grupo);
            grupo.addAlumno(this);
        }
    }

    public void removeGrupo(Grupo grupo) {
        if (grupos.contains(grupo)) {
            grupos.remove(grupo);
            grupo.removeAlumno(this);
        }
    }

    @Override
    public String toString() {
        String estadoStr = (getEstado() != null) ? getEstado().getEstado() : "null";
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac=" + fnac +
                ", estatura=" + estatura +
                ", estado=" + estadoStr +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return Objects.equals(getMatricula(), alumno.getMatricula());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getMatricula());
    }
}

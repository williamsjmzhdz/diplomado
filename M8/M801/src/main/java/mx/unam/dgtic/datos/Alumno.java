package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

// FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ

@Entity
@Table(name = "alumnos")
public class Alumno {

    @Id
    private String matricula;
    private String nombre;
    private String paterno;
    private Date fnac;
    private double estatura;

    public Alumno() {
    }

    public Alumno(String matricula) {
        this.matricula = matricula;
    }

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

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac=" + fnac +
                ", estatura=" + estatura +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alumno alumno = (Alumno) o;
        return matricula.equals(alumno.matricula);
    }

    @Override
    public int hashCode() {
        return Objects.hash(matricula);
    }
}

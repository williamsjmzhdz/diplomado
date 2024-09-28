package mx.unam.dgtic.datos;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Objects;

// FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ

@Entity
@Table(name = "alumnos")

@NamedQuery(
        name = "Alumno.buscarAltos",
        query = "SELECT a FROM Alumno a WHERE a.estatura >= 1.70"
)

@NamedQuery(
        name = "Alumno.buscarAltosConFecha",
        query = "SELECT a FROM Alumno a WHERE a.estatura >= 1.70" +
                " AND a.fnac >= :fecha"
)

@NamedQuery(
        name = "Alumno.buscarPorNombre",
        query = "SELECT a FROM Alumno a WHERE a.nombre = ?1"
)

@NamedQuery(
        name = "Alumno.buscarPorNombreYPaterno",
        query = "SELECT a FROM Alumno a WHERE a.nombre = ?1 AND a.paterno = ?2"
)

@NamedQuery(
        name = "Alumno.buscarPorEstadoCurp",
        query = "SELECT a FROM Alumno a WHERE SUBSTRING(a.curp, 12, 2) = :codigoEstado"
)

@NamedQuery(
        name = "Alumno.contarPorEstadoCurp",
        query = "SELECT COUNT(a) FROM Alumno a WHERE SUBSTRING(a.curp, 12, 2) = :codigoEstado"
)

@NamedQuery(
        name = "Alumno.buscarPorCurpContenga",
        query = "SELECT a FROM Alumno a WHERE a.curp LIKE CONCAT('%', :substring, '%')"
)

@NamedQuery(
        name = "Alumno.contarPorCurpContenga",
        query = "SELECT COUNT(a) FROM Alumno a WHERE a.curp LIKE CONCAT('%', :substring, '%')"
)

@NamedQuery(
        name = "Alumno.searchByEstaturaNotBetweenOrderByEstatura",
        query = "SELECT a FROM Alumno a WHERE " +
                "a.estatura NOT BETWEEN :estaturaini AND :estaturafin " +
                "ORDER BY a.estatura ASC"
)

@NamedNativeQuery(
        name = "Alumno.buscarAltosMayorPromedio",
        query = "SELECT * FROM Alumnos " +
                "WHERE estatura >= (SELECT AVG(estatura) FROM Alumnos) " +
                "ORDER BY estatura DESC",
        resultClass = Alumno.class
)
public class Alumno {

    @Id
    private String matricula;
    private String nombre;
    private String paterno;
    private Date fnac;
    private double estatura;
    private String curp;

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

    public Alumno(String matricula, String nombre, String paterno, Date fnac, double estatura, String curp) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.paterno = paterno;
        this.fnac = fnac;
        this.estatura = estatura;
        this.curp = curp;
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

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", paterno='" + paterno + '\'' +
                ", fnac=" + fnac +
                ", estatura=" + estatura +
                ", curp='" + curp + '\'' +
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

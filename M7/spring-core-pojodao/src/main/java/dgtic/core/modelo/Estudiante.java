package dgtic.core.modelo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Estudiante {
    private String matricula;
    private String nombre;
    private Integer edad;
    private List<Materia> materias = new ArrayList<>();

    public Estudiante(String matricula, String nombre, Integer edad) {
        this.matricula = matricula;
        this.nombre = nombre;
        this.edad = edad;
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

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<Materia> getMaterias() {
        return materias;
    }

    public void setMaterias(Materia ... materias) {
        this.materias = Arrays.asList(materias);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "matricula='" + matricula + '\'' +
                ", nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", materias=" + materias +
                '}';
    }
}

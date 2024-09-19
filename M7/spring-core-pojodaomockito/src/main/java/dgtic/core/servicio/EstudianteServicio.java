package dgtic.core.servicio;

import dgtic.core.modelo.Estudiante;

import java.util.List;

public interface EstudianteServicio {
    public List<Estudiante> findAll();
    public Estudiante findById(String matricula);
    public String archivoCSV(String matricula);
    public int creditos(String matricula);
}

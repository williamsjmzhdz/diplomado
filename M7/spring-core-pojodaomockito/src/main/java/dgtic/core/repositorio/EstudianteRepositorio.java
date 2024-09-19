package dgtic.core.repositorio;

import dgtic.core.modelo.Estudiante;

import java.util.List;

public interface EstudianteRepositorio {
    public List<Estudiante> findAll();
    public Estudiante findById(String matricula);
    public void save(Estudiante estudiante);
}

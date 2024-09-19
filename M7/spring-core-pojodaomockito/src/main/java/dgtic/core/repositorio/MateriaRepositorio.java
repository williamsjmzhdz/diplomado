package dgtic.core.repositorio;

import dgtic.core.modelo.Materia;

import java.util.List;

public interface MateriaRepositorio {
    public List<Materia> findAll();
    public Materia findById(Long id);
    public void save(Materia materia);
}

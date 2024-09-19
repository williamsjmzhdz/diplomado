package dgtic.core.repositorio.impl;

import dgtic.core.modelo.Estudiante;
import dgtic.core.repositorio.BaseDeDatos;
import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("baseDeDatosDAOExtra")
public class BaseDeDatosExtraDAOImpl implements BaseDeDatosDAO {

    @Override
    public List<Estudiante> getEstudiantes(String carrera) {
        return BaseDeDatos.carreras.get(carrera);
    }

    @Override
    public Estudiante getEstudiante(String carrera, String matricula) {
        return BaseDeDatos.carreras.get(carrera).stream()
                .filter(estudiante -> estudiante.getMatricula().equals(matricula))
                .findFirst()
                .orElse(null);
    }
}

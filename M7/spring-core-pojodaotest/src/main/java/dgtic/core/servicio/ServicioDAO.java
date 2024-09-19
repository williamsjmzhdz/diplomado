package dgtic.core.servicio;

import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ServicioDAO {

    @Autowired
    @Qualifier("baseDeDatosDAOExtra")
    private BaseDeDatosDAO baseDeDatosDAO;

    /*
    @Autowired
    public ServicioDAO(@Qualifier("baseDeDatosDAOExtra") BaseDeDatosDAO baseDeDatosDAO) {
        this.baseDeDatosDAO = baseDeDatosDAO;
    }
    */

    public BaseDeDatosDAO getBaseDeDatosDAO() {
        return baseDeDatosDAO;
    }

    //@Autowired(required = false) // Si no encuentra un bean, puede poner un null
    public void setBaseDeDatosDAO(/*@Qualifier("baseDeDatosDAOExtra")*/ BaseDeDatosDAO baseDeDatosDAO) {
        this.baseDeDatosDAO = baseDeDatosDAO;
    }

    public String archivoCSV(String carrera) {
        // Generamos un CSV de estudiantes y sus materias
        return baseDeDatosDAO.getEstudiantes(carrera).stream()
                .map(alm ->
                        alm.getMatricula() + ";" + alm.getNombre() + ";" +
                                alm.getMaterias().stream()
                                        .map(mat -> mat.getNombre() + ";" + mat.getCreditos())
                                        .collect(Collectors.joining(","))
                )
                .collect(Collectors.joining("\n"));
    }
}

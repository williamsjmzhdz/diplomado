package dgtic.core.config;

import dgtic.core.modelo.Estudiante;
import org.springframework.context.annotation.*;

@Configuration
public class ConfiguracionServicioDos {

    @Bean(name = "estudianteTres")
    @Scope("prototype")
    public Estudiante servicioEstudiante() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Rebeca");
        estudiante.setEdad(44);
        return estudiante;
    }

}

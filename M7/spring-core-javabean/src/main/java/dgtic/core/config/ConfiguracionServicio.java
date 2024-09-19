package dgtic.core.config;

import dgtic.core.modelo.Estudiante;
import org.springframework.context.annotation.*;

@Configuration
@ImportResource(locations = {"classpath:bean-configuration.xml",
        "classpath:bean-services.xml"})
//@ComponentScan(basePackages = "dgtic.core")
@Import({ConfiguracionServicioDos.class})
public class ConfiguracionServicio {

    @Bean(name = "estudiante")
    @Scope("prototype")
    public Estudiante servicioEstudiante() {
        Estudiante estudiante = new Estudiante();
        estudiante.setNombre("Pedro");
        estudiante.setEdad(34);
        return estudiante;
    }

}

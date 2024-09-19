package dgtic.core.inicio;

import dgtic.core.config.ConfiguracionServicio;
import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InicioTres {

    public static void main(String[] args) {

        // Carga el contexto de Spring con base en la clase de configuración
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(ConfiguracionServicio.class);

        // Obtiene el bean de nombre "estudiante" definido en la clase de configuración
        Estudiante estudiante = context.getBean("estudiante", Estudiante.class);

        // Obtiene de nuevo el bean de nombre "estudiante"
        Estudiante estudianteDos = context.getBean("estudiante", Estudiante.class);

        // Muestra el bean en consola
        System.out.println(estudiante);
        System.out.println(estudianteDos);

        // Cambia el nombre del estudiante
        estudiante.setNombre("Raúl");

        // Vuelve a mostrar el bean en consola
        System.out.println(estudiante);
        System.out.println(estudianteDos);

        System.out.println("----------");

        // Obtiene el bean de nombre "materia" definido en el archivo XML
        Materia materia = context.getBean("materia", Materia.class);
        System.out.println(materia);

        // Cierra el contexto de Spring
        context.close();

    }
}

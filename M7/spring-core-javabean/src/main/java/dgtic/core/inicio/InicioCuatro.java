package dgtic.core.inicio;

import dgtic.core.config.ConfiguracionServicio;
import dgtic.core.modelo.Estudiante;
import dgtic.core.modelo.Materia;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class InicioCuatro {

    public static void main(String[] args) {

        // Carga el contexto de Spring con base en la clase de configuración
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(ConfiguracionServicio.class);

        Estudiante estudiante = context.getBean("estudiante", Estudiante.class);
        Estudiante estudianteDos = context.getBean("estudiante", Estudiante.class);
        Estudiante estudianteTres = context.getBean("estudianteTres", Estudiante.class);

        System.out.println(estudiante);
        System.out.println(estudianteDos);
        System.out.println(estudianteTres);
        System.out.println("----------");
        estudiante.setNombre("Raúl");
        System.out.println(estudiante);
        System.out.println(estudianteDos);
        System.out.println("----------");

        Materia materia = context.getBean("materia", Materia.class);
        Materia materiaDos = context.getBean("materiaDos", Materia.class);
        System.out.println(materia);
        System.out.println(materiaDos);

        // Cierra el contexto de Spring
        context.close();

    }
}

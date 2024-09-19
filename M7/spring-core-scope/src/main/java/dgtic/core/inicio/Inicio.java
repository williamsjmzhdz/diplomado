package dgtic.core.inicio;

import dgtic.core.modelo.*;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {

    public static void main(String[] args) {

        // Cargar el contexto de Spring desde el archivo de configuración XML
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{
                        "bean-configuration.xml",
                        "bean-services.xml"
                }
        );

        Persona persona = context.getBean("persona", Persona.class);
        System.out.println(persona);
        persona.setNombre("Tomás");
        System.out.println(persona);
        try {
            persona.getCoche().getModeloCoche(TipoCarro.FAMILIAR).crear();
            persona.getCoche().getModeloCoche(TipoCarro.DEPORTIVO).crear();
            System.out.println("===================");
            Persona personaDos = context.getBean("persona", Persona.class);
            System.out.println(personaDos);
        } catch (IllegalAccessException e) {
            System.out.println(e.getMessage());
        }

        // Cerrar el contexto de Spring
        ((ClassPathXmlApplicationContext) context).close();



    }
}

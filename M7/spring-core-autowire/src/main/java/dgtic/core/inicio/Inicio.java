package dgtic.core.inicio;

import dgtic.core.modelo.*;
import org.springframework.beans.factory.UnsatisfiedDependencyException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {

    public static void main(String[] args) {

        try {

            // Cargar el contexto de Spring desde el archivo de configuración XML
            ApplicationContext context = new ClassPathXmlApplicationContext("bean-configuration.xml");

            // Obtener y mostrar el primer empleado
            Empleado empleado = context.getBean("empleado", Empleado.class);
            System.out.println(empleado);

            if (empleado.getActividad() != null) {
                empleado.getActividad().realiza();
            } else {
                System.out.println("No se encontró un bean válido para inyectar.");
                System.out.println(empleado);
            }

            // Cerrar el contexto de Spring
            ((ClassPathXmlApplicationContext) context).close();

        } catch (UnsatisfiedDependencyException e) {

            System.out.println("Error de dependencia.");

        }

    }
}

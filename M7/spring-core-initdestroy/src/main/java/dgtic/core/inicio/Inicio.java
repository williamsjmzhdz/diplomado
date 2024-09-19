package dgtic.core.inicio;

import dgtic.core.modelo.*;
import dgtic.core.servicio.Servicio;
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

        Empleado emp = context.getBean("empleado", Empleado.class);
        emp.limpiar();
        System.out.println("----------");
        Servicio servicio = context.getBean("servicio", Servicio.class);
        servicio.getEmpleado().limpiar();

        // Cerrar el contexto de Spring
        ((ClassPathXmlApplicationContext) context).close();

    }
}

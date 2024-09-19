package dgtic.core.inicio;

import dgtic.core.modelo.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;

public class Inicio {

    public static void main(String[] args) {

        // Cargar el contexto de Spring desde el archivo de configuración XML
        ApplicationContext context = new ClassPathXmlApplicationContext("bean-configuration.xml");

        // Obtener y mostrar el primer empleado
        Empleado empleado = context.getBean("empleado", Empleado.class);
        System.out.println(empleado);

        // Modificar y mostrar las actividades del empleado
        ((PlanificacionProyectos) empleado.getActividades().get(2)).setNumeroProyectos(20);
        ((PlanificacionProyectos) empleado.getActividades().get(3)).setNumeroProyectos(1);
        System.out.println(((PlanificacionProyectos) empleado.getActividades().get(2)).getNumeroProyectos());
        System.out.println(((PlanificacionProyectos) empleado.getActividades().get(3)).getNumeroProyectos());

        // Realizar actividades del primer empleado
        for (Actividades actividad : empleado.getActividades()) {
            actividad.realiza();
        }

        System.out.println("====================================");

        // Obtener y mostrar las actividades del segundo empleado
        EmpleadoS empleadoDos = context.getBean("empleadoDos", EmpleadoS.class);
        for (Actividades actividad : empleadoDos.getActividades()) {
            actividad.realiza();
        }

        System.out.println("====================================");

        // Obtener y mostrar las actividades del tercer empleado usando llaves
        EmpleadoM empleadoTres = context.getBean("empleadoTres", EmpleadoM.class);
        for (String llave : empleadoTres.getActividades().keySet()) {
            System.out.println("Llave: " + llave);
            empleadoTres.getActividades().get(llave).realiza();
        }

        System.out.println("====================================");

        // Obtener y mostrar las actividades del cuarto empleado usando Iterator
        EmpleadoP empleadoCuatro = context.getBean("empleadoCuatro", EmpleadoP.class);
        Iterator<Object> iterator = empleadoCuatro.getActividades().keySet().iterator();
        while (iterator.hasNext()) {
            String llave = (String) iterator.next();
            System.out.println("Llave: " + llave);
            System.out.println(empleadoCuatro.getActividades().get(llave));
        }

        // Cerrar el contexto de Spring
        ((ClassPathXmlApplicationContext) context).close();
    }
}

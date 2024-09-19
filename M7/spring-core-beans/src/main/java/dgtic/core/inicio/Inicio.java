package dgtic.core.inicio;

import dgtic.core.modelo.Empleado;
import dgtic.core.modelo.PlanificacionProyectos;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Inicio {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {
                        "bean-configuration.xml"
                }
        );

        Empleado empleado = context.getBean("empleado", Empleado.class);
        System.out.println(empleado);
        empleado.getActividad().realiza();

        System.out.println("=================================");


        Empleado empleadoDos = context.getBean("empleadoDos", Empleado.class);
        empleadoDos.getActividad().realiza();

        System.out.println("=================================");


        Empleado empleadoTres = context.getBean("empleadoTres", Empleado.class);
        ((PlanificacionProyectos) empleadoTres.getActividad()).setNumeroProyectos(20);
        System.out.println(((PlanificacionProyectos) empleadoTres.getActividad()).getNumeroProyectos());

        System.out.println("=================================");


        Empleado empleadoCuatro = context.getBean("empleadoCuatro", Empleado.class);
        ((PlanificacionProyectos) empleadoCuatro.getActividad()).setNumeroProyectos(3);
        System.out.println(((PlanificacionProyectos) empleadoCuatro.getActividad()).getNumeroProyectos());

        System.out.println("=================================");

        ((PlanificacionProyectos) empleadoTres.getActividad()).setNumeroProyectos(-1);
        ((PlanificacionProyectos) empleadoCuatro.getActividad()).setNumeroProyectos(90);
        System.out.println(((PlanificacionProyectos) empleadoTres.getActividad()).getNumeroProyectos());
        System.out.println(((PlanificacionProyectos) empleadoCuatro.getActividad()).getNumeroProyectos());


        ((ClassPathXmlApplicationContext) context).close();

    }

}

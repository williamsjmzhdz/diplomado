package dgtic.core.inicio;

import dgtic.core.modelo.Persona;
import dgtic.core.servicio.Servicio;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Inicio {

    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] {
                        "bean-configuration.xml",
                        "bean-services.xml"
                }
        );

        Servicio servicio = (Servicio) context.getBean("servicio");
        servicio.getPersona().setNombre("Williams");
        servicio.getPersona().setEdad(26);

        System.out.println(servicio.toString());
        ((ClassPathXmlApplicationContext) context).close();

    }

}

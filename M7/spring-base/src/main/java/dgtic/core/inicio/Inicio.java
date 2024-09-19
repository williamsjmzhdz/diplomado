package dgtic.core.inicio;

import dgtic.core.modelo.Persona;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class Inicio {

    public static void main(String[] args) {

        final Resource resource = new ClassPathResource("bean-configuration.xml");
        final DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        final XmlBeanDefinitionReader xml = new XmlBeanDefinitionReader(beanFactory);
        xml.loadBeanDefinitions(resource);
        Persona persona = (Persona) beanFactory.getBean("persona");
        System.out.println(persona);

    }

}

package dgtic.core.inicio;

import dgtic.core.config.ConfiguracionServicio;
import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libreria;
import dgtic.core.modelo.Libro;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Inicio {

    public static void main(String[] args) {

        // Carga el contexto de Spring con base en la clase de configuración
        ConfigurableApplicationContext context =
                new AnnotationConfigApplicationContext(ConfiguracionServicio.class);

        Libreria libreria = context.getBean("libreria", Libreria.class);
        Libro libroUno = context.getBean("libro", Libro.class);
        libreria.getLibros().add(libroUno);
        System.out.println(libreria);
        System.out.println(libreria.getLibros().get(0));
        System.out.println(libreria.getLibros().get(0).getAutor());
        System.out.println("----------");
        Libro libroDos = context.getBean("libro", Libro.class);
        Autor autorDos = context.getBean("autor", Autor.class);
        autorDos.setNombre("Daniel");
        libroDos.setAutor(autorDos);
        System.out.println(libroDos);
        autorDos.setNombre("Tomás");
        System.out.println(libroDos);

        // Cierra el contexto de Spring
        context.close();

    }
}

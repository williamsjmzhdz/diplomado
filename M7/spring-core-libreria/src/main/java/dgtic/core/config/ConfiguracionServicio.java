package dgtic.core.config;

import dgtic.core.modelo.Autor;
import dgtic.core.modelo.Libreria;
import dgtic.core.modelo.Libro;
import org.springframework.context.annotation.*;

@Configuration
public class ConfiguracionServicio {

    @Bean(name = "autor")
    @Scope("prototype")
    public Autor getAutor() {
        Autor autor = new Autor();
        autor.setNombre("Sin nombre");
        autor.setApellidoPaterno("Sin apellido");
        autor.setCelular("000000");
        return autor;
    }

    @Bean(name = "libro")
    @Scope("prototype")
    public Libro getLibro() {
        Libro libro = new Libro();
        libro.setNombre("Ciencia");
        libro.setPrecio(0.0);
        libro.setAutor(getAutor());
        return libro;
    }

    @Bean(name = "libreria")
    public Libreria getLibreria() {
        Libreria libreria = new Libreria();
        libreria.setNombre("El Sótano");
        libreria.setCorreoElectronico("elsotano@demo.com");
        return libreria;
    }

}

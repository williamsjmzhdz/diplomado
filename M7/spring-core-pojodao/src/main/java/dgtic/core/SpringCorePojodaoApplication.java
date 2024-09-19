package dgtic.core;

import dgtic.core.repositorio.intf.BaseDeDatosDAO;
import dgtic.core.servicio.ServicioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringCorePojodaoApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("baseDeDatosDAO")
	private BaseDeDatosDAO base;

	@Autowired
	private ServicioDAO servicioDAO;

	public static void main(String[] args) {
		SpringApplication.run(SpringCorePojodaoApplication.class, args);
	}



	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando...");
		System.out.println(base.getEstudiante("ime", "126"));
		System.out.println(base.getEstudiantes("ico"));
		System.out.println("----------");
		System.out.println(servicioDAO.archivoCSV("ico"));
	}
}

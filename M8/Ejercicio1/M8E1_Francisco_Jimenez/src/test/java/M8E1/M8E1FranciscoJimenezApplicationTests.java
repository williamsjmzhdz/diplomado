package M8E1;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


/**
 * Alumno: FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ
 * Asignación: Ejercicio 1
 * Fecha de realización: 24/09/2024
 */
@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
class M8E1FranciscoJimenezApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ");
		System.out.println("Carga de esquema y datos.");
	}

}

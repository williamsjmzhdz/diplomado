package com.bazarboost;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;


/*
 * Alumno: Francisco Williams Jiménez Hernández
 * Proyecto: Bazarboost
 * */
@SpringBootTest
@Sql({"/schema.sql", "/data.sql"})
class BazarboostApplicationTests {

	@Test
	void contextLoads() {
		System.out.println("FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ");
		System.out.println("Carga de esquema y datos.");
	}

}

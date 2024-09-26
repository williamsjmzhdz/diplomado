package mx.unam.dgtic;

import mx.unam.dgtic.datos.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class M800ApplicationMateriaTests {

	final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
	final String ID = "FWJ-19980514";
	final String CLAVE_MATERIA = "FWJH";

	@Autowired
	MateriaRepository repositorioMateria;

	@Autowired
	MongoTemplate mongoTemplate;

	@Test
	void buscarTodasMateriasTest() {
		System.out.println(ALUMNO);
		System.out.println("Buscar todas las materias en MongoDB");
		System.out.println("Total de materias: " + repositorioMateria.count() + " en la base MongoDB");
		repositorioMateria.findAll().forEach(System.out::println);
	}

	@Test
	void insertarMateriaTest() {
		System.out.println(ALUMNO);
		System.out.println("Insertar una materia en MongoDB");

		Materia materia = new Materia(
				CLAVE_MATERIA,
				"PERSISTENCIA CON MONGODB",
				10.0,
				3.0
		);

		materia.setId(ID);
		materia.setDetalle(new Detalle("Ciencias de la Computación", 2025.1));
		List<Tema> temas = new ArrayList<>();
		temas.add(new Tema("COLECCIONES", 4.0));
		temas.add(new Tema("DOCUMENTOS", 3.0));
		temas.add(new Tema("MAPEO A JAVA", 3.0));

		materia.setTemas(temas);
		repositorioMateria.save(materia);

		System.out.println("Total de materias: " + repositorioMateria.count() + " en la base MongoDB");
		repositorioMateria.findAll().forEach(System.out::println);
	}

	@Test
	void buscarMateriasPorCriteriosTest() {
		System.out.println(ALUMNO);
		System.out.println("Buscar materias por criterios con MongoTemplate");

		Query query = new Query();
		System.out.println("\nBuscar matería CON CLAVE = " + CLAVE_MATERIA);
		query.addCriteria(Criteria.where("clave_materia").is(CLAVE_MATERIA));
		System.out.println("Materias con clave = " + CLAVE_MATERIA + ":");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

		query = new Query();
		System.out.println("\nBuscar materías CON 10 CRÉDITOS O MÁS");
		query.addCriteria(Criteria.where("creditos").gte(10.0));
		System.out.println("Materias con 10 créditos o más:");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

		query = new Query();
		System.out.println("\nBuscar materías SIN TEMAS");
		query.addCriteria(Criteria.where("temas").exists(false));
		System.out.println("Materias que no tienen temas");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

		query = new Query();
		System.out.println("\nBuscar materías SIN DETALLE");
		query.addCriteria(Criteria.where("detalle").exists(false));
		System.out.println("Materias que no tienen detalle");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

		query = new Query();
		System.out.println("\nBuscar materías CON 65 O MÁS HORAS");
		query.addCriteria(Criteria.where("horas").gte(65.0));
		System.out.println("Materias con 65 horas o más:");
		mongoTemplate.find(query, Materia.class).forEach(System.out::println);

	}

}


/*
1. Insertar varios JPA
2. Eliminar uno JPA
3. Eliminar varios JPA

4. Buscar Todos Mongo
5. Insertar en Mongo
6. Buscar por Criteria Mongo

7. Listar todas las materias
8. Insertar materias
9. Buscar magterias por criterios
*/
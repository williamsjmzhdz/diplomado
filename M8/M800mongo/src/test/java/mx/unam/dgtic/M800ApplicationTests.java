package mx.unam.dgtic;

import mx.unam.dgtic.datos.Alumno;
import mx.unam.dgtic.datos.AlumnoRepository;
import mx.unam.dgtic.datos.Edad;
import mx.unam.dgtic.datos.Evaluacion;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class M800ApplicationTests {

	final String ALUMNO = "FRANCISCO WILLIAMS JIMÉNEZ HERNÁNDEZ";
	final String ID = "19980514";
	final String MATRICULA = "1F";

	@Autowired
	AlumnoRepository repositorioAlumno;

	@Autowired
	MongoTemplate mongoTemplate;

	@Test
	void buscarTodosTest() {
		System.out.println(ALUMNO);
		System.out.println("Buscar todos los alumnos en MongoDB");
		System.out.println("Total de alumnos: " + repositorioAlumno.count() + " en la base MongoDB");
		repositorioAlumno.findAll().forEach(System.out::println);
	}

	@Test
	void buscarUno() {
		System.out.println(ALUMNO);
		System.out.println("Buscar un alumno por ID");

		Optional<Alumno> optional = repositorioAlumno.findById(ID);
		if (optional.isPresent()) {
			Alumno alumno = optional.get();
			System.out.println("Nombre: " + alumno.getNombre());
			System.out.println("Paterno: " + alumno.getPaterno());
			System.out.println("Años: " + alumno.getEdad().getAnios());
			System.out.println("Evaluaciones: ");
			alumno.getEvaluaciones().forEach(evaluacion -> {
				System.out.println(
						evaluacion.getMateria() +
						" " +
						evaluacion.getCalificacion() +
						" " +
						evaluacion.getFecha()
				);
			});

		}
	}

	@Test
	void insertarUnoTest() {
		System.out.println(ALUMNO);
		System.out.println("Insertar Alumno");
		Alumno alumno = new Alumno(
				MATRICULA,
				"WILLIAMS",
				"JIMÉNEZ",
				new Date(),
				1.65
		);
		alumno.setId(ID);
		alumno.setEdad(new Edad(26, 4, 5));
		List<Evaluacion> evaluaciones = new ArrayList<>();
		evaluaciones.add(new Evaluacion("JAVA", 10, new Date()));
		evaluaciones.add(new Evaluacion("SPRING", 9, new Date()));
		evaluaciones.add(new Evaluacion("POO", 8, new Date()));

		alumno.setEvaluaciones(evaluaciones);
		repositorioAlumno.save(alumno);

		System.out.println("Total de alumnos: " + repositorioAlumno.count() + " en la base MongoDB");
		repositorioAlumno.findAll().forEach(System.out::println);
	}

	@Test
	void editarUnoTest() {
		System.out.println(ALUMNO);
		System.out.println("Editar alumno por ID");

		Optional<Alumno> optional = repositorioAlumno.findById(ID);
		if (optional.isPresent()) {
			Alumno alumno = optional.get();
			System.out.println("Alumno antes de la edición");
			System.out.println(alumno);

			alumno.setNombre("FRANCISCO WILLIAMS");
			alumno.setPaterno("JIMÉNEZ HERNÁNDEZ");

			List<Evaluacion> evaluaciones = alumno.getEvaluaciones();
			evaluaciones.add(new Evaluacion("JDBC", 8.0, new Date()));
			alumno.setEvaluaciones(evaluaciones);

			alumno.setEdad(new Edad(48, 12, 12));
			repositorioAlumno.save(alumno);

			System.out.println("Datos después de la edición");
			alumno = repositorioAlumno.findById(ID).get();

			System.out.println("Nombre: " + alumno.getNombre());
			System.out.println("Paterno: " + alumno.getPaterno());
			System.out.println("Años: " + alumno.getEdad().getAnios());
			System.out.println("Evaluaciones: ");
			alumno.getEvaluaciones().forEach(evaluacion -> {
				System.out.println(
						evaluacion.getMateria() +
								" " +
								evaluacion.getCalificacion() +
								" " +
								evaluacion.getFecha()
				);
			});
		}
	}

	@Test
	void insertMongoTemplateTest() {
		System.out.println(ALUMNO);
		System.out.println("Insertar Alumno con MongoTemplate");
		Alumno alumno = new Alumno(
				"MT1",
				"WILLIAMS",
				"JIMÉNEZ",
				new Date(),
				1.65
		);
		mongoTemplate.insert(alumno);
		System.out.println("Total de alumnos: " + repositorioAlumno.count() + " en la base MongoDB");
		repositorioAlumno.findAll().forEach(System.out::println);
	}

	@Test
	void buscarMongoTemplate() {
		System.out.println(ALUMNO);
		System.out.println("Buscar con MongoTemplate");

		Query query = new Query();
		query.addCriteria(Criteria.where("matricula").is("MT1"));
		System.out.println("Alumnos con matrículo MT1");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("estatura").gt(1.75));
		System.out.println("Alumnos con estatura > 1.75");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("evaluaciones.calificacion").lte(8.9));
		System.out.println("Alumnos con alguna calificación <= 8.9");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("edad.anios").lt(25));
		System.out.println("Alumnos menores de 25 años");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("paterno").regex(".*MAR.*", "i"));
		System.out.println("Alumnos que contengan MAR en el paterno");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);

		query = new Query();
		query.addCriteria(Criteria.where("evaluaciones").exists(false));
		System.out.println("Alumnos que no tengan el campo Evaluaciones");
		mongoTemplate.find(query, Alumno.class).forEach(System.out::println);
	}
}

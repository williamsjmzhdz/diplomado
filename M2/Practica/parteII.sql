# CREATE DATABASE practica;
USE practica;


DROP TABLE IF EXISTS calendario;
DROP TABLE IF EXISTS alumnos;
DROP TABLE IF EXISTS cat_curso;
DROP TABLE IF EXISTS cat_actividad;


CREATE TABLE cat_actividad
(
  idActividad		INT NOT NULL PRIMARY KEY,
  actividad			CHAR(15)
);
INSERT INTO cat_actividad VALUES
	(1, 'Estudiante'),
	(2, 'Profesionista'),
	(3, 'Maestro'),
	(4, 'Jubilado');


CREATE TABLE cat_curso
(
  idCurso			INT NOT NULL PRIMARY KEY, 
  curso				varchar(60) NOT NULL UNIQUE,
  objetivo			varchar(300) NOT NULL,
  horas				smallint	NOT NULL DEFAULT 30,
  precioPublico		smallint	NOT NULL DEFAULT 3000,
  pagoInstructor	smallint	NOT NULL DEFAULT 1000
);
INSERT INTO cat_curso VALUES (1, 'Introducción a la programación', 'Aprender a programar con C', 20, 4070, 1000);
INSERT INTO cat_curso VALUES (2, 'Python', 'Aprender a usar Python desde cero', 30, 5070, 2000);
INSERT INTO cat_curso VALUES (3, 'JavaScript Básico', 'Insertar código JS en Html', 20, 3070, 3000);
INSERT INTO cat_curso VALUES (4, 'JavaScript Avanzado', 'Extraer datos', 40, 5000, 4000);
INSERT INTO cat_curso VALUES (5, 'HTML', 'Aprender a realiza páginas web', 15, 3000, 1000);

CREATE TABLE alumnos
(
  boleta			INT NOT NULL PRIMARY KEY, 
  nombre			varchar(60),
  primerApellido	varchar(60),
  segundoApellido	varchar(60),
  RFC				char(13),
  fechaNacimiento	date,
  idActividad		int NOT NULL,
  cursosTomados		smallint NOT NULL DEFAULT 0,
  CONSTRAINT UQ_nombre UNIQUE (nombre, primerApellido, segundoApellido),
  CONSTRAINT FK_actividad FOREIGN KEY (idActividad) REFERENCES cat_actividad(idActividad)
);
INSERT INTO alumnos VALUES (111, 'Elías', 'Herrero', 'Sámano', 'HEA921203DT1', '1992/12/03', 2,0); 
INSERT INTO alumnos VALUES
	(222, 'Arturo', 'Morales', 'Herrero', 'MOHA721203DT1', '1972.12.03', 1, 1),
	(333, 'Lucía', 'Sámano', 'Pineda', 'SAPL481203DT1', '1948.12.03', 4, 2),
	(444, 'Enrique', 'Montes', 'Sánchez de la Barquera', 'MOSE283007', '1928.07.30', 4, 4),
	(555, 'Deny', 'Osnaya', '', 'OAXD0622109O2', '2006.10.22', 2, 1),
	(666, 'Laura', 'García', 'Osnaya', 'GAOL700330L98', '1970/03/30', 3, 1);

CREATE TABLE calendario
(
  idCalendario	INT NOT NULL PRIMARY KEY, 
  idCurso		INT NOT NULL,
  boleta		INT NOT NULL,
  sesiones		INT NOT NULL DEFAULT 1,
  numFaltas		INT NOT NULL DEFAULT 0,
  promFinal		INT NOT NULL DEFAULT 0,  
  
  CONSTRAINT UQ_CursoBoleta UNIQUE (idCurso, boleta),

  CONSTRAINT FK_curso FOREIGN KEY (idCurso) REFERENCES cat_curso(idCurso),
  CONSTRAINT FK_alumno FOREIGN KEY (boleta) REFERENCES alumnos(boleta)
);
INSERT INTO calendario VALUES
	(1, 1, 444, 10, 1, 10),
	(2, 2, 111, 20, 2, 9),
	(3, 3, 333, 30, 0, 8),
	(4, 1, 666, 10, 0, 7),
	(5, 2, 222, 10, 0, 6),
	(6, 3, 555, 10, 1, 5),
	(7, 1, 333, 10, 2, 5),
	(82, 2, 666, 20, 2, 6),
	(93, 5, 555, 30, 0, 7),
	(14, 1, 111, 10, 0, 8),

	(8, 2, 333, 20, 2, 9),
	(9, 4, 333, 30, 0, 10),
	(114, 1, 555, 10, 0, 10),
	(15, 5, 111, 10, 0, 9),
	(26, 5, 222, 10, 1,8),
	(27, 5, 333, 10, 2, 9),
	(22, 3, 666, 20, 2, 7),
	(23, 4, 222, 30, 0, 5),
	(34, 2, 444, 10, 0, 5);


## Código de la práctica

SELECT * FROM cat_curso;

UPDATE cat_curso 
	SET precioPublico = precioPublico + (precioPublico * 0.1) 
	WHERE horas <= 20;
	
SELECT * FROM cat_curso;

SELECT * FROM alumnos;

INSERT INTO alumnos 
	(boleta, nombre, primerApellido, fechaNacimiento, RFC, idActividad)
	VALUES 
	(667, 'Laura', 'López', '2000-01-01', 'LOGL000101ABC', 1);
	
SELECT * FROM alumnos;

SELECT * FROM cat_curso;

INSERT INTO cat_curso VALUES (6, 'Administración de SQL SERVER', 'Aprender a administrar bases de datos SQL SERVER', 20, 5000, 2500);
INSERT INTO cat_curso VALUES (7, 'BIG DATA como herramienta de negocios', 'Aprender técnicas de integración y análisis de información en grandes volúmenes de datos', 30, 7500, 4000);

SELECT * FROM cat_curso;

SELECT * FROM cat_curso WHERE horas > 25 ORDER BY curso;

SELECT cc.curso 
	FROM calendario c
	LEFT JOIN cat_curso cc
	ON c.idCurso = cc.idCurso
	INNER JOIN alumnos a
	ON c.boleta = a.boleta
 	WHERE nombre = 'Arturo'
	 AND primerApellido = 'Morales'
	 AND segundoApellido = 'Herrero';
	 
SELECT promFinal, COUNT(*) AS numeroAlumnos
	FROM calendario
	GROUP BY promFinal
	ORDER BY promFinal DESC;
	
DELETE FROM calendario
	WHERE boleta = (
		SELECT boleta 
		FROM alumnos
		WHERE nombre = 'Arturo'
		AND primerApellido = 'Morales'
		AND segundoApellido = 'Herrero'
	);
	
DELETE FROM alumnos
	WHERE nombre = 'Arturo'
	AND primerApellido = 'Morales'
	AND segundoApellido = 'Herrero';
	
SELECT * FROM alumnos;
SELECT * FROM calendario;

	



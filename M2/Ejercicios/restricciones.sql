-- Seleccionar la base de datos
USE segundabd;

-- Eliminar la tabla si existe
DROP TABLE IF EXISTS estudiante;

-- Crear la tabla estudiante
CREATE TABLE estudiante (
	idEstudiante INT PRIMARY KEY AUTO_INCREMENT,
	nombre VARCHAR(60) DEFAULT 'Sin nombre' UNIQUE,
	domicilio VARCHAR(126) NOT NULL DEFAULT 'Desconocido',
	genero CHAR(1) DEFAULT 'F' CHECK (genero = 'M' OR genero = 'F' OR genero = 'N'),
	edad INT DEFAULT 6 CHECK (edad >= 5 AND edad <= 100),
	promedio DECIMAL(3,2),
	fechaDeNacimiento DATE
);

-- Insertar datos en la tabla estudiante
INSERT INTO estudiante (idEstudiante, nombre, edad, domicilio) VALUES (
	38,
	'Williams', 
	26,
	'Av. A #3'
);

INSERT INTO estudiante (idEstudiante, nombre, domicilio, genero) VALUES (
	42,
	'Laura', 
	'calle 3',
	'N'
);

INSERT INTO estudiante (nombre) VALUES (
	'Hugo'
);

INSERT INTO estudiante (nombre, edad) VALUES (
	'Matusalen',
	20
);

INSERT INTO estudiante (nombre, edad) VALUES (
	'Williams Jimenez',
	20
);

INSERT INTO estudiante (edad, genero) VALUES (
	88,
	'F'
);

-- Consultar todos los datos de la tabla estudiante
SELECT * FROM estudiante;



###############################
-- Eliminar tablas si existen
DROP TABLE IF EXISTS equipos_x_partido;
DROP TABLE IF EXISTS partidos;
DROP TABLE IF EXISTS equipos;
DROP TABLE IF EXISTS estadios;

-- Crear tabla estadios
CREATE TABLE estadios (
	idEstadio INT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	ciudad VARCHAR(100) NOT NULL,
	domicilio VARCHAR(100) NOT NULL,
	capacidad INT NOT NULL,
	fechaDeConstruccion DATE NOT NULL CHECK (fechaDeConstruccion >= '1930-01-01'),
	fechaDeInauguracion DATE NOT NULL,
	CONSTRAINT pk_estadios PRIMARY KEY (idEstadio),
	CONSTRAINT uq_estadios_nombre_ciudad UNIQUE (nombre, ciudad),
	CONSTRAINT ck_estadios_capacidad CHECK (capacidad >= 100 AND capacidad <= 120000),
	CONSTRAINT ck_estadios_fechas CHECK (fechaDeInauguracion > fechaDeConstruccion)
);

-- Insertar datos en la tabla estadios
INSERT INTO estadios VALUES (
	45,
	'Azteca',
	'CDMX',
	'Tlalpan',
	70000,
	'1950-01-01',
	'1960-01-01'
);

-- Crear tabla equipos
CREATE TABLE equipos (
	idEquipo INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
	nombreEquipo VARCHAR(100) NOT NULL,
	idEstadio INT NOT NULL,
	grupo CHAR(1) NOT NULL DEFAULT 'A' CHECK (grupo >= 'A' AND grupo <= 'F'),
	puntosAcumulados TINYINT NOT NULL DEFAULT 0 CHECK (puntosAcumulados >= 0),
	CONSTRAINT fk_estadios_equipos FOREIGN KEY (idEstadio) REFERENCES estadios (idEstadio)
);

-- Crear tabla partidos
CREATE TABLE partidos (
	idPartido INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
	idEstadio INT NOT NULL,
	fecha DATETIME,
	CONSTRAINT fk_estadios_partidos FOREIGN KEY (idEstadio) REFERENCES estadios (idEstadio)
);

-- Crear tabla equipos_x_partido
CREATE TABLE equipos_x_partido (
	idEquipo INT NOT NULL,
	idPartido INT NOT NULL,
	localVisitante CHAR (1) NOT NULL DEFAULT 'L' CHECK (localVisitante = 'L' OR localVisitante = 'V'),
	goles TINYINT NOT NULL DEFAULT 0 CHECK (goles >= 0),
	CONSTRAINT PRIMARY KEY (idEquipo, idPartido),
	CONSTRAINT fk_equipo_exp FOREIGN KEY (idEquipo) REFERENCES equipos (idEquipo),
	CONSTRAINT fk_partido_exp FOREIGN KEY (idPartido) REFERENCES partidos (idPartido)	
);

-- Consultar datos de la tabla estadios
SELECT * FROM estadios;

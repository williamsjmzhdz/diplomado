USE practica;

DROP TABLE if EXISTS reparto;
DROP TABLE if EXISTS actores;
DROP TABLE if EXISTS peliculas;

CREATE TABLE peliculas(
	pelicula_id INT AUTO_INCREMENT,
	nombre VARCHAR(255) NOT NULL,
	genero VARCHAR(255) NOT NULL,
	clasificacion VARCHAR(255) NOT NULL,
	idioma VARCHAR(255) NOT NULL DEFAULT "español",
	numero_premios_ganados INT NOT NULL DEFAULT 0,
	
	CONSTRAINT PK_peliculas PRIMARY KEY (pelicula_id)
);

CREATE TABLE actores(
	actor_id INT AUTO_INCREMENT,
	nombre VARCHAR(255) NOT NULL,
	nacionalidad VARCHAR(255) NOT NULL,
	edad INT NOT NULL,
	numero_premios_ganados INT NOT NULL DEFAULT 0,
	
	CONSTRAINT PK_actores PRIMARY KEY (actor_id),
	CONSTRAINT CK_actores_edad CHECK (edad > 0)
);

CREATE TABLE reparto(
	reparto_id INT AUTO_INCREMENT,
	nombre_personaje VARCHAR(255) NOT NULL,
	sueldo DECIMAL(10,2) NOT NULL,
	actor_id INT NOT NULL,
	pelicula_id INT NOT NULL,
	
	CONSTRAINT PK_reparto PRIMARY KEY (reparto_id),
	CONSTRAINT UQ_reparto_actor_id_pelicula_id UNIQUE (actor_id, pelicula_id),
	CONSTRAINT FK_reparto_actor_id FOREIGN KEY (actor_id) REFERENCES actores(actor_id) ON DELETE CASCADE,
	CONSTRAINT FK_reparto_pelicula_id FOREIGN KEY (pelicula_id) REFERENCES peliculas(pelicula_id) ON DELETE CASCADE,
	CONSTRAINT CK_reparto_sueldo CHECK (sueldo > 0)
);
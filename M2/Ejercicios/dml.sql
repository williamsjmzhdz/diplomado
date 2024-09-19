# Taxis de aplicación

DROP TABLE if EXISTS cliente;
DROP TABLE if EXISTS genero;

CREATE TABLE genero (
	genero_id INT AUTO_INCREMENT,
	abreviacion CHAR(1) NOT NULL DEFAULT 'D' CHECK (abreviacion = 'F' OR abreviacion = 'M' OR abreviacion = 'D'),
	nombre VARCHAR(100) NOT NULL DEFAULT 'Desconocido' CHECK(nombre = 'Femenino' OR nombre = 'Masculino' OR nombre = 'Desconocido'), 

	CONSTRAINT pk_genero PRIMARY KEY genero (genero_id),
	CONSTRAINT uq_abreviacion_nombre UNIQUE genero (abreviacion, nombre)
);

-- Insertar registros
INSERT INTO genero (abreviacion, nombre) VALUES ('F', 'Femenino');
INSERT INTO genero (abreviacion, nombre) VALUES ('M', 'Masculino');
INSERT INTO genero (nombre) VALUES ('Desconocido');

-- Seleccionar registros y ordenarlos por id
SELECT * FROM genero ORDER BY genero_id;

-- Eliminar registros
#DELETE FROM catalogo_genero; # Elimina todos los registros de la tabla
#SELECT * FROM catalogo_genero ORDER BY catalogo_genero_id;

#DELETE FROM genero WHERE genero_id = 2; # Elimina registro(s) que cumplan la expresión booleana
#SELECT * FROM genero ORDER BY genero_id;

-- Limpiar la tabla
#TRUNCATE TABLE genero; # Elimina toda la tabla y la vuelve a construir (limpia la tabla)
#SELECT * FROM genero;


CREATE TABLE cliente (
	cliente_id INT AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	edad TINYINT UNSIGNED NOT NULL,
	genero_id INT,
	correo_electronico VARCHAR(100) NOT NULL,
	nombre_usuario VARCHAR(20) NOT NULL,
	contrasenia VARCHAR(20) NOT NULL,
	
	CONSTRAINT pk_cliente PRIMARY KEY (cliente_id),
	CONSTRAINT fk_cliente_genero FOREIGN KEY (genero_id) REFERENCES genero (genero_id) ON DELETE SET NULL,
	CONSTRAINT uq_cliente_correo_electronico UNIQUE (correo_electronico),
	CONSTRAINT uq_cliente_nombre_usuario UNIQUE (nombre_usuario),
	CONSTRAINT ck_cliente_contrasenia CHECK (contrasenia <> nombre_usuario)
);

INSERT INTO cliente (nombre, edad, genero_id, correo_electronico, nombre_usuario, contrasenia)
VALUES ('Juan Pérez', 30, 1, 'juan.perez@example.com', 'juanperez', 'contraseña123');

INSERT INTO cliente (nombre, edad, genero_id, correo_electronico, nombre_usuario, contrasenia)
VALUES ('Ana López', 25, 2, 'ana.lopez@example.com', 'analopez', 'contraseña321');

INSERT INTO cliente (nombre, edad, genero_id, correo_electronico, nombre_usuario, contrasenia)
VALUES ('Mario Domínguez', 40, 1, 'mario.dominguez@example.com', 'mariodominguez', 'mario2022');

INSERT INTO cliente (nombre, edad, genero_id, correo_electronico, nombre_usuario, contrasenia)
VALUES ('Sofía Castro', 28, 2, 'sofia.castro@example.com', 'sofiacastro', 'sofiaSecure123');

INSERT INTO cliente (nombre, edad, genero_id, correo_electronico, nombre_usuario, contrasenia)
VALUES ('Carlos Mejía', 35, 1, 'carlos.mejia@example.com', 'carlosmejia', 'carlosPass321');


SELECT * FROM cliente;

-- Actualizar registros
UPDATE cliente SET contrasenia = '12345'; # Modifica todos los registros al no haber cláusula WHERE
UPDATE cliente SET nombre = 'Juan Pérez Orozco', edad = edad + 1 WHERE cliente_id = 1; # Modifica 2 campos del registro con ID = 1
UPDATE cliente SET contrasenia = 'contraseñaMayores30' WHERE edad >= 30; # Modifica la contraseña de los registros cuya edad es mayor o igual a 30
UPDATE cliente SET contrasenia = CONCAT (nombre_usuario, '12'), edad = edad - 10; # Modifica todos los registros restándoles 10 años de edad y concatenando el '12' a su nombre de usuario


#DELETE FROM genero WHERE genero_id = 2; # Hace uso del ON DELETE SET NULL
SELECT * FROM cliente;
SELECT * FROM genero;

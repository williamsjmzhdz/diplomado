USE segundabd;

DROP TABLE productos;

CREATE TABLE productos (
	nombreProducto CHAR(50),
	precio DOUBLE,
	litros TINYINT,
	existencias INT,
	codigoDeBarras BIGINT,
	precioDeVenta DECIMAL(5,2),#punto fijo
	costoDeProduccion DOUBLE #punto flotante
);

DROP TABLE pruebaenteros;

CREATE TABLE pruebaNumeros (
	entero INT,
	puntoFijo DECIMAL (8,4),
	puntoFlotante DOUBLE 
);

INSERT INTO pruebaNumeros VALUES (123.4, 123.4, 123.4);
SELECT * FROM pruebaNumeros;

DROP TABLE empleado;

CREATE TABLE empleado (
	rfc CHAR(13),
	nombre VARCHAR(100),
	fechaIngreso DATE,
	horaDeEntrada TIME,
	ultimaSalida DATETIME 
);

INSERT INTO empleado VALUES (
	'oimc',
	'williams jimenez',
	'2024-06-01',
	'07:30',
	NOW()
);

INSERT INTO empleado VALUES (
	'gall',
	'laura lopez',
	NOW(),
	NOW(),
	NOW()
);

SELECT * FROM empleado;
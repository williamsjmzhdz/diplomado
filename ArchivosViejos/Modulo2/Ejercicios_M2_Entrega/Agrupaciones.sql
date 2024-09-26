# Agrupaciones (GROUP BY y funciones de agregación)
USE segundabd;

UPDATE cliente SET edad = 25 WHERE cliente_id = 1;

SELECT * FROM cliente;

# SELECT campos, funciones de agregación GROUP BY campos;
SELECT genero_id, COUNT(*) registros FROM cliente GROUP BY genero_id;

SELECT genero_id, COUNT(*) clientes, AVG (edad) AS edad_promedio, 
	MIN(edad) AS edad_minima, MAX(edad) AS edad_maxima
	FROM cliente GROUP BY genero_id;

SELECT genero_id, COUNT(*) clientes, AVG(edad) AS edad_promedio FROM cliente GROUP BY genero_id;
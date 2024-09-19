USE sistema;

SELECT * FROM modulos;
SELECT * FROM roles;
SELECT * FROM usuarios;
SELECT * FROM bitacora;

SELECT u.usuario, u.estatus, r.rol
	FROM usuarios u, roles r
	WHERE u.idRol = r.idRol;
	
## Usando JOINS

SELECT A.usuario, A.estatus, B.rol
	FROM usuarios A 
	LEFT JOIN roles B
	ON A.idRol = B.idRol;
	
SELECT * FROM bitacora;

SELECT u.usuario, m.modulo, b.fecha
	FROM bitacora b
	LEFT JOIN usuarios u ON b.idUsuario = u.idUsuario
	LEFT JOIN modulos m ON b.cveModulo = m.cveModulo;
	
USE segundabd;
SELECT * FROM a;
SELECT * FROM b;

SELECT a.*, b.*
	FROM a
	LEFT JOIN b ON a.numero = b.numero;
	
SELECT a.*, b.*
	FROM a
	RIGHT JOIN b ON a.numero = b.numero;
	
SELECT a.*, b.*
	FROM a
	INNER JOIN b ON a.numero = b.numero;
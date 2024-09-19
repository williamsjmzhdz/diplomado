USE sistema;
# En orden inverso a como fueron creadas
DROP TABLE IF EXISTS bitacora;
DROP TABLE IF EXISTS modulos;
DROP TABLE IF EXISTS usuarios;
DROP TABLE IF EXISTS roles;

CREATE TABLE roles (
	idRol INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	rol VARCHAR(50) NOT NULL UNIQUE CHECK (LENGTH(rol) > 5) 
);

CREATE TABLE usuarios (
	idUsuario INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	usuario VARCHAR(100) UNIQUE NOT NULL,
	idRol INT NOT NULL REFERENCES roles (idRol),
	correo VARCHAR(20) NOT NULL UNIQUE CHECK (LENGTH(correo)>=10),
	contrasena VARCHAR(20) NOT NULL CHECK (LENGTH(contrasena)>=5 AND correo <> contrasena),
	estatus CHAR(1) NOT NULL CHECK (estatus IN ('A','B'))
);

CREATE TABLE modulos (
	cveModulo INT NOT NULL PRIMARY KEY,
	modulo VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE bitacora (
	idBitacora INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
	idUsuario INT NOT NULL,
	cveModulo INT NOT NULL,
	fecha DATETIME NOT NULL CHECK (YEAR(fecha)>=2000),

	CONSTRAINT uq_bitacora UNIQUE (idUsuario, fecha),
	CONSTRAINT fk_bitacora_usuarios FOREIGN KEY (idUsuario) REFERENCES usuarios(idUsuario),
	CONSTRAINT fk_bitacora_modulos FOREIGN KEY (cveModulo) REFERENCES modulos(cveModulo)
);

INSERT INTO roles (idRol, rol) VALUES
(1, 'Administrador'),
(2, 'Supervisor'),
(3, 'Vendedor de mostrador');

INSERT INTO usuarios (idUsuario, usuario, idRol, correo, contrasena, estatus) VALUES
(1, 'Rachel',   1, 'rachel@friends.com'  , 'Admin123' , 'A'),
(2, 'Monica',   2, 'monica@friends.com'  , 'Super234' , 'A'),
(3, 'Ross',     2, 'ross@friends.com'    , 'Super345' , 'A'),
(4, 'Chandler', 3, 'chandler@friends.com', 'Ventas456', 'B'),
(5, 'Joey',     3, 'joey@friends.com'    , 'Ventas567', 'A');

INSERT INTO modulos (cveModulo, modulo) VALUES
(0, 'Inicio del sistema'),
(1, 'Administración de Usuarios'),
(2, 'Administración de Productos'),
(3, 'Venta'),
(4, 'Inventario');

INSERT INTO bitacora (idUsuario, cveModulo, fecha) VALUES
(1, 0, '2020-06-12 08:30:00'),
(1, 1, '2020-06-12 09:30:00'),
(1, 2, '2020-06-12 10:30:00'),
(1, 4, '2020-06-12 11:30:00'),

(2, 0, '2020-06-11 10:45:00'),
(2, 2, '2020-06-11 11:45:00'),
(2, 2, '2020-06-11 12:45:00'),
(2, 0, '2020-06-12 16:45:00'),
(2, 2, '2020-06-11 17:45:00'),
(2, 4, '2020-06-11 18:45:00'),

(3, 0, '2020-06-10 15:20:00'),
(3, 2, '2020-06-10 15:20:50'),
(3, 4, '2020-06-10 16:20:00'),
(3, 0, '2020-06-12 09:20:00'),
(3, 2, '2020-06-12 19:20:00'),
(3, 4, '2020-06-12 21:20:00'),

(4, 0, '2020-06-09 14:10:00'),
(4, 3, '2020-06-09 15:10:00'),
(4, 3, '2020-06-09 15:10:50'),
(4, 3, '2020-06-09 16:10:00'),
(4, 3, '2020-06-09 17:10:00'),
(4, 3, '2020-06-09 18:10:00'),
(4, 0, '2020-06-10 12:10:00'),
(4, 3, '2020-06-10 13:10:00'),
(4, 3, '2020-06-10 14:10:50'),
(4, 3, '2020-06-10 15:10:00'),
(4, 3, '2020-06-10 16:10:00'),
(4, 3, '2020-06-10 17:10:00'),

(5, 0, '2020-06-08 11:55:00'),
(5, 0, '2020-06-18 16:55:00');


SELECT * FROM roles;
SELECT * FROM modulos;
SELECT * FROM usuarios;
SELECT * FROM bitacora;

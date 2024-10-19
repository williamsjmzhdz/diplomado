SET NAMES 'UTF8MB4';
DROP DATABASE IF EXISTS loja;
CREATE DATABASE IF NOT EXISTS loja DEFAULT CHARACTER SET UTF8MB4;
USE loja;

CREATE TABLE tipo(
id_tpo						INT NOT NULL AUTO_INCREMENT,
nombre						VARCHAR(30) NOT NULL,
PRIMARY KEY(id_tpo)
)DEFAULT CHARACTER SET UTF8MB4;

INSERT INTO tipo(nombre) 
VALUES('Clupeiformes'),('Salmoniformes'),('Aulopiformes'),('Anguliformes'),('Beloniformes');

CREATE TABLE lote(
id_lte						INT NOT NULL AUTO_INCREMENT,
fecha						DATETIME NOT NULL,
kilos						INT NOT NULL,
numero_cajas				INT NOT NULL,
precio_kilo_salida			DOUBLE NOT NULL,
PRIMARY KEY(id_lte)
)DEFAULT CHARACTER SET UTF8MB4;
INSERT INTO lote(fecha,kilos,numero_cajas,precio_kilo_salida) 
VALUES('2024-01-12 12:00',10,2,34.2),('2024-01-13 14:00',11,21,124.2),
('024-01-14 1:00',3,12,14.2),('2024-01-15 2:00',2,2,34.2),
('2024-04-22 2:00',2,2,34.2),('2024-04-22 2:00',2,2,34.2);

CREATE TABLE comprador(
codigo_cpr					INT NOT NULL AUTO_INCREMENT,
nombre						VARCHAR(15) NOT NULL,
apellido_paterno			VARCHAR(15) NOT NULL,
apellido_materno			VARCHAR(15) NOT NULL,
direccion					VARCHAR(200) NOT NULL,
correo						VARCHAR(80) NOT NULL UNIQUE,
PRIMARY KEY(codigo_cpr)
)DEFAULT CHARACTER SET UTF8MB4;
INSERT INTO comprador(nombre,apellido_paterno,apellido_materno,direccion,correo)
VALUES('Pedro','Martinez','Martinez','Av. Londres 20 de Noviembre',"demo1@demo.com"),
('Samuel','Trejo','Rojas','Av. Londres 22 de Norte',"demo2@demo.com"),
('Antonio','Sabila','Costa','Av. Londres 25 de Rojas',"demo3@demo.com");

CREATE TABLE compra(
id_lte						INT NOT NULL AUTO_INCREMENT,
codigo_cpr					INT NOT NULL,
precio_kilo_final			DOUBLE NOT NULL,
precio_total				DOUBLE NOT NULL,
fecha						DATETIME NOT NULL,
PRIMARY KEY(id_lte),
CONSTRAINT fk_lote FOREIGN KEY (id_lte) REFERENCES lote(id_lte),
CONSTRAINT fk_comprador_compra FOREIGN KEY (codigo_cpr) REFERENCES comprador(codigo_cpr)
)DEFAULT CHARACTER SET UTF8MB4;
INSERT INTO compra(id_lte,codigo_cpr,precio_kilo_final,precio_total,fecha)
VALUES(1,2,234.45,1003.4,'2024-01-13:10:10'),(2,2,34.45,103.1,'2024-01-14:10:11'),
(3,3,234.45,1003.4,'2024-01-15:10:14'),(4,3,134.45,2003.4,'2024-01-16:10:15');


CREATE TABLE caladero(
id_clo						INT NOT NULL AUTO_INCREMENT,
ubicacion					VARCHAR(100) NOT NULL,
extension					DOUBLE NOT NULL,
PRIMARY KEY(id_clo)
)DEFAULT CHARACTER SET UTF8MB4;
INSERT INTO caladero(ubicacion,extension) 
VALUES('sur norte del la torre',23.4),('norte del la torre',9.4),('noreste del la torre',3.4);

CREATE TABLE barco(
id_bco						INT NOT NULL AUTO_INCREMENT,
nombre						VARCHAR(50) NOT NULL,
PRIMARY KEY(id_bco)
)DEFAULT CHARACTER SET UTF8MB4;
INSERT INTO barco(nombre) VALUES('barco 1'),('barco 2'),('barco 3');

CREATE TABLE especie(
id_epe						INTEGER NOT NULL AUTO_INCREMENT,
nombre						VARCHAR(50) NOT NULL,
id_lte						INT NOT NULL,						
id_tpo						INT NOT NULL,	
imagen						VARCHAR(100) DEFAULT 'Sin_imagen_disponible.jpg',					
PRIMARY KEY(id_epe),
CONSTRAINT fk_lote_especie FOREIGN KEY (id_lte) REFERENCES lote(id_lte),
CONSTRAINT fk_tipo_especie FOREIGN KEY (id_tpo) REFERENCES tipo(id_tpo)
)DEFAULT CHARACTER SET UTF8MB4;
INSERT INTO especie(nombre,id_lte,id_tpo) VALUES('pescado 1',1,1),('pescado 2',3,2),('pescado 3',2,3);

CREATE TABLE captura(
id_ctr						INTEGER NOT NULL AUTO_INCREMENT,
fecha						DATE NOT NULL,
peso						DOUBLE NOT NULL,
id_epe						INTEGER NOT NULL,
id_bco						INT NOT NULL,
id_clo						INT NOT NULL,
PRIMARY KEY(id_ctr),
CONSTRAINT fk_especie_captura FOREIGN KEY (id_epe) REFERENCES especie(id_epe),
CONSTRAINT fk_barco_captura FOREIGN KEY (id_bco) REFERENCES barco(id_bco),
CONSTRAINT fk_caladero_captura FOREIGN KEY (id_clo) REFERENCES caladero(id_clo)
)DEFAULT CHARACTER SET UTF8MB4;
INSERT INTO captura(fecha,peso,id_epe,id_bco,id_clo) VALUES('2024-01-13',234.34,1,1,1),('2024-01-14',234.34,2,1,1),
('2024-01-15',234.34,3,2,1);


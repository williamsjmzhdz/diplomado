USE segundabd;
SELECT * FROM prep2024p;

CREATE VIEW secciones AS 
SELECT entidad, distrito, seccion,
SUM(XG) AS Xochitl, 
SUM(CS) AS Claudia, 
SUM(JM) AS Maynez
FROM prep2024p
GROUP BY entidad, distrito, seccion
ORDER BY entidad;

SELECT * FROM secciones;
SELECT * FROM secciones WHERE Maynez > Xochitl;

# DROP VIEW secciones;

CREATE TABLE catalogo (
	producto VARCHAR(100),
	precio INT,
	inicio DATE,
	fin DATE
);

INSERT INTO catalogo VALUES ('agua', 15, '2000-01-01', '2024-12-31');
INSERT INTO catalogo VALUES ('agua', 14, '1990-01-01', '1999-12-31');

INSERT INTO catalogo VALUES ('pasta', 25, '2000-01-01', '2024-10-31');
INSERT INTO catalogo VALUES ('pasta', 24, '1990-01-01', '1999-12-31');

INSERT INTO catalogo VALUES ('jabón', 24, '1990-01-01', '2025-12-31');

CREATE VIEW productosVigentes AS
	SELECT * FROM catalogo WHERE NOW() BETWEEN inicio AND fin;
	
SELECT * FROM productosVigentes;
DROP TABLE IF EXISTS Alumnos;
CREATE TABLE Alumnos (
  matricula varchar(20),
  nombre varchar(50),
  paterno varchar(50),
  fnac date,
  estatura decimal(10,2),
  curp varchar(18) unique key,
  PRIMARY KEY (matricula)
);

DROP TABLE IF EXISTS Materia;
CREATE TABLE Materia (
    clave_materia VARCHAR(50) NOT NULL,
    materia VARCHAR(100) NOT NULL,
    creditos INT NOT NULL,
    horas INT NOT NULL,
    PRIMARY KEY (clave_materia)
);

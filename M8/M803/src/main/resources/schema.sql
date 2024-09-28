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

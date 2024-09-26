-- Crea la base de datos "bazarboost_m8_e1" si no existe.
CREATE DATABASE IF NOT EXISTS bazarboost_m8_e1;

-- Selecciona la base de datos "bazarboost_m8_e1"
USE bazarboost_m8_e1;

-- Elimina las tablas si existen
DROP TABLE if EXISTS Roles;
DROP TABLE if EXISTS Categorias;
DROP TABLE if EXISTS Descuentos;
DROP TABLE if EXISTS Marcas;

-- Crea el catálogo "Roles"
CREATE TABLE Roles (
    rol_id INT,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    CONSTRAINT PK_Roles PRIMARY KEY (rol_id),
    CONSTRAINT UQ_Roles_nombre UNIQUE (nombre)
);

-- Crea el catálogo "Categorias"
CREATE TABLE Categorias (
    categoria_id INT,
    nombre VARCHAR(40) NOT NULL,
    CONSTRAINT PK_Categorias PRIMARY KEY (categoria_id),
    CONSTRAINT UQ_Categorias_nombre UNIQUE (nombre)
);

-- Crea el catálogo "Descuentos"
CREATE TABLE Descuentos(
    descuento_id INT,
    porcentaje INT NOT NULL,
    nombre VARCHAR(40) NOT NULL,
    CONSTRAINT PK_Descuentos PRIMARY KEY (descuento_id),
    CONSTRAINT UQ_Descuentos_nombre UNIQUE (nombre),
    CONSTRAINT CK_Descuentos_porcentaje CHECK (porcentaje >= 0 AND porcentaje <= 100)
);

-- Crea el catálogo "Marcas"
CREATE TABLE Marcas (
    marca_id INT,
    nombre VARCHAR(40) NOT NULL,
    descripcion VARCHAR(100),
    CONSTRAINT PK_Marcas PRIMARY KEY (marca_id),
    CONSTRAINT UQ_Marcas_nombre UNIQUE (nombre)
);

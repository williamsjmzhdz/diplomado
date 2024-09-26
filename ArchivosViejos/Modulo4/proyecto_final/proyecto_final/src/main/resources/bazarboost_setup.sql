-- Elimina la base de datos si existe
DROP DATABASE IF EXISTS bazarboost_test;

-- Crea la base de datos
CREATE DATABASE bazarboost_test;

-- Selecciona la base de datos para operaciones futuras
USE bazarboost_test;

-- Crea la tabla Usuarios
CREATE TABLE Usuarios (
    usuario_id INT AUTO_INCREMENT,
    nombre VARCHAR(40) NOT NULL,
    apellido_paterno VARCHAR(40) NOT NULL,
    apellido_materno VARCHAR(40) NOT NULL,
    correo_electronico VARCHAR(80) NOT NULL,
    contrasenia VARCHAR(40) NOT NULL, 
    CONSTRAINT PK_Usuarios PRIMARY KEY (usuario_id),
    CONSTRAINT UQ_Usuarios_correo_electronico UNIQUE (correo_electronico)
);

-- Crea la tabla Roles
CREATE TABLE Roles (
    rol_id INT AUTO_INCREMENT,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(100) NOT NULL,
    CONSTRAINT PK_Roles PRIMARY KEY (rol_id),
    CONSTRAINT UQ_Roles_nombre UNIQUE (nombre)
);

-- Crea la tabla UsuariosRoles
CREATE TABLE UsuariosRoles (
    usuario_rol_id INT AUTO_INCREMENT,
    fecha_asignacion TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id INT NOT NULL,
    rol_id INT NOT NULL,
    
    CONSTRAINT PK_UsuariosRoles PRIMARY KEY (usuario_rol_id),
    CONSTRAINT UQ_UsuariosRoles_usuario_id_rol_id UNIQUE (usuario_id, rol_id),
    CONSTRAINT FK_UsuariosRoles_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE,
    CONSTRAINT FK_UsuariosRoles_rol_id FOREIGN KEY (rol_id) REFERENCES Roles(rol_id) ON DELETE CASCADE 
);

-- Insertar roles de prueba
INSERT INTO Roles (nombre, descripcion) VALUES 
('Cliente', 'Cliente del sistema'),
('Vendedor', 'Vendedor del sistema'),
('Administrador', 'Administrador del sistema');

-- Insertar usuarios de prueba
INSERT INTO Usuarios (nombre, apellido_paterno, apellido_materno, correo_electronico, contrasenia) VALUES 
('Juan', 'Pérez', 'López', 'juan.perez@example.com', 'pass123'),
('Ana', 'García', 'Martínez', 'ana.garcia@example.com', 'pass456'),
('Luis', 'Hernández', 'Torres', 'luis.hernandez@example.com', 'pass789');

-- Insertar relaciones usuario-rol
INSERT INTO UsuariosRoles (usuario_id, rol_id) VALUES 
(1, 1), -- Juan es Cliente
(2, 2), -- Ana es Vendedora
(3, 3); -- Luis es Administrador
USE bazarboost;

DROP TABLE IF EXISTS ProductosFacturas;
DROP TABLE IF EXISTS ProductosCarrito;
DROP TABLE IF EXISTS ProductosDescuentos;
DROP TABLE IF EXISTS ProductosCategorias;
DROP TABLE IF EXISTS Descuentos;
DROP TABLE IF EXISTS Reseñas;
DROP TABLE IF EXISTS Facturas;
DROP TABLE IF EXISTS MetodosPago;
DROP TABLE IF EXISTS Direcciones;
DROP TABLE IF EXISTS UsuariosRoles;
DROP TABLE IF EXISTS Productos;
DROP TABLE IF EXISTS Roles;
DROP TABLE IF EXISTS Categorias;
DROP TABLE IF EXISTS Usuarios;

CREATE TABLE Usuarios (
    usuario_id INT AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
	 apellido_paterno VARCHAR(255) NOT NULL,
    apellido_materno VARCHAR(255) NOT NULL,
    correo_electronico VARCHAR(255) NOT NULL,
    contraseña VARCHAR(255) NOT NULL, 
    
    CONSTRAINT PK_Usuarios PRIMARY KEY (usuario_id),
    CONSTRAINT UQ_Usuarios_correo_electronico UNIQUE (correo_electronico)
);

CREATE TABLE Categorias (
    categoria_id INT AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,

    CONSTRAINT PK_Categorias PRIMARY KEY (categoria_id),
    CONSTRAINT UQ_Categorias_nombre UNIQUE (nombre)
);

CREATE TABLE Roles (
    rol_id INT AUTO_INCREMENT,
    nombre VARCHAR(50) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    
    CONSTRAINT PK_Roles PRIMARY KEY (rol_id),
    CONSTRAINT UQ_Roles_nombre UNIQUE (nombre)
);

CREATE TABLE Productos (
    producto_id INT AUTO_INCREMENT,
    nombre VARCHAR(255) NOT NULL,
    descripcion VARCHAR(255) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    existencia INT NOT NULL,
    imagen_url VARCHAR(255) NOT NULL,
    usuario_id INT NOT NULL,
    
    CONSTRAINT PK_Productos PRIMARY KEY (producto_id),
    CONSTRAINT UQ_Productos_nombre UNIQUE (nombre),
    CONSTRAINT FK_Productos_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE,
    CONSTRAINT CK_Productos_precio CHECK (precio >= 0),
    CONSTRAINT CK_Productos_existencia CHECK (existencia >= 0)
);

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

CREATE TABLE Direcciones (
   direccion_id INT AUTO_INCREMENT,
   estado VARCHAR(255) NOT NULL,
   ciudad VARCHAR(255) NOT NULL,
   colonia VARCHAR(255) NOT NULL,
   calle VARCHAR(255) NOT NULL,
   numero_domicilio INT NOT NULL,
   codigo_postal VARCHAR(20) NOT NULL,
   telefono_contacto VARCHAR(20) NOT NULL,
   usuario_id INT NOT NULL,
    
   CONSTRAINT PK_Direcciones PRIMARY KEY (direccion_id),
   CONSTRAINT UQ_Direcciones UNIQUE (estado, ciudad, colonia, calle, numero_domicilio, codigo_postal),
   CONSTRAINT FK_Direcciones_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE 
);

CREATE TABLE MetodosPago (
    metodo_pago_id INT AUTO_INCREMENT,
    nombre_titular VARCHAR(255) NOT NULL,
    numero_tarjeta VARCHAR(255) NOT NULL,
    fecha_expiracion DATE NOT NULL,
    codigo_seguridad CHAR(3) NOT NULL,
    tipo_tarjeta ENUM('Débito', 'Crédito') NOT NULL,
    monto DECIMAL(10, 2) NOT NULL,
    usuario_id INT NOT NULL,
    
    CONSTRAINT PK_MetodosPago PRIMARY KEY (metodo_pago_id),
    CONSTRAINT UQ_MetodosPago_numero_tarjeta UNIQUE (numero_tarjeta),
    CONSTRAINT FK_MetodosPago_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE,
    CONSTRAINT CK_MetodosPago_monto CHECK (monto >= 0)
);

CREATE TABLE Facturas (
    factura_id INT AUTO_INCREMENT,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    subtotal DECIMAL(10, 2) NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    porcentaje_impuestos DECIMAL(10, 2) NOT NULL,
    usuario_id INT,
    metodo_pago_id INT,
    direccion_id INT,
    
    CONSTRAINT PK_Facturas PRIMARY KEY (factura_id),
    CONSTRAINT UQ_Facturas_fecha_usuario_id UNIQUE (fecha, usuario_id),
    CONSTRAINT FK_Facturas_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE SET NULL,
    CONSTRAINT FK_Facturas_metodo_pago_id FOREIGN KEY (metodo_pago_id) REFERENCES MetodosPago(metodo_pago_id) ON DELETE SET NULL,
    CONSTRAINT FK_Facturas_direccion_id FOREIGN KEY (direccion_id) REFERENCES Direcciones(direccion_id) ON DELETE SET NULL,
    CONSTRAINT CK_Facturas_subtotal CHECK (subtotal >= 0),
    CONSTRAINT CK_Facturas_total CHECK (total >= 0),
    CONSTRAINT CK_Facturas_porcentaje_impuestos CHECK (porcentaje_impuestos >= 0)
);

CREATE TABLE Reseñas (
    reseña_id INT AUTO_INCREMENT,
    comentario VARCHAR(255) NOT NULL,
    calificacion INT NOT NULL,
    fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    usuario_id INT,
    producto_id INT NOT NULL,
    
    CONSTRAINT PK_Reseñas PRIMARY KEY (reseña_id),
    CONSTRAINT UQ_Reseñas_usuario_id_producto_id UNIQUE (usuario_id, producto_id),
    CONSTRAINT FK_Reseñas_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE SET NULL,
    CONSTRAINT FK_Reseñas_producto_id FOREIGN KEY (producto_id) REFERENCES Productos(producto_id) ON DELETE CASCADE,
    CONSTRAINT CK_Reseñas_calificacion CHECK (calificacion >= 1 AND calificacion <= 5)
);

CREATE TABLE Descuentos(
    descuento_id INT AUTO_INCREMENT,
    porcentaje INT NOT NULL,
    nombre VARCHAR(255) NOT NULL,
    usuario_id INT NOT NULL,
    
    CONSTRAINT PK_Descuentos PRIMARY KEY (descuento_id),
    CONSTRAINT UQ_Descuentos_nombre UNIQUE (nombre),
    CONSTRAINT FK_Descuentos_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE,
    CONSTRAINT CK_Descuentos_porcentaje CHECK (porcentaje >= 0 AND porcentaje <= 100)
);

CREATE TABLE ProductosCategorias(
    producto_categoria_id INT AUTO_INCREMENT,
    producto_id INT NOT NULL,
    categoria_id INT NOT NULL,
    
    CONSTRAINT PK_ProductosCategorias PRIMARY KEY (producto_categoria_id),
    CONSTRAINT UQ_ProductosCategorias_producto_id_categoria_id UNIQUE (producto_id, categoria_id),
    CONSTRAINT FK_ProductosCategorias_producto_id FOREIGN KEY (producto_id) REFERENCES Productos(producto_id) ON DELETE CASCADE,
    CONSTRAINT FK_ProductosCategorias_categoria_id FOREIGN KEY (categoria_id) REFERENCES Categorias(categoria_id) ON DELETE CASCADE
);

CREATE TABLE ProductosDescuentos (
    producto_descuento_id INT AUTO_INCREMENT,
    producto_id INT NOT NULL,
    descuento_id INT NOT NULL,
    
    CONSTRAINT PK_ProductosDescuentos PRIMARY KEY (producto_descuento_id),
    CONSTRAINT UQ_ProductosDescuentos_producto_id_descuento_id UNIQUE (producto_id, descuento_id),
    CONSTRAINT FK_ProductosDescuentos_producto_id FOREIGN KEY (producto_id) REFERENCES Productos(producto_id) ON DELETE CASCADE,
    CONSTRAINT FK_ProductosDescuentos_descuento_id FOREIGN KEY (descuento_id) REFERENCES Descuentos(descuento_id) ON DELETE CASCADE
);

CREATE TABLE ProductosCarrito(
    producto_carrito_id INT AUTO_INCREMENT,
    cantidad INT NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    usuario_id INT NOT NULL,
    producto_id INT NOT NULL,
    
    CONSTRAINT PK_ProductosCarrito PRIMARY KEY (producto_carrito_id),
    CONSTRAINT UQ_ProductosCarrito_producto_id_usuario_id UNIQUE (producto_id, usuario_id),
    CONSTRAINT FK_ProductosCarrito_producto_id FOREIGN KEY (producto_id) REFERENCES Productos(producto_id) ON DELETE CASCADE,
    CONSTRAINT FK_ProductosCarrito_usuario_id FOREIGN KEY (usuario_id) REFERENCES Usuarios(usuario_id) ON DELETE CASCADE,
    CONSTRAINT CK_ProductosCarrito_cantidad CHECK (cantidad > 0),
    CONSTRAINT CK_ProductosCarrito_total CHECK (total >= 0)
);

CREATE TABLE ProductosFacturas(
    producto_factura_id INT AUTO_INCREMENT,
    cantidad INT NOT NULL,
    total DECIMAL(10, 2) NOT NULL,
    factura_id INT NOT NULL,
    producto_id INT,
    
    CONSTRAINT PK_ProductosFacturas PRIMARY KEY (producto_factura_id),
    CONSTRAINT UQ_ProductosFacturas_producto_id_factura_id UNIQUE (producto_id, factura_id),
    CONSTRAINT FK_ProductosFacturas_producto_id FOREIGN KEY (producto_id) REFERENCES Productos(producto_id) ON DELETE SET NULL,
    CONSTRAINT FK_ProductosFacturas_factura_id FOREIGN KEY (factura_id) REFERENCES Facturas(factura_id) ON DELETE CASCADE,
    CONSTRAINT CK_ProductosFacturas_cantidad CHECK (cantidad > 0),
    CONSTRAINT CK_ProductosFacturas_total CHECK (total >= 0)
);


## PUNTO OPCIONAL: ÍNDICES
CREATE INDEX idx_facturas_usuario_id ON Facturas(usuario_id);
CREATE INDEX idx_productosfacturas_factura_id ON ProductosFacturas(factura_id);
CREATE INDEX idx_productos_producto_id ON Productos(producto_id);
CREATE INDEX idx_metodospago_metodo_pago_id ON MetodosPago(metodo_pago_id);
CREATE INDEX idx_direcciones_direccion_id ON Direcciones(direccion_id);
CREATE INDEX idx_usuarios_correo_electronico ON Usuarios(correo_electronico);
CREATE INDEX idx_productoscategorias_producto_id ON ProductosCategorias(producto_id);
CREATE INDEX idx_productoscategorias_categoria_id ON ProductosCategorias(categoria_id);
CREATE INDEX idx_productoscarrito_usuario_id ON ProductosCarrito(usuario_id);
CREATE INDEX idx_metodospago_usuario_id ON MetodosPago(usuario_id);
CREATE INDEX idx_direcciones_usuario_id ON Direcciones(usuario_id);
CREATE INDEX idx_descuentos_usuario_id ON Descuentos(usuario_id);
CREATE INDEX idx_productosdescuentos_producto_id ON ProductosDescuentos(producto_id);
CREATE INDEX idx_resenas_producto_id ON Reseñas(producto_id);

# PUNTO OPCIONAL: INSERTS
-- Inserciones en la tabla Usuarios
INSERT INTO Usuarios (nombre, apellido_paterno, apellido_materno, correo_electronico, contraseña)
VALUES 
('Juan', 'Pérez', 'González', 'juan.perez@example.com', 'password123'),
('María', 'Rodríguez', 'López', 'maria.rodriguez@example.com', 'password123'),
('Pedro', 'García', 'Martínez', 'pedro.garcia@example.com', 'password123');

-- Inserciones en la tabla Categorias
INSERT INTO Categorias (nombre, descripcion)
VALUES 
('Ropa de Hombre', 'Categoría de ropa masculina'),
('Ropa de Mujer', 'Categoría de ropa femenina'),
('Accesorios', 'Categoría de accesorios de moda');

-- Inserciones en la tabla Roles
INSERT INTO Roles (nombre, descripcion)
VALUES 
('Administrador', 'Administrador del sistema'),
('Vendedor', 'Vendedor en el sistema'),
('Cliente', 'Cliente del sistema');

-- Inserciones en la tabla Productos
INSERT INTO Productos (nombre, descripcion, precio, existencia, imagen_url, usuario_id)
VALUES 
('Camiseta Hombre', 'Camiseta de algodón para hombre', 199.99, 50, 'img/camiseta_hombre.jpg', 2),
('Vestido Mujer', 'Vestido elegante para mujer', 499.99, 30, 'img/vestido_mujer.jpg', 2),
('Gorra', 'Gorra unisex', 99.99, 100, 'img/gorra.jpg', 3);

-- Inserciones en la tabla UsuariosRoles
INSERT INTO UsuariosRoles (usuario_id, rol_id)
VALUES 
(1, 1),
(2, 2),
(3, 3);

-- Inserciones en la tabla Direcciones
INSERT INTO Direcciones (estado, ciudad, colonia, calle, numero_domicilio, codigo_postal, telefono_contacto, usuario_id)
VALUES 
('Estado1', 'Ciudad1', 'Colonia1', 'Calle1', 123, '00000', '1234567890', 1),
('Estado2', 'Ciudad2', 'Colonia2', 'Calle2', 456, '11111', '0987654321', 2),
('Estado3', 'Ciudad3', 'Colonia3', 'Calle3', 789, '22222', '1122334455', 3);

-- Inserciones en la tabla MetodosPago
INSERT INTO MetodosPago (nombre_titular, numero_tarjeta, fecha_expiracion, codigo_seguridad, tipo_tarjeta, monto, usuario_id)
VALUES 
('Juan Pérez', '1234567812345678', '2025-12-31', '123', 'Crédito', 1000.00, 1),
('María Rodríguez', '8765432187654321', '2026-11-30', '321', 'Débito', 500.00, 2),
('Pedro García', '1111222233334444', '2024-10-31', '456', 'Crédito', 750.00, 3);

-- Inserciones en la tabla Facturas
INSERT INTO Facturas (subtotal, total, porcentaje_impuestos, usuario_id, metodo_pago_id, direccion_id)
VALUES 
(150.00, 165.00, 10.00, 1, 1, 1),
(300.00, 330.00, 10.00, 2, 2, 2),
(450.00, 495.00, 10.00, 3, 3, 3);

-- Inserciones en la tabla Reseñas
INSERT INTO Reseñas (comentario, calificacion, usuario_id, producto_id)
VALUES 
('Buena calidad', 5, 1, 1),
('Muy elegante', 4, 2, 2),
('Cómoda y práctica', 4, 3, 3);

-- Inserciones en la tabla Descuentos
INSERT INTO Descuentos (porcentaje, nombre, usuario_id)
VALUES 
(10, 'Descuento Primavera', 2),
(20, 'Descuento Verano', 3),
(15, 'Descuento Otoño', 1);

-- Inserciones en la tabla ProductosCategorias
INSERT INTO ProductosCategorias (producto_id, categoria_id)
VALUES 
(1, 1),
(2, 2),
(3, 3);

-- Inserciones en la tabla ProductosDescuentos
INSERT INTO ProductosDescuentos (producto_id, descuento_id)
VALUES 
(1, 1),
(2, 2),
(3, 3);

-- Inserciones en la tabla ProductosCarrito
INSERT INTO ProductosCarrito (cantidad, total, usuario_id, producto_id)
VALUES 
(2, 399.98, 1, 1),
(1, 499.99, 2, 2),
(3, 299.97, 3, 3);

-- Inserciones en la tabla ProductosFacturas
INSERT INTO ProductosFacturas (cantidad, total, factura_id, producto_id)
VALUES 
(1, 199.99, 1, 1),
(2, 999.98, 2, 2),
(1, 99.99, 3, 3);

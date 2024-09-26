-- Selecciona la base de datos "bazarboost_m8_e1"
USE bazarboost_m8_e1;

-- Inserción de datos en la tabla "Roles"
INSERT INTO Roles (rol_id, nombre, descripcion) VALUES
(1, 'Administrador', 'Acceso total al sistema'),
(2, 'Cliente', 'Puede realizar compras y dejar reseñas'),
(3, 'Vendedor', 'Puede gestionar productos y ventas');

-- Inserción de datos en la tabla "Categorias"
INSERT INTO Categorias (categoria_id, nombre) VALUES
(1, 'Camisetas'),
(2, 'Pantalones'),
(3, 'Chaquetas'),
(4, 'Accesorios');

-- Inserción de datos en la tabla "Descuentos"
INSERT INTO Descuentos (descuento_id, porcentaje, nombre) VALUES
(1, 10, 'Descuento de Bienvenida'),
(2, 20, 'Descuento de Temporada'),
(3, 5, 'Descuento por Fidelidad'),
(4, 15, 'Descuento Black Friday');

-- Inserción de datos en la tabla "Marcas"
INSERT INTO Marcas (marca_id, nombre, descripcion) VALUES
(1, 'Nike', 'Marca deportiva enfocada en ropa casual y deportiva'),
(2, 'Adidas', 'Marca deportiva reconocida por sus accesorios y calzado'),
(3, 'Levi\'s', 'Marca icónica de pantalones y ropa de mezclilla'),
(4, 'H&M', 'Marca de moda rápida con una amplia gama de ropa y accesorios');

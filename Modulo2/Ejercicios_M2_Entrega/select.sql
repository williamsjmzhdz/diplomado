# Autor: Francisco Williams Jiménez Hernández
# Fecha de creación: 08/06/2024

# Instrucción SELECT
# SELECT nos permite leer registros de una tabla

# Sintaxis de los apuntes
-- <> = Opcional
-- []  = Obligatorio, sustituir
-- | = OR

# Operadores de comparación: <, >, <=, >=, =, <>

USE segundabd;

# SELECT * FROM [NOMBRE_TABLA];
-- Selecciona todos los registros de X tabla.
SELECT * FROM genero;
SELECT * FROM cliente;

# SELECT * FROM [NOMBRE_TABLA] ORDER BY [CAMPO1] <[ASC | DESC]>, [CAMPO2]  <[ASC | DESC]>, ..., [CAMPOn] <[ASC | DESC]>;
-- Selecciona todos los registros de X tabla y los ordena con base en Y campo.
SELECT * FROM genero ORDER BY genero_id;
SELECT nombre FROM genero ORDER BY abreviacion;
SELECT nombre_usuario, correo_electronico FROM cliente ORDER BY cliente_id ASC, correo_electronico ASC;
SELECT nombre_usuario, correo_electronico FROM cliente ORDER BY cliente_id DESC;

# SELECT [CAMPO1, CAMPO2, ..., CAMPOn] from [NOMBRE_TABLA];
-- Selecciona campos específicos de X tabla.
SELECT nombre_usuario, correo_electronico, cliente_id FROM cliente;

# SELECT [CAMPO1, CAMPO2, ..., CAMPOn] from [NOMBRE_TABLA] ORDER BY [CAMPO];
-- Selecciona campos específicos de X tabla y los ordena con base en Y campo.
SELECT nombre_usuario, correo_electronico, cliente_id FROM cliente ORDER BY cliente_id;

# SELECT [CAMPO1] <AS> [ALIAS_CAMPO1], [CAMPO2] <AS> [ALIAS_CAMPO2], ..., [CAMPOn] <AS> [ALIAS_CAMPOn] FROM [NOMBRE_TABLA];
-- Selecciona X campo(s) con Y alias de Z tabla.
SELECT nombre_usuario usuario, correo_electronico correo FROM cliente;

# SELECT [CAMPO1] <AS> [ALIAS_CAMPO1], [CAMPO2] <AS> [ALIAS_CAMPO2], <[EXPRESIÓN] <AS> <[ALIAS]>>..., [CAMPOn] <AS> [ALIAS_CAMPOn] FROM [NOMBRE_TABLA];
-- Selecciona X campo(s) con Y alias de Z tabla. Agrega columnas artificiales y le asigna el resultado de una expresión.
SELECT nombre_usuario AS usuario, correo_electronico correo, edad + 1 AS proxima_edad FROM cliente;

# SELECT [CAMPO1, CAMPO2, ..., CAMPOn] from [NOMBRE_TABLA] <WHERE [CONDICION1] <[AND | OR] [CONDICION2]>, ..., <[AND | OR] [CONDICIONn]>;
-- Selecciona campos específicos de X tabla que cumplan con cierta(s) condición(es).
SELECT * FROM cliente WHERE edad >= 21;
SELECT * FROM cliente WHERE edad = 21;
SELECT * FROM cliente WHERE edad <> 21 OR genero_id <> 2;
SELECT * FROM cliente WHERE edad BETWEEN 15 AND 25;
SELECT * FROM cliente WHERE edad IN (3, 19, 22, 21);

SELECT * FROM cliente;

# SELECT [CAMPO1, CAMPO2, ..., CAMPOn] from [NOMBRE_TABLA] WHERE [CAMPO1] LIKE [VALOR_CAMPO1];
SELECT * FROM cliente WHERE nombre_usuario LIKE 'juanperez';
SELECT * FROM cliente WHERE nombre LIKE 'M%';
SELECT * FROM cliente WHERE nombre LIKE '%Z%';
SELECT * FROM cliente WHERE nombre LIKE '%a__o%';

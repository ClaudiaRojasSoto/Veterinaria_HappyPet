happypet=# CREATE TABLE dueno (
    dueno_id SERIAL PRIMARY KEY,
    dueno_rut VARCHAR(10) NOT NULL UNIQUE,
    dueno_nombre VARCHAR(100) NOT NULL,
    dueno_apellidos VARCHAR(100) NOT NULL,
    dueno_email VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO dueno (dueno_rut, dueno_nombre, dueno_apellidos, dueno_email) 
VALUES 
    ('18987345-6', 'Eugene', 'Boyde', 'eboyde0@squarespace.com'),
    ('19009874-3', 'Constantine', 'Gooke', 'cgooke1@addtoany.com'),
    ('16123987-1', 'Riccardo', 'Reinger', 'rreinger2@wordpress.com'),
    ('7098345-4', 'Dominick', 'Iacomettii', 'diacomettii3@eventbrite.com'),
    ('16678098-9', 'Camella', 'Nice', 'cnice4@salon.com');

CREATE TABLE genero (
    genero_id SERIAL PRIMARY KEY,
    genero_descripcion VARCHAR(50) NOT NULL
);

INSERT INTO genero (genero_descripcion) 
VALUES ('Hembra'), ('Macho');

^C  ('Multi Vitaminico', 'Bayer', 2, 2, 8);inventario_marca, tipo_producto_id, sucursal_id, inventario_existencia) on, box_atencion) 
happypet=# CREATE TABLE dueno (
    dueno_id SERIAL PRIMARY KEY,
    dueno_rut VARCHAR(10) NOT NULL UNIQUE,
    dueno_nombre VARCHAR(100) NOT NULL,
    dueno_apellidos VARCHAR(100) NOT NULL,
    dueno_email VARCHAR(100) NOT NULL UNIQUE
);

INSERT INTO dueno (dueno_rut, dueno_nombre, dueno_apellidos, dueno_email) 
VALUES 
    ('18987345-6', 'Eugene', 'Boyde', 'eboyde0@squarespace.com'),
    ('19009874-3', 'Constantine', 'Gooke', 'cgooke1@addtoany.com'),
    ('16123987-1', 'Riccardo', 'Reinger', 'rreinger2@wordpress.com'),
    ('7098345-4', 'Dominick', 'Iacomettii', 'diacomettii3@eventbrite.com'),
    ('16678098-9', 'Camella', 'Nice', 'cnice4@salon.com');
CREATE TABLE
INSERT 0 5
happypet=# CREATE TABLE genero (
    genero_id SERIAL PRIMARY KEY,
    genero_descripcion VARCHAR(50) NOT NULL
);

INSERT INTO genero (genero_descripcion) 
VALUES ('Hembra'), ('Macho');
CREATE TABLE
INSERT 0 2
happypet=# CREATE TABLE tipo_mascota (
    tipo_mascota_id SERIAL PRIMARY KEY,
    tipo_mascota_descripcion VARCHAR(50) NOT NULL
);

INSERT INTO tipo_mascota (tipo_mascota_descripcion) 
VALUES ('Perro'), ('Gato'), ('Loro'), ('Caballo'), ('Hamster'), ('Iguana'), ('Conejo');
CREATE TABLE
INSERT 0 7
happypet=# CREATE TABLE mascota (
    mascota_id SERIAL PRIMARY KEY,
    mascota_nombre VARCHAR(50) NOT NULL,
    mascota_raza VARCHAR(50) NOT NULL,
    dueno_id INT NOT NULL REFERENCES dueno (dueno_id),
    genero_id INT NOT NULL REFERENCES genero (genero_id),
    tipo_mascota_id INT NOT NULL REFERENCES tipo_mascota (tipo_mascota_id)
);

INSERT INTO mascota (mascota_nombre, mascota_raza, dueno_id, genero_id, tipo_mascota_id) 
VALUES 
    ('wolf', 'Golden', 1, 2, 1),
    ('Squirrel', 'BullDog Ingles', 2, 1, 1),
    ('Plover', 'Persa', 3, 1, 1),
    ('pilot', 'Egipcio', 4, 1, 2),
    ('ferret', 'Verde', 5, 1, 3);
CREATE TABLE
INSERT 0 5
happypet=# CREATE TABLE medico (
    medico_id SERIAL PRIMARY KEY,
    medico_rut VARCHAR(10) NOT NULL,
    medico_nombre VARCHAR(100) NOT NULL,
    medico_apellidos VARCHAR(100) NOT NULL,
    medico_email VARCHAR(100) NOT NULL
);

INSERT INTO medico (medico_rut, medico_nombre, medico_apellidos, medico_email) 
VALUES 
    ('15987645-2', 'Dana', 'Philott', 'dphilott0@washingtonpost.com'),
    ('13925645-K', 'Kinsley', 'Vannini', 'kvannini1@ycombinator.com'),
    ('12987345-2', 'Madel', 'Staning', 'mstaning2@shutterfly.com'),
    ('15900630-2', 'Cecilio', 'Clynman', 'cclynman3@clickbank.net'),
    ('14234743-2', 'Pedro', 'Evemy', 'pevemy4@cbsnews.com');
CREATE TABLE
INSERT 0 5
happypet=# CREATE TABLE sucursal (
    sucursal_id SERIAL PRIMARY KEY,
    sucursal_nombre VARCHAR(100) NOT NULL,
    sucursal_direccion VARCHAR(100) NOT NULL,
    sucursal_telefono VARCHAR(100) NOT NULL
);

INSERT INTO sucursal (sucursal_nombre, sucursal_direccion, sucursal_telefono) 
VALUES 
    ('Casa Matriz', 'Los pinos 1214', '67897455'),
    ('Sucursal Jose Perez', 'Jose Perez 98', '67897454');
CREATE TABLE
INSERT 0 2
happypet=# CREATE TABLE medico_sucursal (
    medico_sucursal_id SERIAL PRIMARY KEY,
    medico_id INT NOT NULL REFERENCES medico (medico_id),
    sucursal_id INT NOT NULL REFERENCES sucursal (sucursal_id),
    titular BOOLEAN NOT NULL
);

INSERT INTO medico_sucursal (medico_id, sucursal_id, titular) 
VALUES 
    (1, 1, TRUE), 
    (2, 2, TRUE),
    (3, 1, FALSE),
    (3, 2, FALSE),
    (4, 1, FALSE),
    (4, 2, FALSE),
    (5, 1, FALSE),
    (5, 2, FALSE);
CREATE TABLE
INSERT 0 8
happypet=# CREATE TABLE tipo_atencion (
    tipo_atencion_id SERIAL PRIMARY KEY,
    tipo_atencion_descripcion VARCHAR(50) NOT NULL
);

INSERT INTO tipo_atencion (tipo_atencion_descripcion) 
VALUES ('Medica'), ('Cirugia');
CREATE TABLE
INSERT 0 2
happypet=# CREATE TABLE atencion (
    atencion_id SERIAL PRIMARY KEY,
    medico_id INT NOT NULL REFERENCES medico (medico_id),
    sucursal_id INT NOT NULL REFERENCES sucursal (sucursal_id),
    mascota_id INT NOT NULL REFERENCES mascota (mascota_id),
    tipo_atencion_id INT NOT NULL REFERENCES tipo_atencion (tipo_atencion_id),
    fecha_realizacion TIMESTAMP NOT NULL,
    fecha_proxima_revision TIMESTAMP DEFAULT NULL,
    box_atencion VARCHAR(50) NOT NULL
);

INSERT INTO atencion (medico_id, sucursal_id, mascota_id, tipo_atencion_id, fecha_realizacion, fecha_proxima_revision, box_atencion) 
VALUES 
    (1, 1, 1, 1, NOW(), NOW() + INTERVAL '6 days', 'Box 3'),
    (2, 2, 2, 2, NOW(), NOW() + INTERVAL '6 days', 'Box 1'),
    (3, 1, 3, 1, NOW() + INTERVAL '2 days', NOW() + INTERVAL '12 days', 'Box 5'),
    (4, 2, 4, 2, NOW(), NOW() + INTERVAL '6 days', 'Box 3'),
    (5, 1, 5, 1, NOW() + INTERVAL '1 day', NOW() + INTERVAL '12 days', 'Box 5');
CREATE TABLE
INSERT 0 5
happypet=# CREATE TABLE tipo_producto (
    tipo_producto_id SERIAL PRIMARY KEY,
    tipo_producto_descripcion VARCHAR(50) NOT NULL
);

INSERT INTO tipo_producto (tipo_producto_descripcion) 
VALUES ('Accesorio'), ('Remedio');
CREATE TABLE
INSERT 0 2
happypet=# CREATE TABLE inventario (
    inventario_id SERIAL PRIMARY KEY,
    inventario_nombre VARCHAR(100) NOT NULL,
    inventario_marca VARCHAR(100) NOT NULL,
    tipo_producto_id INT NOT NULL REFERENCES tipo_producto (tipo_producto_id),
    sucursal_id INT NOT NULL REFERENCES sucursal (sucursal_id),
    inventario_existencia INT NOT NULL
);

INSERT INTO inventario (inventario_nombre, inventario_marca, tipo_producto_id, sucursal_id, inventario_existencia) 
VALUES 
    ('Collar Rojo', 'BrandPig', 1, 1, 4),
    ('Analgesico', 'Bayer', 2, 1, 12),
    ('Hueso Goma', 'BrandPig', 1, 2, 2),
    ('Multi Vitaminico', 'Bayer', 2, 2, 8);
CREATE TABLE
INSERT 0 4
happypet=# 
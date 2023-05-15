/*
  Archivo: biblioteca.sql

  Bases de datos - 750006C-01
  Proyecto del curso - Base de datos de una biblioteca

  Integrantes: 
  John Freddy Belalcázar Rojas 2182464-3743 
  Santiago González Gálvez 2183392-3743 
  Juan Camilo Narváez Tascón 2140112-3743 
  Christian David Vargas Gutiérrez 2179172-3743
*/

-- Editorial --
DROP TABLE IF EXISTS editorial CASCADE;
CREATE TABLE editorial (
  codigo_editorial VARCHAR(5) NOT NULL,
  nombre_editorial VARCHAR(100) NOT NULL,
  pais_origen VARCHAR(100),
  pagina_web VARCHAR(100),
  
  PRIMARY KEY (codigo_editorial)
);

-- Area --
DROP TABLE IF EXISTS area_conocimiento CASCADE;
CREATE TABLE area_conocimiento(
  codigo_area VARCHAR(5) NOT NULL,
  nombre_area VARCHAR(100) NOT NULL,
  descripcion_area VARCHAR(500),
  area_padre VARCHAR(5),
  
  PRIMARY KEY (codigo_area),
  FOREIGN KEY (area_padre) REFERENCES area_conocimiento (codigo_area)
);

-- Libro --
DROP TABLE IF EXISTS libro CASCADE;
CREATE TABLE libro (
  ISBN VARCHAR(5) NOT NULL,
  titulo VARCHAR(100) NOT NULL,
  num_pagina VARCHAR(4),
  anio_publicacion VARCHAR(4),
  idioma VARCHAR(20),
  codigo_area VARCHAR(5) NOT NULL,
  codigo_editorial VARCHAR(5) NOT NULL,
  
  PRIMARY KEY(ISBN),
  FOREIGN KEY(codigo_editorial) REFERENCES editorial (codigo_editorial),
  FOREIGN KEY(codigo_area) REFERENCES area_conocimiento (codigo_area)
);

-- Autor --
DROP TABLE IF EXISTS autor CASCADE;
CREATE TABLE autor (
  codigo_autor VARCHAR(5) NOT NULL,
  primer_nombre VARCHAR(100) NOT NULL,
  segundo_nombre VARCHAR(100),
  primer_apellido VARCHAR(100) NOT NULL,
  segundo_apellido VARCHAR(100),
  
  PRIMARY KEY(codigo_autor)
);

-- Escribe --
DROP TABLE IF EXISTS escribe CASCADE;
CREATE TABLE escribe (
  codigo_autor VARCHAR(5) NOT NULL,
  ISBN VARCHAR(5) NOT NULL,

  PRIMARY KEY (codigo_autor, ISBN),
  FOREIGN KEY (codigo_autor) REFERENCES autor (codigo_autor),
  FOREIGN KEY (ISBN) REFERENCES libro (ISBN)
);

-- Digital --
DROP TABLE IF EXISTS digital CASCADE;
CREATE TABLE digital(
  ISBN VARCHAR(5) NOT NULL,
  URL VARCHAR(200) NOT NULL,
  tamano_bytes INT,
  formato VARCHAR(15),
  
  PRIMARY KEY (ISBN, URL),
  FOREIGN KEY (ISBN) REFERENCES libro (ISBN)
);

-- Ejemplar --
DROP TABLE IF EXISTS ejemplar CASCADE;
CREATE TABLE ejemplar(
  ISBN VARCHAR(5) NOT NULL,
  num_ejemplar INT NOT NULL,
  estante VARCHAR(5),
  num_cajon VARCHAR(5),
  num_pasillo VARCHAR(5),
  nombre_sala VARCHAR(100),
  
  PRIMARY KEY (ISBN, num_ejemplar),
  FOREIGN KEY (ISBN) REFERENCES libro (ISBN)
);

-- Usuario --
DROP TABLE IF EXISTS usuario CASCADE;
CREATE TABLE usuario(
  id_usuario VARCHAR(5) NOT NULL,
  nombre_usuario VARCHAR(100),
  telefono  VARCHAR(10),
  direccion VARCHAR(100),
  email VARCHAR(50),
  
  PRIMARY KEY (id_usuario)
);

-- Estudiante --
DROP TABLE IF EXISTS estudiante CASCADE;
CREATE TABLE estudiante(
  id_usuario VARCHAR(5) NOT NULL,
  carrera VARCHAR(50),
  universidad VARCHAR(100),

  PRIMARY KEY (id_usuario),
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);

-- Profesor --
DROP TABLE IF EXISTS profesor CASCADE;
CREATE TABLE profesor (
  id_usuario VARCHAR(5) NOT NULL, 
  dependencia VARCHAR(50),
  titulo VARCHAR(50),

  PRIMARY KEY (id_usuario),
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario)
);

-- Áreas interés de profesores ---
DROP TABLE IF EXISTS areas_interes_profesor CASCADE;
CREATE TABLE areas_interes_profesor (
  id_usuario VARCHAR(5) NOT NULL, 
  codigo_area VARCHAR(5) NOT NULL, 

  PRIMARY KEY (id_usuario, codigo_area),
  FOREIGN KEY (id_usuario) REFERENCES profesor (id_usuario),
  FOREIGN KEY (codigo_area) REFERENCES area_conocimiento (codigo_area)
);

-- Empleado --
DROP TABLE IF EXISTS empleado CASCADE;
CREATE TABLE empleado (
  id_empleado VARCHAR(5) NOT NULL, 
  nombre_empleado VARCHAR(100) NOT NULL,
  cargo VARCHAR(50),

  CONSTRAINT id_empleado_pk PRIMARY KEY (id_empleado)
);

-- Solicitud --
DROP TABLE IF EXISTS solicitud CASCADE;
CREATE TABLE solicitud (
  consecutivo_solicitud VARCHAR(5) NOT NULL,
  id_usuario VARCHAR(5) NOT NULL,
  ISBN VARCHAR(5) NOT NULL,
  fecha_solicitud DATE, 
  descripcion VARCHAR(100),

  PRIMARY KEY (consecutivo_solicitud),
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  FOREIGN KEY (ISBN) REFERENCES libro (ISBN)
);

-- Descarga --
DROP TABLE IF EXISTS descarga CASCADE;
CREATE TABLE descarga (
  id_usuario VARCHAR(5) NOT NULL,
  fecha_descarga_con_hora TIMESTAMP NOT NULL,
  ISBN VARCHAR(5) NOT NULL,
  URL VARCHAR(200) NOT NULL,
  num_ip VARCHAR(12), 

  PRIMARY KEY (id_usuario, fecha_descarga_con_hora),
  FOREIGN KEY (ISBN, URL) REFERENCES digital (ISBN, URL)
);

-- Prestamo --
DROP TABLE IF EXISTS prestamo CASCADE;
CREATE TABLE prestamo (
  consecutivo_prestamo VARCHAR(5) NOT NULL, 
  id_usuario VARCHAR(5) NOT NULL,
  id_empleado VARCHAR(5) NOT NULL,
  fecha_prestamo DATE, 

  PRIMARY KEY (consecutivo_prestamo),
  FOREIGN KEY (id_usuario) REFERENCES usuario (id_usuario),
  FOREIGN KEY (id_empleado) REFERENCES empleado (id_empleado)
);

-- Presta --
DROP TABLE IF EXISTS presta CASCADE;
CREATE TABLE presta (
  consecutivo_prestamo VARCHAR(5) NOT NULL,
  ISBN VARCHAR(5) NOT NULL,
  num_ejemplar INT NOT NULL,
  fecha_devolucion_esperada DATE,
  fecha_devolucion_real DATE, 

  PRIMARY KEY (consecutivo_prestamo, ISBN, num_ejemplar),
  FOREIGN KEY (ISBN, num_ejemplar) REFERENCES ejemplar (ISBN, num_ejemplar)
);

-- Multa --
DROP TABLE IF EXISTS multa CASCADE;
CREATE TABLE multa (
  consecutivo_prestamo VARCHAR(5) NOT NULL,
  ISBN VARCHAR(5) NOT NULL,
  num_ejemplar INT NOT NULL,
  fecha_multa DATE, 
  valor_multa MONEY, 
  descripcion_multa VARCHAR(100),

  PRIMARY KEY (consecutivo_prestamo, ISBN, num_ejemplar, fecha_multa),
  FOREIGN KEY (consecutivo_prestamo, ISBN, num_ejemplar) REFERENCES presta (consecutivo_prestamo, ISBN, num_ejemplar)
);

INSERT INTO editorial (codigo_editorial, nombre_editorial, pais_origen, pagina_web) VALUES
('ED001', 'McGraw-Hill', 'Estados Unidos', 'www.mheducation.com'),
('ED002', 'Pearson Education', 'Reino Unido', 'www.pearson.com'),
('ED003', 'Wiley', 'Estados Unidos', 'www.wiley.com'),
('ED004', 'Oxford University Press', 'Reino Unido', 'global.oup.com'),
('ED005', 'Cambridge University Press', 'Reino Unido', 'www.cambridge.org'),
('ED006', 'Springer', 'Alemania', 'www.springer.com'),
('ED007', 'Addison-Wesley', 'Estados Unidos', 'www.pearson.com'),
('ED008', 'Elsevier', 'Países Bajos', 'www.elsevier.com'),
('ED009', 'HarperCollins Publishers', 'Reino Unido', 'www.harpercollins.com'),
('ED010', 'Cengage Learning', 'Estados Unidos', 'www.cengage.com');

INSERT INTO area_conocimiento (codigo_area, nombre_area, descripcion_area, area_padre) VALUES
('AC001', 'Matematicas', 'Ciencia que se dedica al estudio de las propiedades de los numeros y las operaciones aritmeticas y algebraicas.', NULL),
('AC002', 'Fisica', 'Ciencia que estudia las propiedades y el comportamiento de la energia y la materia.', NULL),
('AC003', 'Quimica', 'Ciencia que estudia la composicion, estructura, propiedades y transformaciones de la materia.', NULL),
('AC004', 'Biologia', 'Ciencia que estudia los seres vivos, su origen, evolucion y propiedades.', NULL),
('AC005', 'Informatica', 'Ciencia que estudia el tratamiento automatico de la informacion mediante ordenadores.', NULL),
('AC006', 'Ingenieria Civil', 'Rama de la ingenieria que se ocupa del diseno, construccion, mantenimiento y gestion de infraestructuras y edificaciones.', NULL),
('AC007', 'Ingenieria Mecanica', 'Rama de la ingenieria que se ocupa del diseno, construccion y mantenimiento de maquinaria y sistemas mecanicos.', NULL),
('AC008', 'Medicina', 'Ciencia que se dedica al estudio de la salud y las enfermedades en los seres humanos.', NULL),
('AC009', 'Psicologia', 'Ciencia que estudia la conducta y los procesos mentales de los seres humanos y otros animales.', NULL),
('AC010', 'Filosofia', 'Ciencia que se ocupa de estudiar la realidad, el conocimiento, la moral, la mente y el lenguaje.', NULL),
('AC011', 'Algebra', 'Rama de las matematicas que se ocupa de las estructuras algebraicas y sus propiedades.', 'AC001'),
('AC012', 'Geometria', 'Rama de las matematicas que se ocupa del estudio de las propiedades y las relaciones de los puntos, las lineas, las figuras y los cuerpos en el espacio.', 'AC001'),
('AC013', 'Calculo', 'Rama de las matematicas que se ocupa del estudio de los limites, las derivadas, las integrales y las series infinitas.', 'AC001'),
('AC014', 'Mecanica Clasica', 'Rama de la fisica que estudia el movimiento de los cuerpos y sus interacciones.', 'AC002'),
('AC015', 'Fisica Cuantica', 'Rama de la fisica que estudia los fenomenos y las propiedades de la materia a nivel subatomico.', 'AC002'),
('AC016', 'Termodinamica', 'Rama de la fisica que se ocupa del estudio de los procesos de transferencia de calor y trabajo.', 'AC002'),
('AC017', 'Quimica Organica', 'Rama de la quimica que estudia los compuestos quimicos que contienen carbono.', 'AC003'),
('AC018', 'Quimica Inorganica', 'Rama de la quimica que estudia los compuestos quimicos que no contienen carbono.', 'AC003'),
('AC019', 'Algebra Lineal', 'Rama de las matematicas que se ocupa del estudio de los espacios vectoriales y las transformaciones lineales.', 'AC011'),
('AC020', 'Geometria Analitica', 'Rama de las matematicas que se ocupa de las figuras geometricas en un sistema de coordenadas.', 'AC012'),
('AC021', 'Calculo Vectorial', 'Rama de las matematicas que se ocupa de las funciones de varias variables y sus derivadas.', 'AC013'),
('AC022', 'Fisica Nuclear', 'Rama de la fisica que se ocupa del estudio del nucleo atomico y sus interacciones.', 'AC015'),
('AC023', 'Fisica de Particulas', 'Rama de la fisica que se ocupa del estudio de las particulas elementales y sus interacciones.', 'AC015'),
('AC024', 'Mecanica de Fluidos', 'Rama de la fisica que se ocupa del estudio del movimiento de los fluidos y sus interacciones con solidos y gases.', 'AC014'),
('AC025', 'Electromagnetismo', 'Rama de la fisica que se ocupa del estudio de las interacciones entre cargas electricas y campos magneticos.', 'AC014'),
('AC026', 'Bioquimica', 'Rama de la quimica que se ocupa del estudio de los procesos quimicos que tienen lugar en los seres vivos.', 'AC017'),
('AC027', 'Quimica Analitica', 'Rama de la quimica que se ocupa del estudio de la composicion quimica de las sustancias.', 'AC018'),
('AC028', 'Ingenieria Electrica', 'Rama de la ingenieria que se ocupa del diseño, construccion y mantenimiento de sistemas electricos y electronicos.', 'AC007'),
('AC029', 'Ingenieria de Materiales', 'Rama de la ingenieria que se ocupa del estudio de los materiales y sus propiedades para su uso en aplicaciones tecnologicas.', 'AC006'),
('AC030', 'Neurociencia', 'Ciencia que se dedica al estudio del sistema nervioso y su relacion con el comportamiento y la cognicion.', 'AC004'),
('AC031', 'Ciencias de la Computacion', 'Ciencia que estudia los fundamentos teoricos y practicos de la computacion y la programacion.', 'AC005'),
('AC032', 'Ingenieria de Software', 'Rama de la ingenieria que se ocupa del diseño, desarrollo, mantenimiento y gestion de software.', 'AC005'),
('AC033', 'Inteligencia Artificial', 'Rama de la informatica que se ocupa del desarrollo de algoritmos y sistemas capaces de realizar tareas que requieren inteligencia humana, como el aprendizaje y la toma de decisiones.', 'AC005'),
('AC034', 'Redes y Comunicaciones', 'Rama de la informatica que se ocupa del diseño, construccion y mantenimiento de redes de computadoras y sistemas de comunicaciones.', 'AC005'),
('AC035', 'Sistemas Operativos', 'Rama de la informatica que se ocupa del diseño, construccion y gestion de los sistemas operativos.', 'AC005'),
('AC036', 'Literatura', 'Estudio de la escritura, la lectura y la interpretacion de obras literarias en diferentes generos y formas de expresion.', NULL),
('AC037', 'Literatura Colombiana', 'Estudio de la produccion literaria de autores colombianos o sobre Colombia, abarcando diversas epocas, generos y temas.', 'AC036'),
('AC038', 'Historia', 'Estudio critico y sistematico del pasado humano a traves de fuentes escritas, orales, arqueologicas y visuales para comprender y explicar el presente y proyectar el futuro.', NULL);

-- Libro
INSERT INTO libro (ISBN, titulo, num_pagina, anio_publicacion, idioma, codigo_area, codigo_editorial) VALUES
('LI001', 'Introducción a las Matemáticas', '350', '2010', 'Español', 'AC001', 'ED001'),
('LI002', 'Física para Principiantes', '250', '2015', 'Español', 'AC002', 'ED002'),
('LI003', 'Química Orgánica Avanzada', '400', '2012', 'Inglés', 'AC017', 'ED003'),
('LI004', 'Biología Celular y Molecular', '500', '2018', 'Español', 'AC004', 'ED004'),
('LI005', 'Programación en Python', '300', '2019', 'Español', 'AC031', 'ED005'),
('LI006', 'Diseño Estructural de Puentes', '450', '2016', 'Español', 'AC006', 'ED006'),
('LI007', 'Mecánica de Máquinas', '400', '2014', 'Español', 'AC007', 'ED007'),
('LI008', 'Medicina Interna: Diagnóstico y Tratamiento', '600', '2017', 'Español', 'AC008', 'ED008'),
('LI009', 'Psicología del Desarrollo', '350', '2011', 'Español', 'AC009', 'ED009'),
('LI010', 'Filosofía del Conocimiento', '250', '2013', 'Español', 'AC010', 'ED010'),
('LI011', 'Álgebra Lineal Aplicada', '400', '2018', 'Español', 'AC019', 'ED001'),
('LI012', 'Geometría Analítica y Cálculo Vectorial', '450', '2016', 'Español', 'AC020', 'ED002'),
('LI013', 'Física Cuántica Avanzada', '350', '2014', 'Inglés', 'AC022', 'ED003'),
('LI014', 'Química Inorgánica: Principios y Aplicaciones', '500', '2017', 'Español', 'AC018', 'ED004'),
('LI015', 'Cálculo Integral: Teoría y Práctica', '400', '2015', 'Español', 'AC021', 'ED005'),
('LI016', 'Mecánica Clásica: Fundamentos y Aplicaciones', '450', '2013', 'Español', 'AC014', 'ED006'),
('LI017', 'Termodinámica y Transferencia de Calor', '400', '2012', 'Español', 'AC016', 'ED007'),
('LI018', 'Bioquímica: Estructura y Función', '500', '2019', 'Español', 'AC026', 'ED008'),
('LI019', 'Química Analítica Avanzada', '350', '2010', 'Español', 'AC027', 'ED009'),
('LI020', 'Matemáticas Avanzadas para Ingeniería', '500', '2022', 'Español', 'AC001', 'ED001'),
('LI021', 'Ingeniería de Materiales: Propiedades y Aplicaciones', '450', '2018', 'Español', 'AC029', 'ED010'),
('LI022', 'Neurociencia Cognitiva', '350', '2017', 'Español', 'AC030', 'ED001'),
('LI023', 'Introducción a la Computación', '300', '2013', 'Español', 'AC031', 'ED002'),
('LI024', 'Inteligencia Artificial: Fundamentos y Aplicaciones', '400', '2015', 'Español', 'AC033', 'ED003'),
('LI025', 'Redes y Comunicaciones: Principios y Práctica', '450', '2016', 'Español', 'AC034', 'ED004'),
('LI026', 'Sistemas Operativos Modernos', '350', '2019', 'Español', 'AC035', 'ED005'),
('LI027', 'Literatura Universal: Grandes Obras de la Historia', '500', '2014', 'Español', 'AC036', 'ED006'),
('LI028', 'Cien Años de Soledad', '400', '2010', 'Español', 'AC037', 'ED007'),
('LI029', 'Historia del Mundo Contemporáneo', '450', '2013', 'Español', 'AC038', 'ED008'),
('LI030', 'Matemáticas Avanzadas para Ingeniería', '350', '2012', 'Español', 'AC001', 'ED009'),
('LI031', 'Cálculo Diferencial e Integral', '400', '2018', 'Español', 'AC013', 'ED001'),
('LI032', 'Física Moderna: Teoría y Aplicaciones', '600', '2020', 'Español', 'AC015', 'ED002'),
('LI033', 'Introducción a la Química Orgánica', '350', '2019', 'Español', 'AC017', 'ED003'),
('LI034', 'Biología Molecular y Genética', '450', '2021', 'Español', 'AC004', 'ED004'),
('LI035', 'Programación Orientada a Objetos en C++', '300', '2017', 'Español', 'AC031', 'ED005'),
('LI036', 'Ingeniería Estructural: Diseño y Análisis', '550', '2022', 'Español', 'AC006', 'ED006'),
('LI037', 'Psicología del Desarrollo', '400', '2020', 'Español', 'AC009', 'ED007'),
('LI038', 'Historia Universal: Desde la Prehistoria hasta el Siglo XXI', '800', '2019', 'Español', 'AC038', 'ED008'),
('LI039', 'Redes de Computadoras: Fundamentos y Aplicaciones', '450', '2021', 'Español', 'AC034', 'ED009'),
('LI040', 'Medicina Interna: Diagnóstico y Tratamiento', '700', '2022', 'Español', 'AC008', 'ED010');

-- Autor
INSERT INTO autor (codigo_autor, primer_nombre, segundo_nombre, primer_apellido, segundo_apellido)
VALUES 
  ('AU001', 'John', 'Smith', 'Johnson', 'Williams'),
  ('AU002', 'Michael', 'Christopher', 'Brown', 'Jones'),
  ('AU003', 'Jennifer', 'Elizabeth', 'Davis', 'Taylor'),
  ('AU004', 'David', 'Thomas', 'Miller', 'Anderson'),
  ('AU005', 'Jessica', 'Emily', 'Wilson', 'Harris'),
  ('AU006', 'William', 'Ryan', 'Thompson', 'Clark'),
  ('AU007', 'Emily', 'Grace', 'Lewis', 'Moore'),
  ('AU008', 'Daniel', 'Jacob', 'Lee', 'Walker'),
  ('AU009', 'Ava', 'Sophia', 'Hall', 'Young'),
  ('AU010', 'James', 'Matthew', 'Allen', 'Gonzalez'),
  ('AU011', 'Olivia', 'Chloe', 'Hernandez', 'Lopez'),
  ('AU012', 'Alexander', 'Benjamin', 'King', 'Perez'),
  ('AU013', 'Sophia', 'Lily', 'Nelson', 'Wright'),
  ('AU014', 'Emma', 'Mia', 'Green', 'Hill'),
  ('AU015', 'Joseph', 'Samuel', 'Roberts', 'Turner'),
  ('AU016', 'Madison', 'Ella', 'Phillips', 'Campbell'),
  ('AU017', 'Ethan', 'Andrew', 'Baker', 'Mitchell'),
  ('AU018', 'Isabella', 'Victoria', 'Rivera', 'Parker'),
  ('AU019', 'Liam', 'Gabriel', 'Adams', 'Collins'),
  ('AU020', 'Mia', 'Natalie', 'Cook', 'Morgan'),
  ('AU021', 'Charlotte', 'Avery', 'Bell', 'Ross'),
  ('AU022', 'Noah', 'Dylan', 'Cooper', 'Reed'),
  ('AU023', 'Amelia', 'Harper', 'Morris', 'Bennett'),
  ('AU024', 'Lucas', 'Owen', 'Gray', 'James'),
  ('AU025', 'Evelyn', 'Scarlett', 'Sanders', 'Hughes'),
  ('AU026', 'Matthew', 'Jack', 'Price', 'Foster'),
  ('AU027', 'Harper', 'Sofia', 'Stewart', 'Simmons'),
  ('AU028', 'Henry', 'Leo', 'Kelly', 'Ramirez'),
  ('AU029', 'Abigail', 'Lillian', 'Reynolds', 'Murray'),
  ('AU030', 'Benjamin', 'Carter', 'Ward', 'Sullivan');

-- Escribe
INSERT INTO escribe (codigo_autor, ISBN) VALUES
('AU001', 'LI001'),
('AU002', 'LI001'),
('AU003', 'LI002'),
('AU004', 'LI003'),
('AU005', 'LI003'),
('AU006', 'LI004'),
('AU007', 'LI005'),
('AU008', 'LI005'),
('AU009', 'LI006'),
('AU010', 'LI006'),
('AU011', 'LI007'),
('AU012', 'LI008'),
('AU013', 'LI009'),
('AU014', 'LI010'),
('AU015', 'LI010'),
('AU016', 'LI011'),
('AU017', 'LI011'),
('AU018', 'LI012'),
('AU019', 'LI013'),
('AU020', 'LI013'),
('AU021', 'LI014'),
('AU022', 'LI015'),
('AU023', 'LI016'),
('AU024', 'LI017'),
('AU025', 'LI018'),
('AU026', 'LI018'),
('AU027', 'LI019'),
('AU028', 'LI020'),
('AU029', 'LI021'),
('AU030', 'LI022'),
('AU001', 'LI023'),
('AU002', 'LI024'),
('AU003', 'LI025'),
('AU004', 'LI025'),
('AU005', 'LI026'),
('AU006', 'LI027'),
('AU007', 'LI028'),
('AU008', 'LI029'),
('AU009', 'LI030'),
('AU010', 'LI030');

-- Digital
INSERT INTO digital (ISBN, URL, tamano_bytes, formato) VALUES
('LI001', 'https://example.com/book1', 2500000, 'PDF'),
('LI002', 'https://example.com/book2', 1800000, 'EPUB'),
('LI003', 'https://example.com/book3', 3500000, 'PDF'),
('LI004', 'https://example.com/book4', 2100000, 'EPUB'),
('LI005', 'https://example.com/book5', 3200000, 'PDF'),
('LI006', 'https://example.com/book6', 2900000, 'PDF'),
('LI007', 'https://example.com/book7', 1800000, 'EPUB'),
('LI008', 'https://example.com/book8', 2700000, 'PDF'),
('LI009', 'https://example.com/book9', 1500000, 'EPUB'),
('LI010', 'https://example.com/book10', 2400000, 'PDF'),
('LI011', 'https://example.com/book11', 2000000, 'PDF'),
('LI012', 'https://example.com/book12', 3100000, 'EPUB'),
('LI013', 'https://example.com/book13', 1900000, 'PDF'),
('LI014', 'https://example.com/book14', 2600000, 'EPUB'),
('LI015', 'https://example.com/book15', 2200000, 'PDF'),
('LI016', 'https://example.com/book16', 3000000, 'PDF'),
('LI017', 'https://example.com/book17', 2300000, 'EPUB'),
('LI018', 'https://example.com/book18', 1700000, 'PDF'),
('LI019', 'https://example.com/book19', 2800000, 'EPUB'),
('LI020', 'https://example.com/book20', 3300000, 'PDF'),
('LI021', 'https://example.com/book21', 2400000, 'PDF'),
('LI022', 'https://example.com/book22', 2200000, 'EPUB'),
('LI023', 'https://example.com/book23', 3000000, 'PDF'),
('LI024', 'https://example.com/book24', 1900000, 'EPUB'),
('LI025', 'https://example.com/book25', 2600000, 'PDF'),
('LI026', 'https://example.com/book26', 2100000, 'PDF'),
('LI027', 'https://example.com/book27', 3200000, 'EPUB'),
('LI028', 'https://example.com/book28', 2700000, 'PDF'),
('LI029', 'https://example.com/book29', 1800000, 'EPUB'),
('LI030', 'https://example.com/book30', 2500000, 'PDF');

-- Ejemplar
INSERT INTO ejemplar (ISBN, num_ejemplar, estante, num_cajon, num_pasillo, nombre_sala) VALUES
('LI001', 1, 'ES001', 'CA001', 'PAS01', 'Sala Matemáticas'),
('LI001', 2, 'ES001', 'CA001', 'PAS01', 'Sala Matemáticas'),
('LI001', 3, 'ES001', 'CA001', 'PAS01', 'Sala Matemáticas'),
('LI001', 4, 'ES001', 'CA001', 'PAS01', 'Sala Matemáticas'),
('LI002', 1, 'ES002', 'CA002', 'PAS02', 'Sala Física'),
('LI002', 2, 'ES002', 'CA002', 'PAS02', 'Sala Física'),
('LI003', 1, 'ES003', 'CA003', 'PAS03', 'Sala Química'),
('LI003', 2, 'ES003', 'CA003', 'PAS03', 'Sala Química'),
('LI003', 3, 'ES003', 'CA003', 'PAS03', 'Sala Química'),
('LI004', 1, 'ES004', 'CA004', 'PAS04', 'Sala Biología'),
('LI004', 2, 'ES004', 'CA004', 'PAS04', 'Sala Biología'),
('LI005', 1, 'ES005', 'CA005', 'PAS05', 'Sala Informática'),
('LI005', 2, 'ES005', 'CA005', 'PAS05', 'Sala Informática'),
('LI005', 3, 'ES005', 'CA005', 'PAS05', 'Sala Informática'),
('LI005', 4, 'ES005', 'CA005', 'PAS05', 'Sala Informática'),
('LI006', 1, 'ES006', 'CA006', 'PAS06', 'Sala Matemáticas'),
('LI006', 2, 'ES006', 'CA006', 'PAS06', 'Sala Matemáticas'),
('LI006', 3, 'ES006', 'CA006', 'PAS06', 'Sala Matemáticas'),
('LI006', 4, 'ES006', 'CA006', 'PAS06', 'Sala Matemáticas'),
('LI007', 1, 'ES007', 'CA007', 'PAS07', 'Sala Física'),
('LI007', 2, 'ES007', 'CA007', 'PAS07', 'Sala Física'),
('LI007', 3, 'ES007', 'CA007', 'PAS07', 'Sala Física'),
('LI008', 1, 'ES008', 'CA008', 'PAS08', 'Sala Química'),
('LI008', 2, 'ES008', 'CA008', 'PAS08', 'Sala Química'),
('LI009', 1, 'ES009', 'CA009', 'PAS09', 'Sala Biología'),
('LI009', 2, 'ES009', 'CA009', 'PAS09', 'Sala Biología'),
('LI009', 3, 'ES009', 'CA009', 'PAS09', 'Sala Biología'),
('LI010', 1, 'ES010', 'CA010', 'PAS10', 'Sala Informática'),
('LI010', 2, 'ES010', 'CA010', 'PAS10', 'Sala Informática'),
('LI010', 3, 'ES010', 'CA010', 'PAS10', 'Sala Informática'),
('LI010', 4, 'ES010', 'CA010', 'PAS10', 'Sala Informática'),
('LI011', 1, 'ES011', 'CA011', 'PAS01', 'Sala Matemáticas'),
('LI011', 2, 'ES011', 'CA011', 'PAS01', 'Sala Matemáticas'),
('LI011', 3, 'ES011', 'CA011', 'PAS01', 'Sala Matemáticas'),
('LI012', 1, 'ES012', 'CA012', 'PAS02', 'Sala Física'),
('LI012', 2, 'ES012', 'CA012', 'PAS02', 'Sala Física'),
('LI013', 1, 'ES013', 'CA013', 'PAS03', 'Sala Química'),
('LI013', 2, 'ES013', 'CA013', 'PAS03', 'Sala Química'),
('LI013', 3, 'ES013', 'CA013', 'PAS03', 'Sala Química'),
('LI013', 4, 'ES013', 'CA013', 'PAS03', 'Sala Química'),
('LI014', 1, 'ES014', 'CA014', 'PAS04', 'Sala Historia'),
('LI014', 2, 'ES014', 'CA014', 'PAS04', 'Sala Historia'),
('LI014', 3, 'ES014', 'CA014', 'PAS04', 'Sala Historia'),
('LI015', 1, 'ES015', 'CA015', 'PAS05', 'Sala Literatura'),
('LI016', 1, 'ES016', 'CA016', 'PAS06', 'Sala Arte'),
('LI016', 2, 'ES016', 'CA016', 'PAS06', 'Sala Arte'),
('LI017', 1, 'ES017', 'CA017', 'PAS07', 'Sala Psicología'),
('LI018', 1, 'ES018', 'CA018', 'PAS08', 'Sala Economía'),
('LI018', 2, 'ES018', 'CA018', 'PAS08', 'Sala Economía'),
('LI019', 1, 'ES019', 'CA019', 'PAS09', 'Sala Biología'),
('LI019', 2, 'ES019', 'CA019', 'PAS09', 'Sala Biología'),
('LI019', 3, 'ES019', 'CA019', 'PAS09', 'Sala Biología'),
('LI020', 2, 'ES020', 'CA020', 'PAS10', 'Sala Informática'),
('LI020', 3, 'ES020', 'CA020', 'PAS10', 'Sala Informática'),
('LI021', 1, 'ES021', 'CA021', 'PAS01', 'Sala Matemáticas'),
('LI021', 2, 'ES021', 'CA021', 'PAS01', 'Sala Matemáticas'),
('LI021', 3, 'ES021', 'CA021', 'PAS01', 'Sala Matemáticas'),
('LI022', 1, 'ES022', 'CA022', 'PAS02', 'Sala Física'),
('LI023', 1, 'ES023', 'CA023', 'PAS03', 'Sala Química'),
('LI023', 2, 'ES023', 'CA023', 'PAS03', 'Sala Química'),
('LI023', 3, 'ES023', 'CA023', 'PAS03', 'Sala Química'),
('LI024', 1, 'ES024', 'CA024', 'PAS04', 'Sala Historia'),
('LI025', 1, 'ES025', 'CA025', 'PAS05', 'Sala Literatura'),
('LI025', 2, 'ES025', 'CA025', 'PAS05', 'Sala Literatura'),
('LI025', 3, 'ES025', 'CA025', 'PAS05', 'Sala Literatura'),
('LI026', 1, 'ES026', 'CA026', 'PAS06', 'Sala Arte'),
('LI026', 2, 'ES026', 'CA026', 'PAS06', 'Sala Arte'),
('LI027', 1, 'ES027', 'CA027', 'PAS07', 'Sala Psicología'),
('LI027', 2, 'ES027', 'CA027', 'PAS07', 'Sala Psicología'),
('LI027', 3, 'ES027', 'CA027', 'PAS07', 'Sala Psicología'),
('LI028', 1, 'ES028', 'CA028', 'PAS08', 'Sala Economía'),
('LI028', 2, 'ES028', 'CA028', 'PAS08', 'Sala Economía'),
('LI028', 3, 'ES028', 'CA028', 'PAS08', 'Sala Economía'),
('LI029', 1, 'ES029', 'CA029', 'PAS09', 'Sala Biología'),
('LI029', 2, 'ES029', 'CA029', 'PAS09', 'Sala Biología'),
('LI029', 3, 'ES029', 'CA029', 'PAS09', 'Sala Biología'),
('LI030', 1, 'ES030', 'CA030', 'PAS10', 'Sala Informática'),
('LI030', 2, 'ES030', 'CA030', 'PAS10', 'Sala Informática'),
('LI030', 3, 'ES030', 'CA030', 'PAS10', 'Sala Informática');

-- Usuario
INSERT INTO usuario (id_usuario, nombre_usuario, telefono, direccion, email) VALUES
('US001', 'Juan Perez', '3182754123', 'Calle 24 # 5-100, Cali', 'juan.perez@correounivalle.edu.co'),
('US002', 'Maria Lopez', '3124567890', 'Avenida 4 Norte # 10-20, Cali', 'maria.lopez@correounivalle.edu.co'),
('US003', 'Pedro Garcia', '3156789012', 'Calle 13 # 13-15, Cali', 'pedro.garcia@correounivalle.edu.co'),
('US004', 'Ana Rodriguez', '3203456789', 'Calle 55 # 10-11, Cali', 'ana.rodriguez@correounivalle.edu.co'),
('US005', 'Luisa Martinez', '3237890123', 'Avenida circunvalar # 10-22, Cali', 'luisa.martinez@correounivalle.edu.co'),
('US006', 'Carlos Sanchez', '3202345678', 'Ventanales de Santa Monica, apto 201, Cali', 'carlos.sanchez@correounivalle.edu.co'),
('US007', 'Lucia Ortiz', '3134567890', 'Calle 5 Norte # 10-22, Cali', 'lucia.ortiz@correounivalle.edu.co'),
('US008', 'Manuel Ramirez', '3147890123', 'Carrera 24 # 44-10, Cali', 'manuel.ramirez@correounivalle.edu.co'),
('US009', 'Carmen Castro', '3123456789', 'Calle 39 # 4-100, Cali', 'carmen.castro@correounivalle.edu.co'),
('US010', 'Jorge Medina', '3117890123', 'Brisas de San Antonio, apto 510, Cali', 'jorge.medina@correounivalle.edu.co'),
('US011', 'Mariana Herrera', '3151112233', 'Carrera 9 # 72-10, Cali', 'mariana.herrera@correounivalle.edu.co'),
('US012', 'Andres Perez', '3112223344', 'Calle 100 # 20-29, Cali', 'andres.perez@correounivalle.edu.co'),
('US013', 'Camila Martinez', '3183334455', 'Calle 147 # 54-20, Cali', 'camila.martinez@correounivalle.edu.co'),
('US014', 'Jose Rodriguez', '3104445566', 'Carrera 50 # 98-30, Cali', 'jose.rodriguez@correounivalle.edu.co'),
('US015', 'Daniela Sanchez', '3175556677', 'Calle 80 # 25-05, Cali', 'daniela.sanchez@correounivalle.edu.co'),
('US016', 'Luis Puertas', '3126667788', 'Avenida Circunvalar # 50-20, Cali', 'luis.puertas@correounivalle.edu.co'),
('US017', 'Sofia Castro', '3157778899', 'Carrera 15 # 71-68, Cali', 'sofia.castro@correounivalle.edu.co'),
('US018', 'Miguel Munoz', '3208889900', 'Carrera 7 # 32-40, Cali', 'miguel.munoz@correounivalle.edu.co'), 
('US019', 'Fernanda Gomez', '3109990011', 'Calle 9 # 50-15, Cali', 'fernanda.gomez@correounivalle.edu.co'),
('US020', 'David Hernandez', '3180001122', 'Avenida 6A # 24-78, Cali', 'david.hernandez@correounivalle.edu.co');

-- Estudiante
INSERT INTO estudiante (id_usuario, carrera, universidad) VALUES
('US001', 'Ingenieria de Sistemas', 'Universidad del Valle'),
('US002', 'Administracion de Empresas', 'Universidad del Valle'),
('US003', 'Derecho', 'Universidad Javeriana'),
('US004', 'Medicina', 'Universidad del Valle'),
('US005', 'Contaduria Publica', 'Universidad Icesi'),
('US006', 'Psicologia', 'Universidad del Valle'),
('US007', 'Ingenieria Industrial', 'Universidad del Valle'),
('US008', 'Biologia', 'Universidad del Valle'),
('US009', 'Ingenieria Civil', 'Universidad del Valle'),
('US010', 'Diseño Grafico', 'Universidad Autonoma de Occidente');

-- Profesor
INSERT INTO profesor (id_usuario, dependencia, titulo) VALUES
('US011', 'Departamento de Fisica', 'Doctora en Fisica'),
('US012', 'Departamento de Matematicas', 'Doctor en Matematicas'),
('US013', 'Departamento de Quimica', 'Doctora en Quimica'),
('US014', 'Facultad de Ingenieria', 'Doctor en Ingenieria de Sistemas'),
('US015', 'Departamento de Biologia', 'Doctora en Biologia'),
('US016', 'Facultad de Ingenieria', 'Doctor en Ingenieria de Sistemas'),
('US017', 'Escuela de Filosofia', 'Doctora en Filosofia'),
('US018', 'Escuela de Literatura', 'Doctor en Literatura'),
('US019', 'Escuela de Historia', 'Doctora en Historia'),
('US020', 'Facultad de Artes Integradas', 'Maestro en Artes Plasticas');

-- Areas interes - Profesor
INSERT INTO areas_interes_profesor (id_usuario, codigo_area) VALUES
('US011', 'AC002'),
('US011', 'AC014'),
('US011', 'AC015'),
('US011', 'AC016'),
('US011', 'AC022'),
('US011', 'AC023'),
('US011', 'AC024'),
('US011', 'AC025'),
('US012', 'AC001'),
('US012', 'AC011'),
('US012', 'AC012'),
('US012', 'AC013'),
('US012', 'AC019'),
('US012', 'AC020'),
('US012', 'AC021'),
('US013', 'AC003'),
('US013', 'AC015'),
('US013', 'AC016'),
('US013', 'AC017'),
('US013', 'AC018'),
('US013', 'AC022'),
('US013', 'AC023'),
('US013', 'AC026'),
('US013', 'AC027'),
('US014', 'AC005'),
('US014', 'AC030'),
('US014', 'AC031'),
('US014', 'AC032'),
('US014', 'AC033'),
('US014', 'AC034'),
('US014', 'AC035'),
('US015', 'AC004'),
('US015', 'AC008'),
('US015', 'AC009'),
('US015', 'AC017'),
('US015', 'AC026'),
('US015', 'AC030'),
('US016', 'AC005'),
('US016', 'AC031'),
('US016', 'AC032'),
('US016', 'AC033'),
('US016', 'AC034'),
('US016', 'AC035'),
('US017', 'AC009'),
('US017', 'AC010'),
('US017', 'AC030'),
('US018', 'AC010'),
('US018', 'AC036'),
('US018', 'AC037'),
('US018', 'AC038');

-- Empleado
INSERT INTO empleado (id_empleado, nombre_empleado, cargo) VALUES
('EM001', 'Luisa Rodriguez', 'Bibliotecologa'),
('EM002', 'Andres Gomez', 'Asistente de biblioteca'),
('EM003', 'Maria Fernandez', 'Encargada de adquisiciones'),
('EM004', 'Juan Torres', 'Tecnico de catalogacion'),
('EM005', 'Carolina Sanchez', 'Encargada de prestamo'),
('EM006', 'Pedro Gonzalez', 'Asistente de prestamo'),
('EM007', 'Gabriela Ramirez', 'Asistente de referencia'),
('EM008', 'Alejandro Herrera', 'Encargado de conservacion'),
('EM009', 'Sara Castro', 'Asistente de conservacion'),
('EM010', 'Esteban Martinez', 'Encargado de sistemas');
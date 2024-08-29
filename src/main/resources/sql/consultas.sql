-- FASE 1

-- 1) Listar el nombre de una sucursal y sus médicos   en base a su id.

SELECT 
    m.medico_nombre,
    m.medico_apellidos,
    s.sucursal_nombre
FROM 
    medico_sucursal ms
JOIN 
    medico m ON ms.medico_id = m.medico_id
JOIN 
    sucursal s ON ms.sucursal_id = s.sucursal_id
WHERE 
    s.sucursal_id = 1;
    
    
 medico_nombre | medico_apellidos | sucursal_nombre 
---------------+------------------+-----------------
 Dana          | Philott          | Casa Matriz
 Madel         | Staning          | Casa Matriz
 Cecilio       | Clynman          | Casa Matriz
 Pedro         | Evemy            | Casa Matriz


-- 2) Listar los productos  del inventario de una sucursal en base al id de la sucursal.

SELECT 
    i.inventario_nombre,
    i.inventario_marca,
    tp.tipo_producto_descripcion,
    s.sucursal_nombre
FROM 
    inventario i
JOIN 
    tipo_producto tp ON i.tipo_producto_id = tp.tipo_producto_id
JOIN 
    sucursal s ON i.sucursal_id = s.sucursal_id
WHERE 
    s.sucursal_id = 2;
    
    
 inventario_nombre | inventario_marca | tipo_producto_descripcion |   sucursal_nombre   
-------------------+------------------+---------------------------+---------------------
 Hueso Goma        | BrandPig         | Accesorio                 | Sucursal Jose Perez
 Multi Vitaminico  | Bayer            | Remedio                   | Sucursal Jose Perez


-- 3) Listar todas las mascotas  indicando nombre , que tipo de atención que tuvieron (médica  o cirugía)  ,
-- y debe ser utilizado el id de la sucursal para filtrar la información(en el ejemplo se tomó el id de sucursal 1).

-- el script que responde la solicitud entrega menos información que la que entrega la imagen de ejemplo,
-- ya que la imajen de ejemplo entrega todas las mascotas, independientemente de su sucursal. el primer script filtra las mascotas 
--indicando su nombre, el tipo de atención y filtra por el id de la sucursal 1, lo que responde a la pregunta:

SELECT 
    m.mascota_nombre,
    med.medico_nombre,
    med.medico_apellidos,
    ta.tipo_atencion_descripcion
FROM 
    atencion a
JOIN 
    mascota m ON a.mascota_id = m.mascota_id
JOIN 
    medico med ON a.medico_id = med.medico_id
JOIN 
    tipo_atencion ta ON a.tipo_atencion_id = ta.tipo_atencion_id
JOIN 
    sucursal s ON a.sucursal_id = s.sucursal_id
WHERE 
    s.sucursal_id = 1;
 
 
  mascota_nombre | medico_nombre | medico_apellidos | tipo_atencion_descripcion 
----------------+---------------+------------------+---------------------------
 MascotaEditada | Dana          | Philott          | Medica
 Plover         | Madel         | Staning          | Medica
 ferret         | Pedro         | Evemy            | Medica
 
 
 -- el siguiente script es para obtener la respuesta que está en la imagen pero que difiere con la consulta sql planteada en la pregunta:
 
 happypet=# SELECT 
    m.mascota_nombre,
    med.medico_nombre,
    med.medico_apellidos,
    ta.tipo_atencion_descripcion
FROM 
    atencion a
JOIN 
    mascota m ON a.mascota_id = m.mascota_id
JOIN 
    medico med ON a.medico_id = med.medico_id
JOIN 
    tipo_atencion ta ON a.tipo_atencion_id = ta.tipo_atencion_id;
    
    
 mascota_nombre | medico_nombre | medico_apellidos | tipo_atencion_descripcion 
----------------+---------------+------------------+---------------------------
 MascotaEditada | Dana          | Philott          | Medica
 Squirrel       | Kinsley       | Vannini          | Cirugia
 Plover         | Madel         | Staning          | Medica
 pilot          | Cecilio       | Clynman          | Cirugia
 ferret         | Pedro         | Evemy            | Medica


-- 4) Listar la cantidad  mascotas atendidas  por tipo de mascota que tiene  cada  Sucursal:

-- En esta pregunta está el mismo problema, se plantea una consulta sql, pero se muestra un resultado distinto en la imagen
-- la primera respuesta da atención a la pregunta, la segundda a la imagen:

SELECT 
    s.sucursal_nombre,
    tm.tipo_mascota_descripcion,
    COUNT(m.mascota_id) AS cantidad_mascotas
FROM 
    atencion a
JOIN 
    mascota m ON a.mascota_id = m.mascota_id
JOIN 
    tipo_mascota tm ON m.tipo_mascota_id = tm.tipo_mascota_id
JOIN 
    sucursal s ON a.sucursal_id = s.sucursal_id
GROUP BY 
    s.sucursal_nombre,
    tm.tipo_mascota_descripcion
ORDER BY 
    s.sucursal_nombre, 
    tm.tipo_mascota_descripcion;
    
    
   sucursal_nombre   | tipo_mascota_descripcion | cantidad_mascotas 
---------------------+--------------------------+-------------------
 Casa Matriz         | Loro                     |                 1
 Casa Matriz         | Perro                    |                 2
 Sucursal Jose Perez | Gato                     |                 1
 Sucursal Jose Perez | Perro                    |                 1
 
 -- esta segunda respuesta da atención a la imagen que se muestra como ejemplo:
 
SELECT 
    m.mascota_nombre,
    tm.tipo_mascota_descripcion,
    s.sucursal_nombre
FROM 
    mascota m
JOIN 
    tipo_mascota tm ON m.tipo_mascota_id = tm.tipo_mascota_id
JOIN 
    atencion a ON m.mascota_id = a.mascota_id
JOIN 
    sucursal s ON a.sucursal_id = s.sucursal_id;
    
    
 mascota_nombre | tipo_mascota_descripcion |   sucursal_nombre   
----------------+--------------------------+---------------------
 MascotaEditada | Perro                    | Casa Matriz
 Squirrel       | Perro                    | Sucursal Jose Perez
 Plover         | Perro                    | Casa Matriz
 pilot          | Gato                     | Sucursal Jose Perez
 ferret         | Loro                     | Casa Matriz
 
 
 -- 5) Agrupar la cantidad de cirugías  que se han realizado en una sucursal determinada, mostrando cantidad,
 -- el nombre del médico y la sucursal , estableciendo el orden de forma descendiente por la cantidad de cirugias de los 10 médicos
 
 
happypet=# SELECT 
    COUNT(a.atencion_id) AS atenciones,
    med.medico_nombre,
    s.sucursal_nombre
FROM 
    atencion a
JOIN 
    medico med ON a.medico_id = med.medico_id
JOIN 
    sucursal s ON a.sucursal_id = s.sucursal_id
JOIN 
    tipo_atencion ta ON a.tipo_atencion_id = ta.tipo_atencion_id
WHERE 
    ta.tipo_atencion_descripcion = 'Cirugia'
GROUP BY 
    med.medico_nombre,
    s.sucursal_nombre
ORDER BY 
    atenciones DESC;
    
    
 atenciones | medico_nombre |   sucursal_nombre   
------------+---------------+---------------------
          1 | Cecilio       | Sucursal Jose Perez
          1 | Kinsley       | Sucursal Jose Perez


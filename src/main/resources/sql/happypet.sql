create table dueno(
	dueno_id int auto_increment primary key,
    dueno_rut varchar(10) not null,
	dueno_nombre varchar(100) not null,
    dueno_apellidos varchar(100) not null ,
    dueno_email varchar(100) not null 
);
insert into dueno (dueno_rut,dueno_nombre, dueno_apellidos, dueno_email) 
values ('18987345-6','Eugene', 'Boyde', 'eboyde0@squarespace.com'),
('19009874-3','Constantine', 'Gooke', 'cgooke1@addtoany.com'),
('16123987-1','Riccardo', 'Reinger', 'rreinger2@wordpress.com'),
('7098345-4','Dominick', 'Iacomettii', 'diacomettii3@eventbrite.com'),
('16678098-9','Camella', 'Nice', 'cnice4@salon.com');
alter table dueno
add constraint uq_rut UNIQUE (dueno_rut),
add constraint uq_email UNIQUE (dueno_email);


create table genero(
	genero_id int auto_increment primary key,
    genero_descripcion varchar(50) not null
);
insert into genero (genero_descripcion)
value ('Hembra'),('Macho');
create table tipo_mascota(
	tipo_mascota_id int auto_increment primary key,
    tipo_mascota_descripcion varchar(50) not null
);
insert into tipo_mascota (tipo_mascota_descripcion)
value ('Perro'),('Gato'),('Loro'),('Caballo'),('Hamster'),('Iguana'),('Conejo');


create table mascota(
	mascota_id int auto_increment primary key,
	mascota_nombre varchar(50) not null,
    mascota_raza varchar(50) not null,
    dueno_id int not null,
    genero_id int not null,
    tipo_mascota_id int not null,
    foreign key (dueno_id)
	references  dueno (dueno_id),
    foreign key (genero_id)
	references  genero (genero_id),
    foreign key (tipo_mascota_id)
	references  tipo_mascota (tipo_mascota_id)
);
insert into mascota ( mascota_nombre, mascota_raza, dueno_id, genero_id,tipo_mascota_id) 
values ( 'wolf', "Golden", 1, 2,1),
	 ('Squirrel', "BullDog Ingles", 2, 1,1),
	 ( 'Plover', "Persa", 3, 1,1),
	 ( 'pilot ', "Egipcio", 4, 1,2),
	 ( 'ferret', "Verde", 5, 1,3);
create table medico(
	medico_id int auto_increment primary key,
    medico_rut varchar(10) not null,
	medico_nombre varchar(100) not null,
    medico_apellidos varchar(100) not null ,
    medico_email varchar(100) not null 
);
insert into medico (medico_rut,medico_nombre,medico_apellidos,medico_email)
values ('15987645-2', 'Dana', 'Philott', 'dphilott0@washingtonpost.com'),
	 ('13925645-K', 'Kinsley', 'Vannini', 'kvannini1@ycombinator.com'),
	 ('12987345-2', 'Madel', 'Staning', 'mstaning2@shutterfly.com'),
	 ('15900630-2', 'Cecilio', 'Clynman', 'cclynman3@clickbank.net'),
	 ('14234743-2', 'Pedro', 'Evemy', 'pevemy4@cbsnews.com');

create table sucursal(
	sucursal_id int auto_increment primary key,
    sucursal_nombre varchar(100) not null,
	sucursal_direccion varchar(100) not null,
    sucursal_telefono varchar(100) not null
    
);
insert into sucursal (sucursal_nombre,sucursal_direccion,sucursal_telefono)
values ("Casa MAtriz","Los pinos 1214","67897455"),("Sucursal Jose Perez","Jose Perez 98","67897454");

create table medico_sucursal(
	medico_sucursal_id int auto_increment primary key,
	medico_id int not null ,
    sucursal_id int not null,
    titular boolean not null,
    foreign key (medico_id)
	references  medico (medico_id),
    foreign key (sucursal_id)
	references  sucursal (sucursal_id)
);
insert into medico_sucursal (medico_id,sucursal_id,titular)
values (1,1,true), (2,2,true),(3,1,false),(3,2,false),(4,1,false),(4,2,false),(5,1,false),(5,2,false);


create table tipo_atencion(
	tipo_atencion_id int auto_increment primary key,
    tipo_atencion_descripcion varchar(50) not null
);
insert into tipo_atencion (tipo_atencion_descripcion)
value ('Medica'),('Cirugia');

create table atencion(
	atencion_id int auto_increment primary key,
    medico_id int not null,
    sucursal_id int not null,
    mascota_id int not null,
    tipo_atencion_id int not null,
    fecha_realizacion datetime not null,
    fecha_proxima_revision datetime default null,
    box_atencion varchar(50) not null,
    foreign key (medico_id)
	references  medico (medico_id),
    foreign key (sucursal_id)
	references  sucursal (sucursal_id),
    foreign key (mascota_id)
	references  mascota (mascota_id),
    foreign key (tipo_atencion_id)
	references  tipo_atencion (tipo_atencion_id)
);

insert into atencion (medico_id,sucursal_id,mascota_id,tipo_atencion_id,fecha_realizacion,fecha_proxima_revision,box_atencion)
 values (1,1,1,1,now(),DATE_ADD(now(), interval 6 day),"Box 3"),
		(2,2,2,2,now(),DATE_ADD(now(), interval 6 day),"Box 1"),
		(3,1,3,1,DATE_ADD(now(), interval 2 day),DATE_ADD(now(), interval 12 day),"Box 5"),
		(4,2,4,2,now(),DATE_ADD(now(), interval 6 day),"Box 3"),
		(5,1,5,1,DATE_ADD(now(), interval 1 day),DATE_ADD(now(), interval 12 day),"Box 5");
        
        

 create table tipo_producto(
	tipo_producto_id int auto_increment primary key,
    tipo_producto_descripcion varchar(50) not null
);
insert into tipo_producto (tipo_producto_descripcion)
value ('Accesorio'),('Remedio'); 


create table inventario(
	inventario_id int auto_increment primary key,
    inventario_nombre varchar(100) not null,
    inventario_marca varchar(100) not null,
    tipo_producto_id int not null,
    sucursal_id int not null,
    inventario_existencia int not null,
    foreign key (tipo_producto_id)
	references  tipo_producto (tipo_producto_id),
    foreign key (sucursal_id)
	references  sucursal (sucursal_id)
);

insert into inventario (inventario_nombre,inventario_marca,tipo_producto_id,sucursal_id,inventario_existencia)
values("Collar Rojo","BrandPig",1,1,4),("Analgesico","Bayer",2,1,12),
	  ("Hueso Goma","BrandPig",1,2,2),("Multi Vitaminico","Bayer",2,2,8);
      
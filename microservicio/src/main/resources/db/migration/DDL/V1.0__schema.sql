
create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
 id int(11) not null auto_increment,
 celular varchar(15) not null unique,
 nombre varchar(100) not null,
 direccion varchar(100) not null,
 fecha_creacion datetime DEFAULT CURRENT_TIMESTAMP,
 primary key (id)
);

insert into cliente values
(null, 3138523670, 'Dani', 'Cra 7 # 18 09', now()),
(null, 3138523671, 'Dani 2', 'Cra 7 # 18 09', now());

create table comercio (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 primary key (id)
);

insert into comercio values
(null, 'JJ'),
(null, 'Jamhbrientos');

create table horario_atencion (
 id int(11) not null auto_increment,
 hora_inicial time not null,
 hora_final time not null,
 dia_semana int not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 id_comercio  int(11),
 primary key (id),
 foreign key (id_comercio) references comercio (id)
);

insert into horario_atencion values
(null, '03:00:00', '04:00:00', 7, now(), 1),
(null, '05:00:00', '10:00:00', 7, now(), 2);

create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(250)  null,
 valor double not null,
 foto BLOB null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 id_comercio int(11) not null,
 primary key (id),
 foreign key (id_comercio) references comercio(id)
);

insert into producto values
(null, 'Perro HD', 'Perro de la casa', 7000.00, null, now(), 1),
(null, 'Picada', 'Salchipapas de la casa', 10000.00, null, now(), 2);

create table oferta (
 id int(11) not null auto_increment,
 hora_inicial time not null,
 hora_final time not null,
 dia date not null,
 valor double not null,
 id_producto int(11) not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 primary key (id),
 foreign key (id_producto) references producto(id)
);

insert into oferta values
(null, '03:00:00', '04:00:00', CURDATE(), 3500.00 , 1 , now());

create table pedido (
 id int(11) not null auto_increment,
 id_cliente int(11) not null,
 estado_pedido varchar(100)
 check (estado_pedido in ('PENDIENTE', 'EN_PREPARACION', 'DESPACHADO', 'ENTREGADO')),
 hora time not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 valor_domicilio double,
 primary key (id),
 foreign key (id_cliente) references cliente(id)
);

insert into pedido values
(null, 1, 'PENDIENTE', CURTIME(), now() , 2000.00 );

create table detalle_pedido (
 id int(11) not null auto_increment,
 id_pedido int(11) not null,
 id_producto int(11) not null,
 valor double not null,
 cantidad int(11) not null,
 nota varchar(100) null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 primary key (id),
 foreign key (id_pedido) references pedido(id),
 foreign key (id_producto) references producto(id)
);

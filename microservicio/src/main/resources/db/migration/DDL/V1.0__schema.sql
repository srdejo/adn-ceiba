
create table if not exists usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table if not exists cliente (
 id int(11) not null auto_increment,
 celular varchar(15) not null unique,
 nombre varchar(100) not null,
 direccion varchar(100) not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 primary key (id)
);

create table if not exists comercio (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 primary key (id)
);

create table if not exists horario (
 id int(11) not null auto_increment,
 hora_inicial time not null,
 hora_final time not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 id_comercio  int(11),
 primary key (id),
 foreign key (id_comercio) references comercio (id)
);

create table if not exists producto (
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

create table if not exists oferta (
 id int(11) not null auto_increment,
 hora_inicial time not null,
 hora_final time not null,
 dia date not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 valor double not null,
 id_producto int(11) not null,
 primary key (id),
 foreign key (id_producto) references producto(id)
);

create table if not exists pedido (
 id int(11) not null auto_increment,
 id_cliente int(11) not null,
 id_producto int(11) not null,
 estado ENUM("en espera", "preparado", "en camino", "entregado") not null,
 hora time not null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 valor_domicilio double,
 primary key (id),
 foreign key (id_producto) references producto(id),
 foreign key (id_cliente) references cliente(id)
);

create table if not exists detalle_pedido (
 id int(11) not null auto_increment,
 id_pedido int(11) not null,
 id_producto int(11) not null,
 valor double not null,
 nota varchar(100) null,
 fecha_creacion datetime not null DEFAULT CURRENT_TIMESTAMP,
 primary key (id),
 foreign key (id_pedido) references pedido(id),
 foreign key (id_producto) references producto(id)
);

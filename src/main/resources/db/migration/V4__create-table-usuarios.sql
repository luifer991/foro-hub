create table usuarios(

        id bigint not null auto_increment,
        login varchar(50) not null,
        email varchar(60) not null,
        password varchar(200) not null,
        perfil_id bigint not null,

        primary key(id),
        constraint fk_usuarios_perfil_id foreign key (perfil_id) references perfiles(id)
);
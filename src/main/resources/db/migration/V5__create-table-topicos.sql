create table topicos(

        id bigint not null auto_increment,
        titulo varchar(200) not null unique,
        mensaje varchar(600) not null unique,
        fecha datetime not null,
        status varchar(10) not null,
        usuario_id bigint not null,
        curso_id bigint not null,

        primary key(id),
        constraint fk_topicos_usuarios_id foreign key (usuario_id) references usuarios(id),
        constraint fk_topicos_curso_id foreign key (curso_id) references cursos(id)
);
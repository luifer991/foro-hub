create table cursos(

        id bigint not null auto_increment,
        nombre varchar(16) not null,
        categoria varchar(10) not null,
        fecha datetime not null,

        primary key(id)
);
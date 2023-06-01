create table if not exists dentista (
    id int auto_increment primary key,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    matricula varchar(55) not null,
);

 create table if not exists paciente (
    id int auto_increment primary key,
    nome varchar(255) not null,
    sobrenome varchar(255) not null,
    endereco varchar(255) not null,
    rg varchar(255) not null,
    dataAlta varchar(255) not null
);
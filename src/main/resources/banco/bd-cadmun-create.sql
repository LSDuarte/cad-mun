create table cidade (
    id_cidade bigserial not null,
    nome_cidade varchar(255),
    fk_estado int8,
    primary key (id_cidade)
)

create table endereco (
    id_endereco bigserial not null,
    bairro varchar(255),
    cep varchar(255),
    numero int4,
    nome_rua varchar(255),
    fk_cidade int8,
    primary key (id_endereco)
)

create table estado (
    id_estado bigserial not null,
    nome_estado varchar(255),
    sigla varchar(255),
    primary key (id_estado)
)

create table pessoa (
    id_pessoa bigserial not null,
    cpf varchar(255),
    data_nasc date,
    idade int4,
    nome varchar(255),
    sexo varchar(255),
    sobrenome varchar(255),
    fk_endereco int8,
    primary key (id_pessoa)
)

alter table cidade 
    add constraint FKhqumryw75m7cj2i1jcun0mlsj 
    foreign key (fk_estado) 
    references estado

alter table endereco 
    add constraint FK1psl3e0icdouluru254nb0r3s 
    foreign key (fk_cidade) 
    references cidade

alter table pessoa 
    add constraint FK6awwh5cnpxhb2p9k66m7c4ais 
    foreign key (fk_endereco) 
    references endereco
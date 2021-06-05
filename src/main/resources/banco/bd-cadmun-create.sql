create table cidade (
       id_cidade  bigserial not null,
        nome_cidade varchar(100) not null,
        fk_estado int8 not null,
        primary key (id_cidade)
    )
Hibernate: 
    
    create table endereco (
       id_endereco  bigserial not null,
        bairro varchar(255) not null,
        cep varchar(255) not null,
        numero int4 not null,
        nome_rua varchar(255) not null,
        fk_cidade int8 not null,
        primary key (id_endereco)
    )
Hibernate: 
    
    create table estado (
       id_estado  bigserial not null,
        nome_estado varchar(100) not null,
        sigla varchar(2) not null,
        primary key (id_estado)
    )
Hibernate: 
    
    create table pessoa (
       id_pessoa  bigserial not null,
        cpf varchar(255) not null,
        data_nasc timestamp not null,
        idade int4 not null,
        nome varchar(255) not null,
        sexo varchar(255) not null,
        sobrenome varchar(255) not null,
        fk_endereco int8 not null,
        primary key (id_pessoa)
    )
Hibernate: 
    
    alter table cidade 
       add constraint FKhqumryw75m7cj2i1jcun0mlsj 
       foreign key (fk_estado) 
       references estado
Hibernate: 
    
    alter table endereco 
       add constraint FK1psl3e0icdouluru254nb0r3s 
       foreign key (fk_cidade) 
       references cidade
Hibernate: 
    
    alter table pessoa 
       add constraint FK6awwh5cnpxhb2p9k66m7c4ais 
       foreign key (fk_endereco) 
       references endereco

    create table tb_compras (
       id integer not null auto_increment,
        data_compra date,
        total_compra double precision,
        pessoas_id integer,
        primary key (id)
    ) engine=InnoDB;

    create table tb_pessoas (
       id integer not null auto_increment,
        dn varchar(255),
        nome varchar(255),
        primary key (id)
    ) engine=InnoDB;

    alter table tb_compras 
       add constraint FKbe11y70uw6nrs3a97eo0hi6m0 
       foreign key (pessoas_id) 
       references tb_pessoas (id);
INSERT INTO tb_pessoas(nome,dn) VALUES ('Maria','14/12/2000');
INSERT INTO tb_compras(pessoas_id,total_compra,data_compra) VALUES (1,100.0,'2021-05-15');

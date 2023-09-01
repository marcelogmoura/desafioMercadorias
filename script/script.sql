create table mercadoria(

id serial primary key,
nomeMercadoria varchar(60) not null,
descricao varchar(250) not null,
quantidade integer not null,
dataEntrada date not null,
tipo integer not null


);
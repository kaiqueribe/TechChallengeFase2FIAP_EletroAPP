create table tb_eletrodomestico (potencia float(53), voltagem float(53), id bigserial not null, modelo varchar(255), nome varchar(255), primary key (id));
create table tb_endereco (id bigserial not null, bairro varchar(255), cep varchar(255), cidade varchar(255), complemento varchar(255), numero varchar(255), rua varchar(255), uf varchar(255), primary key (id));
create table tb_pessoa (data_nascimento date, endereco_id bigint unique, id bigserial not null, cpf varchar(255), email varchar(255), nome varchar(255), parentesco varchar(255), sexo varchar(255) check (sexo in ('MASCULINO','FEMININO','OUTRO')), telefone varchar(255), primary key (id));
create table tb_usuario (id bigserial not null, primary key (id));
alter table if exists tb_pessoa add constraint FK9t86f6i2946qdwijwjn5c2mi2 foreign key (endereco_id) references tb_endereco;

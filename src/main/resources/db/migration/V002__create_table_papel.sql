IF NOT EXISTS (SELECT * FROM sysobjects WHERE name='papeis' and xtype='U')

create table papeis(
id BIGINT NOT NULL IDENTITY(1,1) PRIMARY KEY,
nome_papel varchar(45) NOT NULL,
descricao_papel VARCHAR(250),
cod_status_papel BIT NULL


)
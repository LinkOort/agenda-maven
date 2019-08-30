CREATE TABLE enderecos(
	id_endereco INT NOT NULL AUTO_INCREMENT,
	lougradouro_endereco 	VARCHAR(255),
	cep_endereco 			CHAR(8),
	PRIMARY KEY				(id_endereco)
);

CREATE TABLE contatos(
	id_contato INT NOT NULL AUTO_INCREMENT,
	email_contato 			VARCHAR(255),
	telefone_contato 		VARCHAR(255),
	PRIMARY KEY 	(id_contato)
);

CREATE TABLE pessoas (
	id_pessoa	INT NOT NULL AUTO_INCREMENT,
	nome_pessoa			VARCHAR(255),
	nascimento_pessoa	DATETIME, 
	sexo_pessoa			CHAR(1),
	fk_endereco			int,
	fk_contato 			int,
	PRIMARY KEY 		(id_pessoa),
	FOREIGN KEY (fk_endereco) REFERENCES enderecos(id_endereco),
	FOREIGN KEY (fk_contato) REFERENCES contatos(id_contato)
);

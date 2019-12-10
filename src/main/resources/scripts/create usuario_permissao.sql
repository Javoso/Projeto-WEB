
CREATE TABLE 'permissao' (
  'codigo' bigint(20) NOT NULL,
  'descricao' varchar(255) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB;


CREATE TABLE 'usuario' (
  'id' bigint(20) NOT NULL AUTO_INCREMENT,
  'email' varchar(255) DEFAULT NULL,
  'imagem' longtext,
  'nome' varchar(255) DEFAULT NULL,
  'senha' varchar(255) DEFAULT NULL,
  'status' varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5;


CREATE TABLE 'usuario_permissao' (
  'codigo_usuario' bigint(20) NOT NULL,
  'codigo_permissao' bigint(20) NOT NULL,
  KEY 'FK_avjx37djp61ntnv8uwia3dkki' ('codigo_permissao'),
  KEY 'FK_p8gk2su1ew0kjr1ypah7f4s2f' ('codigo_usuario'),
  CONSTRAINT 'FK_avjx37djp61ntnv8uwia3dkki' FOREIGN KEY ('codigo_permissao') REFERENCES 'permissao' ('codigo'),
  CONSTRAINT 'FK_p8gk2su1ew0kjr1ypah7f4s2f' FOREIGN KEY ('codigo_usuario') REFERENCES 'usuario' ('id')
) ENGINE=InnoDB;

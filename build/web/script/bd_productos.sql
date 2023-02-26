
drop database bd_productos;
create database bd_productos;
use  bd_productos;

CREATE TABLE usuario (
  i_num_id_user int NOT NULL AUTO_INCREMENT,
  c_user varchar(20) DEFAULT NULL,
  c_password varchar(50) DEFAULT NULL,
  c_perfil varchar(20) DEFAULT NULL,
  PRIMARY KEY (i_num_id_user)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE empleado (
  i_num_id_emp int NOT NULL AUTO_INCREMENT,
  c_dni varchar(8) DEFAULT NULL,
  c_nombres varchar(100) DEFAULT NULL,
  c_correo varchar(100) DEFAULT NULL,
  i_num_id_user int,
  PRIMARY KEY (i_num_id_emp),
  FOREIGN KEY (i_num_id_user) REFERENCES usuario (i_num_id_user)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE categoria (
  i_num_id_cat int NOT NULL AUTO_INCREMENT,
  c_descripcion varchar(50) DEFAULT NULL,
  c_estado char(1) DEFAULT NULL,
  PRIMARY KEY (i_num_id_cat)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE producto (
  i_num_id_prod int NOT NULL AUTO_INCREMENT,
  c_nombre varchar(50) DEFAULT NULL,
  c_descripcion varchar(100) DEFAULT NULL,
  n_precio double DEFAULT NULL,
  c_estado char(1) DEFAULT NULL,
  i_num_id_cat int,
  PRIMARY KEY (i_num_id_prod),
  FOREIGN KEY (i_num_id_cat) REFERENCES categoria (i_num_id_cat)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


INSERT INTO usuario values(1,'ADMIN','12345678','ADMINISTRADOR');
INSERT INTO usuario values(2,'MARIA','123','USER');

INSERT INTO empleado values(1,'12345678','SISTEMAS','admin@gmail.com',1);
INSERT INTO empleado values(2,'89765432','MARIA DEL CARMEN','maria@gmail.com',2);

INSERT INTO categoria values(1,'CATEGORIA 01','1');
INSERT INTO categoria values(2,'CATEGORIA 02','1');

INSERT INTO producto values(1,'LAPTOP LENOVO 456','LAPTOP LENOVO 456 - 14P - MEMORIA 12',2000.00,'1',1);
INSERT INTO producto values(2,'CELULAR SAMSUNG','CELULAR SAMSUNG 5P-CAMARA 45MP',1000.00,'1',2);



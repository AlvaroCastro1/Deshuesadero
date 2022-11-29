drop DATABASE autopartes;
CREATE DATABASE autopartes;
USE autopartes;

CREATE TABLE Carro (
    num_serie varchar(30),
    marca VARCHAR(30),
    linea VARCHAR(30),
    kilometraje DOUBLE,
    modelo VARCHAR(10),
    anio YEAR,
    descripcion VARCHAR(100),
    PRIMARY KEY(num_serie)
) ENGINE = INNODB;

CREATE TABLE Pieza (
    num_pieza VARCHAR(30),
    num_serie VARCHAR(30),
    nombre VARCHAR(50),
    precio_minimo DOUBLE(7,2),
    garantia VARCHAR(10),
    descripcion VARCHAR(100),
    estado int (1),
    PRIMARY KEY(num_pieza),
    FOREIGN KEY(num_serie) REFERENCES Carro(num_serie)
) ENGINE = INNODB;

CREATE TABLE Vendedor(
    id INT(5) AUTO_INCREMENT,
    nombre VARCHAR(50),
    fechaNac DATE,
    PRIMARY KEY (id)
) ENGINE = INNODB;

CREATE TABLE Venta(
    id_venta INT(5) AUTO_INCREMENT,
    fecha DATE,
    id_vendedor INT(5),
    total DOUBLE(7,2),
    PRIMARY KEY(id_venta),
    FOREIGN KEY (id_vendedor) REFERENCES Vendedor(id)
) ENGINE = INNODB;

CREATE TABLE Nota_venta(
    cons int(5),
    num_pieza VARCHAR(30),
    id_venta INT(5),
    subtotal DOUBLE(7,2),
    PRIMARY KEY(cons,num_pieza,id_venta),
    FOREIGN KEY (num_pieza) REFERENCES Pieza(num_pieza),
    FOREIGN KEY (id_venta) REFERENCES Venta(id_venta)
) ENGINE = INNODB;

INSERT INTO pieza VALUES ("asd1","1","asdf",200,"3 meses","asdf",1);
INSERT INTO pieza VALUES ("asd2","1","zxc",200,"3 meses","asdf",1);
INSERT INTO pieza VALUES ("asd3","1","vbncv",200,"3 meses","asdf",1);
INSERT INTO pieza VALUES ("asd4","1","yukkgh",200,"3 meses","asdf",1);
INSERT INTO Venta VALUES(1,'2022-01-01',1,200);


SELECT id_venta FROM Venta ORDER by id_venta ASC LIMIT 1;

CREATE TRIGGER status_u 
AFTER INSERT on nota_venta
FOR EACH ROW
UPDATE pieza SET estado=0 where num_pieza= new.num_pieza ;
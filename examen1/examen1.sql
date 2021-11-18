CREATE SCHEMA IF NOT EXISTS `examen1` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `examen1` ;

DROP TABLE IF EXISTS `productos`;

CREATE TABLE `productos` (
  `codigo` varchar(5)  NOT NULL,
  `nombre` varchar(50) DEFAULT '',
  `precio` float DEFAULT NULL,
  `disponible` int(1) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `productos` (`codigo`, `nombre`, `precio`, `disponible`)
VALUES
	('LIM33','LIMONES',1.89,1),
	('NAR44','NARANJAS',1.69,0),
	('PLT32','PLATANOS',1.75,1),
	('CHORI','CHORIZO',3.25,0),
	('JAM67','JAMON',4.21,1),
	('SALM1','SALMON',12.05,1),
	('BOLL5','BOLLERIA',2.1,1);



DROP TABLE IF EXISTS `ubicacion`;

CREATE TABLE `ubicacion` (
  `id_ubic` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `seccion` varchar(50) DEFAULT NULL,
  `ubicacion` varchar(50) DEFAULT NULL,
  `imagen` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id_ubic`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

INSERT INTO `ubicacion` (`id_ubic`, `seccion`, `ubicacion`, `imagen`)
VALUES
	(1,'FRUTERIA','PASILLO 1','pasillo1.jpg'),
	(2,'CHARCUTERIA','PASILLO 2','pasillo2.jpg'),
	(3,'CARNICERIA','PASILLO 3','pasillo3.jpg'),
	(4,'COSMETICOS','PASILLO 4','paillo4.jpg'),
	(5,'PESCADERIA','PASILLO 5','pasillo5.jpg'),
	(6,'PANADERIA','PASILLO 6','pasillo6.jpg');

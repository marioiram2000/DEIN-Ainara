SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

CREATE SCHEMA IF NOT EXISTS `examen2agenda` DEFAULT CHARACTER SET latin1 COLLATE latin1_spanish_ci;
USE `examen2agenda` ;

DROP TABLE IF EXISTS `examen2agenda`.`email` ;
DROP TABLE IF EXISTS `examen2agenda`.`telefono` ;
DROP TABLE IF EXISTS `examen2agenda`.`persona` ;

-- -----------------------------------------------------
-- Table `examen2agenda`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen2agenda`.`persona` (
  `dni` VARCHAR(9) NOT NULL,
  `nombre` VARCHAR(150) NULL DEFAULT NULL,
  `apellido1` VARCHAR(150) NULL DEFAULT NULL,
  `apellido2` VARCHAR(150) NULL DEFAULT NULL,
  `anio_nacimiento` INT(4),
  PRIMARY KEY (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

-- -----------------------------------------------------
-- Table `examen2agenda`.`telefono`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen2agenda`.`telefono` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `telefono` VARCHAR(9) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_telefono_persona`
    FOREIGN KEY (`dni`)
    REFERENCES `examen2agenda`.`persona` (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

-- -----------------------------------------------------
-- Table `examen2agenda`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `examen2agenda`.`email` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `dni` VARCHAR(9) NOT NULL,
  `email` VARCHAR(150) NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `FK_email_persona`
    FOREIGN KEY (`dni`)
    REFERENCES `examen2agenda`.`persona` (`dni`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_spanish_ci;

INSERT INTO `persona` (`dni`, `nombre`, `apellido1`, `apellido2`, `anio_nacimiento`) VALUES
('12345678P','Ainara','Montoya','Uriarte',1990),
('00000000A','Airam','Brito','Triana',2000),
('11111111A','Nerea','Del Valle','Garrido',2000),
('22222222A','Raul','Estrada','Garcia',2000),
('33333333A','Kevin','Fernandez de Landa','Gutierrez',2001),
('44444444A','Cesar','Ferreiro','Ortiz de Guinea',2001),
('55555555A','Aitor','Gallastegi','Borreguero',2002),
('66666666A','Alejandro','Lopez de Guereñu','Macazaga',2002),
('77777777A','Mario','Orozco','Neila',2002),
('88888888A','Ander','Rodriguez','Gancedo',2002),
('99999999A','Elena','Sanz','Espada',2003);

INSERT INTO `email` (`dni`,`email`) VALUES
('00000000A','airam@dm2.com'),
('11111111A','nerea@dm2.com'),
('22222222A','raul@dm2.com'),
('33333333A','kevin@dm2.com'),
('33333333A','kevin1@dm2.com'),
('55555555A','aitor@dm2.com'),
('66666666A','alejandro@dm2.com'),
('77777777A','mario@dm2.com'),
('88888888A','ander@dm2.com'),
('99999999A','elena@dm2.com'),
('00000000A','brito@dm2.com'),
('11111111A','delvalle@dm2.com'),
('22222222A','estrada@dm2.com'),
('33333333A','fernandezdelanda@dm2.com'),
('55555555A','aitor1@dm2.com'),
('55555555A','gallastegi@dm2.com'),
('66666666A','lopezdeguereñu@dm2.com'),
('77777777A','orozco@dm2.com'),
('88888888A','rodriguez@dm2.com'),
('99999999A','sanz@dm2.com'),
('99999999A','elena1@dm2.com'),
('99999999A','elena2@dm2.com'),
('12345678P','ainaramu@gmail.com'),
('12345678P','ainaramu@dm2.com');

INSERT INTO `telefono` (`dni`,`telefono`) VALUES
('77777777A','111111111'),
('11111111A','111111112'),
('22222222A','111111113'),
('33333333A','111111114'),
('44444444A','111111115'),
('55555555A','111111116'),
('66666666A','111111117'),
('77777777A','111111118'),
('88888888A','111111119'),
('99999999A','222333441'),
('66666666A','222333442'),
('11111111A','222333443'),
('22222222A','222333444'),
('33333333A','222333445'),
('55555555A','222333446'),
('55555555A','222333447'),
('66666666A','222333448'),
('77777777A','222333449'),
('88888888A','555666771'),
('99999999A','555666772'),
('99999999A','555666773'),
('99999999A','555666774'),
('12345678P','123456789'),
('12345678P','987165432'),
('12345678P','534768615');

commit;
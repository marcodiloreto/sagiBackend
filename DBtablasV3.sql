-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema sagidb
-- -----------------------------------------------------

DROP SCHEMA `sagidb`;
CREATE SCHEMA `sagidb` DEFAULT CHARACTER SET utf8 ;
USE `sagidb` ;

-- -----------------------------------------------------
-- Table `sagidb`.`disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`disciplina` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `rareza` ENUM('PORAHORANADA') NULL DEFAULT NULL,
  `fotoURL` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 4
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagidb`.`actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`actividad` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `promRating` DECIMAL(2,1) NULL DEFAULT NULL,
  `bajaLogica` BIT(1) NOT NULL DEFAULT b'0',
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NULL DEFAULT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `disciplinaID` INT(11) NOT NULL,
  `maxCupos` INT(11) NULL DEFAULT NULL,
  `latitud` DECIMAL(8,6) NOT NULL,
  `longitud` DECIMAL(9,6) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Actividad_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `sagidb`.`disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_Actividad_Disciplina1_idx` ON `sagidb`.`actividad` (`disciplinaID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`diassemana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`diassemana` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `dia` ENUM('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES', 'SABADO', 'DOMINGO') NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagidb`.`plan`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`plan` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `horaInicio` TIME NULL,
  `horaFin` TIME NULL,
  `actividadID` INT(11) NOT NULL,
  `diassemanaID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_plan_actividad`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_plan_diassemana1`
    FOREIGN KEY (`diassemanaID`)
    REFERENCES `sagidb`.`diassemana` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_plan_actividad_idx` ON `sagidb`.`plan` (`actividadID` ASC) ;

CREATE INDEX `fk_plan_diassemana1_idx` ON `sagidb`.`plan` (`diassemanaID` ASC) ;

USE `sagidb` ;

-- -----------------------------------------------------
-- Table `sagidb`.`persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`persona` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fotoURL` VARCHAR(150) NULL DEFAULT NULL,
  `promRating` DECIMAL(2,1) NULL DEFAULT NULL,
  `bajaLogica` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
AUTO_INCREMENT = 6
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagidb`.`creadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`creadores` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `personaID` INT(11) NOT NULL,
  `actividadID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaActividad_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaActividad_Persona`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 8
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_PersonaActividad_Persona_idx` ON `sagidb`.`creadores` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaActividad_Actividad1_idx` ON `sagidb`.`creadores` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`disciplinahija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`disciplinahija` (
  `disciplinaID` INT(11) NOT NULL AUTO_INCREMENT,
  `hijaID` INT(11) NOT NULL,
  CONSTRAINT `fk_DisciplinaHija_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `sagidb`.`disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DisciplinaHija_Disciplina2`
    FOREIGN KEY (`hijaID`)
    REFERENCES `sagidb`.`disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 2
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_DisciplinaHija_Disciplina1_idx` ON `sagidb`.`disciplinahija` (`disciplinaID` ASC) ;

CREATE INDEX `fk_DisciplinaHija_Disciplina2_idx` ON `sagidb`.`disciplinahija` (`hijaID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`disciplinamadre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`disciplinamadre` (
  `disciplinaID` INT(11) NOT NULL AUTO_INCREMENT,
  `madreID` INT(11) NOT NULL,
  CONSTRAINT `fk_DisciplinaMadre_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `sagidb`.`disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DisciplinaMadre_Disciplina2`
    FOREIGN KEY (`madreID`)
    REFERENCES `sagidb`.`disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 3
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_DisciplinaMadre_Disciplina1_idx` ON `sagidb`.`disciplinamadre` (`disciplinaID` ASC) ;

CREATE INDEX `fk_DisciplinaMadre_Disciplina2_idx` ON `sagidb`.`disciplinamadre` (`madreID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`evento` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `fecha` DATE NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `estado` ENUM('VIGENTE', 'CANCELADO', 'FINALIZADO') NOT NULL DEFAULT 'VIGENTE',
  `actividadID` INT(11) NOT NULL,
  `bajaLogica` BIT(1) NOT NULL DEFAULT b'0',
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Evento_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_Evento_Actividad1_idx` ON `sagidb`.`evento` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`interesados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`interesados` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `personaID` INT(11) NOT NULL,
  `actividadID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaActividadInteresado_actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaActividadInteresado_persona`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_PersonaActividadInteresado_persona_idx` ON `sagidb`.`interesados` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaActividadInteresado_actividad1_idx` ON `sagidb`.`interesados` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`pago` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `monto` DOUBLE NOT NULL,
  `fecha` DATETIME NOT NULL,
  `comprobanteURL` VARCHAR(255) NOT NULL,
  `personaID` INT(11) NOT NULL,
  `actividadID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Pago_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pago_Persona1`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_Pago_Persona1_idx` ON `sagidb`.`pago` (`personaID` ASC) ;

CREATE INDEX `fk_Pago_Actividad1_idx` ON `sagidb`.`pago` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`rating` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `estrellas` INT(11) NULL DEFAULT NULL,
  `opinion` VARCHAR(255) NULL DEFAULT NULL,
  `excusa` ENUM('NADIE', 'AUSENTE', 'CANCELO') NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `sagidb`.`personaevento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`personaevento` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `personaID` INT(11) NOT NULL,
  `eventpID` INT(11) NOT NULL,
  `ratingID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaEvento_Evento1`
    FOREIGN KEY (`eventpID`)
    REFERENCES `sagidb`.`evento` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaEvento_Persona1`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaEvento_Rating1`
    FOREIGN KEY (`ratingID`)
    REFERENCES `sagidb`.`rating` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE INDEX `fk_PersonaEvento_Persona1_idx` ON `sagidb`.`personaevento` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaEvento_Evento1_idx` ON `sagidb`.`personaevento` (`eventpID` ASC) ;

CREATE INDEX `fk_PersonaEvento_Rating1_idx` ON `sagidb`.`personaevento` (`ratingID` ASC) ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;




/*  VIEJO (V2)
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- Schema sagidb
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `sagidb` ;

-- -----------------------------------------------------
-- Schema sagidb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `sagidb` DEFAULT CHARACTER SET utf8 ;
USE `sagidb` ;

-- -----------------------------------------------------
-- Table `sagidb`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Persona` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fotoURL` VARCHAR(150) NULL DEFAULT NULL,
  `promRating` DOUBLE NULL DEFAULT NULL,
  `bajaLogica` BIT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB
;


-- -----------------------------------------------------
-- Table `sagidb`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Disciplina` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `rareza` ENUM('PORAHORANADA') NULL DEFAULT NULL,
  `fotoURL` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;



-- -----------------------------------------------------
-- Table `sagidb`.`Actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Actividad` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(255) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `promRating` DECIMAL(2,1) NULL DEFAULT NULL,
  `bajaLogica` BIT(1) NOT NULL DEFAULT 0,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NULL DEFAULT NULL,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `disciplinaID` INT(11) NOT NULL,
  `maxCupos` INT(11) NULL,
  `latitud` DECIMAL(8,6) NOT NULL,
  `longitud` DECIMAL(9,6) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Actividad_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `sagidb`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Actividad_Disciplina1_idx` ON `sagidb`.`Actividad` (`disciplinaID` ASC) ;


-- -----------------------------------------------------
-- Table `mydb`.`Interesados`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Interesados` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `personaID` INT(11) NOT NULL,
  `actividadID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaActividadInteresado_persona`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaActividadInteresado_actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PersonaActividadInteresado_persona_idx` ON `sagidb`.`Interesados` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaActividadInteresado_actividad1_idx` ON `sagidb`.`Interesados` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`DiasSemana`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`DiasSemana` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `dia` ENUM('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES', 'SABADO', 'DOMINGO') NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sagidb`.`ActividadDias`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`ActividadDias` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `actividadID` INT(11) NOT NULL,
  `diasSemanaID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_ActividadDias_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ActividadDias_DiasSemana1`
    FOREIGN KEY (`diasSemanaID`)
    REFERENCES `sagidb`.`DiasSemana` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


CREATE INDEX `fk_ActividadDias_Actividad1_idx` ON `sagidb`.`ActividadDias` (`actividadID` ASC) ;

CREATE INDEX `fk_ActividadDias_DiasSemana1_idx` ON `sagidb`.`ActividadDias` (`diasSemanaID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`DisciplinaHija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`DisciplinaHija` (
  `disciplinaID` INT(11) NOT NULL AUTO_INCREMENT,
  `hijaID` INT(11) NOT NULL,
  CONSTRAINT `fk_DisciplinaHija_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `sagidb`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DisciplinaHija_Disciplina2`
    FOREIGN KEY (`hijaID`)
    REFERENCES `sagidb`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DisciplinaHija_Disciplina1_idx` ON `sagidb`.`DisciplinaHija` (`disciplinaID` ASC) ;

CREATE INDEX `fk_DisciplinaHija_Disciplina2_idx` ON `sagidb`.`DisciplinaHija` (`hijaID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`DisciplinaMadre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`DisciplinaMadre` (
  `disciplinaID` INT(11) NOT NULL AUTO_INCREMENT,
  `madreID` INT(11) NOT NULL,
  CONSTRAINT `fk_DisciplinaMadre_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `sagidb`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DisciplinaMadre_Disciplina2`
    FOREIGN KEY (`madreID`)
    REFERENCES `sagidb`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DisciplinaMadre_Disciplina1_idx` ON `sagidb`.`DisciplinaMadre` (`disciplinaID` ASC) ;

CREATE INDEX `fk_DisciplinaMadre_Disciplina2_idx` ON `sagidb`.`DisciplinaMadre` (`madreID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`Evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Evento` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `fecha` DATE NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NULL DEFAULT NULL,
  `actividadID` INT(11) NOT NULL,
  `bajaLogica` BIT(1) NOT NULL DEFAULT 0,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Evento_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Evento_Actividad1_idx` ON `sagidb`.`Evento` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Pago` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `monto` DOUBLE NOT NULL,
  `fecha` DATETIME NOT NULL,
  `comprobanteURL` VARCHAR(255) NOT NULL,
  `personaID` INT(11) NOT NULL,
  `actividadID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Pago_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pago_Persona1`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pago_Persona1_idx` ON `sagidb`.`Pago` (`personaID` ASC) ;

CREATE INDEX `fk_Pago_Actividad1_idx` ON `sagidb`.`Pago` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`Creadores`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Creadores` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `personaID` INT(11) NOT NULL,
  `actividadID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaActividad_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `sagidb`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaActividad_Persona`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PersonaActividad_Persona_idx` ON `sagidb`.`Creadores` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaActividad_Actividad1_idx` ON `sagidb`.`Creadores` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `sagidb`.`Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`Rating` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `estrellas` INT(11) NULL DEFAULT NULL,
  `opinion` VARCHAR(255) NULL DEFAULT NULL,
  `excusa` ENUM('NADIE', 'AUSENTE', 'CANCELO') NULL DEFAULT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `sagidb`.`PersonaEvento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `sagidb`.`PersonaEvento` (
  `ID` INT(11) NOT NULL AUTO_INCREMENT,
  `personaID` INT(11) NOT NULL,
  `eventpID` INT(11) NOT NULL,
  `ratingID` INT(11) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaEvento_Evento1`
    FOREIGN KEY (`eventpID`)
    REFERENCES `sagidb`.`Evento` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaEvento_Persona1`
    FOREIGN KEY (`personaID`)
    REFERENCES `sagidb`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaEvento_Rating1`
    FOREIGN KEY (`ratingID`)
    REFERENCES `sagidb`.`Rating` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PersonaEvento_Persona1_idx` ON `sagidb`.`PersonaEvento` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaEvento_Evento1_idx` ON `sagidb`.`PersonaEvento` (`eventpID` ASC) ;

CREATE INDEX `fk_PersonaEvento_Rating1_idx` ON `sagidb`.`PersonaEvento` (`ratingID` ASC) ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
*/
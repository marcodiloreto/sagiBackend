-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema SagiDB
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SagiDB
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `SagiDB`;
CREATE SCHEMA IF NOT EXISTS `SagiDB` DEFAULT CHARACTER SET utf8 ;
USE `SagiDB` ;

-- -----------------------------------------------------
-- Table `SagiDB`.`Persona`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`Persona` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `rol` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fotoURL` VARCHAR(150) NULL,
  `promRating` DOUBLE NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;




-- -----------------------------------------------------
-- Table `SagiDB`.`Disciplina`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`Disciplina` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(45) NOT NULL,
  `rareza` ENUM('PORAHORANADA') NULL,
  `fotoURL` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SagiDB`.`Actividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`Actividad` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `desc` VARCHAR(45) NOT NULL,
  `precio` VARCHAR(45) NOT NULL,
  `promRating` VARCHAR(45) NULL,
  `bajaLogica` VARCHAR(45) NULL,
  `diasSemana` ENUM('LUNES', 'MARTES', 'MIERCOLES', 'JUEVES', 'VIERNES', 'SABADO', 'DOMINGO') NULL,
  `fechaInicio` DATE NOT NULL,
  `fechaFin` DATE NULL,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `disciplinaID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Actividad_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `SagiDB`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Actividad_Disciplina1_idx` ON `SagiDB`.`Actividad` (`disciplinaID` ASC) ;


-- -----------------------------------------------------
-- Table `SagiDB`.`Evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`Evento` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `horaInicio` TIME NOT NULL,
  `horaFin` TIME NOT NULL,
  `fecha` DATE NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `estado` VARCHAR(45) NULL,
  `actividadID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Evento_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `SagiDB`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Evento_Actividad1_idx` ON `SagiDB`.`Evento` (`actividadID` ASC) ;


-- -----------------------------------------------------
-- Table `SagiDB`.`PersonaActividad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`PersonaActividad` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `personaID` INT NOT NULL,
  `actividadID` INT NOT NULL,
  `tipoRelacion` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaActividad_Persona`
    FOREIGN KEY (`personaID`)
    REFERENCES `SagiDB`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaActividad_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `SagiDB`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PersonaActividad_Persona_idx` ON `SagiDB`.`PersonaActividad` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaActividad_Actividad1_idx` ON `SagiDB`.`PersonaActividad` (`actividadID` ASC) ;




-- -----------------------------------------------------
-- Table `SagiDB`.`Rating`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`Rating` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `estrellas` INT NULL,
  `opinion` VARCHAR(255) NULL,
  `excusa` ENUM('nadie', 'ausente', 'cancelo') NULL,
  PRIMARY KEY (`ID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SagiDB`.`PersonaEvento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`PersonaEvento` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `personaID` INT NOT NULL,
  `eventpID` INT NOT NULL,
  `ratingID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_PersonaEvento_Persona1`
    FOREIGN KEY (`personaID`)
    REFERENCES `SagiDB`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaEvento_Evento1`
    FOREIGN KEY (`eventpID`)
    REFERENCES `SagiDB`.`Evento` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_PersonaEvento_Rating1`
    FOREIGN KEY (`ratingID`)
    REFERENCES `SagiDB`.`Rating` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_PersonaEvento_Persona1_idx` ON `SagiDB`.`PersonaEvento` (`personaID` ASC) ;

CREATE INDEX `fk_PersonaEvento_Evento1_idx` ON `SagiDB`.`PersonaEvento` (`eventpID` ASC) ;

CREATE INDEX `fk_PersonaEvento_Rating1_idx` ON `SagiDB`.`PersonaEvento` (`ratingID` ASC) ;


-- -----------------------------------------------------
-- Table `SagiDB`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`Pago` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `monto` VARCHAR(45) NOT NULL,
  `fecha` VARCHAR(45) NOT NULL,
  `comprobanteURL` VARCHAR(255) NOT NULL,
  `personaID` INT NOT NULL,
  `actividadID` INT NOT NULL,
  PRIMARY KEY (`ID`),
  CONSTRAINT `fk_Pago_Persona1`
    FOREIGN KEY (`personaID`)
    REFERENCES `SagiDB`.`Persona` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Pago_Actividad1`
    FOREIGN KEY (`actividadID`)
    REFERENCES `SagiDB`.`Actividad` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_Pago_Persona1_idx` ON `SagiDB`.`Pago` (`personaID` ASC);

CREATE INDEX `fk_Pago_Actividad1_idx` ON `SagiDB`.`Pago` (`actividadID` ASC);


-- -----------------------------------------------------
-- Table `SagiDB`.`DisciplinaMadre`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`DisciplinaMadre` (
  `disciplinaID` INT NOT NULL AUTO_INCREMENT,
  `madreID` INT NOT NULL,
  CONSTRAINT `fk_DisciplinaMadre_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `SagiDB`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DisciplinaMadre_Disciplina2`
    FOREIGN KEY (`madreID`)
    REFERENCES `SagiDB`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DisciplinaMadre_Disciplina1_idx` ON `SagiDB`.`DisciplinaMadre` (`disciplinaID` ASC) ;
CREATE INDEX `fk_DisciplinaMadre_Disciplina2_idx` ON `SagiDB`.`DisciplinaMadre` (`madreID` ASC) ;


-- -----------------------------------------------------
-- Table `SagiDB`.`DisciplinaHija`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `SagiDB`.`DisciplinaHija` (
  `disciplinaID` INT NOT NULL AUTO_INCREMENT,
  `hijaID` INT NOT NULL,
  CONSTRAINT `fk_DisciplinaHija_Disciplina1`
    FOREIGN KEY (`disciplinaID`)
    REFERENCES `SagiDB`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_DisciplinaHija_Disciplina2`
    FOREIGN KEY (`hijaID`)
    REFERENCES `SagiDB`.`Disciplina` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_DisciplinaHija_Disciplina1_idx` ON `SagiDB`.`DisciplinaHija` (`disciplinaID` ASC) ;
CREATE INDEX `fk_DisciplinaHija_Disciplina2_idx` ON `SagiDB`.`DisciplinaHija` (`hijaID` ASC) ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

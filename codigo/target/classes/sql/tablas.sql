-- MySQL Script generated by MySQL Workbench
-- vie 15 nov 2019 17:09:14 CST
-- Model: New Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema BEDU_JSE2
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema BEDU_JSE2
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `BEDU_JSE2` ;
USE `BEDU_JSE2` ;

-- -----------------------------------------------------
-- Table `BEDU_JSE2`.`equipos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BEDU_JSE2`.`equipos` ;

CREATE TABLE IF NOT EXISTS `BEDU_JSE2`.`equipos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `BEDU_JSE2`.`partidos`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `BEDU_JSE2`.`partidos` ;

CREATE TABLE IF NOT EXISTS `BEDU_JSE2`.`partidos` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `marcador_equipo_1` INT NOT NULL,
  `marcador_equipo_2` INT NOT NULL,
  `equipos1_fk` INT NOT NULL,
  `equipos2_fk` INT NOT NULL,
  PRIMARY KEY (`id`),
  CONSTRAINT `fk_partidos_equipos`
    FOREIGN KEY (`equipos1_fk`)
    REFERENCES `BEDU_JSE2`.`equipos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_partidos_equipos1`
    FOREIGN KEY (`equipos2_fk`)
    REFERENCES `BEDU_JSE2`.`equipos` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

CREATE INDEX `fk_partidos_equipos_idx` ON `BEDU_JSE2`.`partidos` (`equipos1_fk` ASC);

CREATE INDEX `fk_partidos_equipos1_idx` ON `BEDU_JSE2`.`partidos` (`equipos2_fk` ASC);


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

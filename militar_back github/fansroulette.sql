-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema fansroulette
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema fansroulette
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `fansroulette` DEFAULT CHARACTER SET utf8 ;
USE `fansroulette` ;

-- -----------------------------------------------------
-- Table `fansroulette`.`ZTT_USUARIO`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fansroulette`.`ZTT_USUARIO` ;

CREATE TABLE IF NOT EXISTS `fansroulette`.`ZTT_USUARIO` (
  `iduser` INT NOT NULL AUTO_INCREMENT,
  `correo` VARCHAR(125) NULL,
  `contrasena` VARCHAR(255) NULL,
  `tipo_usuario` INT NULL,
  `nombre` VARCHAR(125) NULL,
  `apellidos` VARCHAR(125) NULL,
  `nombre_completo` VARCHAR(255) NULL,
  `ano_nacimiento` DATE NULL,
  `apodo` VARCHAR(125) NULL,
  `biografia` LONGTEXT NULL,
  `foto` VARCHAR(125) NULL,
  `verificado` TINYINT NULL,
  `fecha_creacion` DATETIME NULL,
  `ultimo_acceso` DATE NULL,
  `instagram` VARCHAR(125) NULL,
  `twitter` VARCHAR(125) NULL,
  `onlyfans` VARCHAR(125) NULL,
  `tiktok` VARCHAR(125) NULL,
  PRIMARY KEY (`iduser`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fansroulette`.`ZTT_RULETA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fansroulette`.`ZTT_RULETA` ;

CREATE TABLE IF NOT EXISTS `fansroulette`.`ZTT_RULETA` (
  `idruleta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(125) NULL,
  `usuario_creacion` VARCHAR(125) NULL,
  `fecha_creacion` DATETIME NULL,
  PRIMARY KEY (`idruleta`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fansroulette`.`ZTM_FICHA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fansroulette`.`ZTM_FICHA` ;

CREATE TABLE IF NOT EXISTS `fansroulette`.`ZTM_FICHA` (
  `idficha` INT NOT NULL AUTO_INCREMENT,
  `cantidad` INT NULL,
  `precio` FLOAT NULL,
  `porcentaje_tr` INT NULL,
  `fecha_creacion` DATETIME NULL,
  `usuario_creacion` VARCHAR(125) NULL,
  PRIMARY KEY (`idficha`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fansroulette`.`ZTT_COMPRA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fansroulette`.`ZTT_COMPRA` ;

CREATE TABLE IF NOT EXISTS `fansroulette`.`ZTT_COMPRA` (
  `idcompra` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NOT NULL,
  `idficha` INT NOT NULL,
  `precio_compra` FLOAT NULL,
  `fecha_compra` DATETIME NULL,
  INDEX `fk_ZTT_USUARIO_has_ZTM_CURSO_ZTM_CURSO1_idx` (`idficha` ASC) VISIBLE,
  INDEX `fk_ZTT_USUARIO_has_ZTM_CURSO_ZTT_USUARIO1_idx` (`iduser` ASC) VISIBLE,
  PRIMARY KEY (`idcompra`),
  CONSTRAINT `fk_ZTT_USUARIO_has_ZTM_CURSO_ZTT_USUARIO1`
    FOREIGN KEY (`iduser`)
    REFERENCES `fansroulette`.`ZTT_USUARIO` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZTT_USUARIO_has_ZTM_CURSO_ZTM_CURSO1`
    FOREIGN KEY (`idficha`)
    REFERENCES `fansroulette`.`ZTM_FICHA` (`idficha`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `fansroulette`.`ZTT_USUARIO_RULETA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fansroulette`.`ZTT_USUARIO_RULETA` ;

CREATE TABLE IF NOT EXISTS `fansroulette`.`ZTT_USUARIO_RULETA` (
  `idusuario_ruleta` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NOT NULL,
  `idruleta` INT NOT NULL,
  `titulo` VARCHAR(125) NULL,
  `url_adjunto` VARCHAR(125) NULL,
  `fecha_creacion` DATETIME NULL,
  PRIMARY KEY (`idusuario_ruleta`),
  INDEX `fk_ZTT_EXAMEN_ZTT_USUARIO1_idx` (`iduser` ASC) VISIBLE,
  INDEX `fk_ZTT_EXAMEN_ZTT_CATEGORIA1_idx` (`idruleta` ASC) VISIBLE,
  CONSTRAINT `fk_ZTT_EXAMEN_ZTT_USUARIO1`
    FOREIGN KEY (`iduser`)
    REFERENCES `fansroulette`.`ZTT_USUARIO` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZTT_EXAMEN_ZTT_CATEGORIA1`
    FOREIGN KEY (`idruleta`)
    REFERENCES `fansroulette`.`ZTT_RULETA` (`idruleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `fansroulette`.`ZTT_TIRADA`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `fansroulette`.`ZTT_TIRADA` ;

CREATE TABLE IF NOT EXISTS `fansroulette`.`ZTT_TIRADA` (
  `idtirada` INT NOT NULL AUTO_INCREMENT,
  `iduser` INT NOT NULL,
  `idusuario_tirada` INT NOT NULL,
  `fecha_tirada` DATETIME NULL,
  PRIMARY KEY (`idtirada`),
  INDEX `fk_ZTT_HISTORICO_ZTT_USUARIO1_idx` (`iduser` ASC) VISIBLE,
  INDEX `fk_ZTT_TIRADA_ZTT_USUARIO_RULETA1_idx` (`idusuario_tirada` ASC) VISIBLE,
  CONSTRAINT `fk_ZTT_HISTORICO_ZTT_USUARIO1`
    FOREIGN KEY (`iduser`)
    REFERENCES `fansroulette`.`ZTT_USUARIO` (`iduser`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ZTT_TIRADA_ZTT_USUARIO_RULETA1`
    FOREIGN KEY (`idusuario_tirada`)
    REFERENCES `fansroulette`.`ZTT_USUARIO_RULETA` (`idusuario_ruleta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

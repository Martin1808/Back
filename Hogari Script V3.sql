-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Hogari
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Hogari
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Hogari` DEFAULT CHARACTER SET utf8 ;
USE `Hogari` ;

-- -----------------------------------------------------
-- Table `Hogari`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hogari`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Numero_contacto` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NULL,
  `Es_arrendador?` VARCHAR(45) BINARY NULL,
  `Imagen_perfil` VARCHAR(45) NOT NULL,
  `logIn_idlogIn` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `logIn_idlogIn`),
  INDEX `fk_Usuario_logIn1_idx` (`logIn_idlogIn` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_logIn1`
    FOREIGN KEY (`logIn_idlogIn`)
    REFERENCES `Hogari`.`logIn` (`idlogIn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hogari`.`logIn`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hogari`.`logIn` (
  `idlogIn` INT NOT NULL,
  `nombreLogin` VARCHAR(45) NOT NULL,
  `passwordLogin` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idlogIn`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hogari`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hogari`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Numero_contacto` VARCHAR(45) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `Email` VARCHAR(45) NULL,
  `Es_arrendador?` VARCHAR(45) BINARY NULL,
  `Imagen_perfil` VARCHAR(45) NOT NULL,
  `logIn_idlogIn` INT NOT NULL,
  PRIMARY KEY (`idUsuario`, `logIn_idlogIn`),
  INDEX `fk_Usuario_logIn1_idx` (`logIn_idlogIn` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_logIn1`
    FOREIGN KEY (`logIn_idlogIn`)
    REFERENCES `Hogari`.`logIn` (`idlogIn`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hogari`.`Imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hogari`.`Imagenes` (
  `idImagenes` INT NOT NULL,
  `idInmueble` INT NOT NULL,
  `nombre_archivo` VARCHAR(45) NOT NULL,
  `Reservacion_idReservacion` INT NOT NULL,
  `Reservacion_Usuario_idUsuario` INT NOT NULL,
  `Reservacion_Inmueble_idInmueble` INT NOT NULL,
  `Reservacion_Inmueble_Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idImagenes`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hogari`.`Inmueble`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hogari`.`Inmueble` (
  `idInmueble` INT NOT NULL AUTO_INCREMENT,
  `Ciudad` VARCHAR(45) NOT NULL,
  `Direccion` VARCHAR(45) NOT NULL,
  `Tipo_Inmueble` VARCHAR(45) NOT NULL,
  `NumeroPersonas` INT NOT NULL,
  `Mascotas` VARCHAR(45) BINARY NULL,
  `Descripcion` VARCHAR(200) NOT NULL,
  `Dimensiones` VARCHAR(45) NOT NULL,
  `Precio` DECIMAL(15) NOT NULL,
  `Publicacion` DATETIME NOT NULL,
  `Creacion_publicacion` DATETIME NULL,
  `Updated_publicacion` DATETIME NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  `Imagenes_idImagenes` INT NOT NULL,
  PRIMARY KEY (`idInmueble`, `Usuario_idUsuario`, `Imagenes_idImagenes`),
  INDEX `fk_Inmueble_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Inmueble_Imagenes1_idx` (`Imagenes_idImagenes` ASC) VISIBLE,
  CONSTRAINT `fk_Inmueble_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `Hogari`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inmueble_Imagenes1`
    FOREIGN KEY (`Imagenes_idImagenes`)
    REFERENCES `Hogari`.`Imagenes` (`idImagenes`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
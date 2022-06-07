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
  PRIMARY KEY (`idUsuario`))
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
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hogari`.`Imagenes`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hogari`.`Imagenes` (
  `idImagenes` INT NOT NULL  AUTO_INCREMENT,
  `idInmueble` INT NOT NULL  AUTO_INCREMENT,
  `nombre_archivo` VARCHAR(45) NOT NULL,
  `Reservacion_idReservacion` INT NOT NULL,
  `Reservacion_Usuario_idUsuario` INT NOT NULL,
  `Reservacion_Inmueble_idInmueble` INT NOT NULL,
  `Reservacion_Inmueble_Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idImagenes`, `Reservacion_idReservacion`, `Reservacion_Usuario_idUsuario`, `Reservacion_Inmueble_idInmueble`, `Reservacion_Inmueble_Usuario_idUsuario`),
  INDEX `fk_Imagenes_Reservacion1_idx` (`Reservacion_idReservacion` ASC, `Reservacion_Usuario_idUsuario` ASC, `Reservacion_Inmueble_idInmueble` ASC, `Reservacion_Inmueble_Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Imagenes_Reservacion1`
    FOREIGN KEY (`Reservacion_idReservacion` , `Reservacion_Usuario_idUsuario` , `Reservacion_Inmueble_idInmueble` , `Reservacion_Inmueble_Usuario_idUsuario`)
    REFERENCES `Hogari`.`Reservacion` (`idReservacion` , `Usuario_idUsuario` , `Inmueble_idInmueble` , `Inmueble_Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
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
  `Imagenes_Reservacion_idReservacion` INT NOT NULL,
  `Imagenes_Reservacion_Usuario_idUsuario` INT NOT NULL,
  `Imagenes_Reservacion_Inmueble_idInmueble` INT NOT NULL,
  `Imagenes_Reservacion_Inmueble_Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idInmueble`, `Usuario_idUsuario`, `Imagenes_idImagenes`, `Imagenes_Reservacion_idReservacion`, `Imagenes_Reservacion_Usuario_idUsuario`, `Imagenes_Reservacion_Inmueble_idInmueble`, `Imagenes_Reservacion_Inmueble_Usuario_idUsuario`),
  INDEX `fk_Inmueble_Usuario1_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Inmueble_Imagenes1_idx` (`Imagenes_idImagenes` ASC, `Imagenes_Reservacion_idReservacion` ASC, `Imagenes_Reservacion_Usuario_idUsuario` ASC, `Imagenes_Reservacion_Inmueble_idInmueble` ASC, `Imagenes_Reservacion_Inmueble_Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Inmueble_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `Hogari`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Inmueble_Imagenes1`
    FOREIGN KEY (`Imagenes_idImagenes` , `Imagenes_Reservacion_idReservacion` , `Imagenes_Reservacion_Usuario_idUsuario` , `Imagenes_Reservacion_Inmueble_idInmueble` , `Imagenes_Reservacion_Inmueble_Usuario_idUsuario`)
    REFERENCES `Hogari`.`Imagenes` (`idImagenes` , `Reservacion_idReservacion` , `Reservacion_Usuario_idUsuario` , `Reservacion_Inmueble_idInmueble` , `Reservacion_Inmueble_Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Hogari`.`Reservacion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Hogari`.`Reservacion` (
  `idReservacion` INT NOT NULL AUTO_INCREMENT,
  `idUsuario` VARCHAR(45) NULL,
  `idInmueble` VARCHAR(45) NULL,
  `FechaInicio` DATETIME(6) NULL,
  `FechaSalida` DATETIME(6) NULL,
  `PrecioPorMes` DECIMAL(10) NULL,
  `Total$` DECIMAL(10) NULL,
  `Creacion_publicacion` DATETIME NOT NULL,
  `Updated_publlicacion` DATETIME NOT NULL,
  `Usuario_idUsuario` INT NOT NULL,
  `Inmueble_idInmueble` INT NOT NULL,
  `Inmueble_Usuario_idUsuario` INT NOT NULL,
  PRIMARY KEY (`idReservacion`, `Usuario_idUsuario`, `Inmueble_idInmueble`, `Inmueble_Usuario_idUsuario`),
  INDEX `fk_Reservacion_Usuario_idx` (`Usuario_idUsuario` ASC) VISIBLE,
  INDEX `fk_Reservacion_Inmueble1_idx` (`Inmueble_idInmueble` ASC, `Inmueble_Usuario_idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Reservacion_Usuario`
    FOREIGN KEY (`Usuario_idUsuario`)
    REFERENCES `Hogari`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Reservacion_Inmueble1`
    FOREIGN KEY (`Inmueble_idInmueble` , `Inmueble_Usuario_idUsuario`)
    REFERENCES `Hogari`.`Inmueble` (`idInmueble` , `Usuario_idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

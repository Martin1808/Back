-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Rentas
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Rentas
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Rentas` DEFAULT CHARACTER SET utf8 ;
USE `Rentas` ;

-- -----------------------------------------------------
-- Table `Rentas`.`Contactanos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rentas`.`Contactanos` (
  `idListaLlamada` INT NOT NULL,
  `FechaLlamada` VARCHAR(100) NULL,
  `OrigenLlamada` VARCHAR(45) NULL,
  `origenEmail` VARCHAR(45) NULL,
  PRIMARY KEY (`idListaLlamada`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Rentas`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rentas`.`Usuario` (
  `idUsuario` INT(20) NOT NULL,
  `Nombre` VARCHAR(45) NOT NULL,
  `Apellido` VARCHAR(45) NOT NULL,
  `Numero_Contacto` DECIMAL NOT NULL,
  `CP` INT(10) NOT NULL,
  `Password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(50) NULL,
  `ListaLlamada_idListaLlamada` INT (20) NOT NULL,
  `Es_arrendador?` VARCHAR(45) BINARY NULL,
  PRIMARY KEY (`idUsuario`, `CP`, `ListaLlamada_idListaLlamada`),
  INDEX `fk_Usuario_ListaLlamada1_idx` (`ListaLlamada_idListaLlamada` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_ListaLlamada1`
    FOREIGN KEY (`ListaLlamada_idListaLlamada`)
    REFERENCES `Rentas`.`Contactanos` (`idListaLlamada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Rentas`.`Renta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rentas`.`Renta` (
  `idPedido` INT NOT NULL,
  `idUsuario` VARCHAR(45) NOT NULL,
  `idInmueble` VARCHAR(45) NOT NULL,
  `Periodo` VARCHAR(45) NOT NULL,
  `FolioRegistro` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPedido`, `idUsuario`, `idInmueble`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Rentas`.`Inmueble`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rentas`.`Inmueble` (
  `idInmmueble` INT NOT NULL,
  `Ciudad` VARCHAR(45) NOT NULL,
  `Tipo_Inmueble` VARCHAR(45) NOT NULL,
  `Costo` DECIMAL(2) NOT NULL,
  `Num_Personas` INT NULL,
  `Mascotas` VARCHAR(45) BINARY NULL,
  `Descripcion` VARCHAR(100) NOT NULL,
  `Dimensiones_m2` INT NOT NULL,
  `Renta_idPedido` INT NOT NULL,
  `Renta_idUsuario` VARCHAR(45) NOT NULL,
  `Renta_idInmueble` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idInmmueble`, `Renta_idPedido`, `Renta_idUsuario`, `Renta_idInmueble`),
  INDEX `fk_Inmueble_Renta1_idx` (`Renta_idPedido` ASC, `Renta_idUsuario` ASC, `Renta_idInmueble` ASC) VISIBLE,
  CONSTRAINT `fk_Inmueble_Renta1`
    FOREIGN KEY (`Renta_idPedido` , `Renta_idUsuario` , `Renta_idInmueble`)
    REFERENCES `Rentas`.`Renta` (`idPedido` , `idUsuario` , `idInmueble`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Rentas`.`Persona.EntidadNegocios`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rentas`.`Persona.EntidadNegocios` (
  `EntidadComercialID` INT NOT NULL,
  `Persona.EntidadNegocioscol` VARCHAR(45) NULL,
  PRIMARY KEY (`EntidadComercialID`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Rentas`.`Usuario_has_Renta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Rentas`.`Usuario_has_Renta` (
  `Usuario_idUsuario` INT(10) NOT NULL,
  `Usuario_CP` INT(10) NOT NULL,
  `Usuario_ListaLlamada_idListaLlamada` INT NOT NULL,
  `Renta_idPedido` INT(10) NOT NULL,
  `Renta_idUsuario` VARCHAR(45) NOT NULL,
  `Renta_idInmueble` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Usuario_idUsuario`, `Usuario_CP`, `Usuario_ListaLlamada_idListaLlamada`, `Renta_idPedido`, `Renta_idUsuario`, `Renta_idInmueble`),
  INDEX `fk_Usuario_has_Renta_Renta1_idx` (`Renta_idPedido` ASC, `Renta_idUsuario` ASC, `Renta_idInmueble` ASC) VISIBLE,
  INDEX `fk_Usuario_has_Renta_Usuario1_idx` (`Usuario_idUsuario` ASC, `Usuario_CP` ASC, `Usuario_ListaLlamada_idListaLlamada` ASC) VISIBLE,
  CONSTRAINT `fk_Usuario_has_Renta_Usuario1`
    FOREIGN KEY (`Usuario_idUsuario` , `Usuario_CP` , `Usuario_ListaLlamada_idListaLlamada`)
    REFERENCES `Rentas`.`Usuario` (`idUsuario` , `CP` , `ListaLlamada_idListaLlamada`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_has_Renta_Renta1`
    FOREIGN KEY (`Renta_idPedido` , `Renta_idUsuario` , `Renta_idInmueble`)
    REFERENCES `Rentas`.`Renta` (`idPedido` , `idUsuario` , `idInmueble`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

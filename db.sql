
DROP SCHEMA  IF EXISTS adressbook;
CREATE SCHEMA `adressbook` ;
CREATE SCHEMA `adressbook` DEFAULT CHARACTER SET utf8 ;


CREATE TABLE `adressbook`.`user` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(245) NULL,
  `lastName` VARCHAR(245) NULL,
  `photoPath` VARCHAR(245) NULL,
  `birthday` DATE  ,
  PRIMARY KEY (`id`));


CREATE TABLE `adressbook`.`contact` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `country` VARCHAR(245) NULL,
  `city` VARCHAR(245) NULL,
  `street` VARCHAR(245) NULL,
  `houseNumber` INT(5) NULL,
  `houseSuffix` INT(5) NULL,
  `postCode` INT(10) NULL,
  `iduser` INT UNSIGNED NULL,
  PRIMARY KEY (`id`),
  INDEX `iduser_idx` (`iduser` ASC),
  CONSTRAINT `iduser`
  FOREIGN KEY (`iduser`)
  REFERENCES `adressbook`.`user` (`id`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION);
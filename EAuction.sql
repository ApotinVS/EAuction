-- MySQL Workbench Synchronization
-- Generated: 2016-09-27 23:19
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: Вит

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `auction`.`Repository` (
  `Repository_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Product_id` INT(11) NOT NULL,
  INDEX `Product_id_idx` (`Product_id` ASC),
  PRIMARY KEY (`Repository_id`),
  CONSTRAINT `Product_id`
    FOREIGN KEY (`Product_id`)
    REFERENCES `auction`.`Product` (`Product_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `auction`.`Categories` (
  `Category_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Category` VARCHAR(140) NOT NULL,
  PRIMARY KEY (`Category_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `auction`.`Roles` (
  `Role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Roles` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Role_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `auction`.`Status` (
  `Status_id` INT(11) NOT NULL AUTO_INCREMENT,
  `Status` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`Status_id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `auction`.`BlackList` (
  `BlackList_id` INT(11) NOT NULL AUTO_INCREMENT,
  `User_id` INT(11) NOT NULL,
  PRIMARY KEY (`BlackList_id`),
  INDEX `User_id_idx` (`User_id` ASC),
  CONSTRAINT `User_id`
    FOREIGN KEY (`User_id`)
    REFERENCES `auction`.`User` (`User_id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `auction`.`User` 
ADD CONSTRAINT `Repository_id`
  FOREIGN KEY (`Repository_id`)
  REFERENCES `auction`.`Repository` (`Repository_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE,
ADD CONSTRAINT `Role_id`
  FOREIGN KEY (`Roles_id`)
  REFERENCES `auction`.`Roles` (`Role_id`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

ALTER TABLE `auction`.`Product` 
ADD CONSTRAINT `Category_id`
  FOREIGN KEY (`Category_id`)
  REFERENCES `auction`.`Categories` (`Category_id`)
  ON DELETE CASCADE
  ON UPDATE CASCADE;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

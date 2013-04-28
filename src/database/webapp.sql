SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `Sharing_App` DEFAULT CHARACTER SET latin1 ;
USE `Sharing_App` ;

-- -----------------------------------------------------
-- Table `Sharing_App`.`users`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Sharing_App`.`users` ;

CREATE  TABLE IF NOT EXISTS `Sharing_App`.`users` (
  `username` VARCHAR(20) NOT NULL DEFAULT '' ,
  `password` VARCHAR(32) NOT NULL DEFAULT '' ,
  `email` VARCHAR(50) NOT NULL DEFAULT '' ,
  `account_expiry` DATE NULL DEFAULT NULL ,
  `non_locked` TINYINT(1) NOT NULL DEFAULT '1' ,
  `enabled` TINYINT(1) NOT NULL DEFAULT '1' ,
  `credential_expiry` INT(11) NULL DEFAULT NULL ,
  `role` VARCHAR(20) NOT NULL DEFAULT '' ,
  PRIMARY KEY (`username`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


-- -----------------------------------------------------
-- Table `Sharing_App`.`posts`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `Sharing_App`.`posts` ;

CREATE  TABLE IF NOT EXISTS `Sharing_App`.`posts` (
  `id` INT(11) UNSIGNED NOT NULL AUTO_INCREMENT ,
  `subject` VARCHAR(60) NOT NULL DEFAULT '' ,
  `content` LONGTEXT NULL DEFAULT NULL ,
  `created` DATETIME NOT NULL ,
  `user` VARCHAR(20) NOT NULL DEFAULT '' ,
  `weather` VARCHAR(30) NOT NULL DEFAULT 'unavailable' ,
  PRIMARY KEY (`id`) ,
  INDEX `user` (`user` ASC) ,
  CONSTRAINT `posts_ibfk_1`
    FOREIGN KEY (`user` )
    REFERENCES `Sharing_App`.`users` (`username` )
    ON UPDATE CASCADE)
ENGINE = InnoDB
AUTO_INCREMENT = 12
DEFAULT CHARACTER SET = latin1;

USE `Sharing_App` ;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

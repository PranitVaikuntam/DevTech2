CREATE TABLE `BoatsAndSailors`.`Boat` (
  `Boat_pk` INT NOT NULL auto_increment,
  `Boat_model` ENUM('c', 'j', 't') NULL,
  `Boat_name` VARCHAR(35) NULL,
  `Boat_LOA` FLOAT NULL,
  PRIMARY KEY (`Boat_pk`)
);
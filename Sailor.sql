mysql> CREATE TABLE `BoatsAndSailors`.`Sailor` (
    `Sailor_pk` INT NOT NULL auto_increment,
    `Sailor_name` VARCHAR(50) NULL,
    `Sailor_role` ENUM('skipper', 'crew'),
    `Sailor_DOB` DATETIME,
    `SailorBoat_pk` INT NULL,
    PRIMARY KEY (`Sailor_pk`)
);

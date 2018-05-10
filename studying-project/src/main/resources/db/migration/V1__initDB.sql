CREATE TABLE IF NOT EXISTS `mydb`.`book` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `description` VARCHAR(100) NOT NULL,
  `publishDate` DATE NOT NULL,
  `publisherId` INT NOT NULL,
  `price` DOUBLE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS `mydb`.`author` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `bio` VARCHAR(100) NOT NULL,
  `birthDay` DATE NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`book_author` (
  `id` INT NOT NULL,
  `bookId` INT NOT NULL,
  `authorId` INT NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS `mydb`.`publisher` (
  `id` INT NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB;



ALTER table `mydb`.`book_author`
ADD INDEX `fk_book_author_book1_idx` (`bookId` ASC),
ADD INDEX `fk_book_author_author1_idx` (`authorId` ASC),
ADD CONSTRAINT `fk_book_author_book1`
    FOREIGN KEY (`bookId`)
    REFERENCES `mydb`.`book` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
ADD CONSTRAINT `fk_book_author_author1`
    FOREIGN KEY (`authorId`)
    REFERENCES `mydb`.`author` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER table `mydb`.`book`
ADD INDEX `fk_book_publisher_idx` (`publisherId` ASC),
ADD  CONSTRAINT `fk_book_publisher`
    FOREIGN KEY (`publisherId`)
    REFERENCES `mydb`.`publisher` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    

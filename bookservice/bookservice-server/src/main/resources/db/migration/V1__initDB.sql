CREATE TABLE IF NOT EXISTS book (
  id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(100) NOT NULL,
  publishDate DATE NOT NULL,
  publisherId INT NOT NULL,
  price DOUBLE NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS author (
id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL,
  bio VARCHAR(100) NOT NULL,
  birthDay DATE NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS book_author (
  id INT NOT NULL AUTO_INCREMENT ,
  bookId INT NOT NULL,
  authorId INT NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS publisher (
id INT NOT NULL AUTO_INCREMENT ,
  name VARCHAR(45) NOT NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;



ALTER table book_author
ADD INDEX fk_book_author_book1_idx (bookId ASC),
ADD INDEX fk_book_author_author1_idx (authorId ASC),
ADD CONSTRAINT fk_book_author_book1
    FOREIGN KEY (bookId)
    REFERENCES book (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
ADD CONSTRAINT fk_book_author_author1
    FOREIGN KEY (authorId)
    REFERENCES author (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;

ALTER table book
ADD INDEX fk_book_publisher_idx (publisherId ASC),
ADD  CONSTRAINT fk_book_publisher
    FOREIGN KEY (publisherId)
    REFERENCES publisher (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION;
    

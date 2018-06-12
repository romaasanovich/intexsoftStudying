CREATE TABLE image (
  id INT NOT NULL,
  bookId INT NOT NULL,
  imagePath VARCHAR(100) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_image_bookId_idx (bookId ASC),
  CONSTRAINT fk_image_bookId
    FOREIGN KEY (bookId)
    REFERENCES book (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

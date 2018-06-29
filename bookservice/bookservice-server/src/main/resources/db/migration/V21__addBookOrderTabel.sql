CREATE TABLE bookOrder (
  id INT NOT NULL auto_increment,
  userId INT NOT NULL,
  bookId INT NOT NULL,
  orderTime DATETIME NOT NULL,
  totalPrice DOUBLE NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_bookOrder_user_idx (userId ASC),
  INDEX fk_bookOrder_book_idx (bookId ASC),
  CONSTRAINT fk_bookOrder_user
    FOREIGN KEY (userId)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_bookOrder_book
    FOREIGN KEY (bookId)
    REFERENCES book (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

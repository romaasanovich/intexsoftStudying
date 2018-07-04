CREATE TABLE bookOrder (
  id INT NOT NULL auto_increment,
  userId INT NOT NULL,
  orderTime DATETIME NOT NULL,
  totalPrice DOUBLE NOT NULL,
  status VARCHAR(45) NOT NULL,
  PRIMARY KEY (id));

  CREATE TABLE order_book (
  id INT NOT NULL auto_increment,
  orderId INT NOT NULL,
  bookId INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fk_order_book_1_idx (orderId ASC),
  INDEX fk_bookId_idx (bookId ASC),
  CONSTRAINT fk_orderId
    FOREIGN KEY (orderId)
    REFERENCES bookOrder (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_bookId
    FOREIGN KEY (bookId)
    REFERENCES book (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


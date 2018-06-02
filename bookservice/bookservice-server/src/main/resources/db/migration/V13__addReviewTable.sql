CREATE TABLE review (
  id INT NOT NULL AUTO_INCREMENT,
  review VARCHAR(350) NOT NULL,
  rate INT NOT NULL,
  userId INT NOT NULL,
  bookId INT NOT NULL,
  PRIMARY KEY (id),
  INDEX fK_UserId_User_idx (userId ASC),
  INDEX fk_BookId_Book_idx (bookId ASC),
  CONSTRAINT fK_UserId_User
    FOREIGN KEY (userId)
    REFERENCES user (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_BookId_Book
    FOREIGN KEY (bookId)
    REFERENCES book (id)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

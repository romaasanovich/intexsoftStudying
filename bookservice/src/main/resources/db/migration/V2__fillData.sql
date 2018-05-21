ALTER TABLE book
CHANGE COLUMN description description VARCHAR(1500) NOT NULL ;
ALTER TABLE author
CHANGE COLUMN bio bio VARCHAR(100) NOT NULL ;

ALTER TABLE publisher AUTO_INCREMENT=0;
INSERT INTO publisher (name) VALUES ('Bantam Spectra');
INSERT INTO publisher (name) VALUES ('Bloomsbury Publishing');
INSERT INTO publisher (name) VALUES ('Allen & Unwin');
ALTER TABLE author AUTO_INCREMENT=0;
INSERT INTO author (name, bio, birthDay) VALUES ('Joanne Rowling', 'Novelist short story writer screenwriter', '1965-07-31');
INSERT INTO author (name, bio, birthDay) VALUES ('George Raymond Martin', 'Novelist, film producer, television producer, screenwriter', '1948-09-20');
INSERT INTO author (name, bio, birthDay) VALUES ('JohnRonald Reuel Tolkien', '	Author, academic, philologist, poet', '1973-09-02');

ALTER TABLE book AUTO_INCREMENT=0;
INSERT INTO book (name, description, publishDate, publisherId, price) VALUES ('LordOfTheRings: The Fellowship of the Ring', 'The Fellowship of the Ring is the first of three volumes of the epic[2] novel The Lord of the Rings by the English author J. R. R. Tolkien. It is followed by The Two Towers and The Return of the King. It takes place in the fictional universe of Middle-earth. It was originally published on 29 July 1954 in the United Kingdom. The volume consists of a prologue titled \"Concerning Hobbits, and other matters\" followed by Book I and Book II.', '1954-07-29', '3', '35.2');
INSERT INTO book (name, description, publishDate, publisherId, price) VALUES ('LordOfTheRings: The Two Towers', 'The Two Towers is the second volume of J. R. R. Tolkiens high fantasy novel The Lord of the Rings. It is preceded by The Fellowship of the Ring and followed by The Return of the King.', '1954-11-11', '3', '40.5');
INSERT INTO book (name, description, publishDate, publisherId, price) VALUES ('LordOfTheRings: The Fellowship of the Ring', 'The Return of the King is the third and final volume of J. R. R. Tolkiens The Lord of the Rings, following The Fellowship of the Ring and The Two Towers. The story begins in the kingdom of Gondor, which is soon to be attacked by the Dark Lord Sauron.', '1955-10-20', '3', '48.5');
INSERT INTO book (name, description, publishDate, publisherId, price) VALUES ('A Game of Thrones', 'A Game of Thrones is the first novel in A Song of Ice and Fire, a series of fantasy novels by American author George R. R. Martin. It was first published on August 1, 1996. The novel won the 1997 Locus Award[2] and was nominated for both the 1997 Nebula Award[2] and the 1997 World Fantasy Award. The novella Blood of the Dragon, comprising the Daenerys Targaryen chapters from the novel, won the 1997 Hugo Award for Best Novella. In January 2011 the novel became a New York Times bestseller and reached #1 on the list in July 2011', '1996-08-01', '1', '51.8');
INSERT INTO book (name, description, publishDate, publisherId, price) VALUES ('Harry Potter and the Philosophers Stone', 'Harry Potter and the Philosophers Stone is a fantasy novel written by British author J. K. Rowling. It is the first novel in the Harry Potter series and Rowlings debut novel', '1997-06-26', '2', '30.8');
INSERT INTO book (name, description, publishDate, publisherId, price) VALUES ('Harry Potter and the Prisoner of Azkaban', 'Harry Potter and the Prisoner of Azkaban is a fantasy novel written by British author J. K. Rowling and the third in the Harry Potter series. The book follows Harry Potter, a young wizard, in his third year at Hogwarts School of Witchcraft and Wizardry.', '1999-07-08', '2', '32.8');

ALTER TABLE book_author AUTO_INCREMENT=0;
INSERT INTO book_author (bookId, authorId) VALUES ('1', '3');
INSERT INTO book_author (bookId, authorId) VALUES ('2', '3');
INSERT INTO book_author (bookId, authorId) VALUES ('3', '3');
INSERT INTO book_author (bookId, authorId) VALUES ('4', '1');
INSERT INTO book_author (bookId, authorId) VALUES ('5', '2');
INSERT INTO book_author (bookId, authorId) VALUES ('6', '2');



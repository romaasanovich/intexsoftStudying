ALTER TABLE `mydb`.`user` 
CHANGE COLUMN `password` `password` VARCHAR(100) NOT NULL ;
UPDATE `mydb`.`user` SET `password`='$2a$04$22r9pxCh/szFZ3HdLRpLGujn5UkiUZpQIRPa.7Yc0o.6mBALaVINy', `role`='ROLE_USER' WHERE `id`='1';
UPDATE `mydb`.`user` SET `password`='$2a$04$WNcCi/o6AR5KIKuJaroaaujKdAYGHzSYYfkWCjwdrtvpLva/UHbz6', `role`='ROLE_USER' WHERE `id`='2';
UPDATE `mydb`.`user` SET `password`='$2a$04$6b9HcRHbAdGfJkCayuRfVu0AIoO8S1BbD3xOe1jA8U6LypOM2mFUe', `role`='ROLE_USER' WHERE `id`='3';

-- passes usingBCryptPasswordEncoder;
-- pass root
INSERT INTO user (login, password, email, role) VALUES ('root', '$2a$04$22r9pxCh/szFZ3HdLRpLGujn5UkiUZpQIRPa.7Yc0o.6mBALaVINy', 'qwerty@sm.re', 'ROLE_USER');
-- pass 12345
INSERT INTO user (login, password, email, role) VALUES ('cust1', '$2a$04$WNcCi/o6AR5KIKuJaroaaujKdAYGHzSYYfkWCjwdrtvpLva/UHbz6', 'user10@sm.re', 'ROLE_USER');
-- pass 54321
INSERT INTO user (login, password, email, role) VALUES ('cust', '$2a$04$6b9HcRHbAdGfJkCayuRfVu0AIoO8S1BbD3xOe1jA8U6LypOM2mFUe', 'user52@sm.re', 'ROLE_USER');

DROP TABLE IF EXISTS users_accounts;

CREATE TABLE users_accounts (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  salt VARCHAR(250),
  hash VARCHAR(250)
);

INSERT INTO users_accounts (username, email, password, salt, hash) VALUES
  ('Aliko','a@a.a','I Am Password',NULL, NULL) ,
  ('Folrunsho','b@b.b','I rrrd',NULL, NULL),
  ('Alakija','c@c.c','Password',NULL, NULL);
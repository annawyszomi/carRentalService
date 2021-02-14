DROP TABLE IF EXISTS car;

CREATE TABLE car(
    id LONG AUTO_INCREMENT  PRIMARY KEY,
    brand VARCHAR(250) NOT NULL,
    model VARCHAR(250) NOT NULL,
   status ENUM('RENTED','AVAILABLE')
);
INSERT INTO car (brand, model, status) VALUES
  ('volvo', 's60', ' RENTED'),
  ('honda', 'crv', 'RENTED'),
  ('nissan', 'x-trail', 'AVAILABLE');




DROP TABLE IF EXISTS user;

  CREATE TABLE user(
      id LONG AUTO_INCREMENT  PRIMARY KEY,
      first_name VARCHAR(250) NOT NULL,
      last_name VARCHAR(250) NOT NULL
  );
  INSERT INTO user (first_name, last_name) VALUES
    ('Maria', 'Nowak'),
    ('Jan', 'Kowalski');
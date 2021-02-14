DROP TABLE IF EXISTS car;

CREATE TABLE car(
    id LONG AUTO_INCREMENT  PRIMARY KEY,
    brand VARCHAR(250) NOT NULL,
    model VARCHAR(250) NOT NULL,
   status ENUM('AVAILABLE','RENTED')
);
INSERT INTO car (brand, model, status) VALUES
  ('volvo', 's60', ' AVAILABLE'),
  ('honda', 'crv', 'AVAILABLE'),
  ('nissan', 'x-trail', 'AVAILABLE');

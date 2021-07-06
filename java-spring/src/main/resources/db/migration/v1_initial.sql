CREATE TABLE user (
  userId        VARCHAR(30) NOT NULL,
  password    VARCHAR(100) NOT NULL,
  PRIMARY KEY (userId)
);

INSERT INTO user (userId, password)
  VALUES ('admin', 'pass');

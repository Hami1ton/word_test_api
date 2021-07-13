-- user
INSERT INTO USER (USER_ID, PASSWORD) VALUES ('admin', 'pass');

-- VOCABULARY_BOOK(English Words and Meanings)
INSERT INTO VOCABULARY_BOOK SELECT * FROM CSVREAD('classpath:db/csv/vocabularyBook.csv');

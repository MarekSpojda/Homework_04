create database guests character set UTF8mb4 collate utf8mb4_bin;
CREATE TABLE entries
(
  Id      INT          NOT NULL AUTO_INCREMENT,
  Name    VARCHAR(255) NOT NULL,
  Surname VARCHAR(255) NOT NULL,
  Entry   VARCHAR(512) NOT NULL,
  PRIMARY KEY (Id)
)
  CHARACTER SET UTF8mb4;
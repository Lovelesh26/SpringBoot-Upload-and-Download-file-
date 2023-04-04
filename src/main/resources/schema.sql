
--create table if not exists photoz (
--  id bigint identity primary key ,
--  file_name varchar(225),
--  contentType varchar(225),
--  data binary
--);
CREATE TABLE IF NOT EXISTS photoz (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  file_name VARCHAR(225),
  contentType VARCHAR(225),
  data BINARY
);

CREATE TABLE user_group(
id INT(11) AUTO_INCREMENT,
name VARCHAR(255),
PRIMARY KEY(id));

CREATE TABLE users(
id BIGINT(20) AUTO_INCREMENT,
username VARCHAR(255),
email VARCHAR(255) UNIQUE,
password VARCHAR(245),
user_group_id INT(11),
PRIMARY KEY(id),
FOREIGN KEY(user_group_id) REFERENCES user_group(id));

CREATE TABLE excercise(
  id INT(11) AUTO_INCREMENT,
  title VARCHAR(255),
  description TEXT,
  PRIMARY KEY(id)
);

CREATE TABLE solution(
  id INT(11) AUTO_INCREMENT,
  created DATETIME,
  updated DATETIME,
  description TEXT,
  excercise_id INT(11),
  users_id BIGINT(20),
  PRIMARY KEY(id),
  FOREIGN KEY(excercise_id) REFERENCES excercise(id),
  FOREIGN KEY(users_id) REFERENCES users(id)
);

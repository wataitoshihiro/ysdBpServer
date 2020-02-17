--mysql -u root -p

DROP DATABASE IF EXISTS ysd_db;

CREATE DATABASE ysd_db CHARACTER SET utf8;

GRANT ALL ON ysd_db.* TO jim IDENTIFIED BY "0000";
  Å´MySQL8
CREATE USER 'jim'@'localhost' IDENTIFIED BY '0000';


create schema if not exists `EduDB`;

grant all on EduDB.* to 'admin'@'localhost' identified by '2940';

--MYSQL 8.1.0
CREATE USER 'admin'@'localhost' IDENTIFIED WITH 'mysql_native_password' BY '2940';

GRANT ALL PRIVILEGES ON EduDB.* TO 'admin'@'localhost';

flush privileges;
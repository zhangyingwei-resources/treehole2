# treehole db init script
# db create
CREATE DATABASE treehole;
# admin create
create table admin(id int PRIMARY KEY AUTO_INCREMENT NOT NULL UNIQUE,username VARCHAR(20) NOT NULL,password VARCHAR(50) NOT NULL );

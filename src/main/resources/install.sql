# treehole db init script
# db create
CREATE DATABASE treehole
# table create
create table admin(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,username VARCHAR(20) NOT NULL,password VARCHAR(50) NOT NULL )
create table bloginfo(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL UNIQUE,name VARCHAR(50) NOT NULL,url VARCHAR(50),desc VARCHAR(500))
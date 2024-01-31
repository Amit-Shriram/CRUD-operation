create database project;

use project;

CREATE TABLE Registration (
    ID INT AUTO_INCREMENT PRIMARY KEY,
    Name VARCHAR(255) NOT NULL,
    Email VARCHAR(255) NOT NULL,
    DateOfBirth DATE
);

select * from Registration;


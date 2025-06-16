CREATE DATABASE GowthamTestDB;
GO

USE GowthamTestDB;
GO

CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT
);
GO

INSERT INTO Students (StudentID, Name, Age)
VALUES 
(1, 'Gowtham', 21),
(2, 'Sai', 22);
GO

SELECT * FROM Students;

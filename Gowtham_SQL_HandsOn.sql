-- Create your test database
CREATE DATABASE GowthamTestDB;
GO

-- Use that database
USE GowthamTestDB;
GO

-- Create a Students table
CREATE TABLE Students (
    StudentID INT PRIMARY KEY,
    Name VARCHAR(50),
    Age INT
);
GO

-- Insert data into Students table
INSERT INTO Students (StudentID, Name, Age)
VALUES 
(1, 'Gowtham', 21),
(2, 'Sai', 22);
GO

-- Retrieve all records from the table
SELECT * FROM Students;

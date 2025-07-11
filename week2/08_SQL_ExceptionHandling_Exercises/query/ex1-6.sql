
DROP TABLE IF EXISTS Employees;
DROP TABLE IF EXISTS Departments;
DROP TABLE IF EXISTS AuditLog;
GO


CREATE TABLE Departments (
    DepartmentID INT PRIMARY KEY,
    DepartmentName VARCHAR(100) NOT NULL
);
GO

CREATE TABLE Employees (
    EmployeeID INT PRIMARY KEY,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    Salary DECIMAL(10, 2),
    DepartmentID INT,
    FOREIGN KEY (DepartmentID) REFERENCES Departments(DepartmentID)
);
GO

CREATE TABLE AuditLog (
    LogID INT IDENTITY(1,1) PRIMARY KEY,
    Action VARCHAR(100),
    ErrorMessage VARCHAR(4000),
    ActionDate DATETIME DEFAULT GETDATE()
);
GO


INSERT INTO Departments VALUES
(1, 'HR'),
(2, 'Finance'),
(3, 'IT');
GO


CREATE OR ALTER PROCEDURE AddEmployee
    @EmployeeID INT,
    @FirstName VARCHAR(50),
    @LastName VARCHAR(50),
    @Email VARCHAR(100),
    @Salary DECIMAL(10,2),
    @DepartmentID INT
AS
BEGIN
    
    IF @Salary < 0
    BEGIN
        RAISERROR('Salary cannot be negative.', 16, 1);
        RETURN;
    END
    ELSE IF @Salary < 1000
    BEGIN
        RAISERROR('Warning: Low salary (<1000).', 10, 1); -- warning
    END

    BEGIN TRY
        INSERT INTO Employees (EmployeeID, FirstName, LastName, Email, Salary, DepartmentID)
        VALUES (@EmployeeID, @FirstName, @LastName, @Email, @Salary, @DepartmentID);
    END TRY
    BEGIN CATCH
        INSERT INTO AuditLog (Action, ErrorMessage)
        VALUES ('Insert Employee', ERROR_MESSAGE());
        THROW;
    END CATCH
END;
GO


EXEC AddEmployee 1, 'John', 'Doe', 'john@example.com', 5000, 1;

EXEC AddEmployee 2, 'Jane', 'Smith', 'john@example.com', 6000, 1;

EXEC AddEmployee 3, 'Bob', 'Hill', 'bob@example.com', -1000, 2;

EXEC AddEmployee 4, 'Sara', 'Lee', 'sara@example.com', 900, 2;
GO

CREATE OR ALTER PROCEDURE TransferEmployee
    @EmployeeID INT,
    @NewDepartmentID INT
AS
BEGIN
    BEGIN TRY
        BEGIN TRY
            IF NOT EXISTS (SELECT 1 FROM Departments WHERE DepartmentID = @NewDepartmentID)
            BEGIN
                RAISERROR('Target department does not exist.', 16, 1);
            END

            UPDATE Employees
            SET DepartmentID = @NewDepartmentID
            WHERE EmployeeID = @EmployeeID;
        END TRY
        BEGIN CATCH
            INSERT INTO AuditLog (Action, ErrorMessage)
            VALUES ('Transfer Employee', ERROR_MESSAGE());
            THROW;
        END CATCH
    END TRY
    BEGIN CATCH
        PRINT 'Outer catch block: ' + ERROR_MESSAGE();
    END CATCH
END;
GO


EXEC TransferEmployee 1, 99;
GO

CREATE OR ALTER PROCEDURE BatchInsertEmployees
AS
BEGIN
    BEGIN TRY
        BEGIN TRANSACTION;

        INSERT INTO Employees VALUES (101, 'Alice', 'M', 'alice@example.com', 4500, 1);
        INSERT INTO Employees VALUES (102, 'Tom', 'P', 'alice@example.com', 5500, 2); -- duplicate email
        INSERT INTO Employees VALUES (103, 'Eve', 'Q', 'eve@example.com', 6200, 3);

        COMMIT;
    END TRY
    BEGIN CATCH
        ROLLBACK;
        INSERT INTO AuditLog (Action, ErrorMessage)
        VALUES ('Batch Insert', ERROR_MESSAGE());
        THROW;
    END CATCH
END;
GO


EXEC BatchInsertEmployees;
GO

SELECT * FROM Employees;
SELECT * FROM AuditLog;
GO

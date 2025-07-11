CREATE TRIGGER trg_UpdateAnnualSalary
ON Employees
AFTER UPDATE
AS
BEGIN
    IF UPDATE(Salary)
    BEGIN
        UPDATE e
        SET AnnualSalary = i.Salary * 12
        FROM Employees e
        JOIN inserted i ON e.EmployeeID = i.EmployeeID;
    END
END;
GO


UPDATE Employees SET Salary = 6500 WHERE EmployeeID = 1;
SELECT EmployeeID, Salary, AnnualSalary FROM Employees;
GO

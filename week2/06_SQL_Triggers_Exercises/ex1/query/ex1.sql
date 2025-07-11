CREATE TRIGGER trg_AfterSalaryUpdate
ON Employees
AFTER UPDATE
AS
BEGIN
    IF UPDATE(Salary)
    BEGIN
        INSERT INTO EmployeeChanges (EmployeeID, OldSalary, NewSalary, ChangedAt)
        SELECT 
            d.EmployeeID,
            d.Salary AS OldSalary,
            i.Salary AS NewSalary,
            GETDATE()
        FROM deleted d
        JOIN inserted i ON d.EmployeeID = i.EmployeeID;
    END
END;
GO

UPDATE Employees SET Salary = Salary + 1000 WHERE EmployeeID = 1;
SELECT * FROM EmployeeChanges;
GO

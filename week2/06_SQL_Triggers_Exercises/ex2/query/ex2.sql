CREATE TRIGGER trg_PreventDelete
ON Employees
INSTEAD OF DELETE
AS
BEGIN
    RAISERROR('Deletion of employee records is not allowed.', 16, 1);
END;
GO

DELETE FROM Employees WHERE EmployeeID = 2;
GO


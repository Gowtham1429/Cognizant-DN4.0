DROP TRIGGER IF EXISTS trg_PreventDelete;
GO


DELETE FROM Employees WHERE EmployeeID = 2;
GO

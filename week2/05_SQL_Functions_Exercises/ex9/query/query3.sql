SELECT 
    EmployeeID, 
    FirstName, 
    LastName, 
    Salary,
    dbo.fn_CalculateTotalCompensation(Salary) AS TotalCompensation
FROM Employees;

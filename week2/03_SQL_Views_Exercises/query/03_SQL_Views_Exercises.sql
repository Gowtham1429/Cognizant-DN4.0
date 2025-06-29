
CREATE VIEW vw_EmployeeBasicInfo AS
SELECT 
    e.EmployeeID,
    e.FirstName,
    e.LastName,
    d.DepartmentName
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID;
GO

CREATE VIEW vw_EmployeeFullName AS
SELECT 
    EmployeeID,
    FirstName + ' ' + LastName AS FullName
FROM Employees;
GO


CREATE VIEW vw_EmployeeAnnualSalary AS
SELECT 
    EmployeeID,
    Salary * 12 AS AnnualSalary
FROM Employees;
GO

CREATE VIEW vw_EmployeeReport AS
SELECT 
    e.EmployeeID,
    e.FirstName + ' ' + e.LastName AS FullName,
    d.DepartmentName,
    e.Salary * 12 AS AnnualSalary,
    (e.Salary * 12) * 0.10 AS Bonus
FROM Employees e
JOIN Departments d ON e.DepartmentID = d.DepartmentID;
GO



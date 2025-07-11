CREATE PROCEDURE sp_GetEmployeesByDepartment
    @DepartmentID INT
AS
BEGIN
    SELECT * FROM Employees
    WHERE DepartmentID = @DepartmentID;
END;




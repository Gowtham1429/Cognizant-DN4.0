CREATE FUNCTION fn_GetEmployeesByDepartment
(
    @DeptID INT
)
RETURNS TABLE
AS
RETURN
(
    SELECT * FROM Employees WHERE DepartmentID = @DeptID
);


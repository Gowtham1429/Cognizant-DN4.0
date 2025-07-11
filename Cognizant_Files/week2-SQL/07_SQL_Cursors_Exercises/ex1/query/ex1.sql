DECLARE @EmployeeID INT,
        @FirstName VARCHAR(50),
        @LastName VARCHAR(50),
        @DepartmentID INT,
        @Salary DECIMAL(10,2),
        @JoinDate DATE;

DECLARE emp_cursor CURSOR FOR
SELECT EmployeeID, FirstName, LastName, DepartmentID, Salary, JoinDate
FROM Employees;


OPEN emp_cursor;

FETCH NEXT FROM emp_cursor INTO 
    @EmployeeID, @FirstName, @LastName, @DepartmentID, @Salary, @JoinDate;

WHILE @@FETCH_STATUS = 0
BEGIN
    PRINT 'Employee ID: ' + CAST(@EmployeeID AS VARCHAR) +
          ', Name: ' + @FirstName + ' ' + @LastName +
          ', Dept ID: ' + CAST(@DepartmentID AS VARCHAR) +
          ', Salary: ' + CAST(@Salary AS VARCHAR) +
          ', Join Date: ' + CAST(@JoinDate AS VARCHAR);

    FETCH NEXT FROM emp_cursor INTO 
        @EmployeeID, @FirstName, @LastName, @DepartmentID, @Salary, @JoinDate;
END


CLOSE emp_cursor;
DEALLOCATE emp_cursor;
GO

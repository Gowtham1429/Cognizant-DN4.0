CREATE PROCEDURE sp_SafeSalaryUpdate
    @EmployeeID INT,
    @NewSalary DECIMAL(10,2)
AS
BEGIN
    BEGIN TRY
        IF @NewSalary < 0
            THROW 51000, 'Salary must be a positive number.', 1;

        UPDATE Employees
        SET Salary = @NewSalary
        WHERE EmployeeID = @EmployeeID;

        PRINT 'Salary updated successfully.';
    END TRY
    BEGIN CATCH
        PRINT 'Error: ' + ERROR_MESSAGE();
    END CATCH
END;


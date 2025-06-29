CREATE FUNCTION fn_CalculateAnnualSalary
(
    @Salary DECIMAL(10, 2)
)
RETURNS DECIMAL(10, 2)
AS
BEGIN
    RETURN @Salary * 12;
END;



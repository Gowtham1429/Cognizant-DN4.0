CREATE FUNCTION fn_CalculateTotalCompensation
(
    @Salary DECIMAL(10, 2)
)
RETURNS DECIMAL(10, 2)
AS
BEGIN
    RETURN dbo.fn_CalculateAnnualSalary(@Salary) + dbo.fn_CalculateBonus(@Salary);
END;
GO

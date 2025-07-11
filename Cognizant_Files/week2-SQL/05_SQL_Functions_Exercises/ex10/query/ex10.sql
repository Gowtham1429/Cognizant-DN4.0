ALTER FUNCTION fn_CalculateTotalCompensation
(
    @Salary DECIMAL(10, 2)
)
RETURNS DECIMAL(10, 2)
AS
BEGIN
    DECLARE @AnnualSalary DECIMAL(10,2) = dbo.fn_CalculateAnnualSalary(@Salary);
    DECLARE @Bonus DECIMAL(10,2) = dbo.fn_CalculateBonus(@Salary);
    RETURN @AnnualSalary + @Bonus;
END;



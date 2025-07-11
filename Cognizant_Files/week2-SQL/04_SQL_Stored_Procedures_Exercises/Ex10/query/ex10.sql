CREATE PROCEDURE sp_GetEmployeesByDynamicFilter
    @FilterColumn NVARCHAR(100),
    @FilterValue NVARCHAR(100)
AS
BEGIN
    DECLARE @SQL NVARCHAR(MAX);
    SET @SQL = 'SELECT * FROM Employees WHERE ' + QUOTENAME(@FilterColumn) + ' = @Value';

    EXEC sp_executesql @SQL, N'@Value NVARCHAR(100)', @Value = @FilterValue;
END;


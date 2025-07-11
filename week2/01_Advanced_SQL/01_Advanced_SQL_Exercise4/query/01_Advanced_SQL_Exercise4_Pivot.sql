SELECT *
FROM (
    SELECT 
        p.ProductName,
        MONTH(o.OrderDate) AS SaleMonth,
        od.Quantity
    FROM Orders o
    JOIN OrderDetails od ON o.OrderID = od.OrderID
    JOIN Products p ON od.ProductID = p.ProductID
) AS SourceTable
PIVOT (
    SUM(Quantity)
    FOR SaleMonth IN ([1], [2], [3], [4])
) AS PivotTable;

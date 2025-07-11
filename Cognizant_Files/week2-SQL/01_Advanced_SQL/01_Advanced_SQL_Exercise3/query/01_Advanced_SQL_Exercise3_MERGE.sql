USE RetailDB;
GO

MERGE Products AS target
USING StagingProducts AS source
ON target.ProductID = source.ProductID
WHEN MATCHED THEN
    UPDATE SET 
        target.ProductName = source.ProductName,
        target.Category = source.Category,
        target.Price = source.Price
WHEN NOT MATCHED THEN
    INSERT (ProductID, ProductName, Category, Price)
    VALUES (source.ProductID, source.ProductName, source.Category, source.Price);
SELECT * FROM Products;

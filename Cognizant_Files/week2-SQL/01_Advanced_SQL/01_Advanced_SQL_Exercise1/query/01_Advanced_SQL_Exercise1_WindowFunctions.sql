SELECT ProductID, ProductName, Category, Price,
       ROW_NUMBER() OVER (PARTITION BY Category ORDER BY Price DESC) AS RowNum
FROM Products;

SELECT ProductID, ProductName, Category, Price,
       RANK() OVER (PARTITION BY Category ORDER BY Price DESC) AS RankNum
FROM Products;

SELECT ProductID, ProductName, Category, Price,
       DENSE_RANK() OVER (PARTITION BY Category ORDER BY Price DESC) AS DenseRank
FROM Products;

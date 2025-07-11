
DECLARE static_cursor CURSOR STATIC FOR
SELECT EmployeeID, FirstName, LastName FROM Employees;
OPEN static_cursor;
CLOSE static_cursor;
DEALLOCATE static_cursor;
GO


DECLARE dynamic_cursor CURSOR DYNAMIC FOR
SELECT EmployeeID, FirstName, LastName FROM Employees;
OPEN dynamic_cursor;
CLOSE dynamic_cursor;
DEALLOCATE dynamic_cursor;
GO


DECLARE forward_cursor CURSOR FORWARD_ONLY FOR
SELECT EmployeeID, FirstName, LastName FROM Employees;
OPEN forward_cursor;
CLOSE forward_cursor;
DEALLOCATE forward_cursor;
GO


DECLARE keyset_cursor CURSOR KEYSET FOR
SELECT EmployeeID, FirstName, LastName FROM Employees;
OPEN keyset_cursor;
CLOSE keyset_cursor;
DEALLOCATE keyset_cursor;
GO
PRINT 'Static Cursor opened and closed successfully';

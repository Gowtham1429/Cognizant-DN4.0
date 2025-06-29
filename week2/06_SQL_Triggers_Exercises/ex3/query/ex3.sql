CREATE TRIGGER trg_RestrictLogonDuringMaintenance
ON ALL SERVER
FOR LOGON
AS
BEGIN
    IF DATEPART(HOUR, GETDATE()) = 2
    BEGIN
        ROLLBACK;
        PRINT 'Logins are not allowed between 2 AM and 3 AM due to maintenance.';
    END
END;
GO

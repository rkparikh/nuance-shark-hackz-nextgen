USE [shark_hackz_demo]
GO

INSERT INTO [dbo].[PATIENT]
           ([MRN]
           ,[FACILITY_ID]
           ,[ENTERPRISE_NUM]
           ,[FIRST_NAME]
           ,[LAST_NAME]
           ,[MIDDLE_NAME]
           ,[BIRTH_DATE]
           ,[GENDER])
     VALUES
           ('TEST_MRN1'
           ,'TEST_FACILITY1'
           ,'TEST_ENTERPRISE_NUM1'
           ,'John'
           ,'Smith'
           ,'M'
           ,'1951-10-10 00:00:00.000'
           ,'Male')
GO



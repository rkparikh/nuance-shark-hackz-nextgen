USE [shark_hackz_demo]
GO

INSERT INTO [dbo].[FACTOR]
           ([PROPERTY_NAME]
           ,[DISPLAY_NAME]
           ,[DESCRIPTION]
           ,[FACTOR_TYPE]
           ,[CREATED_BY]
           ,[CREATED_DATE]
           ,[MODIFIED_BY]
           ,[MODIFIED_DATE])
     VALUES
           ('SugerLevel'
           ,'Blood Sugar level(mg/dL)'
           ,'Blood Suger level in mg/dL for Diabetes tracking'
           ,'FLOAT'
           ,'admin'
           ,CURRENT_TIMESTAMP
           ,'admin'
           ,CURRENT_TIMESTAMP)
GO


INSERT INTO [dbo].[FACTOR]
           ([PROPERTY_NAME]
           ,[DISPLAY_NAME]
           ,[DESCRIPTION]
           ,[FACTOR_TYPE]
           ,[CREATED_BY]
           ,[CREATED_DATE]
           ,[MODIFIED_BY]
           ,[MODIFIED_DATE])
     VALUES
           ('ConsistentAbnormalCount'
           ,'Consistent Abnormal Count'
           ,'How many time Consistent Abnormal Count before notification is sent'
           ,'INTEGER'
           ,'admin'
           ,CURRENT_TIMESTAMP
           ,'admin'
           ,CURRENT_TIMESTAMP)
GO

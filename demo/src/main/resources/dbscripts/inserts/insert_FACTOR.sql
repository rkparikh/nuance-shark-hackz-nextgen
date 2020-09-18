USE [shark_hackz_demo]
GO

INSERT INTO [dbo].[FACTOR]
           ([PROPERTY_NAME]
           ,[DISPLAY_NAME]
           ,[DESCRIPTION]
           ,[FACTOR_TYPE])
     VALUES
           ('SugerLevel'
           ,'Blood Sugar level(mg/dL)'
           ,'Blood Suger level in mg/dL for Diabetes tracking'
           ,'FLOAT')
GO


INSERT INTO [dbo].[FACTOR]
           ([PROPERTY_NAME]
           ,[DISPLAY_NAME]
           ,[DESCRIPTION]
           ,[FACTOR_TYPE])
     VALUES
           ('ConsistentAbnormalCount'
           ,'Consistent Abnormal Count'
           ,'How many time Consistent Abnormal Count before notification is sent'
           ,'INTEGER')
GO

USE [shark_hackz_demo]
GO

INSERT INTO [dbo].[VITALS_RULE]
           ([NAME]
           ,[DESCRIPTION]
		   ,[RISK_LEVEL]
           ,[DEFINITION])
     VALUES
           ('BloodSugerRule'
           ,'Rule for sending notification for blood suger levels'
		   ,'HIGH'
           ,'{
    "condition": "AND",
    "rules": [
        {
            "field": "SugerLevel",
            "operator": "GREATER_THAN_OR_EQUAL",
            "value": 200
        },
		{
            "field": "ConsistentAbnormalCount",
            "operator": "EQUAL",
            "value": 3
        }
    ]
}')
GO




CREATE TABLE VITALS_RULE (
    VITALS_RULE_SID BIGINT IDENTITY(1,1) NOT NULL,
	NAME VARCHAR(32) NOT NULL,
    DESCRIPTION VARCHAR(256),
	RISK_LEVEL VARCHAR(32) NOT NULL,
	DEFINITION VARCHAR(max) NOT NULL,
    CREATED_BY VARCHAR(256) NOT NULL,
    CREATED_DATE DATETIME2 NOT NULL CONSTRAINT DF_VITALS_RULE_CD DEFAULT SYSDATETIME(),
    MODIFIED_BY VARCHAR(256) NOT NULL,
    MODIFIED_DATE DATETIME2 NOT NULL CONSTRAINT DF_VITALS_RULE_MD DEFAULT SYSDATETIME()
    CONSTRAINT [PK_VITALS_RULE] PRIMARY KEY CLUSTERED ([VITALS_RULE_SID] ASC)
);
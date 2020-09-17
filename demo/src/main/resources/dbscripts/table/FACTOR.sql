CREATE TABLE FACTOR (
    FACTOR_SID BIGINT IDENTITY(1,1) NOT NULL,
	PROPERTY_NAME VARCHAR(32) NOT NULL,
    DISPLAY_NAME VARCHAR(32) NOT NULL,
    DESCRIPTION VARCHAR(256),
	FACTOR_TYPE VARCHAR(32) NOT NULL,
    CREATED_BY VARCHAR(256) NOT NULL,
    CREATED_DATE DATETIME2 NOT NULL CONSTRAINT DF_FACTOR_CD DEFAULT SYSDATETIME(),
    MODIFIED_BY VARCHAR(256) NOT NULL,
    MODIFIED_DATE DATETIME2 NOT NULL CONSTRAINT DF_FACTOR_MD DEFAULT SYSDATETIME()
    CONSTRAINT [PK_FACTOR] PRIMARY KEY CLUSTERED ([FACTOR_SID] ASC)
);
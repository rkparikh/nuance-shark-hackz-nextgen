CREATE TABLE PATIENT_FACTOR (
    PATIENT_FACTOR_SID BIGINT IDENTITY(1,1) NOT NULL,
    PATIENT_SID [bigint]  NOT NULL,
    FACTOR_SID [bigint]  NOT NULL,
    RECORD_VALUE VARCHAR(64) NOT NULL,
	RECORD_ENTRY_DATE DATETIME2 NOT NULL,    
    CONSTRAINT [PK_PATIENT_FACTOR] PRIMARY KEY CLUSTERED ([PATIENT_FACTOR_SID] ASC)
);
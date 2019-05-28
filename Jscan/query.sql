ALTER PROCEDURE CAD_EMPRESA
(
    @NMEMPRESA VARCHAR(255),
    @CDCNPJ VARCHAR(255),
    @NMFUNCIONARIO VARCHAR(255),
    @NMEMAILFUNCIONARIO VARCHAR(255),
    @NMSENHAFUNCIONARIO VARCHAR(255),
    @NRTELEFONEFUNCIONARIO VARCHAR(20)
) AS 
BEGIN
    IF EXISTS (SELECT * FROM TB_EMPRESA WHERE CDCNPJ = @CDCNPJ)
    BEGIN
        RAISERROR('Empresa já existe', 10, 1)
        PRINT 'EMPRESA JA EXISTE'
        END
    ELSE
        INSERT INTO TB_EMPRESA VALUES (@NMEMPRESA, @CDCNPJ)
        BEGIN
            IF EXISTS (SELECT * FROM TB_FUNCIONARIO WHERE NMEMAIL = @NMEMAILFUNCIONARIO)
                BEGIN
                PRINT 'EMAIL JA EXISTE'
                RAISERROR('Email já cadastrado', 10, 1)
                END
            ELSE
                INSERT INTO TB_FUNCIONARIO VALUES(@NMFUNCIONARIO, @NMEMAILFUNCIONARIO, @NMSENHAFUNCIONARIO, (SELECT IDEMPRESA FROM TB_EMPRESA WHERE CDCNPJ = @CDCNPJ), NULL, 1, @NRTELEFONEFUNCIONARIO)
        END
END

EXECUTE CAD_EMPRESA 'TESTE', 'TESTES', NULL, 'ADM', NULL, NULL

SELECT * FROM TB_EMPRESA

ALTER TABLE TB_FUNCIONARIO
ADD CONSTRAINT PKEMAIL
UNIQUE(NMEMAIL)

ALTER TABLE TB_FUNCIONARIO
ALTER COLUMN NMEMAIL VARCHAR(255) --IS NOT NULL
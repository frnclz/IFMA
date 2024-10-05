CREATE DATABASE LAB2;
USE LAB2;
CREATE TABLE PRODUTOS(PROD_COD INT PRIMARY KEY,
PROD_DESC VARCHAR(25) NOT NULL,
PROD_VALOR DECIMAL(11,2),
PROD_STATUS CHAR(1),
PROD_ESTOQUE_MINIMO INT,
PROD_QTD_ESTOQUE INT NOT NULL);

CREATE TABLE ORCAMENTO(
ORC_COD INT PRIMARY KEY,
ORC_DATE DATE,
ORC_STATUS TINYINT
);

CREATE TABLE ORCAMENTOS_PRODUTOS(
ORC_CODIGO INT PRIMARY KEY,
PROD_COD INT NOT NULL,
ORC_COD INT NOT NULL,
ORC_STATUS CHAR(1),
ORC_QTD INT NOT NULL,
ORC_VALOR DECIMAL(11,2) NOT NULL,
CONSTRAINT FK_ProdutosOrcamentos_Produtos FOREIGN KEY (PROD_COD) REFERENCES
 PRODUTOS(PROD_COD),
 CONSTRAINT FK_OrcamentoOrcamentos_Produtos FOREIGN KEY (ORC_COD) REFERENCES
 ORCAMENTO(ORC_COD)
);

CREATE TABLE PRODUTOS_EM_FALTA(
PROD_CODIGO INT,
DATAN DATE,
PROD_DESC VARCHAR(25) NOT NULL,
PROD_STATUS CHAR(1),
PROD_ESTOQUE_MINIMO INT,
QTD_ESTOQUE INT NOT NULL);

CREATE TABLE PRODUTOS_REQUISICAO(
PROD_CODIGO INT,
PROD_ESTOQUE INT,
PROD_ACOMPRAR INT);

/************************************************ PROCEDURES **********************************************************/

-- PROCEDURE 1
DELIMITER //
CREATE PROCEDURE BAIXA_ESTOQUE(IN COD_PROD INT, IN QTD_VENDIDA INT)
BEGIN
    DECLARE ESTOQUE_ATUAL INT;
    SELECT PROD_QTD_ESTOQUE INTO ESTOQUE_ATUAL FROM PRODUTOS WHERE PROD_COD = COD_PROD;
    
    IF ESTOQUE_ATUAL >= QTD_VENDIDA THEN
        UPDATE PRODUTOS SET PROD_QTD_ESTOQUE = ESTOQUE_ATUAL - QTD_VENDIDA WHERE PROD_COD = COD_PROD;
    ELSE
        INSERT INTO PRODUTOS_EM_FALTA (DATAN, PROD_CODIGO, QTD_ESTOQUE)
        VALUES (NOW(), COD_PROD, ESTOQUE_ATUAL);
    END IF;
END //
DELIMITER ; 

-- PROCEDURE 2
DELIMITER //
CREATE PROCEDURE COMPARAR_ESTOQUE(IN COD_PROD INT)
BEGIN
    DECLARE ESTOQUE_ATUAL INT;
    DECLARE ESTOQUE_MINIMO INT;
    
    SELECT PROD_QTD_ESTOQUE, PROD_ESTOQUE_MINIMO INTO ESTOQUE_ATUAL, ESTOQUE_MINIMO FROM PRODUTOS
    WHERE PROD_COD = COD_PROD;
    
    IF ESTOQUE_ATUAL < ESTOQUE_MINIMO THEN
        INSERT INTO PRODUTOS_REQUISICAO (PROD_CODIGO, PROD_ESTOQUE, PROD_ACOMPRAR)
        VALUES (COD_PROD, ESTOQUE_ATUAL, ESTOQUE_MINIMO - ESTOQUE_ATUAL);
    END IF;
END //
DELIMITER ;

-- PROCEDURE 3
DELIMITER //
CREATE PROCEDURE REAJUSTAR_PRECO(IN COD_PROD INT, IN TAXA DECIMAL(5,2))
BEGIN
    DECLARE PRECO_ATUAL DECIMAL(11,2);
    
    SELECT PROD_VALOR INTO PRECO_ATUAL FROM PRODUTOS WHERE PROD_COD = COD_PROD;
    
    IF TAXA >= 1 AND TAXA <= 50 THEN
        UPDATE PRODUTOS SET PROD_VALOR = PRECO_ATUAL * (1 + TAXA / 100) WHERE PROD_COD = COD_PROD;
    END IF;
END //
DELIMITER ;
/**********************************************************************************************************************/

CREATE TABLE PRODUTOS_ATUALIZADOS (
    PROD_CODIGO INT,
    PROD_QTD_ANTERIOR INT,
    PROD_QTD_ATUALIZADA INT,
    PROD_VALOR DECIMAL(11,2)
);

CREATE TABLE HISTORICO_PRODUTOS_EXCLUIDOS (
    PROD_CODIGO INT,
    PROD_QTD_ESTOQUE INT,
    PROD_PRECO_VENDA DECIMAL(11,2),
    USUARIO_EXCLUSAO VARCHAR(100),
    DATA_HORA_EXCLUSAO DATETIME
);

CREATE TABLE ORCAMENTO_PRODUTOS_CANCELADOS (
    ORC_CODIGO INT,
    PROD_COD INT,
    ORC_QTD INT,
    ORC_VALOR DECIMAL(11,2)
);

/************************************************ TRIGGERS ************************************************************/

-- TRIGGER 1
DELIMITER //
CREATE TRIGGER TRG_PRODUTOS_ATUALIZADOS 
BEFORE UPDATE ON PRODUTOS FOR EACH ROW 
BEGIN 
    IF NEW.PROD_QTD_ESTOQUE = 0 THEN 
        INSERT INTO PRODUTOS_EM_FALTA (DATAN, PROD_CODIGO, PROD_DESC, PROD_STATUS, PROD_ESTOQUE_MINIMO, QTD_ESTOQUE) 
        VALUES (CURRENT_DATE(), OLD.PROD_COD, OLD.PROD_DESC, OLD.PROD_STATUS, OLD.PROD_ESTOQUE_MINIMO, OLD.PROD_QTD_ESTOQUE); 
        SET NEW.PROD_STATUS = NULL; 
        UPDATE ORCAMENTOS_PRODUTOS SET ORC_STATUS = NULL WHERE PROD_COD = OLD.PROD_COD; 
    ELSE 
        INSERT INTO PRODUTOS_ATUALIZADOS (PROD_CODIGO, PROD_QTD_ANTERIOR, PROD_QTD_ATUALIZADA, PROD_VALOR) 
        VALUES (OLD.PROD_COD, OLD.PROD_QTD_ESTOQUE, NEW.PROD_QTD_ESTOQUE, NEW.PROD_VALOR); 
    END IF; 
END//

-- TRIGGER 2
CREATE TRIGGER PRODUTOS_EXCLUIDOS
AFTER DELETE ON PRODUTOS
FOR EACH ROW
BEGIN
    DECLARE PROD_QTD INT;
    SET PROD_QTD = OLD.PROD_QTD_ESTOQUE;
    IF PROD_QTD = 0 THEN
        INSERT INTO HISTORICO_PRODUTOS_EXCLUIDOS (PROD_CODIGO, PROD_QTD_ESTOQUE, PROD_PRECO_VENDA, USUARIO_EXCLUSAO,
        DATA_HORA_EXCLUSAO)
        VALUES (OLD.PROD_COD, PROD_QTD, OLD.PROD_VALOR, CURRENT_USER(), NOW());
    ELSE
        SIGNAL SQLSTATE '45001'
        SET MESSAGE_TEXT = 'Não é possível excluir produtos com estoque.';
    END IF;
END//

-- TRIGGER 3
DELIMITER \\
CREATE TRIGGER ORCAMENTO_CANCELADOS
AFTER UPDATE ON ORCAMENTO
FOR EACH ROW
BEGIN
    IF NEW.ORC_STATUS = 0 THEN
        INSERT INTO ORCAMENTO_PRODUTOS_CANCELADOS (ORC_CODIGO, PROD_COD, ORC_QTD, ORC_VALOR)
        SELECT ORC_CODIGO, PROD_COD, ORC_QTD, ORC_VALOR FROM ORCAMENTOS_PRODUTOS WHERE ORC_CODIGO = OLD.ORC_COD;
        
        DELETE FROM ORCAMENTOS_PRODUTOS WHERE ORC_CODIGO = OLD.ORC_COD;
    END IF;
END\\

/**********************************************************************************************************************/

DELIMITER ;
INSERT INTO PRODUTOS (PROD_COD, PROD_DESC, PROD_VALOR, PROD_STATUS, PROD_ESTOQUE_MINIMO, PROD_QTD_ESTOQUE) VALUES
(1, 'CADERNO 1 MATÉRIA', 10.50, 'A', 10, 20),
(2, 'GRAFITE', 4.50, 'A', 5, 15),
(3, 'BORRACHA C', 2.00, 'A', 8, 10);

INSERT INTO ORCAMENTO (ORC_COD, ORC_DATE, ORC_STATUS) VALUES
(1, '2024-03-17', 1),
(2, '2024-03-18', 1);

INSERT INTO ORCAMENTOS_PRODUTOS (ORC_CODIGO, PROD_COD, ORC_COD, ORC_STATUS, ORC_QTD, ORC_VALOR) VALUES
(1, 1, 1, '1', 2, 21.00),
(2, 2, 1, '1', 3, 47.25);

/*********************************************************************************************************************/
/*
CALL BAIXA_ESTOQUE(1, 5);
CALL COMPARAR_ESTOQUE(2);
CALL REAJUSTAR_PRECO(2, 0.5);
UPDATE PRODUTOS SET PROD_QTD_ESTOQUE = 0 WHERE PROD_COD = 1;
SELECT * FROM PRODUTOS;
SELECT * FROM PRODUTOS_ATUALIZADOS;
SELECT * FROM PRODUTOS_EM_FALTA;
*/

ALTER TABLE ORCAMENTOS_PRODUTOS
DROP FOREIGN KEY FK_ProdutosOrcamentos_Produtos;

ALTER TABLE ORCAMENTOS_PRODUTOS
ADD CONSTRAINT FK_ProdutosOrcamentos_Produtos
FOREIGN KEY (PROD_COD)
REFERENCES PRODUTOS(PROD_COD)
ON DELETE CASCADE;

/*
DELETE FROM PRODUTOS WHERE PROD_COD = 1;
SELECT * FROM Historico_Produtos_Excluidos;
UPDATE ORCAMENTO SET ORC_STATUS = 0 WHERE ORC_COD = 2;
SELECT * FROM orcamento_produtos_cancelados;
select * from orcamentos_produtos;
*/
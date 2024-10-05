-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lab2
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `historico_produtos_excluidos`
--

DROP TABLE IF EXISTS `historico_produtos_excluidos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historico_produtos_excluidos` (
  `PROD_CODIGO` int(11) DEFAULT NULL,
  `PROD_QTD_ESTOQUE` int(11) DEFAULT NULL,
  `PROD_PRECO_VENDA` decimal(11,2) DEFAULT NULL,
  `USUARIO_EXCLUSAO` varchar(100) DEFAULT NULL,
  `DATA_HORA_EXCLUSAO` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historico_produtos_excluidos`
--

LOCK TABLES `historico_produtos_excluidos` WRITE;
/*!40000 ALTER TABLE `historico_produtos_excluidos` DISABLE KEYS */;
INSERT INTO `historico_produtos_excluidos` VALUES (1,0,10.50,'root@localhost','2024-03-23 16:01:17'),(1,0,10.50,'root@localhost','2024-03-23 16:01:17');
/*!40000 ALTER TABLE `historico_produtos_excluidos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orcamento`
--

DROP TABLE IF EXISTS `orcamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orcamento` (
  `ORC_COD` int(11) NOT NULL,
  `ORC_DATE` date DEFAULT NULL,
  `ORC_STATUS` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`ORC_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento`
--

LOCK TABLES `orcamento` WRITE;
/*!40000 ALTER TABLE `orcamento` DISABLE KEYS */;
INSERT INTO `orcamento` VALUES (1,'2024-03-17',0),(2,'2024-03-18',0);
/*!40000 ALTER TABLE `orcamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orcamento_produtos_cancelados`
--

DROP TABLE IF EXISTS `orcamento_produtos_cancelados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orcamento_produtos_cancelados` (
  `ORC_CODIGO` int(11) DEFAULT NULL,
  `PROD_COD` int(11) DEFAULT NULL,
  `ORC_QTD` int(11) DEFAULT NULL,
  `ORC_VALOR` decimal(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamento_produtos_cancelados`
--

LOCK TABLES `orcamento_produtos_cancelados` WRITE;
/*!40000 ALTER TABLE `orcamento_produtos_cancelados` DISABLE KEYS */;
INSERT INTO `orcamento_produtos_cancelados` VALUES (2,2,3,47.25),(1,1,2,21.00),(2,2,3,47.25);
/*!40000 ALTER TABLE `orcamento_produtos_cancelados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orcamentos_produtos`
--

DROP TABLE IF EXISTS `orcamentos_produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `orcamentos_produtos` (
  `ORC_CODIGO` int(11) NOT NULL,
  `PROD_COD` int(11) NOT NULL,
  `ORC_COD` int(11) NOT NULL,
  `ORC_STATUS` char(1) DEFAULT NULL,
  `ORC_QTD` int(11) NOT NULL,
  `ORC_VALOR` decimal(11,2) NOT NULL,
  PRIMARY KEY (`ORC_CODIGO`),
  KEY `FK_OrcamentoOrcamentos_Produtos` (`ORC_COD`),
  KEY `FK_ProdutosOrcamentos_Produtos` (`PROD_COD`),
  CONSTRAINT `FK_OrcamentoOrcamentos_Produtos` FOREIGN KEY (`ORC_COD`) REFERENCES `orcamento` (`ORC_COD`),
  CONSTRAINT `FK_ProdutosOrcamentos_Produtos` FOREIGN KEY (`PROD_COD`) REFERENCES `produtos` (`PROD_COD`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orcamentos_produtos`
--

LOCK TABLES `orcamentos_produtos` WRITE;
/*!40000 ALTER TABLE `orcamentos_produtos` DISABLE KEYS */;
/*!40000 ALTER TABLE `orcamentos_produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos`
--

DROP TABLE IF EXISTS `produtos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos` (
  `PROD_COD` int(11) NOT NULL,
  `PROD_DESC` varchar(25) NOT NULL,
  `PROD_VALOR` decimal(11,2) DEFAULT NULL,
  `PROD_STATUS` char(1) DEFAULT NULL,
  `PROD_ESTOQUE_MINIMO` int(11) DEFAULT NULL,
  `PROD_QTD_ESTOQUE` int(11) NOT NULL,
  PRIMARY KEY (`PROD_COD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos`
--

LOCK TABLES `produtos` WRITE;
/*!40000 ALTER TABLE `produtos` DISABLE KEYS */;
INSERT INTO `produtos` VALUES (2,'GRAFITE',5.01,'A',5,15),(3,'BORRACHA C',2.00,'A',8,10);
/*!40000 ALTER TABLE `produtos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos_atualizados`
--

DROP TABLE IF EXISTS `produtos_atualizados`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos_atualizados` (
  `PROD_CODIGO` int(11) DEFAULT NULL,
  `PROD_QTD_ANTERIOR` int(11) DEFAULT NULL,
  `PROD_QTD_ATUALIZADA` int(11) DEFAULT NULL,
  `PROD_VALOR` decimal(11,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos_atualizados`
--

LOCK TABLES `produtos_atualizados` WRITE;
/*!40000 ALTER TABLE `produtos_atualizados` DISABLE KEYS */;
INSERT INTO `produtos_atualizados` VALUES (1,20,15,10.50),(2,15,15,4.55),(2,15,15,5.01),(1,15,12,10.50),(1,0,50,10.50),(1,0,10,10.50),(1,10,9,10.50);
/*!40000 ALTER TABLE `produtos_atualizados` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos_em_falta`
--

DROP TABLE IF EXISTS `produtos_em_falta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos_em_falta` (
  `PROD_CODIGO` int(11) DEFAULT NULL,
  `DATAN` date DEFAULT NULL,
  `PROD_DESC` varchar(25) NOT NULL,
  `PROD_STATUS` char(1) DEFAULT NULL,
  `PROD_ESTOQUE_MINIMO` int(11) DEFAULT NULL,
  `QTD_ESTOQUE` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos_em_falta`
--

LOCK TABLES `produtos_em_falta` WRITE;
/*!40000 ALTER TABLE `produtos_em_falta` DISABLE KEYS */;
INSERT INTO `produtos_em_falta` VALUES (1,'2024-03-17','CADERNO 1 MATÉRIA',NULL,10,50),(1,'2024-03-23','CADERNO 1 MATÉRIA',NULL,10,9);
/*!40000 ALTER TABLE `produtos_em_falta` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `produtos_requisicao`
--

DROP TABLE IF EXISTS `produtos_requisicao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `produtos_requisicao` (
  `PROD_CODIGO` int(11) DEFAULT NULL,
  `PROD_ESTOQUE` int(11) DEFAULT NULL,
  `PROD_ACOMPRAR` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `produtos_requisicao`
--

LOCK TABLES `produtos_requisicao` WRITE;
/*!40000 ALTER TABLE `produtos_requisicao` DISABLE KEYS */;
/*!40000 ALTER TABLE `produtos_requisicao` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-03-23 16:38:03

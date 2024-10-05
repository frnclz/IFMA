-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: lab6_imobiliaria
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
-- Table structure for table `alugueis`
--

DROP TABLE IF EXISTS `alugueis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alugueis` (
  `ID` int(11) NOT NULL,
  `ID_LOCACAO` int(11) DEFAULT NULL,
  `DATA_VENCIMENTO` date DEFAULT NULL,
  `VALOR_PAGO` decimal(10,2) DEFAULT NULL,
  `DATA_PAGAMENTO` date DEFAULT NULL,
  `OBS` text DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_LOCACAO` (`ID_LOCACAO`),
  CONSTRAINT `alugueis_ibfk_1` FOREIGN KEY (`ID_LOCACAO`) REFERENCES `locacao` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alugueis`
--

LOCK TABLES `alugueis` WRITE;
/*!40000 ALTER TABLE `alugueis` DISABLE KEYS */;
INSERT INTO `alugueis` VALUES (1,1,'2022-02-05',3500.00,'2022-02-05','Pagamento em dia'),(2,2,'2022-03-10',4500.00,'2022-03-10','Pagamento pontual'),(3,3,'2022-04-15',8000.00,'2022-04-15','Pagamento no prazo'),(4,4,'2022-05-05',1800.00,'2022-05-05','Pagamento em dia'),(5,5,'2022-06-07',1000.00,'2022-06-07','Pagamento efetuado com desconto'),(6,6,'2022-07-05',3500.00,'2022-07-05','Pagamento sem problemas'),(7,7,'2022-08-10',4000.00,'2022-08-10','Pagamento normal'),(8,8,'2022-09-20',7500.00,'2022-09-20','Pagamento pontual'),(9,9,'2022-10-25',10000.00,'2022-10-25','Pagamento de área comercial'),(10,10,'2022-11-05',3200.00,'2022-11-05','Pagamento em dia'),(11,11,'2022-12-10',4200.00,'2022-12-10','Pagamento para imóvel residencial'),(12,12,'2023-01-20',7000.00,'2023-01-20','Pagamento para locação empresarial'),(13,13,'2023-02-05',3000.00,'2023-02-05','Pagamento pontual'),(14,14,'2023-03-10',3700.00,'2023-03-10','Pagamento regular'),(15,15,'2023-04-15',9000.00,'2023-04-15','Pagamento para área comercial'),(16,16,'2023-05-25',12000.00,'2023-05-25','Pagamento de terreno comercial'),(17,17,'2023-06-05',3500.00,'2023-06-05','Pagamento de apartamento'),(18,18,'2023-07-10',4800.00,'2023-07-10','Pagamento com reajuste anual'),(19,19,'2023-08-15',7200.00,'2023-08-15','Pagamento comercial'),(20,20,'2023-09-25',11000.00,'2023-09-25','Pagamento para empresa'),(21,21,'2023-10-05',3700.00,'2023-10-05','Pagamento de imóvel residencial'),(22,22,'2023-11-10',4100.00,'2023-11-10','Pagamento regular com reajuste'),(23,23,'2023-12-20',7500.00,'2023-12-20','Pagamento anual para loja'),(24,24,'2024-01-25',9500.00,'2024-01-25','Pagamento de terreno comercial'),(25,25,'2024-02-05',4000.00,'2024-02-05','Pagamento em dia'),(26,26,'2024-03-10',4500.00,'2024-03-10','Pagamento para casa'),(27,27,'2024-04-15',8000.00,'2024-04-15','Pagamento de loja comercial'),(28,28,'2024-05-25',11500.00,'2024-05-25','Pagamento de terreno em área nobre'),(29,29,'2024-06-05',3300.00,'2024-06-05','Pagamento pontual para apartamento'),(30,30,'2024-07-10',4600.00,'2024-07-10','Pagamento regular com desconto');
/*!40000 ALTER TABLE `alugueis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `CPF` varchar(15) NOT NULL,
  `TELEFONE` varchar(12) DEFAULT NULL,
  `EMAIL` varchar(100) DEFAULT NULL,
  `DT_NASCIMENTO` date DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES (1,'Carlos Silva','123.456.789-00','11999990000','carlos@gmail.com','1985-04-23'),(2,'Maria Oliveira','987.654.321-00','11988881111','maria@gmail.com','1990-12-01'),(3,'João Souza','321.654.987-00','11977772222','joao@gmail.com','1978-07-15'),(4,'Ana Costa','456.789.123-00','11966663333','ana@gmail.com','1995-03-30'),(5,'Pedro Santos','654.321.789-00','11955554444','pedro@gmail.com','1980-10-10'),(6,'Rafaela Gomes','213.546.879-11','11912345678','rafaela@gmail.com','1987-08-19'),(7,'Lucas Ferreira','321.123.654-22','11987654321','lucas@gmail.com','1993-11-14'),(8,'Fernanda Almeida','432.654.987-33','11998761234','fernanda@gmail.com','1992-02-20'),(9,'Paulo Lima','543.987.123-44','11965432198','paulo@gmail.com','1984-06-09'),(10,'Gabriel Monteiro','654.123.789-55','11954321098','gabriel@gmail.com','1991-01-15'),(11,'Bruna Rocha','765.432.198-66','11976543210','bruna@gmail.com','1986-03-27'),(12,'Júlio Mendes','876.543.210-77','11965431234','julio@gmail.com','1982-12-05'),(13,'Carla Mendes','987.654.321-88','11987651234','carla@gmail.com','1994-05-25'),(14,'Vitor Vasconcelos','109.876.543-99','11965435678','vitor@gmail.com','1981-04-12'),(15,'Mariana Silva','210.987.654-00','11954329876','mariana@gmail.com','1983-09-19'),(16,'Ricardo Nunes','321.210.987-11','11987650987','ricardo@gmail.com','1979-07-21'),(17,'Amanda Faria','432.321.109-22','11998760987','amanda@gmail.com','1989-02-03'),(18,'Otávio Ramos','543.432.321-33','11976543987','otavio@gmail.com','1997-10-17'),(19,'Isabella Lopes','654.543.432-44','11987650999','isabella@gmail.com','1996-01-23'),(20,'Caio Pereira','765.654.543-55','11965431209','caio@gmail.com','1995-07-31'),(21,'Tatiane Marques','876.765.654-66','11954327654','tatiane@gmail.com','1987-09-08'),(22,'Davi Cavalcanti','987.876.765-77','11998768765','davi@gmail.com','1990-05-16'),(23,'Lucas Fernandes','109.987.876-88','11965439876','lucasf@gmail.com','1985-08-11'),(24,'Thiago Barros','210.109.987-99','11976543298','thiago@gmail.com','1998-11-29'),(25,'Sabrina Souza','321.210.109-00','11998762345','sabrina@gmail.com','1988-06-10'),(26,'Leandro Moreira','432.321.210-11','11965435670','leandro@gmail.com','1991-03-19'),(27,'Caroline Braga','543.432.321-22','11954323456','caroline@gmail.com','1994-08-06'),(28,'Rodrigo Ramos','654.543.432-33','11998761234','rodrigo@gmail.com','1997-12-03'),(29,'Beatriz Cardoso','765.654.543-44','11987652345','beatriz@gmail.com','1980-02-27'),(30,'Felipe Martins','876.765.654-55','11954326543','felipe@gmail.com','1975-09-14');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `imoveis`
--

DROP TABLE IF EXISTS `imoveis`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `imoveis` (
  `ID` int(11) NOT NULL,
  `ID_PROPRIETARIO` int(11) DEFAULT NULL,
  `ID_TIPO_IMOVEL` int(11) DEFAULT NULL,
  `LOGRADOURO` varchar(200) DEFAULT NULL,
  `BAIRRO` varchar(45) DEFAULT NULL,
  `CEP` varchar(10) DEFAULT NULL,
  `METRAGEM` int(11) DEFAULT NULL,
  `DORMITORIOS` tinyint(4) DEFAULT NULL,
  `BANHEIROS` tinyint(4) DEFAULT NULL,
  `SUITES` tinyint(4) DEFAULT NULL,
  `VAGAS_GARAGEM` tinyint(4) DEFAULT NULL,
  `VALOR_ALUGUEL_SUGERIDO` decimal(10,2) DEFAULT NULL,
  `OBS` text DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PROPRIETARIO` (`ID_PROPRIETARIO`),
  KEY `ID_TIPO_IMOVEL` (`ID_TIPO_IMOVEL`),
  CONSTRAINT `imoveis_ibfk_1` FOREIGN KEY (`ID_PROPRIETARIO`) REFERENCES `clientes` (`ID`),
  CONSTRAINT `imoveis_ibfk_2` FOREIGN KEY (`ID_TIPO_IMOVEL`) REFERENCES `tipo_imovel` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `imoveis`
--

LOCK TABLES `imoveis` WRITE;
/*!40000 ALTER TABLE `imoveis` DISABLE KEYS */;
INSERT INTO `imoveis` VALUES (1,1,1,'Av. Paulista, 1000','Bela Vista','01310-100',85,2,2,1,1,3500.00,'Apartamento com vista para a avenida.'),(2,2,2,'Rua das Flores, 200','Jardins','01402-001',120,3,3,2,2,4500.00,'Casa com piscina e jardim.'),(3,3,3,'Rua do Comércio, 50','Centro','01010-010',300,0,4,0,4,8000.00,'Imóvel comercial amplo.'),(4,4,1,'Rua dos Operários, 500','Mooca','03101-040',60,1,1,0,1,1800.00,'Apartamento compacto e moderno.'),(5,5,4,'Av. das Nações, 500','Centro','01020-020',1000,0,0,0,0,1000.00,'Terreno disponível para construção.'),(6,6,1,'Rua Amarela, 300','Pinheiros','05407-001',75,2,2,1,1,3500.00,'Apartamento próximo ao metrô.'),(7,7,2,'Av. Independência, 400','Aclimação','01524-000',110,3,2,1,2,4000.00,'Casa com quintal grande.'),(8,8,3,'Rua Augusta, 150','Consolação','01305-001',250,0,2,0,0,7500.00,'Loja no centro da cidade.'),(9,9,4,'Av. Brasil, 800','Jardim América','01431-001',500,0,0,0,0,10000.00,'Terreno para venda.'),(10,10,1,'Rua da Harmonia, 600','Vila Madalena','05435-000',80,2,1,1,1,3200.00,'Apartamento em área boêmia.'),(11,11,2,'Rua Verde, 700','Jabaquara','04321-000',130,4,3,2,2,4200.00,'Casa com área de lazer.'),(12,12,3,'Rua do Comércio, 90','Centro','01020-010',270,0,3,0,0,7000.00,'Espaço comercial moderno.'),(13,13,1,'Rua dos Pinheiros, 450','Pinheiros','05422-000',65,1,1,0,1,3000.00,'Apartamento em área tranquila.'),(14,14,2,'Rua Azul, 910','Saúde','04330-001',120,3,2,1,2,3700.00,'Casa moderna com jardim.'),(15,15,3,'Av. Central, 100','Centro','01050-001',350,0,4,0,5,9000.00,'Centro comercial novo.'),(16,16,4,'Rua dos Lírios, 200','Campo Belo','04601-010',800,0,0,0,0,12000.00,'Terreno em área nobre.'),(17,17,1,'Av. Paulista, 1100','Bela Vista','01310-110',85,2,2,1,1,3500.00,'Apartamento no coração de São Paulo.'),(18,18,2,'Rua da Paz, 130','Chácara Santo Antônio','04710-001',150,4,3,2,2,4800.00,'Casa em condomínio fechado.'),(19,19,3,'Rua do Comércio, 80','Centro','01011-010',280,0,3,0,0,7200.00,'Loja comercial reformada.'),(20,20,4,'Av. Norte, 100','Santana','02012-000',950,0,0,0,0,11000.00,'Terreno para construção comercial.'),(21,21,1,'Rua Paulista, 1200','Bela Vista','01310-120',85,2,2,1,1,3700.00,'Apartamento de alto padrão.'),(22,22,2,'Rua Verde, 240','Saúde','04321-240',140,3,3,1,2,4100.00,'Casa familiar com jardim.'),(23,23,3,'Av. Das Nações, 150','Centro','01023-010',290,0,3,0,0,7500.00,'Loja no centro movimentado.'),(24,24,4,'Av. Sul, 300','Ipiranga','04203-000',1000,0,0,0,0,9500.00,'Terreno ideal para investimento.'),(25,25,1,'Rua Laranja, 600','Moema','04567-001',100,2,2,1,1,4000.00,'Apartamento novo com área de lazer.'),(26,26,2,'Rua Violeta, 900','Santana','02034-000',130,3,3,2,2,4500.00,'Casa em bairro residencial.'),(27,27,3,'Rua do Comércio, 120','Centro','01013-010',320,0,3,0,0,8000.00,'Loja reformada com estacionamento.'),(28,28,4,'Rua Azul, 500','Jardim Paulista','01410-010',850,0,0,0,0,11500.00,'Terreno em região nobre.'),(29,29,1,'Rua da Consolação, 300','Consolação','01301-000',75,2,1,1,1,3300.00,'Apartamento com vista panorâmica.'),(30,30,2,'Rua Vermelha, 700','Perdizes','05010-001',150,4,3,2,2,4600.00,'Casa espaçosa com quintal.');
/*!40000 ALTER TABLE `imoveis` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locacao`
--

DROP TABLE IF EXISTS `locacao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locacao` (
  `ID` int(11) NOT NULL,
  `ID_IMOVEL` int(11) DEFAULT NULL,
  `ID_INQUILINO` int(11) DEFAULT NULL,
  `VALOR_ALUGUEL` decimal(10,4) DEFAULT NULL,
  `PERCENTUAL_MULTA` decimal(5,2) DEFAULT NULL,
  `DIA_VENCIMENTO` tinyint(4) DEFAULT NULL,
  `DATA_INICIO` date DEFAULT NULL,
  `DATA_FIM` date DEFAULT NULL,
  `ATIVO` tinyint(1) DEFAULT NULL,
  `OBS` text DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_IMOVEL` (`ID_IMOVEL`),
  KEY `ID_INQUILINO` (`ID_INQUILINO`),
  CONSTRAINT `locacao_ibfk_1` FOREIGN KEY (`ID_IMOVEL`) REFERENCES `imoveis` (`ID`),
  CONSTRAINT `locacao_ibfk_2` FOREIGN KEY (`ID_INQUILINO`) REFERENCES `clientes` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locacao`
--

LOCK TABLES `locacao` WRITE;
/*!40000 ALTER TABLE `locacao` DISABLE KEYS */;
INSERT INTO `locacao` VALUES (1,1,1,3500.0000,2.50,5,'2022-01-01','2023-01-01',1,'Contrato renovável'),(2,2,2,4500.0000,2.00,10,'2022-02-01','2023-02-01',1,'Inquilino excelente'),(3,3,3,8000.0000,3.00,15,'2022-03-01','2023-03-01',1,'Contrato longo'),(4,4,4,1800.0000,2.00,5,'2022-04-01','2023-04-01',1,'Desconto pontualidade'),(5,5,5,1000.0000,1.50,7,'2022-05-01','2023-05-01',1,'Contrato para curto prazo'),(6,6,6,3500.0000,2.50,5,'2022-06-01','2023-06-01',1,'Inquilino antigo'),(7,7,7,4000.0000,2.00,10,'2022-07-01','2023-07-01',1,'Pagamentos pontuais'),(8,8,8,7500.0000,3.50,20,'2022-08-01','2023-08-01',1,'Contrato flexível'),(9,9,9,10000.0000,4.00,25,'2022-09-01','2023-09-01',1,'Área comercial'),(10,10,10,3200.0000,2.00,5,'2022-10-01','2023-10-01',1,'Contrato para renovação'),(11,11,11,4200.0000,2.50,10,'2022-11-01','2023-11-01',1,'Contrato familiar'),(12,12,12,7000.0000,3.00,20,'2022-12-01','2023-12-01',1,'Contrato para empresa'),(13,13,13,3000.0000,2.00,5,'2023-01-01','2024-01-01',1,'Inquilino jovem'),(14,14,14,3700.0000,2.50,10,'2023-02-01','2024-02-01',1,'Contrato com desconto'),(15,15,15,9000.0000,3.50,15,'2023-03-01','2024-03-01',1,'Locação comercial'),(16,16,16,12000.0000,4.00,25,'2023-04-01','2024-04-01',1,'Contrato comercial longo'),(17,17,17,3500.0000,2.00,5,'2023-05-01','2024-05-01',1,'Contrato padrão'),(18,18,18,4800.0000,2.50,10,'2023-06-01','2024-06-01',1,'Contrato com reajuste'),(19,19,19,7200.0000,3.00,15,'2023-07-01','2024-07-01',1,'Contrato flexível'),(20,20,20,11000.0000,3.50,25,'2023-08-01','2024-08-01',1,'Contrato comercial'),(21,21,21,3700.0000,2.50,5,'2023-09-01','2024-09-01',1,'Apartamento renovado'),(22,22,22,4100.0000,2.00,10,'2023-10-01','2024-10-01',1,'Contrato com reajuste anual'),(23,23,23,7500.0000,3.00,20,'2023-11-01','2024-11-01',1,'Contrato com valor fixo'),(24,24,24,9500.0000,3.50,25,'2023-12-01','2024-12-01',1,'Contrato flexível para investimento'),(25,25,25,4000.0000,2.00,5,'2024-01-01','2025-01-01',1,'Contrato com desconto especial'),(26,26,26,4500.0000,2.50,10,'2024-02-01','2025-02-01',1,'Casa de família'),(27,27,27,8000.0000,3.50,15,'2024-03-01','2025-03-01',1,'Imóvel comercial em expansão'),(28,28,28,11500.0000,4.00,25,'2024-04-01','2025-04-01',1,'Terreno para construção futura'),(29,29,29,3300.0000,2.00,5,'2024-05-01','2025-05-01',1,'Apartamento com boas acomodações'),(30,30,30,4600.0000,2.50,10,'2024-06-01','2025-06-01',1,'Contrato longo prazo');
/*!40000 ALTER TABLE `locacao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `profissionais`
--

DROP TABLE IF EXISTS `profissionais`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `profissionais` (
  `ID` int(11) NOT NULL,
  `NOME` varchar(45) NOT NULL,
  `PROFISSAO` varchar(45) DEFAULT NULL,
  `TELEFONE1` varchar(12) DEFAULT NULL,
  `TELEFONE2` varchar(12) DEFAULT NULL,
  `VALOR_HORA` decimal(10,2) DEFAULT NULL,
  `OBS` text DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `profissionais`
--

LOCK TABLES `profissionais` WRITE;
/*!40000 ALTER TABLE `profissionais` DISABLE KEYS */;
INSERT INTO `profissionais` VALUES (1,'João Silva','Eletricista','11987654321','11987654322',80.00,'Disponível 24h'),(2,'Maria Souza','Encanador','11987654323','11987654324',90.00,'Especialista em vazamentos'),(3,'Carlos Oliveira','Pintor','11987654325','11987654326',75.00,'Trabalhos rápidos'),(4,'Ana Costa','Marceneiro','11987654327','11987654328',100.00,'Faz móveis sob medida'),(5,'Pedro Lima','Pedreiro','11987654329','11987654330',85.00,'Reformas gerais'),(6,'Juliana Santos','Arquiteto','11987654331','11987654332',150.00,'Projetos arquitetônicos'),(7,'Bruno Almeida','Engenheiro','11987654333','11987654334',200.00,'Engenharia estrutural'),(8,'Fernanda Ribeiro','Paisagista','11987654335','11987654336',110.00,'Jardins e áreas externas'),(9,'Ricardo Lima','Eletricista','11987654337','11987654338',85.00,'Especialista em instalações'),(10,'Patrícia Carvalho','Design de Interiores','11987654339','11987654340',130.00,'Design residencial e comercial'),(11,'Cláudio Teixeira','Pintor','11987654341','11987654342',70.00,'Trabalhos rápidos e de qualidade'),(12,'Gabriela Ferreira','Marceneiro','11987654343','11987654344',95.00,'Móveis sob medida'),(13,'Rodrigo Mota','Pedreiro','11987654345','11987654346',90.00,'Construção e reforma'),(14,'André Santos','Engenheiro','11987654347','11987654348',210.00,'Engenharia civil'),(15,'Letícia Souza','Arquiteto','11987654349','11987654350',160.00,'Projetos residenciais'),(16,'Renato Gomes','Eletricista','11987654351','11987654352',90.00,'Manutenção elétrica'),(17,'Viviane Martins','Encanador','11987654353','11987654354',95.00,'Consertos rápidos'),(18,'Marcos Silva','Pintor','11987654355','11987654356',85.00,'Pintura de grandes áreas'),(19,'Isabela Nunes','Marceneiro','11987654357','11987654358',105.00,'Móveis planejados'),(20,'Lucas Fernandes','Pedreiro','11987654359','11987654360',95.00,'Reformas e reparos'),(21,'Simone Azevedo','Paisagista','11987654361','11987654362',115.00,'Projetos de jardinagem'),(22,'Paulo Vieira','Eletricista','11987654363','11987654364',88.00,'Instalações e reparos'),(23,'Tânia Moraes','Arquiteto','11987654365','11987654366',155.00,'Projetos de interiores'),(24,'Gustavo Souza','Engenheiro','11987654367','11987654368',220.00,'Projetos estruturais'),(25,'Beatriz Lima','Design de Interiores','11987654369','11987654370',140.00,'Design moderno'),(26,'Vitor Carvalho','Eletricista','11987654371','11987654372',92.00,'Manutenção predial'),(27,'Eduardo Ramos','Pintor','11987654373','11987654374',80.00,'Pintura residencial'),(28,'Camila Batista','Arquiteto','11987654375','11987654376',165.00,'Projetos inovadores'),(29,'Fábio Duarte','Engenheiro','11987654377','11987654378',230.00,'Consultoria em construção'),(30,'Daniela Costa','Marceneiro','11987654379','11987654380',110.00,'Projetos especiais.');
/*!40000 ALTER TABLE `profissionais` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicos_imovel`
--

DROP TABLE IF EXISTS `servicos_imovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicos_imovel` (
  `ID` int(11) NOT NULL,
  `ID_PROFISSIONAL` int(11) DEFAULT NULL,
  `ID_IMOVEL` int(11) DEFAULT NULL,
  `DATA_SERVICO` date DEFAULT NULL,
  `VALOR_TOTAL` decimal(10,2) DEFAULT NULL,
  `OBS` text DEFAULT NULL,
  PRIMARY KEY (`ID`),
  KEY `ID_PROFISSIONAL` (`ID_PROFISSIONAL`),
  KEY `ID_IMOVEL` (`ID_IMOVEL`),
  CONSTRAINT `servicos_imovel_ibfk_1` FOREIGN KEY (`ID_PROFISSIONAL`) REFERENCES `profissionais` (`ID`),
  CONSTRAINT `servicos_imovel_ibfk_2` FOREIGN KEY (`ID_IMOVEL`) REFERENCES `imoveis` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicos_imovel`
--

LOCK TABLES `servicos_imovel` WRITE;
/*!40000 ALTER TABLE `servicos_imovel` DISABLE KEYS */;
INSERT INTO `servicos_imovel` VALUES (1,1,1,'2022-01-15',300.00,'Instalação de luminárias'),(2,2,2,'2022-02-20',250.00,'Reparo em encanamento'),(3,3,3,'2022-03-05',1200.00,'Pintura de paredes'),(4,4,4,'2022-04-10',450.00,'Reparo de portas'),(5,5,5,'2022-05-12',1800.00,'Construção de muro'),(6,6,6,'2022-06-18',5000.00,'Projeto arquitetônico completo'),(7,7,7,'2022-07-25',3500.00,'Avaliação estrutural'),(8,8,8,'2022-08-03',900.00,'Manutenção de jardim externo'),(9,9,9,'2022-09-07',600.00,'Revisão elétrica'),(10,10,10,'2022-10-14',2200.00,'Redesign de sala de estar'),(11,11,11,'2022-11-01',600.00,'Pintura do teto'),(12,12,12,'2022-12-20',3200.00,'Móveis sob medida para cozinha'),(13,13,13,'2023-01-05',1200.00,'Reparo em piso'),(14,14,14,'2023-02-17',4000.00,'Consultoria para reforma estrutural'),(15,15,15,'2023-03-10',4500.00,'Projeto para reforma de interiores'),(16,16,16,'2023-04-22',800.00,'Instalação de ar-condicionado'),(17,17,17,'2023-05-18',350.00,'Troca de torneiras'),(18,18,18,'2023-06-15',1500.00,'Pintura de fachada'),(19,19,19,'2023-07-30',500.00,'Reparo em armários de cozinha'),(20,20,20,'2023-08-12',7000.00,'Construção de garagem'),(21,21,21,'2023-09-07',2500.00,'Paisagismo em quintal'),(22,22,22,'2023-10-14',450.00,'Instalação de ventiladores de teto'),(23,23,23,'2023-11-10',3800.00,'Projeto para varanda gourmet'),(24,24,24,'2023-12-05',5500.00,'Avaliação da fundação do prédio'),(25,25,25,'2024-01-11',1600.00,'Reforma completa de interiores'),(26,26,26,'2024-02-05',300.00,'Troca e instalação de interruptores'),(27,27,27,'2024-03-20',1300.00,'Pintura do escritório corporativo'),(28,28,28,'2024-04-25',15000.00,'Construção de piscina residencial'),(29,29,29,'2024-05-12',1800.00,'Estante personalizada para sala'),(30,30,30,'2024-06-10',400.00,'Desentupimento de esgoto');
/*!40000 ALTER TABLE `servicos_imovel` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_imovel`
--

DROP TABLE IF EXISTS `tipo_imovel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo_imovel` (
  `ID` int(11) NOT NULL,
  `DESCRICAO` varchar(256) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_imovel`
--

LOCK TABLES `tipo_imovel` WRITE;
/*!40000 ALTER TABLE `tipo_imovel` DISABLE KEYS */;
INSERT INTO `tipo_imovel` VALUES (1,'Apartamento'),(2,'Casa'),(3,'Comercial'),(4,'Terreno'),(5,'Galpão'),(6,'Flat'),(7,'Cobertura'),(8,'Loft'),(9,'Sala Comercial'),(10,'Kitnet'),(11,'Duplex'),(12,'Triplex'),(13,'Chácara'),(14,'Sítio'),(15,'Fazenda'),(16,'Pousada'),(17,'Hostel'),(18,'Hotel'),(19,'Residência Unifamiliar'),(20,'Residência Multifamiliar'),(21,'Mansão'),(22,'Pavilhão'),(23,'Centro Comercial'),(24,'Shopping Center'),(25,'Estúdio'),(26,'Escritório'),(27,'Consultório Médico'),(28,'Área Rural'),(29,'Praça de Alimentação'),(30,'Parque Industrial');
/*!40000 ALTER TABLE `tipo_imovel` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-08 16:42:54

-- MySQL dump 10.13  Distrib 8.0.29, for Win64 (x86_64)
--
-- Host: localhost    Database: riyoma
-- ------------------------------------------------------
-- Server version	8.0.29

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
-- Table structure for table `attendance`
--

DROP TABLE IF EXISTS `attendance`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attendance` (
  `empID` varchar(45) NOT NULL,
  `date` date DEFAULT NULL,
  `month` int DEFAULT NULL,
  `checkin` varbinary(45) DEFAULT NULL,
  `checkout` varchar(45) DEFAULT NULL,
  `otHours` int DEFAULT NULL,
  PRIMARY KEY (`empID`),
  CONSTRAINT `att__f` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attendance`
--

LOCK TABLES `attendance` WRITE;
/*!40000 ALTER TABLE `attendance` DISABLE KEYS */;
INSERT INTO `attendance` VALUES ('e001','2022-07-30',7,NULL,'2',2),('e002','2022-08-14',8,NULL,NULL,3);
/*!40000 ALTER TABLE `attendance` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cheque_payment`
--

DROP TABLE IF EXISTS `cheque_payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cheque_payment` (
  `payID` int NOT NULL,
  `chequeNo` int NOT NULL,
  `bank` varchar(45) DEFAULT NULL,
  `chequeAmount` decimal(10,2) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payID`,`chequeNo`),
  CONSTRAINT `cpay_fk` FOREIGN KEY (`payID`) REFERENCES `payment` (`payID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cheque_payment`
--

LOCK TABLES `cheque_payment` WRITE;
/*!40000 ALTER TABLE `cheque_payment` DISABLE KEYS */;
INSERT INTO `cheque_payment` VALUES (1,1,'BOC',30000.00,'full payment');
/*!40000 ALTER TABLE `cheque_payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `client_order`
--

DROP TABLE IF EXISTS `client_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `client_order` (
  `orderID` int NOT NULL AUTO_INCREMENT,
  `orderAmount` decimal(30,2) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  `supName` varchar(45) DEFAULT NULL,
  `supPhone` int DEFAULT NULL,
  `orderCost` decimal(30,2) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `co_fk_idx` (`supName`,`supPhone`),
  CONSTRAINT `co_fk` FOREIGN KEY (`supName`, `supPhone`) REFERENCES `supplier` (`name`, `phone`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client_order`
--

LOCK TABLES `client_order` WRITE;
/*!40000 ALTER TABLE `client_order` DISABLE KEYS */;
INSERT INTO `client_order` VALUES (1,450000.00,'2022-06-10','Lucy Liyan',42949672,850060.00),(5,327000.00,'2022-06-10','Tomoko Naraoka',581365836,327000.00),(6,3520000.00,'2022-11-22','Tomoko Naraoka',581365836,NULL),(7,327000.00,'2022-06-10','Takeshi Nasai',591365836,329090.00);
/*!40000 ALTER TABLE `client_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer`
--

DROP TABLE IF EXISTS `customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer` (
  `cusOrderID` int NOT NULL,
  `cusName` varchar(45) NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cusOrderID`,`cusName`),
  CONSTRAINT `cus_fk` FOREIGN KEY (`cusOrderID`) REFERENCES `customer_order` (`cusOrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer`
--

LOCK TABLES `customer` WRITE;
/*!40000 ALTER TABLE `customer` DISABLE KEYS */;
INSERT INTO `customer` VALUES (1,'Kamali Perera','Tokyo bayedit',778794426,'kushaniperera@gmail.com','Battaramulla'),(2,'Widushani Perera','China Deliveries',722345678,'widutest@gmail.com','Anuradhapura'),(3,'Lucky Oshi','China express',778523698,'oshitest@gmail.com','Panaduraedit'),(100,'Ama Gunathilaka','Ama Sallers',783546372,'Ama@gmail.com','Colombo'),(800,'Roshan Gunathilaka','Roshan Sallers',773546372,'roshan@gmail.com','Kottawa, Colombo'),(1000,'Eranga Manawadu','Manawadu Sellers',772366372,'manawadutest@gmail.com','Nugegoda, Colombo'),(1380246,'Mahim Gunathilaka','Mahim Sallers',773546372,'mahim@gmail.com','Kottawa, Colombo');
/*!40000 ALTER TABLE `customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_order`
--

DROP TABLE IF EXISTS `customer_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `customer_order` (
  `cusOrderID` int NOT NULL,
  `orderAmount` decimal(10,2) DEFAULT NULL,
  `orderDate` date DEFAULT NULL,
  PRIMARY KEY (`cusOrderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_order`
--

LOCK TABLES `customer_order` WRITE;
/*!40000 ALTER TABLE `customer_order` DISABLE KEYS */;
INSERT INTO `customer_order` VALUES (1,59000.00,'2022-06-05'),(2,85000.00,'2022-06-10'),(3,NULL,NULL),(100,NULL,NULL),(101,NULL,NULL),(500,NULL,NULL),(800,NULL,NULL),(1000,NULL,NULL),(1380246,NULL,NULL);
/*!40000 ALTER TABLE `customer_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `damaged_item`
--

DROP TABLE IF EXISTS `damaged_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `damaged_item` (
  `orderID` int NOT NULL,
  `machine` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  `loss` decimal(10,2) DEFAULT NULL,
  `supName` varchar(45) DEFAULT NULL,
  `supPhone` int DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `di_fk_idx` (`orderID`,`machine`),
  KEY `di_fk1_idx` (`supName`,`supPhone`),
  CONSTRAINT `di_fk` FOREIGN KEY (`orderID`, `machine`) REFERENCES `ordered_machine` (`orderID`, `machine`),
  CONSTRAINT `di_fk1` FOREIGN KEY (`supName`, `supPhone`) REFERENCES `supplier` (`name`, `phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `damaged_item`
--

LOCK TABLES `damaged_item` WRITE;
/*!40000 ALTER TABLE `damaged_item` DISABLE KEYS */;
/*!40000 ALTER TABLE `damaged_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `delivery_agent`
--

DROP TABLE IF EXISTS `delivery_agent`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `delivery_agent` (
  `agentId` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `company` varchar(45) DEFAULT NULL,
  `phone` int DEFAULT NULL,
  `location` varchar(45) DEFAULT NULL,
  `chargingRate` decimal(8,2) DEFAULT NULL,
  `rating` int DEFAULT NULL,
  PRIMARY KEY (`agentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `delivery_agent`
--

LOCK TABLES `delivery_agent` WRITE;
/*!40000 ALTER TABLE `delivery_agent` DISABLE KEYS */;
INSERT INTO `delivery_agent` VALUES (900,'Sameera','Aramex',785214700,'Colombo',200.00,2),(1000,'bandu','banedit',779856321,'Malabe',200.00,1),(2000,'ABC','Aramex',793214700,'Malabe',200.00,1);
/*!40000 ALTER TABLE `delivery_agent` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `empID` varchar(45) NOT NULL,
  `empName` varchar(45) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `nic` varchar(45) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`empID`),
  KEY `emp_fk_idx` (`designation`),
  CONSTRAINT `emp_fk` FOREIGN KEY (`designation`) REFERENCES `salary_info` (`designation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('e001','Percy Perera','0778523698',' Battaramulla ','percy@gmail.com','CEO','698521478v','Dev@1234'),('e002','Oshani Lakchani','0779900294','Mahabellana','oshanilakchani@gmail.com','Finance Manager','916622961v','11a31da4'),('e003','Piumi Wathsala','0789632580','Panaduraedit','piumiwathsala@gmail.com','Receptionist','945623698v','3441ad11'),('e005','Manesha Perera','0789632587','Malabe','maneshaperera@gmail.com','CEO','921145698v','4d31bc2a'),('e006','Maheshie Jayawardene ','778563258','Kandy','maheshie jayawaradana@gmail.com','Receptionist','932587456v','41a122d3'),('e011','Vahid Ghelijkhani','0774478557','Colombo 09','vahidtest@gmail.com','Finance Manager','946542273v','a4db22c4'),('e012','Philip Uren','0754678667','Kandy','philiptest@gmail.com','Receptionist','927745673v','aadc22cb'),('e013','Vahidgh Ghelijkhani','774478559','Colombo 09','vahidtestty@gmail.com','Finance Manager','946542283v','24cc4232'),('e014','Julian Lan','778569456','Malabe 1234','oshilakchani@gmail.com','Finance Manager','925874569v','2434bc41');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee_leaves`
--

DROP TABLE IF EXISTS `employee_leaves`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee_leaves` (
  `empID` varchar(45) NOT NULL,
  `date` date DEFAULT NULL,
  `month` int DEFAULT NULL,
  PRIMARY KEY (`empID`),
  CONSTRAINT `elv__fk` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee_leaves`
--

LOCK TABLES `employee_leaves` WRITE;
/*!40000 ALTER TABLE `employee_leaves` DISABLE KEYS */;
INSERT INTO `employee_leaves` VALUES ('e001','2022-07-27',NULL),('e002','2022-08-01',NULL),('e003','2022-07-21',NULL),('e006','2022-08-01',NULL),('e011','2022-11-24',NULL);
/*!40000 ALTER TABLE `employee_leaves` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item` (
  `modelID` varchar(45) NOT NULL,
  `machineID` varchar(45) NOT NULL,
  `cusOrderID` int DEFAULT NULL,
  PRIMARY KEY (`modelID`,`machineID`),
  CONSTRAINT `itm_fk` FOREIGN KEY (`modelID`) REFERENCES `stock` (`modelID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES ('MODEL0112','2',2);
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item_supplier`
--

DROP TABLE IF EXISTS `item_supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `item_supplier` (
  `name` varchar(45) NOT NULL,
  `phone` int NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`name`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item_supplier`
--

LOCK TABLES `item_supplier` WRITE;
/*!40000 ALTER TABLE `item_supplier` DISABLE KEYS */;
INSERT INTO `item_supplier` VALUES ('Nirmal Perera',779900294,'ASB','asb@gmail.com','Panadura');
/*!40000 ALTER TABLE `item_supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `loans`
--

DROP TABLE IF EXISTS `loans`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `loans` (
  `loanID` int NOT NULL AUTO_INCREMENT,
  `empID` varchar(45) DEFAULT NULL,
  `loanAmount` decimal(10,2) DEFAULT NULL,
  `datePaid` date DEFAULT NULL,
  `dueDate` date DEFAULT NULL,
  `leftToPay` decimal(10,2) DEFAULT NULL,
  `datePaidBack` date DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`loanID`),
  KEY `lon_fk_idx` (`empID`),
  CONSTRAINT `lon_fk` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `loans`
--

LOCK TABLES `loans` WRITE;
/*!40000 ALTER TABLE `loans` DISABLE KEYS */;
INSERT INTO `loans` VALUES (1,'e001',3000.00,'2022-01-01','2023-07-28',0.00,'2022-07-28','Received'),(2,'e002',100000.00,'2022-07-28','2023-07-28',0.00,'2022-07-28','Received'),(3,'e003',20000.00,'2022-07-28','2023-07-28',0.00,'2022-07-28','Received'),(5,'e002',10000.00,'2022-07-29','2023-07-29',0.00,'2022-07-29','Received'),(7,'e012',10000.00,'2022-07-30','2023-07-30',0.00,'2022-07-30','Received'),(8,'e003',200.00,'2022-11-25','2023-11-25',200.00,NULL,'Paid'),(9,'e011',2300.00,'2022-11-25','2023-11-25',0.00,'2022-11-25','Received'),(10,'e002',1000.00,'2022-12-02','2023-12-02',0.00,'2022-12-02','Received');
/*!40000 ALTER TABLE `loans` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `meeting`
--

DROP TABLE IF EXISTS `meeting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `meeting` (
  `id` int NOT NULL,
  `meetingname` varchar(45) DEFAULT NULL,
  `description` text,
  `starttime` varchar(45) DEFAULT NULL,
  `duration` varchar(45) DEFAULT NULL,
  `startdate` varchar(45) DEFAULT NULL,
  `meetingoption` varchar(45) DEFAULT NULL,
  `participationts` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `meeting`
--

LOCK TABLES `meeting` WRITE;
/*!40000 ALTER TABLE `meeting` DISABLE KEYS */;
/*!40000 ALTER TABLE `meeting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_delivery`
--

DROP TABLE IF EXISTS `order_delivery`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_delivery` (
  `cusOrderID` int NOT NULL,
  `agentId` int DEFAULT NULL,
  `tripKM` int DEFAULT NULL,
  `deliveryCost` decimal(10,2) DEFAULT NULL,
  `handoverDate` date DEFAULT NULL,
  PRIMARY KEY (`cusOrderID`),
  KEY `od_fk1_idx` (`agentId`),
  CONSTRAINT `od_fk` FOREIGN KEY (`cusOrderID`) REFERENCES `customer_order` (`cusOrderID`),
  CONSTRAINT `od_fk1` FOREIGN KEY (`agentId`) REFERENCES `delivery_agent` (`agentId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_delivery`
--

LOCK TABLES `order_delivery` WRITE;
/*!40000 ALTER TABLE `order_delivery` DISABLE KEYS */;
INSERT INTO `order_delivery` VALUES (3,900,100,20000.00,'2022-11-17');
/*!40000 ALTER TABLE `order_delivery` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 TRIGGER `InCusID` AFTER INSERT ON `order_delivery` FOR EACH ROW BEGIN
    UPDATE delivery_agent SET rating = rating + 1 WHERE agentId = NEW.agentId;
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `order_ship`
--

DROP TABLE IF EXISTS `order_ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `order_ship` (
  `orderID` int NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  `loadDate` date DEFAULT NULL,
  `landDate` date DEFAULT NULL,
  `shipID` varchar(45) DEFAULT NULL,
  `charges` decimal(10,2) DEFAULT NULL,
  `otherCharges` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`orderID`),
  KEY `os_fk_idx` (`company`,`shipID`),
  CONSTRAINT `os_fk` FOREIGN KEY (`company`, `shipID`) REFERENCES `ship` (`company`, `shipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_ship`
--

LOCK TABLES `order_ship` WRITE;
/*!40000 ALTER TABLE `order_ship` DISABLE KEYS */;
INSERT INTO `order_ship` VALUES (1,'APL','2022-04-04','2022-06-04','AP1425',400000.00,60.00),(2,'FBA','2022-01-04','2022-07-04','FB563',500000.00,20000.00),(3,NULL,'2022-04-07','2022-06-30','AP1425',20000.00,130.00),(7,NULL,'2022-11-24','2022-12-23','AP1425',2000.00,90.00);
/*!40000 ALTER TABLE `order_ship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ordered_machine`
--

DROP TABLE IF EXISTS `ordered_machine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ordered_machine` (
  `orderID` int NOT NULL,
  `machine` varchar(45) NOT NULL,
  `quantity` int DEFAULT NULL,
  `buyingPrice` decimal(8,2) DEFAULT NULL,
  `buyingCost` decimal(10,2) DEFAULT NULL,
  `sellingPrice` decimal(8,2) DEFAULT NULL,
  PRIMARY KEY (`orderID`,`machine`),
  CONSTRAINT `om_fk` FOREIGN KEY (`orderID`) REFERENCES `client_order` (`orderID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ordered_machine`
--

LOCK TABLES `ordered_machine` WRITE;
/*!40000 ALTER TABLE `ordered_machine` DISABLE KEYS */;
INSERT INTO `ordered_machine` VALUES (1,'Stroke Engine Brush Cutter',2,12000.00,13000.00,13200.00),(5,'Concrete Mixture',3,18000.00,54000.00,NULL),(7,'Concrete Mixture',3,10000.00,30000.00,12000.00);
/*!40000 ALTER TABLE `ordered_machine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `payment` (
  `payID` int NOT NULL AUTO_INCREMENT,
  `payDate` date DEFAULT NULL,
  `payAmount` decimal(10,2) DEFAULT NULL,
  `dueAmount` decimal(10,2) DEFAULT NULL,
  `cusOrderID` int DEFAULT NULL,
  `cusName` varchar(45) DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`payID`),
  KEY `pay_fk_idx` (`cusOrderID`,`cusName`),
  CONSTRAINT `pay_fk` FOREIGN KEY (`cusOrderID`, `cusName`) REFERENCES `customer` (`cusOrderID`, `cusName`)
) ENGINE=InnoDB AUTO_INCREMENT=334 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
INSERT INTO `payment` VALUES (1,'2022-01-20',1000.00,100.00,1,'Kamali Perera','10');
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary`
--

DROP TABLE IF EXISTS `salary`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary` (
  `salaryID` int NOT NULL AUTO_INCREMENT,
  `empID` varchar(45) DEFAULT NULL,
  `bonuses` decimal(10,2) DEFAULT NULL,
  `otAmount` decimal(10,2) DEFAULT NULL,
  `loanReductions` decimal(10,2) DEFAULT NULL,
  `totalSalary` decimal(10,2) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `month` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`salaryID`),
  KEY `slr_fk_idx` (`empID`),
  CONSTRAINT `slr_fk` FOREIGN KEY (`empID`) REFERENCES `employee` (`empID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary`
--

LOCK TABLES `salary` WRITE;
/*!40000 ALTER TABLE `salary` DISABLE KEYS */;
INSERT INTO `salary` VALUES (2,'e005',1000.00,100.00,100.00,1000000.00,'2022-07-29','July'),(3,'e006',5000.00,200.00,200.00,25000.00,'2022-07-29','July'),(4,'e001',5000.00,200.00,100.00,1005000.00,'2022-07-29','July'),(5,'e002',1200.00,100.00,100.00,101200.00,'2022-07-29','July'),(6,'e001',0.00,0.00,0.00,1000000.00,'2022-12-02','December'),(7,'e002',100.00,0.00,0.00,100100.00,'2022-12-02','December');
/*!40000 ALTER TABLE `salary` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salary_info`
--

DROP TABLE IF EXISTS `salary_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `salary_info` (
  `designation` varchar(45) NOT NULL,
  `otRate` decimal(10,2) DEFAULT NULL,
  `basicSalary` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`designation`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salary_info`
--

LOCK TABLES `salary_info` WRITE;
/*!40000 ALTER TABLE `salary_info` DISABLE KEYS */;
INSERT INTO `salary_info` VALUES ('CEO',10.00,1000000.00),('Finance Manager',10.00,100000.00),('Front Office Manager',10.00,75000.00),('HR Manager',10.00,100000.00),('Receptionist',10.00,25000.00);
/*!40000 ALTER TABLE `salary_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ship`
--

DROP TABLE IF EXISTS `ship`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `ship` (
  `company` varchar(45) NOT NULL,
  `shipID` varchar(45) NOT NULL,
  `shipName` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`company`,`shipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ship`
--

LOCK TABLES `ship` WRITE;
/*!40000 ALTER TABLE `ship` DISABLE KEYS */;
INSERT INTO `ship` VALUES ('APL','AP1425','Ocean Freight','apltest@gmail.com','AGC china'),('FBA','FB563','Sino Shipping','fbatest.gmail.com','FBA China');
/*!40000 ALTER TABLE `ship` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `stock`
--

DROP TABLE IF EXISTS `stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `stock` (
  `modelID` varchar(45) NOT NULL,
  `machineName` varchar(45) DEFAULT NULL,
  `maufactYear` int DEFAULT NULL,
  `noAvailable` int DEFAULT NULL,
  `sellingPrice` decimal(8,2) DEFAULT NULL,
  `supName` varchar(45) DEFAULT NULL,
  `supPhone` int DEFAULT NULL,
  `remarks` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`modelID`),
  KEY `stk_fk_idx` (`supName`,`supPhone`),
  CONSTRAINT `stk_fk` FOREIGN KEY (`supName`, `supPhone`) REFERENCES `supplier` (`name`, `phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `stock`
--

LOCK TABLES `stock` WRITE;
/*!40000 ALTER TABLE `stock` DISABLE KEYS */;
INSERT INTO `stock` VALUES ('MODEL00235','Grinding mesh',2020,32,34000.00,'Emma Fang',779900234,'NEW'),('MODEL0112','Machine+ cultivator+Trencher+Lawn mower',2021,50,75000.00,'Takeshi Nasai',591365836,'NEW'),('MODEL0113','hhhh',2021,20,100000.00,'Takeshi Nasai',779900294,'NEW'),('ytryr','hhhhEDIT',2011,2,1000.00,'iui',778963258,'new');
/*!40000 ALTER TABLE `stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `supplier` (
  `name` varchar(45) NOT NULL,
  `phone` int NOT NULL,
  `company` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `address` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`name`,`phone`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `supplier`
--

LOCK TABLES `supplier` WRITE;
/*!40000 ALTER TABLE `supplier` DISABLE KEYS */;
INSERT INTO `supplier` VALUES ('Emma Fang',779900234,'Shandong Landworld Commercial Co., Ltd','lucytest@gmail.com','3 province rd. dingyuanzhai guan '),('iui',778963258,NULL,NULL,NULL),('Lucy Liyan',42949672,'Landworld Commercial Co., Ltd','lucytest@gmail.com','52 province rd. dingyuanzhai guan '),('Takeshi Nasai',591365836,'AT(Pvt) Ltd','atedit@gmail.com','Biejing, Chaina'),('Takeshi Nasai',779900294,'Bteam',' bteam@gmail.com',' Biejing, Chaina'),('Tomoko Naraoka',581365836,'Yukiko Okamoto','tomokotest@gmail.com','Biejing, Chaina'),('Tomokodemo Naraokademo ',581365823,'Yukikodemo  Okamotodemo ','tomokotestdemo @gmail.com','Biejing, Chaina');
/*!40000 ALTER TABLE `supplier` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'riyoma'
--

--
-- Dumping routines for database 'riyoma'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-12-02 20:48:46

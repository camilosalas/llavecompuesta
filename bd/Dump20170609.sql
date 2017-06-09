-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: localhost    Database: proyectobiblioteca
-- ------------------------------------------------------
-- Server version	5.7.18-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `categoria`
--

DROP TABLE IF EXISTS `categoria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `categoria` (
  `idcategoria` int(11) NOT NULL AUTO_INCREMENT,
  `nro` varchar(15) DEFAULT NULL,
  `nombre` varchar(50) DEFAULT NULL,
  `descripcion` varchar(100) DEFAULT NULL,
  `idcategoria_sup` int(11) NOT NULL,
  PRIMARY KEY (`idcategoria`),
  KEY `fk_categoria_categoria1_idx` (`idcategoria_sup`),
  CONSTRAINT `fk_categoria_categoria1` FOREIGN KEY (`idcategoria_sup`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `categoria`
--

LOCK TABLES `categoria` WRITE;
/*!40000 ALTER TABLE `categoria` DISABLE KEYS */;
/*!40000 ALTER TABLE `categoria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editorial`
--

DROP TABLE IF EXISTS `editorial`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `editorial` (
  `ideditorial` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `idubigeo` int(11) NOT NULL,
  PRIMARY KEY (`ideditorial`),
  KEY `fk_editorial_ubigeo1_idx` (`idubigeo`),
  CONSTRAINT `fk_editorial_ubigeo1` FOREIGN KEY (`idubigeo`) REFERENCES `ubigeo` (`idubigeo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editorial`
--

LOCK TABLES `editorial` WRITE;
/*!40000 ALTER TABLE `editorial` DISABLE KEYS */;
/*!40000 ALTER TABLE `editorial` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ejemplar`
--

DROP TABLE IF EXISTS `ejemplar`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ejemplar` (
  `idejemplar` int(11) NOT NULL AUTO_INCREMENT,
  `idlibro` int(11) NOT NULL,
  `idproveedor` int(11) NOT NULL,
  `serie_registro` varchar(45) DEFAULT NULL,
  `estado` char(10) DEFAULT NULL,
  `fecha_ingreso` date DEFAULT NULL,
  `precio` double DEFAULT NULL,
  `notacion_interna` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idejemplar`,`idlibro`),
  KEY `fk_Ejemplar_Libro1_idx` (`idlibro`),
  KEY `fk_Ejemplar_Proveedor1_idx` (`idproveedor`),
  CONSTRAINT `fk_Ejemplar_Libro1` FOREIGN KEY (`idlibro`) REFERENCES `libro` (`idlibro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Ejemplar_Proveedor1` FOREIGN KEY (`idproveedor`) REFERENCES `proveedor` (`idproveedor`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ejemplar`
--

LOCK TABLES `ejemplar` WRITE;
/*!40000 ALTER TABLE `ejemplar` DISABLE KEYS */;
/*!40000 ALTER TABLE `ejemplar` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lector`
--

DROP TABLE IF EXISTS `lector`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `lector` (
  `idperiodo` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  `idturno` int(11) DEFAULT NULL,
  `idtipo` int(11) NOT NULL,
  `estado_habil` int(11) DEFAULT NULL,
  `nivel` char(1) DEFAULT NULL,
  `grado` char(1) DEFAULT NULL,
  `seccion` varchar(5) DEFAULT NULL,
  `condicion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idperiodo`,`idpersona`),
  KEY `fk_lector_tipo1_idx` (`idtipo`),
  KEY `fk_lector_periodo1_idx` (`idperiodo`),
  KEY `fk_lector_persona1_idx` (`idpersona`),
  KEY `fk_lector_turno1_idx` (`idturno`),
  CONSTRAINT `fk_lector_periodo1` FOREIGN KEY (`idperiodo`) REFERENCES `periodo` (`idperiodo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lector_persona1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lector_tipo1` FOREIGN KEY (`idtipo`) REFERENCES `tipo` (`idtipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_lector_turno1` FOREIGN KEY (`idturno`) REFERENCES `turno` (`idturno`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lector`
--

LOCK TABLES `lector` WRITE;
/*!40000 ALTER TABLE `lector` DISABLE KEYS */;
INSERT INTO `lector` VALUES (1,2,1,1,1,NULL,NULL,NULL,NULL),(1,3,3,2,1,NULL,NULL,NULL,NULL);
/*!40000 ALTER TABLE `lector` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `libro` (
  `idlibro` int(11) NOT NULL AUTO_INCREMENT,
  `idcategoria` int(11) NOT NULL,
  `ideditorial` int(11) NOT NULL,
  `idpersona_autor` int(11) NOT NULL,
  `titulo` varchar(100) DEFAULT NULL,
  `year_publicacion` year(4) DEFAULT NULL,
  `paginas` varchar(45) DEFAULT NULL,
  `cantidad` int(11) DEFAULT NULL,
  PRIMARY KEY (`idlibro`),
  KEY `fk_Libro_Editorial1_idx` (`ideditorial`),
  KEY `fk_Libro_Categoria1_idx` (`idcategoria`),
  KEY `fk_libro_persona1_idx` (`idpersona_autor`),
  CONSTRAINT `fk_Libro_Categoria1` FOREIGN KEY (`idcategoria`) REFERENCES `categoria` (`idcategoria`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Libro_Editorial1` FOREIGN KEY (`ideditorial`) REFERENCES `editorial` (`ideditorial`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_libro_persona1` FOREIGN KEY (`idpersona_autor`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `periodo`
--

DROP TABLE IF EXISTS `periodo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `periodo` (
  `idperiodo` int(11) NOT NULL AUTO_INCREMENT,
  `periodo` year(4) DEFAULT NULL,
  PRIMARY KEY (`idperiodo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `periodo`
--

LOCK TABLES `periodo` WRITE;
/*!40000 ALTER TABLE `periodo` DISABLE KEYS */;
INSERT INTO `periodo` VALUES (1,2015);
/*!40000 ALTER TABLE `periodo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `persona` (
  `idpersona` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) DEFAULT NULL,
  `apellidos` varchar(50) DEFAULT NULL,
  `genero` char(1) DEFAULT NULL,
  `fecha_nac` date DEFAULT NULL,
  `idtipo_doc` int(11) NOT NULL,
  `nro_doc` varchar(15) DEFAULT NULL,
  `direccion` varchar(50) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idpersona`),
  KEY `fk_persona_tipo_doc1_idx` (`idtipo_doc`),
  CONSTRAINT `fk_persona_tipo_doc1` FOREIGN KEY (`idtipo_doc`) REFERENCES `tipo_doc` (`idtipo_doc`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES (1,'camilo','salas','1',NULL,1,'71721510','dfdlkfgfdj','8745834'),(2,'jose','flores','1',NULL,1,'45674567','ggnghmh','34567'),(3,'juan','perez','1',NULL,1,'6784839','bdsbcdwk','9876543');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo` (
  `idprestamo` int(11) NOT NULL AUTO_INCREMENT,
  `idperiodo` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  `fecha_prestamo` date DEFAULT NULL,
  PRIMARY KEY (`idprestamo`),
  KEY `fk_prestamo_lector1_idx` (`idperiodo`,`idpersona`),
  CONSTRAINT `fk_prestamo_lector1` FOREIGN KEY (`idperiodo`, `idpersona`) REFERENCES `lector` (`idperiodo`, `idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo`
--

LOCK TABLES `prestamo` WRITE;
/*!40000 ALTER TABLE `prestamo` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestamo_det`
--

DROP TABLE IF EXISTS `prestamo_det`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `prestamo_det` (
  `idprestamo` int(11) NOT NULL,
  `idlibro` int(11) NOT NULL,
  `idejemplar` int(11) NOT NULL,
  `fechadev_programada` date DEFAULT NULL,
  `horadev_programada` time DEFAULT NULL,
  `devuelta` char(2) DEFAULT NULL,
  `fechadev_efectiva` date DEFAULT NULL,
  `horadev_efectiva` time DEFAULT NULL,
  PRIMARY KEY (`idprestamo`,`idlibro`,`idejemplar`),
  KEY `fk_prestamo_det_prestamo1_idx` (`idprestamo`),
  KEY `fk_prestamo_det_ejemplar1_idx` (`idejemplar`,`idlibro`),
  CONSTRAINT `fk_prestamo_det_ejemplar1` FOREIGN KEY (`idejemplar`, `idlibro`) REFERENCES `ejemplar` (`idejemplar`, `idlibro`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_prestamo_det_prestamo1` FOREIGN KEY (`idprestamo`) REFERENCES `prestamo` (`idprestamo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestamo_det`
--

LOCK TABLES `prestamo_det` WRITE;
/*!40000 ALTER TABLE `prestamo_det` DISABLE KEYS */;
/*!40000 ALTER TABLE `prestamo_det` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `proveedor` (
  `idproveedor` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idproveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `rol`
--

DROP TABLE IF EXISTS `rol`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `rol` (
  `idrol` int(11) NOT NULL AUTO_INCREMENT,
  `rol` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idrol`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `rol`
--

LOCK TABLES `rol` WRITE;
/*!40000 ALTER TABLE `rol` DISABLE KEYS */;
INSERT INTO `rol` VALUES (1,'alumno');
/*!40000 ALTER TABLE `rol` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `idtipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'estudiante'),(2,'docente'),(3,'visitante');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo_doc`
--

DROP TABLE IF EXISTS `tipo_doc`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo_doc` (
  `idtipo_doc` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idtipo_doc`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo_doc`
--

LOCK TABLES `tipo_doc` WRITE;
/*!40000 ALTER TABLE `tipo_doc` DISABLE KEYS */;
INSERT INTO `tipo_doc` VALUES (1,'Dni');
/*!40000 ALTER TABLE `tipo_doc` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `turno`
--

DROP TABLE IF EXISTS `turno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `turno` (
  `idturno` int(11) NOT NULL AUTO_INCREMENT,
  `turno` varchar(15) DEFAULT NULL,
  PRIMARY KEY (`idturno`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `turno`
--

LOCK TABLES `turno` WRITE;
/*!40000 ALTER TABLE `turno` DISABLE KEYS */;
INSERT INTO `turno` VALUES (1,'mañana'),(2,'tarde'),(3,'noche');
/*!40000 ALTER TABLE `turno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ubigeo`
--

DROP TABLE IF EXISTS `ubigeo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ubigeo` (
  `idubigeo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) DEFAULT NULL,
  `ubigeo_sup` int(11) NOT NULL,
  PRIMARY KEY (`idubigeo`),
  KEY `fk_Lugar_Procedencia_Lugar_Procedencia1_idx` (`ubigeo_sup`),
  CONSTRAINT `fk_Lugar_Procedencia_Lugar_Procedencia1` FOREIGN KEY (`ubigeo_sup`) REFERENCES `ubigeo` (`idubigeo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ubigeo`
--

LOCK TABLES `ubigeo` WRITE;
/*!40000 ALTER TABLE `ubigeo` DISABLE KEYS */;
/*!40000 ALTER TABLE `ubigeo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `idusuario` int(11) NOT NULL AUTO_INCREMENT,
  `usuario` varchar(50) DEFAULT NULL,
  `clave` varchar(50) DEFAULT NULL,
  `idrol` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL,
  PRIMARY KEY (`idusuario`),
  KEY `fk_Usuario_Rol1_idx` (`idrol`),
  KEY `fk_Usuario_Persona1_idx` (`idpersona`),
  CONSTRAINT `fk_Usuario_Persona1` FOREIGN KEY (`idpersona`) REFERENCES `persona` (`idpersona`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_Usuario_Rol1` FOREIGN KEY (`idrol`) REFERENCES `rol` (`idrol`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'camilo','123',1,1);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-09  9:39:08

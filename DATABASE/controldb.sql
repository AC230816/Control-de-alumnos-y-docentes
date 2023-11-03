-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 03-11-2023 a las 22:04:47
-- Versión del servidor: 8.0.31
-- Versión de PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `controldb`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `admin`
--

CREATE TABLE IF NOT EXISTS `admin` (
  `IDAdmin` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(50) NOT NULL,
  `Apellido` varchar(50) NOT NULL,
  `Edad` int NOT NULL,
  `Sexo` varchar(50) NOT NULL,
  `Password` varchar(50) NOT NULL,
  PRIMARY KEY (`IDAdmin`)
) ENGINE=MyISAM AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `admin`
--

INSERT INTO `admin` (`IDAdmin`, `Nombre`, `Apellido`, `Edad`, `Sexo`, `Password`) VALUES
(1, 'admin', 'hermoso', 18, 'masculino', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE IF NOT EXISTS `estudiante` (
  `IDEstudiante` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Edad` varchar(5) NOT NULL,
  `Sexo` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `IDMaestroAsignado` int DEFAULT NULL,
  PRIMARY KEY (`IDEstudiante`),
  KEY `FK_MaestroID` (`IDMaestroAsignado`)
) ENGINE=MyISAM AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`IDEstudiante`, `Nombre`, `Apellido`, `Edad`, `Sexo`, `Password`, `IDMaestroAsignado`) VALUES
(6, 'estudiante6', 'estudiante6', '18', 'masculino', 'credencial6', 2),
(5, 'estudiante5', 'estudiante5', '18', 'femenino', 'credencial5', 2),
(4, 'estudiante4', 'estudiante4', '18', 'femenino', 'credencial4', 2),
(3, 'estudiante3', 'estudiante3', '18', 'femenino', 'credencial3', 1),
(1, 'estudiante1', 'estudiante1', '18', 'masculino', 'credencial1', 1),
(2, 'estudiante2', 'estudiante2', '18', 'femenino', 'credencial2', 1),
(7, 'estudiante7', 'estudiante7', '18', 'masculino', 'credencial7', 3),
(8, 'estudiante8', 'estudiante8', '18', 'femenino', 'credencial8', 3),
(9, 'estudiante9', 'estudiante9', '18', 'femenino', 'credencial9', 3),

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `login`
--

CREATE TABLE IF NOT EXISTS `login` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Usuario` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `login`
--

INSERT INTO `login` (`ID`, `Usuario`, `Password`) VALUES
(1, 'diego', '123'),
(2, 'Diego Antonio', '1234'),
(4, 'dogulas', 'password');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `profesor`
--

CREATE TABLE IF NOT EXISTS `profesor` (
  `ID` int NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(30) NOT NULL,
  `Apellido` varchar(30) NOT NULL,
  `Edad` int NOT NULL,
  `Sexo` varchar(30) NOT NULL,
  `Password` varchar(30) NOT NULL,
  `Materia` varchar(30) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `profesor`
--

INSERT INTO `profesor` (`ID`, `Nombre`, `Apellido`, `Edad`, `Sexo`, `Password`, `Materia`) VALUES
(3, 'profesor3', 'profesor3', 30, 'masculino', 'credencialprofesor3', 'filosofia'),
(2, 'profesor2', 'profesor2', 30, 'femenino', 'credencialprofesor2', 'matematicas'),
(1, 'profesor1', 'profesor1', 30, 'femenino', 'credencialprofesor1', 'matematica');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

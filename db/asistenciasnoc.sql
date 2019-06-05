-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2019 a las 03:40:30
-- Versión del servidor: 10.1.22-MariaDB
-- Versión de PHP: 7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `asistenciasnoc`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistencias`
--

CREATE TABLE `asistencias` (
  `ID` int(11) NOT NULL,
  `DESCRIPCION` varchar(255) DEFAULT NULL,
  `DURACIONMINUTOS` int(11) DEFAULT NULL,
  `HORA` datetime DEFAULT NULL,
  `TITULO` varchar(255) DEFAULT NULL,
  `fkMotivo` int(11) DEFAULT NULL,
  `fkOperador` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `motivos`
--

CREATE TABLE `motivos` (
  `ID` int(11) NOT NULL,
  `MOTIVO` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `motivos`
--

INSERT INTO `motivos` (`ID`, `MOTIVO`) VALUES
(1, 'Generacion Reportes Estadisticos de Radios'),
(2, 'Verificacion de SIM\'s'),
(3, 'Carga de datos SICOM'),
(4, 'Consulta SICOM'),
(5, 'Mensaje Fanatikon '),
(6, 'Resolucion problemas del Programa (Fanatikon)'),
(7, 'Reportes Fanatikon'),
(8, 'Configuracion Linea Comd'),
(9, 'Configuracion Ubiquiti'),
(10, 'Configuracion FLEX'),
(11, 'Configuracion Routers'),
(12, 'Configuracion SNAP'),
(13, 'Asistencia Tecnica GRPS'),
(14, 'Asistencia Tecnica Lineas Digitales'),
(15, 'Asistencia Tecnica VSAT'),
(16, 'Asitencia Tecnica Ubiquiti'),
(17, 'Asitencia Tecnica PC (Centos)');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `operadores`
--

CREATE TABLE `operadores` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `CLAVE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `operadores`
--

INSERT INTO `operadores` (`ID`, `NOMBRE`, `CLAVE`) VALUES
(1, 'Nicolas Grossi', '123456'),
(2, 'Diego', '123456');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL,
  `fkProvincia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`ID`, `NOMBRE`, `fkProvincia`) VALUES
(1, 'Trifilio', 6),
(2, 'Angel Cardozo', 4),
(3, 'Alan', 6),
(4, 'Guillermo Sotomayor', 6),
(5, 'Willy', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `provincias`
--

CREATE TABLE `provincias` (
  `ID` int(11) NOT NULL,
  `NOMBRE` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `provincias`
--

INSERT INTO `provincias` (`ID`, `NOMBRE`) VALUES
(1, 'Santiago Del Estero'),
(2, 'Neuquen'),
(3, 'Jujuy'),
(4, 'Salta'),
(5, 'La Rioja'),
(6, 'Tierra del Fuego'),
(7, 'La Pampa'),
(8, 'Corrientes'),
(9, 'Catamarca'),
(10, 'Santa Cruz'),
(11, 'Rio Negro'),
(12, 'Buenos Aires');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_asistencias_fkMotivo` (`fkMotivo`),
  ADD KEY `FK_asistencias_fkOperador` (`fkOperador`);

--
-- Indices de la tabla `motivos`
--
ALTER TABLE `motivos`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `operadores`
--
ALTER TABLE `operadores`
  ADD PRIMARY KEY (`ID`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`ID`),
  ADD KEY `FK_personas_fkProvincia` (`fkProvincia`);

--
-- Indices de la tabla `provincias`
--
ALTER TABLE `provincias`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `asistencias`
--
ALTER TABLE `asistencias`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT de la tabla `motivos`
--
ALTER TABLE `motivos`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT de la tabla `operadores`
--
ALTER TABLE `operadores`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT de la tabla `provincias`
--
ALTER TABLE `provincias`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `asistencias`
--
ALTER TABLE `asistencias`
  ADD CONSTRAINT `FK_asistencias_fkMotivo` FOREIGN KEY (`fkMotivo`) REFERENCES `motivos` (`ID`),
  ADD CONSTRAINT `FK_asistencias_fkOperador` FOREIGN KEY (`fkOperador`) REFERENCES `operadores` (`ID`);

--
-- Filtros para la tabla `personas`
--
ALTER TABLE `personas`
  ADD CONSTRAINT `FK_personas_fkProvincia` FOREIGN KEY (`fkProvincia`) REFERENCES `provincias` (`ID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.3.11
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 13-07-2015 a las 05:16:50
-- Versión del servidor: 5.6.24
-- Versión de PHP: 5.6.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `sistemas`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumno`
--

CREATE TABLE IF NOT EXISTS `alumno` (
  `ID_ALUMNO` int(11) NOT NULL,
  `NOMBRE` varchar(100) NOT NULL,
  `APELLIDO_PATERNO` varchar(100) NOT NULL,
  `APELLIDO_MATERNO` varchar(100) DEFAULT NULL,
  `MATRICULA` varchar(10) NOT NULL
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `alumno`
--

INSERT INTO `alumno` (`ID_ALUMNO`, `NOMBRE`, `APELLIDO_PATERNO`, `APELLIDO_MATERNO`, `MATRICULA`) VALUES
(3, 'MOISES', 'TELLEZ', 'TAPIA', '11111'),
(7, 'moi', 'mo', 'm', '123444'),
(2, 'Moises', 'Tapia', 'Tellez', '2032412'),
(1, 'MOISES', 'TELLEZ', 'TAPIA', '2334'),
(6, 'Loretto', 'Tapia', 'Guerrero', '29393'),
(5, 'Moi', 'MOi', 'MOi', '5232');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumno`
--
ALTER TABLE `alumno`
  ADD UNIQUE KEY `MATRICULA_2` (`MATRICULA`), ADD KEY `ID_ALUMNO` (`ID_ALUMNO`), ADD KEY `MATRICULA` (`MATRICULA`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `alumno`
--
ALTER TABLE `alumno`
  MODIFY `ID_ALUMNO` int(11) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=8;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-11-2021 a las 22:18:20
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_salud`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pacientes`
--

CREATE TABLE `pacientes` (
  `ID` int(11) NOT NULL,
  `Identificacion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `ApellidoPaciente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `NombrePaciente` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Genero` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Direccion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `CentroAtencion` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `MotivoConsulta` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Medico` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Fecha` varchar(50) COLLATE utf8_unicode_ci NOT NULL,
  `Hora` varchar(50) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  ADD PRIMARY KEY (`ID`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `pacientes`
--
ALTER TABLE `pacientes`
  MODIFY `ID` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

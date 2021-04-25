-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: localhost
-- Tiempo de generación: 25-04-2021 a las 07:02:40
-- Versión del servidor: 10.4.11-MariaDB
-- Versión de PHP: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `MiPollo`
--
CREATE DATABASE IF NOT EXISTS `MiPollo` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `MiPollo`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Cliente`
--

CREATE TABLE `Cliente` (
  `Nombre` text NOT NULL,
  `Apellido` text NOT NULL,
  `Telefono` bigint(15) NOT NULL,
  `Direccion` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Cliente`
--

INSERT INTO `Cliente` (`Nombre`, `Apellido`, `Telefono`, `Direccion`) VALUES
('Cliente', 'Cliente', 1, 'Mi Pollo'),
('Joel', 'De la Cruz', 1234, 'Justo Sierra'),
('Kevin', 'Inzunza', 4321, 'Lazaro Cardenas'),
('Magdiel', 'Pacheco', 1234567890, 'Benito Juarez,Mexicali');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Pedido`
--

CREATE TABLE `Pedido` (
  `Id_Pedido` int(11) NOT NULL,
  `Id_Cliente` bigint(11) NOT NULL DEFAULT 1,
  `Paquete` text NOT NULL,
  `Extra` text NOT NULL,
  `Fecha` date NOT NULL,
  `Total` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `Pedido`
--

INSERT INTO `Pedido` (`Id_Pedido`, `Id_Cliente`, `Paquete`, `Extra`, `Fecha`, `Total`) VALUES
(23, 1, 'Paquete 1: 1\nPaquete 2: 1\nPaquete 3: 1\nPaquete 4: 1\n', 'Salsa Y Cebolla: 1\nEnsalada: 1\nTortillas de Maiz: 1\nTortillas de Harina: 1\n', '2021-04-20', 830),
(24, 1234, 'Paquete 1: 1\nPaquete 5: 1\n', 'Salsa Y Cebolla: 1\nTortillas de Maiz: 1\nTortillas de Harina: 1\n', '2021-04-23', 350);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Cliente`
--
ALTER TABLE `Cliente`
  ADD PRIMARY KEY (`Telefono`);

--
-- Indices de la tabla `Pedido`
--
ALTER TABLE `Pedido`
  ADD PRIMARY KEY (`Id_Pedido`),
  ADD KEY `Id_Cliente` (`Id_Cliente`),
  ADD KEY `Id_Cliente_2` (`Id_Cliente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Pedido`
--
ALTER TABLE `Pedido`
  MODIFY `Id_Pedido` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Pedido`
--
ALTER TABLE `Pedido`
  ADD CONSTRAINT `pedido_ibfk_1` FOREIGN KEY (`Id_Cliente`) REFERENCES `Cliente` (`Telefono`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

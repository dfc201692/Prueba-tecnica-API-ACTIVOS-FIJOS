-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-03-2022 a las 23:25:11
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_springboot`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `activos`
--

CREATE TABLE `activos` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `descripcion` longtext COLLATE utf8_bin NOT NULL,
  `serial` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `numero_inventario` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '',
  `peso` float NOT NULL DEFAULT 0,
  `alto` float NOT NULL DEFAULT 0,
  `ancho` float NOT NULL DEFAULT 0,
  `largo` float NOT NULL DEFAULT 0,
  `valor` bigint(20) NOT NULL DEFAULT 0,
  `fecha_compra` date NOT NULL DEFAULT '0000-00-00',
  `tipo` int(11) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `activos`
--

INSERT INTO `activos` (`id`, `nombre`, `descripcion`, `serial`, `numero_inventario`, `peso`, `alto`, `ancho`, `largo`, `valor`, `fecha_compra`, `tipo`) VALUES
(1, 'Silla', 'Silla reclinable para puesto de trabajo', 'AAA0001', 'INV0001', 2.5, 130, 70, 30, 1200000, '2022-02-28', 0),
(2, 'Silla', 'Silla reclinable para puesto de trabajo', 'AAA0002', 'INV0002', 2.5, 130, 70, 30, 1200000, '2022-02-28', 0),
(3, 'Mesa', 'Mesa para puesto de trabajo', 'AAA0003', 'INV0003', 2.5, 130, 70, 30, 1200000, '2022-02-28', 0),
(5, 'Televisor', 'Televisor sala de reuniones', 'TV00001', 'INV00004', 10, 0, 5, 50, 2500000, '2022-02-28', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `persona`
--

CREATE TABLE `persona` (
  `id_persona` int(10) NOT NULL,
  `nombrePersona` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `activos` int(11) NOT NULL,
  `cantidad` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Volcado de datos para la tabla `persona`
--

INSERT INTO `persona` (`id_persona`, `nombrePersona`, `activos`, `cantidad`) VALUES
(1, 'pepito perez', 3, 2),
(2, 'camila martinez', 5, 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipo_activos`
--

CREATE TABLE `tipo_activos` (
  `id` int(10) NOT NULL,
  `tipo` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `activos`
--
ALTER TABLE `activos`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `persona`
--
ALTER TABLE `persona`
  ADD PRIMARY KEY (`id_persona`),
  ADD UNIQUE KEY `activos` (`activos`);

--
-- Indices de la tabla `tipo_activos`
--
ALTER TABLE `tipo_activos`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tipo` (`tipo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `activos`
--
ALTER TABLE `activos`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `persona`
--
ALTER TABLE `persona`
  ADD CONSTRAINT `persona_ibfk_1` FOREIGN KEY (`activos`) REFERENCES `activos` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

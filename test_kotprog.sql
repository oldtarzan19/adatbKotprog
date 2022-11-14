-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Nov 14. 23:04
-- Kiszolgáló verziója: 10.4.25-MariaDB
-- PHP verzió: 8.1.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `test_kotprog`
--

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `foglalasok`
--

CREATE TABLE `foglalasok` (
  `jaratszam` int(4) NOT NULL,
  `ugyfel_azonosito` int(6) NOT NULL,
  `foglalas_idopontja` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `helyszam` int(3) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `foglalasok`
--

INSERT INTO `foglalasok` (`jaratszam`, `ugyfel_azonosito`, `foglalas_idopontja`, `helyszam`) VALUES
(1234, 123456, '2022-11-14 22:04:06', 35),
(2341, 123456, '2022-11-14 21:48:09', 20),
(3241, 654321, '2022-11-14 21:55:35', 85);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `jarat`
--

CREATE TABLE `jarat` (
  `jarat_szam` int(4) NOT NULL,
  `jarat_tipus` varchar(10) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `sofor_nev` varchar(20) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `ferohelyek_szama` int(3) NOT NULL,
  `max_sebesseg` int(3) NOT NULL,
  `indulovaros_kod` int(2) NOT NULL,
  `vegallomasvaros_kod` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `jarat`
--

INSERT INTO `jarat` (`jarat_szam`, `jarat_tipus`, `sofor_nev`, `ferohelyek_szama`, `max_sebesseg`, `indulovaros_kod`, `vegallomasvaros_kod`) VALUES
(1234, 'Vonat', 'Nagy Pista', 350, 90, 1, 2),
(2341, 'Busz', 'Illés Zoltán', 50, 90, 3, 1),
(3241, 'Vonat', 'Nagy Pista', 350, 90, 2, 1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ugyfel`
--

CREATE TABLE `ugyfel` (
  `ugyfel_azonosito` int(6) NOT NULL,
  `nev` varchar(30) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `lakcim` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `telefonszam` varchar(10) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `ugyfel`
--

INSERT INTO `ugyfel` (`ugyfel_azonosito`, `nev`, `lakcim`, `telefonszam`) VALUES
(123456, 'Zsofenszki Kristóf', 'Szeged', '123'),
(456123, 'Varga Kristóf', 'Nagyszénás', '0630788440'),
(654321, 'Kasza Dominik', 'Szeged', '12345');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `varos`
--

CREATE TABLE `varos` (
  `varos_kod` int(2) NOT NULL,
  `nev` varchar(15) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `varos`
--

INSERT INTO `varos` (`varos_kod`, `nev`) VALUES
(1, 'Szeged'),
(2, 'Békéscsaba'),
(3, 'Pécs'),
(4, 'Budapest');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `foglalasok`
--
ALTER TABLE `foglalasok`
  ADD PRIMARY KEY (`jaratszam`,`foglalas_idopontja`,`helyszam`),
  ADD UNIQUE KEY `jaratszam` (`jaratszam`,`ugyfel_azonosito`,`helyszam`),
  ADD KEY `ugyfel_azonosito` (`ugyfel_azonosito`);

--
-- A tábla indexei `jarat`
--
ALTER TABLE `jarat`
  ADD PRIMARY KEY (`jarat_szam`),
  ADD KEY `indulovaroskod` (`indulovaros_kod`),
  ADD KEY `vegallomasvaroskod` (`vegallomasvaros_kod`);

--
-- A tábla indexei `ugyfel`
--
ALTER TABLE `ugyfel`
  ADD PRIMARY KEY (`ugyfel_azonosito`);

--
-- A tábla indexei `varos`
--
ALTER TABLE `varos`
  ADD PRIMARY KEY (`varos_kod`);

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `foglalasok`
--
ALTER TABLE `foglalasok`
  ADD CONSTRAINT `foglalasok_ibfk_1` FOREIGN KEY (`jaratszam`) REFERENCES `jarat` (`jarat_szam`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `foglalasok_ibfk_2` FOREIGN KEY (`ugyfel_azonosito`) REFERENCES `ugyfel` (`ugyfel_azonosito`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Megkötések a táblához `jarat`
--
ALTER TABLE `jarat`
  ADD CONSTRAINT `jarat_ibfk_1` FOREIGN KEY (`indulovaros_kod`) REFERENCES `varos` (`varos_kod`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `jarat_ibfk_2` FOREIGN KEY (`vegallomasvaros_kod`) REFERENCES `varos` (`varos_kod`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

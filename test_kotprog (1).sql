-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Nov 15. 00:21
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
  `indulas_ideje` time DEFAULT NULL,
  `erkezes_ideje` time DEFAULT NULL,
  `indulovaros_kod` int(2) NOT NULL,
  `vegallomasvaros_kod` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `jarat`
--

INSERT INTO `jarat` (`jarat_szam`, `jarat_tipus`, `sofor_nev`, `ferohelyek_szama`, `max_sebesseg`, `indulas_ideje`, `erkezes_ideje`, `indulovaros_kod`, `vegallomasvaros_kod`) VALUES
(1242, 'Vonat', 'Fehér Klaudia', 250, 100, '12:00:00', '14:00:00', 2, 1),
(1380, 'Vonat', 'Király Kornél', 400, 110, '09:28:00', '13:10:00', 4, 3),
(2018, 'Repulő', 'Farkas Adél', 230, 990, '04:50:00', '06:05:00', 4, 8),
(2271, 'Vonat', 'Szőke Rudolf', 250, 90, '18:50:00', '22:00:00', 5, 4),
(2551, 'Vonat', 'Szőke Rudolf', 250, 115, '13:10:00', '15:45:00', 4, 5),
(2928, 'Repulő', 'Farkas Adél', 230, 980, '11:30:00', '12:40:00', 8, 4),
(2969, 'Busz', 'Gáspár Áron', 30, 90, '16:25:00', '17:25:00', 7, 2),
(3329, 'Vonat', 'Katona Rudolf', 400, 95, '22:00:00', '23:50:00', 1, 6),
(3457, 'Busz', 'Gáspár Áron', 30, 90, '10:15:00', '11:15:00', 2, 7),
(3981, 'Repulő', 'Király Barna', 190, 900, '12:00:00', '15:42:00', 4, 10),
(4099, 'Repulő', 'Király Barna', 190, 850, '20:20:00', '23:52:00', 10, 4),
(4784, 'Vonat', 'Orosz Áron', 230, 100, '15:30:00', '18:25:00', 1, 6),
(5041, 'Repulő', 'Balla Patrícia', 200, 920, '20:45:00', '22:10:00', 9, 4),
(5838, 'Vonat', 'Király Kornél', 400, 105, '18:10:00', '22:18:00', 3, 4),
(7431, 'Busz', 'Illés Zoltán', 30, 75, '08:35:00', '13:40:00', 3, 2),
(7551, 'Busz', 'Boros Katalin', 25, 80, '12:25:00', '15:25:00', 4, 5),
(8471, 'Vonat', 'Katona Rudolf', 400, 95, '17:10:00', '19:20:00', 6, 1),
(8941, 'Repulő', 'Balla Patrícia', 200, 920, '08:10:00', '10:00:00', 4, 9),
(9567, 'Busz', 'Illés Zoltán', 30, 95, '15:40:00', '20:40:00', 2, 3),
(9627, 'Busz', 'Boros Katalin', 25, 85, '18:30:00', '21:30:00', 5, 4);

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
(4, 'Budapest'),
(5, 'Debrecen'),
(6, 'Kecskemét'),
(7, 'Gyula'),
(8, 'Bécs'),
(9, 'Bukarest'),
(10, 'Barcelona');

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

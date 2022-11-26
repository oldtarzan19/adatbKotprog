-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2022. Nov 26. 16:45
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
(1242, 13, '2022-11-23 18:08:02', 53),
(5838, 13, '2022-11-24 17:17:12', 25),
(1242, 15, '2022-11-24 17:22:05', 107),
(3457, 17, '2022-11-24 17:16:41', 2),
(2969, 18, '2022-11-24 17:17:17', 7),
(2271, 21, '2022-11-24 17:17:27', 50),
(9627, 21, '2022-11-24 17:20:06', 17),
(5838, 22, '2022-11-24 16:57:49', 84),
(5838, 22, '2022-11-24 17:24:02', 61),
(1242, 23, '2022-11-24 17:19:18', 9),
(9627, 23, '2022-11-24 17:14:30', 11),
(1380, 24, '2022-11-24 17:16:54', 120),
(3329, 24, '2022-11-24 17:22:36', 130),
(5838, 24, '2022-11-24 17:13:47', 85),
(7551, 24, '2022-11-24 17:19:49', 21),
(9567, 24, '2022-11-24 17:19:55', 24),
(1242, 27, '2022-11-24 17:13:24', 72),
(8471, 29, '2022-11-24 17:14:53', 63),
(5838, 30, '2022-11-24 17:19:36', 94),
(9567, 32, '2022-11-24 17:17:23', 16),
(2271, 33, '2022-11-24 17:14:15', 121),
(2969, 35, '2022-11-24 17:14:37', 14),
(3457, 35, '2022-11-24 17:17:36', 14),
(3457, 37, '2022-11-24 17:14:23', 13);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `hotel`
--

CREATE TABLE `hotel` (
  `szallas_id` int(2) NOT NULL,
  `csillagok_szama` int(1) NOT NULL,
  `van_e_medence` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `hotel`
--

INSERT INTO `hotel` (`szallas_id`, `csillagok_szama`, `van_e_medence`) VALUES
(8, 4, 1),
(7, 4, 1),
(11, 4, 1),
(16, 3, 1),
(29, 2, 0),
(28, 4, 0),
(32, 1, 0),
(20, 5, 1),
(34, 3, 0),
(24, 2, 0),
(22, 4, 1),
(26, 5, 1),
(36, 4, 1),
(33, 3, 1),
(31, 4, 0);

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
(1001, 'Busz', 'Lukács Gábor', 50, 90, '12:50:00', '15:10:00', 6, 7),
(1002, 'Busz', 'Kovács Emőke', 50, 90, '08:00:00', '11:12:00', 7, 6),
(1101, 'Repülő', 'Deák Emőke', 300, 990, '04:30:00', '08:10:00', 8, 9),
(1102, 'Repülő', 'Orbán Benedek', 250, 950, '08:10:00', '14:50:00', 9, 10),
(1103, 'Repülő', 'Rácz Panna', 350, 999, '06:10:00', '11:30:00', 10, 8),
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
-- Tábla szerkezet ehhez a táblához `szallas`
--

CREATE TABLE `szallas` (
  `szallas_id` int(2) NOT NULL,
  `varos_kod` int(2) NOT NULL,
  `nev` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `ar_per_ej` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `szallas`
--

INSERT INTO `szallas` (`szallas_id`, `varos_kod`, `nev`, `ar_per_ej`) VALUES
(7, 1, 'Szeged Hotel', 19000),
(8, 7, 'Gyulai Várfürdő és Hotel', 21000),
(9, 2, 'Csaba motel', 4500),
(10, 3, 'Kisvirág vendéglő', 6500),
(11, 4, 'Danubius Hotel Aréna', 23500),
(12, 1, 'Szegedi Motel', 11000),
(13, 1, 'Marina Apartman', 5600),
(14, 7, 'Lila Villa', 5000),
(15, 5, 'Arany Bika Szálló', 10000),
(16, 9, 'Monopoly Hotel', 15000),
(17, 8, 'Ultra Apartman', 6500),
(18, 4, 'Ezüstfenyő Apartman', 20000),
(19, 3, 'Mecsek Apartman', 4500),
(20, 10, 'Barcelona Hotel', 50000),
(21, 10, 'World Apartman', 10000),
(22, 2, 'Aranyág Hotel', 15000),
(23, 6, 'Hírös Panzió', 6000),
(24, 6, 'Kisvirág Hotel', 12000),
(25, 8, 'Straus Apartman', 35000),
(26, 8, 'Mozart Hotel', 60000),
(27, 9, 'Marvel Hotel', 30000),
(28, 5, 'Ezüst Bika Hotel', 30000),
(29, 5, ' Ruby Haven Hotel', 4545),
(30, 9, 'Cerulean Dune Resort & Spa', 54000),
(31, 8, 'Marina Cottage Hotel & Spa', 50000),
(32, 4, 'Ivory Universe Resort', 30000),
(33, 3, 'Ruby Haven Hotel', 45000),
(34, 9, 'Rose Aurora Hotel', 15000),
(35, 5, 'Soft Spire Apartman', 45000),
(36, 9, 'White Bear Hotel', 14000),
(37, 3, 'Barna Medve Apartman', 5000);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ugyfel`
--

CREATE TABLE `ugyfel` (
  `ugyfel_azonosito` int(6) NOT NULL,
  `nev` varchar(30) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `lakcim` varchar(100) COLLATE utf8mb4_hungarian_ci NOT NULL,
  `telefonszam` varchar(11) COLLATE utf8mb4_hungarian_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_hungarian_ci;

--
-- A tábla adatainak kiíratása `ugyfel`
--

INSERT INTO `ugyfel` (`ugyfel_azonosito`, `nev`, `lakcim`, `telefonszam`) VALUES
(13, 'Zsofenszki Kristóf', 'Szeged', '06307884406'),
(15, 'Fehér Klaudia', 'Pécs', '06811197519'),
(16, 'Orosz Áron', 'Szeged', '06650740790'),
(17, 'Gáspár Áron', 'Gyula', '06186259184'),
(18, 'Balla Patrícia', 'Békéscsaba', '06951197231'),
(19, 'Katona Rudolf', 'Orosháza', '06755995118'),
(20, 'Boros Katalin', 'Székesfehérvár', '06638789429'),
(21, 'Barna Milla', 'Pécs', '06977854987'),
(22, 'Farkas Adél', 'Gyula', '06874732920'),
(23, 'Király Kornél', 'Pécs', '06349455478'),
(24, 'Illés Zoltán', 'Budapest', '06465423589'),
(25, 'Balla Endre', 'Budapest', '06888566266'),
(26, 'Szőke Rudolf', 'Budapest', '06127183396'),
(27, 'Orbán Kornél', 'Miskolc', '06807494654'),
(28, 'Szabó Emőke', 'Budapest', '06554758809'),
(29, 'Rácz Maja', 'Szeged', '06601970611'),
(30, 'Balog Katinka', 'Budapest', '06657869755'),
(31, 'Kerekes Servácz', 'Gyula', '06571254380'),
(32, 'Király Barna', 'Orosháza', '06937654513'),
(33, 'Novák Dorián', 'Veszprém', '06992669142'),
(34, 'Fülöp Léna', 'Békéscsaba', '06914736800'),
(35, 'Szalai Léna', 'Kecskemét', '06450656942'),
(36, 'Jakab Áron', 'Debrecen', '06510929076'),
(37, 'Szücs Bendegúz', 'Kecskemét', '06593389025');

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
  ADD KEY `ugyfel` (`ugyfel_azonosito`);

--
-- A tábla indexei `hotel`
--
ALTER TABLE `hotel`
  ADD KEY `szallas_id` (`szallas_id`);

--
-- A tábla indexei `jarat`
--
ALTER TABLE `jarat`
  ADD PRIMARY KEY (`jarat_szam`),
  ADD KEY `erkezo_kulso_kulcs` (`vegallomasvaros_kod`),
  ADD KEY `indulo_kulso_kulcs` (`indulovaros_kod`);

--
-- A tábla indexei `szallas`
--
ALTER TABLE `szallas`
  ADD PRIMARY KEY (`szallas_id`),
  ADD KEY `kulso_kulcs_varos` (`varos_kod`);

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
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `szallas`
--
ALTER TABLE `szallas`
  MODIFY `szallas_id` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=38;

--
-- AUTO_INCREMENT a táblához `ugyfel`
--
ALTER TABLE `ugyfel`
  MODIFY `ugyfel_azonosito` int(6) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;

--
-- AUTO_INCREMENT a táblához `varos`
--
ALTER TABLE `varos`
  MODIFY `varos_kod` int(2) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `foglalasok`
--
ALTER TABLE `foglalasok`
  ADD CONSTRAINT `foglalasok_ibfk_1` FOREIGN KEY (`jaratszam`) REFERENCES `jarat` (`jarat_szam`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ugyfel` FOREIGN KEY (`ugyfel_azonosito`) REFERENCES `ugyfel` (`ugyfel_azonosito`) ON DELETE CASCADE;

--
-- Megkötések a táblához `hotel`
--
ALTER TABLE `hotel`
  ADD CONSTRAINT `hotel_ibfk_1` FOREIGN KEY (`szallas_id`) REFERENCES `szallas` (`szallas_id`) ON DELETE CASCADE;

--
-- Megkötések a táblához `jarat`
--
ALTER TABLE `jarat`
  ADD CONSTRAINT `erkezo_kulso_kulcs` FOREIGN KEY (`vegallomasvaros_kod`) REFERENCES `varos` (`varos_kod`) ON DELETE CASCADE,
  ADD CONSTRAINT `indulo_kulso_kulcs` FOREIGN KEY (`indulovaros_kod`) REFERENCES `varos` (`varos_kod`) ON DELETE CASCADE;

--
-- Megkötések a táblához `szallas`
--
ALTER TABLE `szallas`
  ADD CONSTRAINT `kulso_kulcs_varos` FOREIGN KEY (`varos_kod`) REFERENCES `varos` (`varos_kod`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 13 Şub 2018, 15:48:13
-- Sunucu sürümü: 10.1.28-MariaDB
-- PHP Sürümü: 7.1.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Veritabanı: `demo`
--

-- --------------------------------------------------------

--
-- Tablo için tablo yapısı `doctors`
--

CREATE TABLE `doctors` (
  `Id` int(10) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Clinic` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `doctors`
--

INSERT INTO `doctors` (`Id`, `Name`, `Clinic`) VALUES
(1, 'Dr. Ertug Adalarli', 'Ear-Nose-Throat Clinic'),
(2, 'Dr.Alper Ezircan', 'Ear-Nose-Throat Clinic'),
(3, 'Dr. Kubilay Aydede', 'Surgery Clinic'),
(4, 'Dr. Hande Ozdinler', 'Surgery Clinic'),
(5, 'Dr. Omer Ozkan', 'Surgery Clinic'),
(6, 'Dr. Tufan Aybek', 'Dermatology Clinic'),
(7, 'Dr. Murat Gunel', 'Dermatology Clinic'),
(8, 'Dr. Nihat Gunel', 'Dermatology Clinic'),
(9, 'Dr. Mehmet Oz', 'Orthopedics');

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `doctors`
--
ALTER TABLE `doctors`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `doctors`
--
ALTER TABLE `doctors`
  MODIFY `Id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

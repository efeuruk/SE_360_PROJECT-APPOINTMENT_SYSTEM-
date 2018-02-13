-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 13 Şub 2018, 15:47:23
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
-- Tablo için tablo yapısı `appointment`
--

CREATE TABLE `appointment` (
  `Doctor` varchar(100) NOT NULL,
  `Clinic` varchar(100) NOT NULL,
  `Day` varchar(100) NOT NULL,
  `Hour` varchar(100) NOT NULL,
  `Id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `appointment`
--

INSERT INTO `appointment` (`Doctor`, `Clinic`, `Day`, `Hour`, `Id`) VALUES
('Dr. Ertug Adalarli', 'Ear-Nose-Throat Clinic', 'Monday', '10:00', 1),
('Dr. Kubilay Aydede', 'Dermatology Clinic', 'Wednesday', '13:00', 2),
('Dr.Alper Ezircan', 'Surgery Clinic', 'Wednesday', '13:00', 3),
('Dr. Kubilay Aydede', 'Dermatology Clinic', 'Tuesday', '12:00', 4),
('Dr. Kubilay Aydede', 'Ear-Nose-Throat Clinic', 'Tuesday', '11:00', 5),
('Dr. Kubilay Aydede', 'Orthopedics', 'Wednesday', '12:00', 6),
('Dr.Alper Ezircan', 'Ear-Nose-Throat Clinic', 'Thursday', '12:00', 7),
('Dr. Omer Ozkan', 'Dermatology Clinic', 'Wednesday', '14:00', 8),
('Dr. Kubilay Aydede', 'Dermatology Clinic', 'Wednesday', '13:00', 9),
('Dr. Murat Gunel', 'Orthopedics', 'Friday', '12:00', 10),
('Dr. Ertug Adalarli', 'Dermatology Clinic', 'Friday', '16:00', 11);

--
-- Dökümü yapılmış tablolar için indeksler
--

--
-- Tablo için indeksler `appointment`
--
ALTER TABLE `appointment`
  ADD PRIMARY KEY (`Id`);

--
-- Dökümü yapılmış tablolar için AUTO_INCREMENT değeri
--

--
-- Tablo için AUTO_INCREMENT değeri `appointment`
--
ALTER TABLE `appointment`
  MODIFY `Id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

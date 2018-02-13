-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Anamakine: 127.0.0.1
-- Üretim Zamanı: 13 Şub 2018, 15:48:38
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
-- Tablo için tablo yapısı `patients`
--

CREATE TABLE `patients` (
  `Ad` varchar(20) NOT NULL,
  `Soyad` varchar(20) NOT NULL,
  `SSN` varchar(20) NOT NULL,
  `Password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Tablo döküm verisi `patients`
--

INSERT INTO `patients` (`Ad`, `Soyad`, `SSN`, `Password`) VALUES
('Berk', 'Ezircan', '12', ''),
('Efe', 'Uruk', '20513059500', 'efe123'),
('Efe', 'Uruk', '20513059500', 'efe123'),
('Kubilay', 'Aydede', '1', '12345'),
('Ertug', 'adalarli', '1', 'ertug'),
('Figen', 'Sayili', '11078152454', 'figen123'),
('Admin', 'Admin', 'admin', 'admin'),
('Nur', 'Ersoy', '2222', 'nur'),
('Hakan', 'Uruk', '2015', 'hakan');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

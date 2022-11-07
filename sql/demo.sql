SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;


CREATE TABLE `demo_role` (
  `id` bigint(20) NOT NULL,
  `name` varchar(255) COLLATE utf8mb4_czech_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `demo_role`
--

INSERT INTO `demo_role` (`id`, `name`) VALUES
(1, 'USER'),
(2, 'ADMIN');

-- --------------------------------------------------------

--
-- Struktura tabulky `demo_user`
--

CREATE TABLE `demo_user` (
  `id` bigint(20) NOT NULL,
  `hashed_password` varchar(255) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8mb4_czech_ci DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `demo_user`
--

INSERT INTO `demo_user` (`id`, `hashed_password`, `username`) VALUES
(1, '$2a$10$/pvYi8qvIFZ.NipF6idG/.H5XR1DOtdpwnprWDAzh094XOwBhboiW', 'user'),
(2, '$2a$10$1H2ne5AB6jZpNo5UYqQ84OdkELQlOPL3XXmmfnJUMcT70PhTEasjy', 'admin'),
(3, '$2a$10$g8bmTk8nI7/nwNxE2eu0TeVoMWEEaHnlZ5R1cMeR4oBftDV/zIX5C', 'super');

-- --------------------------------------------------------

--
-- Struktura tabulky `demo_user_role`
--

CREATE TABLE `demo_user_role` (
  `fk_user` bigint(20) NOT NULL,
  `fk_role` bigint(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

--
-- Vypisuji data pro tabulku `demo_user_role`
--

INSERT INTO `demo_user_role` (`fk_user`, `fk_role`) VALUES
(1, 1),
(2, 1),
(2, 2),
(3, 1),
(3, 2);

--
-- Indexy pro exportované tabulky
--

--
-- Indexy pro tabulku `demo_role`
--
ALTER TABLE `demo_role`
  ADD PRIMARY KEY (`id`);

--
-- Indexy pro tabulku `demo_user`
--
ALTER TABLE `demo_user`
  ADD PRIMARY KEY (`id`);

--
-- Indexy pro tabulku `demo_user_role`
--
ALTER TABLE `demo_user_role`
  ADD PRIMARY KEY (`fk_user`,`fk_role`),
  ADD KEY `FKrodtvugy2x4rpkwj6dmlr6c5n` (`fk_role`);

--
-- AUTO_INCREMENT pro tabulky
--

--
-- AUTO_INCREMENT pro tabulku `demo_role`
--
ALTER TABLE `demo_role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pro tabulku `demo_user`
--
ALTER TABLE `demo_user`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;

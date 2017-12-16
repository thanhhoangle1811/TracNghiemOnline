CREATE TABLE `accountrole` (
  `accountid` int(11) NOT NULL,
  `roleid` int(11) NOT NULL,
  `enable` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

ALTER TABLE `accountrole`
  ADD PRIMARY KEY (`accountid`,`roleid`),
  ADD KEY `roleid` (`roleid`);

  ALTER TABLE `accountrole`
  ADD CONSTRAINT `accountrole_ibfk_1` FOREIGN KEY (`accountid`) REFERENCES `account` (`id`),
  ADD CONSTRAINT `accountrole_ibfk_2` FOREIGN KEY (`roleid`) REFERENCES `role` (`id`);
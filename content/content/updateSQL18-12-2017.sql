ALTER TABLE account DROP FOREIGN KEY account_ibfk_1,DROP KEY roleid;
ALTER TABLE account DROP COLUMN roleid;
ALTER TABLE answer ADD COLUMN isStudent tinyint(1);
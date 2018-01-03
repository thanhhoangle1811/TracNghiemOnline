ALTER TABLE question
  drop FOREIGN KEY question_ibfk_2,
  drop KEY examid;
  
ALTER TABLE answer DROP COLUMN isStudent;
ALTER TABLE question DROP COLUMN examid;


 ALTER TABLE question DROP COLUMN examid;
 
 CREATE TABLE `examquestion` (
 `examid` int(11) NOT NULL,
 `questionid` int(11) NOT NULL,
 PRIMARY KEY (`examid`,`questionid`)
)

INSERT INTO `role` (`id`, `name`) VALUES (NULL, 'ADMIN');
INSERT INTO `account` (`id`, `firstname`, `lastname`, `email`, `password`) VALUES (NULL, 'Le', 'Hoang', 'lehoang@gmail.com', '123456');

INSERT INTO `examquestion` (`examid`, `questionid`) VALUES ('1', '4');
INSERT INTO `examquestion` (`examid`, `questionid`) VALUES ('1', '8');
INSERT INTO `examquestion` (`examid`, `questionid`) VALUES ('1', '9');
INSERT INTO `examquestion` (`examid`, `questionid`) VALUES ('1', '10');
INSERT INTO `examquestion` (`examid`, `questionid`) VALUES ('1', '11');
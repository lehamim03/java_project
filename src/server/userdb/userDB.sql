CREATE TABLE member_table (
  uname VARCHAR(30),
  uemail VARCHAR(30) NOT NULL,
  password VARCHAR(30),
  PRIMARY KEY(uemail)
) ENGINE=MYISAM CHARSET=utf8;

/* 테이블 생성 */
CREATE TABLE friendList (
  id INT NOT NULL AUTO_INCREMENT,
  userEmail VARCHAR(30),
  friendEmail VARCHAR(30),
  PRIMARY KEY(id),
  FOREIGN KEY (userEmail) REFERENCES member_table (uemail),
  FOREIGN KEY (friendEmail) REFERENCES member_table (uemail)
) ENGINE=MYISAM CHARSET=utf8;

/* 데이터 삽입 */
INSERT INTO member_table VALUES('와우시날 임원', 'a', 'a');
INSERT INTO member_table VALUES('일반 부원', 'b', 'b');
INSERT INTO member_table VALUES('학생', 'c', 'c');

INSERT INTO friendList VALUES(1, 'a', 'b');
INSERT INTO friendList VALUES(2, 'a', 'c');
INSERT INTO friendList VALUES(4, 'b', 'a');
INSERT INTO friendList VALUES(5, 'b', 'c');
INSERT INTO friendList VALUES(7, 'c', 'b');
INSERT INTO friendList VALUES(8, 'c', 'a');

DROP TABLE member_table;

DROP TABLE friendList;


/* 테이블 조회 */
SELECT * FROM member_table;
SELECT * FROM friendList;

CREATE SCHEMA schedule;

use schedule;

CREATE TABLE schedule(
                         ID BIGINT PRIMARY KEY AUTO_INCREMENT COMMENT '일정 식별자',
                         NAME VARCHAR(50) NOT NULL COMMENT '작성자',
                         PASSWORD INT(50) NOT NULL COMMENT '비밀번호',
                         CONTENTS TEXT NOT NULL COMMENT '일정 내용',
                         CREATEDATE DATETIME NOT NULL COMMENT '작성일',
                         UPDATEDATE DATETIME NOT NULL COMMENT '수정일'
);

DROP TABLE schedule;

ALTER TABLE schedule MODIFY PASSWORD VARCHAR(30);

ALTER TABLE schedule MODIFY CREATEDATE DATE;
ALTER TABLE schedule MODIFY UPDATEDATE DATE;


select * from schedule;

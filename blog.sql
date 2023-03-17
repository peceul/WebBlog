-- 기본 테이블 및 시퀀스 생성
-- security 적용으로 인하여 blogpwd 문자열의 길이를 20 -> 200으로 올림

CREATE TABLE blog_member (
    blogid VARCHAR2(20) PRIMARY KEY,
    blogpwd VARCHAR2(200) NOT NULL,
    bloggername VARCHAR2(20) NOT NULL,
    photo NUMBER(1) DEFAULT 1,
    enabled NUMBER(1) DEFAULT 1 CHECK (enabled IN (0, 1)), 
    rolename VARCHAR2(20) DEFAULT 'ROLE_USER' CHECK (rolename IN('ROLE_USER', 'ROLE_ADMIN'))
);

CREATE TABLE blog_board (
    blogseq NUMBER PRIMARY KEY,
    blogid VARCHAR2(20) REFERENCES blog_member(blogid) ON DELETE CASCADE,
    title VARCHAR2(200) NOT NULL,
    blogtext VARCHAR2(2000) NOT NULL,
    regdate DATE DEFAULT SYSDATE,
    likecnt NUMBER DEFAULT 0
);

CREATE SEQUENCE blog_board_seq;

--- 테이블 및 시퀀스 삭제`

DROP TABLE blog_member;
DROP TABLE blog_board;
DROP SEQUENCE blog_board_seq;
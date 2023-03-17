-- �⺻ ���̺� �� ������ ����
-- security �������� ���Ͽ� blogpwd ���ڿ��� ���̸� 20 -> 200���� �ø�

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

--- ���̺� �� ������ ����`

DROP TABLE blog_member;
DROP TABLE blog_board;
DROP SEQUENCE blog_board_seq;
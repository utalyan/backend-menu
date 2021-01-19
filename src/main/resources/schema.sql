DROP TABLE IF EXISTS CITY;
DROP TABLE IF EXISTS COUNTY;

CREATE TABLE CITY (
ID BIGINT NOT NULL,
NAME VARCHAR(30),
PRIMARY KEY (ID)
);

CREATE TABLE COUNTY (
ID BIGINT NOT NULL,
NAME VARCHAR(30),
CITY_ID BIGINT,
PRIMARY KEY (ID)
);

--DROP VIEW IF EXISTS V_CITY;
--DROP VIEW IF EXISTS V_COUNTY;
--CREATE VIEW V_CITY AS SELECT ID, NAME FROM CITY;

--CREATE VIEW V_COUNTY AS SELECT ID, NAME, CITY_ID FROM COUNTY;
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

CREATE VIEW V_SERVING AS
SELECT  srv.id as id,
            srv.name as name,
            srv.factor as factor,
             to.id as type_of_id,
             to.name as name_type_of ,
             to.firm_id as firm_id
            FROM serving srv
           JOIN type_of to ON srv.type_of_id = to.id;


CREATE VIEW V_ADDITION AS
SELECT  add.id as id,
            add.name as name,
            add.amount as amount,
             to.id as type_of_id,
             to.name as type_of_name ,
             to.firm_id as firm_id
            FROM addition add
           JOIN type_of to ON add.type_of_id = to.id;

CREATE VIEW V_FOOD_SHORT AS
SELECT  ID,
                NAME,
                TYPE_OF_ID
            FROM FOOD
           ;


CREATE VIEW V_FOOD AS
SELECT  ID,
                NAME,
                SERVING_GRAM,
                PRICE,
                DESCRIPTION,
                IMAGE,
                TYPE_OF_ID
            FROM FOOD
           ;

CREATE VIEW V_MENU_DETAIL AS
SELECT  md.id as id,
            md.menu_id as menu_id,
             to.id as type_of_id,
             to.name as type_of_name ,
             f.id as food_id,
             f.name as food_name,
             f.price as food_price
            FROM menu_detail md
            JOIN food f on md.food_id = f.id
           JOIN type_of to ON f.type_of_id = to.id;
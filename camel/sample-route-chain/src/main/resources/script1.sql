create schema MYKILLERAPP;

CREATE TABLE MYKILLERAPP.AakashTable (
        ID INTEGER NOT NULL,
        MyKey INTEGER NOT NULL,
        Content VARCHAR(20) NOT NULL,
        PRIMARY KEY (ID)
    );
    
insert into MYKILLERAPP.AakashTable values (1,1,'Hello');
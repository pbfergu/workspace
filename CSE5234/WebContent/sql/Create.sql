

CREATE TABLE ITEM(ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), DESCRIPTION VARCHAR(255), AVAILABLE_QUANTITY INT, UNIT_PRICE DECIMAL(20,2));

INSERT INTO ITEM (NAME,DESCRIPTION,AVAILABLE_QUANTITY,UNIT_PRICE) VALUES('Ray Ban','looks good',20,88.98);
INSERT INTO ITEM (NAME,DESCRIPTION,AVAILABLE_QUANTITY,UNIT_PRICE) VALUES('Levis','unexpensive',50,30);
INSERT INTO ITEM (NAME,DESCRIPTION,AVAILABLE_QUANTITY,UNIT_PRICE) VALUES('Gucci','good style',40,100);
INSERT INTO ITEM (NAME,DESCRIPTION,AVAILABLE_QUANTITY,UNIT_PRICE) VALUES('Prada','popular',23,200);
INSERT INTO ITEM (NAME,DESCRIPTION,AVAILABLE_QUANTITY,UNIT_PRICE) VALUES('Oakley','good quality',50,90);

CREATE TABLE CUSTOMER_ORDER(ID BIGINT PRIMARY KEY AUTO_INCREMENT,CUSTOMER_NAME VARCHAR(255),STATUS VARCHAR(255));

CREATE TABLE CUSTOMER_ORDER_LINE_ITEM(ID BIGINT PRIMARY KEY AUTO_INCREMENT,ITEM_ID BIGINT ,ITEM_NAME VARCHAR(255),QUANTITY INT,CUSTOMER_ORDER_ID_FK BIGINT);

CREATE TABLE PAYMENT_INFO(ID BIGINT PRIMARY KEY AUTO_INCREMENT, CREDIT_CARD_NUMBER VARCHAR(255), EXP_DATE VARCHAR(50),CVV_CODE VARCHAR(50),CARD_HOLDER_NAME VARCHAR(255), EMAIL_ADDRESS VARCHAR(255),CUSTOMER_ORDER_ID_FK BIGINT, CONFIRMATION_NUMBER VARCHAR(255));

CREATE TABLE SHIPPING_INFO(ID BIGINT PRIMARY KEY AUTO_INCREMENT, NAME VARCHAR(255), ADDRESSLINE1 VARCHAR(255), ADDRESSLINE2 VARCHAR(255), CITY VARCHAR(255),STATE VARCHAR(255), ZIP VARCHAR(255), CUSTOMER_ORDER_ID_FK BIGINT );
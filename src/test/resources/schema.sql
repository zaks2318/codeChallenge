-- CREATE TABLE CUSTOMER(
--                          CUSTOMER_ID INT AUTO_INCREMENT PRIMARY KEY,
--                          CUSTOMER_FIRSTNAME VARCHAR(250) NOT NULL ,
--                          CUSTOMER_LASTNAME VARCHAR(250) Not NULL
-- );



CREATE TABLE TRANSACTION_TABLE(
    transaction_id INT,
    customer_id INT,
    create_year INT,
    create_month INT,
    create_day INT,
    transaction_amount DOUBLE
);



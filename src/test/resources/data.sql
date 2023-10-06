-- INSERT INTO ABC (first_name, last_name, email,age) VALUES
--     ('Zack','Huang','zackhuang@gmail.com',5),
--     ('John','Lee','johnlee@gmail.com',08),
--     ('Jack','Smith','jacksmith@gmail.com',10);


-- INSERT INTO CUSTOMER (CUSTOMER_FIRSTNAME, CUSTOMER_LASTNAME) VALUES('Zack','Huang');
INSERT INTO TRANSACTION_TABLE (transaction_id, customer_id, create_year,create_month,create_day,transaction_amount) VALUES
    (1,1,2023,8,5,55),
    (2,1,2023,9,2,120),
    (3,1,2023,9,5,255),
    (4,1,2023,10,5,33),
    (5,2,2023,8,5,155),
    (6,2,2023,9,5,155),
    (7,2,2023,10,5,155),
    (8,3,2023,8,5,55),
    (9,3,2023,9,5,200),
    (10,3,2023,9,5,155);
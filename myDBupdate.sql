/*OUTPUT CHANGES IN QUERY 1*/
Delete FROM f18_25_cust_buys where CustomerID = 'C032' and Product_ID = 'P025' and Store_ID = 'S01' and buy_date = DATE '2018-08-17';

/*Output changes in Query 2 */
INSERT INTO F18_25_CUST_BUYS(CustomerID,Product_ID,Store_ID,Quantity,Buy_date,Price,buy_type) values ('C005','P001','S01',1,DATE '2018-10-12',100.00,'Normal');
INSERT INTO F18_25_CUST_BUYS(CustomerID,Product_ID,Store_ID,Quantity,Buy_date,Price,buy_type) values ('C006','P001','S01',1,DATE '2018-10-12',100.00,'Normal');
INSERT INTO F18_25_CUST_BUYS(CustomerID,Product_ID,Store_ID,Quantity,Buy_date,Price,buy_type) values ('C011','P001','S01',1,DATE '2018-10-13',100.00,'Normal');
INSERT INTO F18_25_CUST_BUYS(CustomerID,Product_ID,Store_ID,Quantity,Buy_date,Price,buy_type) values ('C005','P001','S01',1,DATE '2018-10-11',100.00,'Normal');

/*Output changes in query 3 */
INSERT INTO F18_25_CUST_BUYS(CustomerID,Product_ID,Store_ID,Quantity,Buy_date,Price,buy_type) values ('C005','P001','S01',1,DATE '2018-08-13',100.00,'Normal');
INSERT INTO F18_25_CUST_BUYS(CustomerID,Product_ID,Store_ID,Quantity,Buy_date,Price,buy_type) values ('C006','P001','S01',1,DATE '2018-08-13',100.00,'Normal');

/*OUTPUT CHANGES IN QUERY 4*/
UPDATE F18_25_CUST_BUYS SET buy_type='Call' WHERE store_id='S03' AND CUSTOMERID IN ('C013','C014');

/*OUTPUT CHANGES IN QUERY 8*/
INSERT INTO F18_25_EMPLOYEE (EmployeeID,FirstName,LastName,StoreID,Gender,DOB,Address,EmployeeType,EmploymentType,FromDate,ToDate,EmploymentWage) VALUES ('E011','Arno','Dorian','S03','Male','08-01-1996','603 Notre dame ave','Cashier','Permanant','08-10-2018','Present',350);

/*OUTPUT CHANGES IN QUERY 9*/
UPDATE f18_25_has set quantity_of_reserved_products=25 where product_id='P013' OR product_id='P012';

/*OUTPUT CHANGES IN QUERY 10*/
DELETE FROM f18_25_has where warehouse_id='W001' and product_id in('P036','P019','P021','P035','P028','P001');

/*OUTPUT CHANGES IN QUERY 11*/

INSERT INTO F18_25_DELIVERY(STR_ID,CUST_ID,Delivery_date,STAGE)
VALUES('S01','C003',DATE '2018-08-13',3);
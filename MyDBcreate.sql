/*Create table for F18_25_Store*/
CREATE TABLE F18_25_Store(Store_ID VARCHAR(3) PRIMARY KEY, Store_Name VARCHAR(10), Contact NUMBER, Street VARCHAR(20), City VARCHAR(10), Zip NUMBER);

/*Create table for F18_25_Customer*/
CREATE TABLE F18_25_Customer(Customer_ID VARCHAR(10) PRIMARY KEY, First_Name VARCHAR(10), Last_Name VARCHAR(10));

/*CREATE table for Regular F18_25_Customer*/
CREATE TABLE F18_25_REGULAR_CUST(CustomerID varchar(10) REFERENCES F18_25_Customer(Customer_ID) ON delete set NULL, Address varchar(25),Contact varchar(10),Cardnumber varchar(9),cardtype varchar(10),cardIssueDate varchar(10));

/*Create table for Call_order_Customer*/
CREATE TABLE F18_25_Call_Order_Customer(Cust_ID VARCHAR(4) REFERENCES F18_25_Customer(Customer_ID) ON delete set NULL, Address VARCHAR(40), Cust_Contact VARCHAR(20));

/*Create table for F18_25_Supplier*/
CREATE TABLE F18_25_Supplier(Supplier_ID VARCHAR(5) PRIMARY KEY, Supplier_Type VARCHAR(20), Supplier_Name VARCHAR(30));

/*Create table for F18_25_Product*/
CREATE TABLE F18_25_Product(Product_ID VARCHAR(4) PRIMARY KEY, Name VARCHAR(20), Brand VARCHAR(20), Supp_ID VARCHAR(5) REFERENCES F18_25_Supplier(Supplier_ID), Product_Type VARCHAR(20));

/*Create table for F18_25_Phone*/
CREATE TABLE F18_25_Phone(Supp_ID VARCHAR(5) REFERENCES F18_25_Supplier(Supplier_ID), Phone_Number NUMBER PRIMARY KEY);

/*Create table for F18_25_Delivery*/
CREATE TABLE F18_25_Delivery(Str_ID VARCHAR(3) REFERENCES F18_25_Store(Store_ID),Cust_ID VARCHAR(4) REFERENCES F18_25_Customer(Customer_ID),Delivery_date Date, Stage NUMBER);

/*Create table for Employee*/
CREATE TABLE F18_25_EMPLOYEE (EmployeeID varchar(10) PRIMARY KEY, FirstName varchar(15), LastName varchar(15), StoreID varchar(5) NOT NULL REFERENCES F18_25_Store(Store_ID),Gender varchar(6),DOB varchar(10),Address varchar(30), EmployeeType varchar(15),EmploymentType varchar(10),FromDate varchar(10),ToDate varchar(10), EmploymentWage Number(10) );

/*Create table for WareHouse*/
CREATE TABLE F18_25_WAREHOUSE(WarehouseID varchar(11) primary key,Address varchar(25));

/*Create table for F18_25_Cust_Buys*/
CREATE TABLE F18_25_Cust_Buys (CustomerID varchar(10) REFERENCES F18_25_customer(Customer_ID) ON delete set NULL, Product_ID varchar(10) References F18_25_Product(Product_ID),Store_ID varchar(10) REFERENCES F18_25_STORE(Store_ID), Quantity Number(3),Buy_date Date, Price float(2),Buy_Type varchar(10));

/*Create Table for Supplier_Buys*/

CREATE TABLE F18_25_SUPPLIER_BUYS(Supplier_ID varchar(10) References F18_25_Supplier(Supplier_ID),Warehouse_ID References F18_25_WAREHOUSE(WarehouseID),buy_date DATE ,Amount_paid float(2));

/*Create table for F18_25_Supplier_Purchase*/
CREATE TABLE F18_25_Supplier_Purchase(Supplier_ID VARCHAR(10) references F18_25_Supplier(Supplier_ID),Product_ID references F18_25_Product(Product_ID),Warehouse_ID references F18_25_WAREHOUSE(WarehouseID),Sup_Buy_Date DATE,Quantity NUMBER(3),Purchase_Price FLOAT(2));

/*Create table for F18_25_Has*/
CREATE TABLE F18_25_Has(Warehouse_ID references F18_25_WAREHOUSE(WarehouseID),Store_ID references F18_25_Store(Store_ID),Product_ID references F18_25_Product(Product_ID),Quantity_of_Reserved_Products NUMBER(3));

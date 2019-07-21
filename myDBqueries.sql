/*
=====================================================================English Query 1===============================================================
|Select which product brand was purchased most at each store, by joining product table and cust_buys table and finding the count of product ids   |
|grouping them with store id and product brand and finding each stores' maximum count value.                                                      |
===================================================================================================================================================
*/
Select str,brd,cnt from 
	(select F18_25_cust_buys.store_id as str,F18_25_product.brand as brd,count(F18_25_cust_buys.product_id) as cnt 
	from F18_25_product,F18_25_cust_buys 
	where F18_25_product.product_id=F18_25_cust_buys.product_id 
	group by F18_25_cust_buys.store_id,F18_25_product.brand 
	order by F18_25_cust_buys.store_id)
 where cnt in 
	(select max(cnt) 
		from(
			select F18_25_cust_buys.store_id as str,F18_25_product.brand as brd,count(F18_25_cust_buys.product_id) as cnt
			from F18_25_product,F18_25_cust_buys 
			where F18_25_product.product_id=F18_25_cust_buys.product_id
			group by F18_25_cust_buys.store_id,F18_25_product.brand 
			order by F18_25_cust_buys.store_id) brcnt 
			group by str);
/*
Expected results
----------------
S01        Amul                         24
S02        Oakfarms                     14
S03        Amul                         15
*/

/*
=====================================================================English Query 2===============================================================
|Select which product type was sold most in a particular period, by joining product table and cust_buys table and finding the count of product ids|
|and finding the product type having maximun count                                                                                                |
===================================================================================================================================================
*/
Select product_type,cnt 
from 
	(select F18_25_product.product_type as product_type,count(F18_25_cust_buys.product_id) as cnt from F18_25_product,F18_25_cust_buys where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '2018-08-13' and date '2018-10-16')
	group by F18_25_product.product_type) 
where cnt = (select max(cnt) 
			from 
				(select count(F18_25_cust_buys.product_id) as cnt 
				from F18_25_product,F18_25_cust_buys 
				where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '2018-08-13' and date '2018-10-16')
				group by F18_25_product.product_type));
/*
Expected Results
----------------
Dairy                        92
*/

/*
=====================================================================English Query 3===============================================================
|Select store id and revenue of each store in a particular period, by joining product table and cust_buys table and finding the sum of prices of  |
|the products bought between particular dates and grouping it by store id.                                                                        |
===================================================================================================================================================
*/
select F18_25_cust_buys.store_id,sum(F18_25_cust_buys.price*F18_25_cust_buys.quantity) as revenue
from F18_25_cust_buys,F18_25_product 
where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '2018-08-13' and date '2018-08-16') 
group by F18_25_cust_buys.store_id;
/*
Expected Results
----------------
S01              1382
S02               930
S03               900
*/

/*
=====================================================================English Query 4===============================================================
|Select store id with minimum call order count using cust_buys table and finding the number of call orders for each store by using group by and   |
|finding the minimum value for the call order count of each store.                                                                                |
===================================================================================================================================================
*/
select str, call_order_cnt 
from 
	(Select store_id as str,count(buy_type) as call_order_cnt  from F18_25_cust_buys where buy_type = 'Call'  group by store_id) 
	where call_order_cnt = (select min(typcnt) 
					from (Select store_id as str,count(buy_type) as typcnt  
						  from F18_25_cust_buys 
						  where buy_type = 'Call'  
						  group by store_id));
/*
Expected Results
----------------
S03                    14
*/

/*
=====================================================================English Query 5===============================================================
|Select total expense on Gold card by joining regular_cust table and cust_buys table and grouping it by buy_date,customer_id and customer_type and|
|finding the sum of expenses.                                                                                                                     |
===================================================================================================================================================
*/
select (sum(tot)/100)*10 as gold_discount 
from (select cid,sum(prc) as tot,dat,ctyp 
	from (select F18_25_cust_buys.customerID as cid,F18_25_cust_buys.buy_date as dat,F18_25_regular_cust.cardtype as ctyp,F18_25_cust_buys.price as prc 
	from F18_25_cust_buys,F18_25_regular_cust 
	where F18_25_regular_cust.customerID = F18_25_cust_buys.customerID) 
	group by dat,cid,ctyp 
	having sum(prc) >800 and ctyp = 'Gold');
/*
Expected Results
----------------
462
*/

/*
=====================================================================English Query 6===============================================================
|Select total expense on Silver card by joining regular_cust table and cust_buys table and grouping it by buy_date,customer_id and customer_type  |
|and finding the sum of expenses.                                                                                                                 |
===================================================================================================================================================
*/
select (sum(tot)/100)*5 as silver_discount 
from (select cid,sum(prc) as tot,dat,ctyp 
	 from (select F18_25_cust_buys.customerID as cid,F18_25_cust_buys.buy_date as dat,F18_25_regular_cust.cardtype as ctyp,F18_25_cust_buys.price as prc 
			from F18_25_cust_buys,F18_25_regular_cust 
			where F18_25_regular_cust.customerID = F18_25_cust_buys.customerID) 
			group by dat,cid,ctyp 
			having sum(prc) >500 and ctyp = 'Silver');
/*
Expected Result
---------------
374
*/

/*
=====================================================================English Query 7===============================================================
|Select location which is getting frequent call orders from customers by joining call_order table and Customer table and finding count of call    |
|order customer addresses and grouping it by customer address and then finding the maximum of the count.                                          |
===================================================================================================================================================
*/
Select call_order_location 
from (select F18_25_Call_Order_Customer.Address as call_order_location, count(F18_25_Call_Order_Customer.Address)as cadcnt 
	 from F18_25_cust_buys,F18_25_Call_Order_Customer 
	 where F18_25_cust_buys.customerID = F18_25_Call_Order_Customer.Cust_ID 
	 group by F18_25_Call_Order_Customer.Address) 
where cadcnt = (Select max(cadcnt) 
				from (select F18_25_Call_Order_Customer.Address as cad, count(F18_25_Call_Order_Customer.Address)as cadcnt from F18_25_cust_buys,F18_25_Call_Order_Customer 
					  where F18_25_cust_buys.customerID = F18_25_Call_Order_Customer.Cust_ID 
					  group by F18_25_Call_Order_Customer.Address));
/*
Expected Results
----------------
76010
*/

/*
=====================================================================English Query 8===============================================================
|Select store with maximum expense by joining store and employee tables and finding the expenses on employee wages and group it by store_id and   |
|sum it with maintenance charge and purchase price from supplier_ purchase table and find the maximum expense.                                    |
===================================================================================================================================================
*/
SELECT STR,EXPENSE 
FROM (select str,sumewage+5000+(select sum(purchase_price) as sprice 
	 from f18_25_supplier_purchase where (sup_buy_date between DATE '2018-08-11' AND DATE '2018-08-14')) as Expense 
	 from(select str,sum(ewage) as sumewage 
		  from(select f18_25_store.store_id as str,f18_25_employee.employmentwage as ewage 
			   from f18_25_employee,f18_25_store 
			   where f18_25_employee.storeid=f18_25_store.store_id) 
			   group by str))
WHERE EXPENSE= (SELECT MAX(EXPENSE) 
				FROM (select str,sumewage+5000+(select sum(purchase_price) as sprice 
					  from f18_25_supplier_purchase 
					  where (sup_buy_date between DATE '2018-08-11' AND DATE '2018-08-14')) as Expense 
					  from(select str,sum(ewage) as sumewage 
						   from(select f18_25_store.store_id as str,f18_25_employee.employmentwage as ewage 
								from f18_25_employee,f18_25_store 
								where f18_25_employee.storeid=f18_25_store.store_id) 
								group by str)));
/*
Expected Result
---------------
S01       8540
*/

/*
=====================================================================English Query 9===============================================================
|Select warehouse_id, product_id for which the quantity of products is minimum by joining has table and sub query resulting in minimum quantity of|
|reserved products grouped by warehouse_id, on quantity and warehouse_id.                                                                         |
===================================================================================================================================================
*/
SELECT f18_25_has.warehouse_id,f18_25_has.product_id,f18_25_has.quantity_of_reserved_products 
from f18_25_has 
inner join
	(select f18_25_has.warehouse_id,min(Quantity_of_reserved_products) as minqnt 
	from f18_25_has 
	group by warehouse_id) qnt 
on f18_25_has.quantity_of_reserved_products=qnt.minqnt and f18_25_has.warehouse_id=qnt.warehouse_id;
/*
Expected Result
---------------
W001        P012                            20
W001        P013                            20
W002        P036                            21
W003        P027                            20
W002        P015                            21
W002        P040                            21
W002        P021                            21
*/

/*
=====================================================================English Query 10==============================================================
|Select warehouse_id which has the less number of products by finding count of products in each warehouse by grouping it by warehouse_id and      |
|finding th minimum of the reserved product count.                                                                                                |
===================================================================================================================================================
*/

SELECT warehouseid 
FROM (SELECT warehouse_id as warehouseid,COUNT(PRODUCT_ID) as PCNT 
	 FROM f18_25_has GROUP BY warehouse_id) 
	 where PCNT=(SELECT MIN(PCNT) 
				FROM
			    (SELECT warehouse_id,COUNT(PRODUCT_ID) as PCNT 
				from f18_25_has 
				GROUP BY warehouse_id));
/*
Expected Result
---------------
W003
*/

/*
=====================================================================English Query 11==============================================================
|Select Store_id and total delivery charge for each store by calculating delivery charges using stages for each call order delivery using charges |
|for each stage provided in requirements and grouping by stage and store_id and then finding sum of total delivery charge grouping it agin by     |
|store_id                                                                                                                                         |
===================================================================================================================================================
*/

SELECT sid, sum(totalamnt) as TotalDeliveryCharge
FROM (SELECT str_id as sid,stage as stg,(stage*10)+10 as stdchrg,count(stage)as stgcnt,((stage*10)+10)*(count(stage)) as totalamnt 
      FROM f18_25_Delivery GROUP BY stage,str_id) GROUP BY sid;
/*
Expected Result
---------------
S01                 120
S02                 160
S03                 120
*/

/*
=====================================================================English Query 12==============================================================
|Select Store_id  which has the minimum revenue for a particular period of time by joining cust_buys table and product table and finding the sum  |
| of all revenues and grouping it by store_id and then finding minimum revenue.                                                                    |
===================================================================================================================================================
*/
Select str from 
	(select F18_25_cust_buys.store_id as str,sum(F18_25_cust_buys.price) as rev 
	from F18_25_cust_buys,F18_25_product 
	where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '2018-08-13' and date '2018-10-16') 
	group by F18_25_cust_buys.store_id) 
	where rev = (Select min(rev) 
		from (select sum(F18_25_cust_buys.price) as rev 
			from F18_25_cust_buys,F18_25_product 
			where F18_25_product.product_id=F18_25_cust_buys.product_id and (F18_25_cust_buys.buy_date between date '2018-08-13' and date '2018-10-16') 
			group by F18_25_cust_buys.store_id));
/*
Expected Results
----------------
S03
*/
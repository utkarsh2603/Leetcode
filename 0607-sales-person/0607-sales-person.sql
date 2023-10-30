# Write your MySQL query statement below
with cte as
(select sales_id 
from Orders o 
left join Company c
on o.com_id = c.com_id
where c.name like 'RED')

select name 
from SalesPerson
where sales_id not in(select distinct sales_id from cte)
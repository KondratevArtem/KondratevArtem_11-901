kondratev artem 11-901
1)
select model, speed, hd from PC where price < 500
2)
select distinct maker from Product where type = 'Printer'
3)
select model, ram, screen from Laptop where price > 1000
4)
select * from Printer where color = 'y'
5)
select model, speed, hd from PC where (cd = '12x' or cd = '24x') and price < 600
6)
select distinct p.maker, l.speed from Laptop l inner join Product p on p.model = l.model where hd >= 10
7)
select p.model, l.price from Product p inner join Laptop l on p.model = l.model where p.maker = 'B' union select p.model, pc.price from Product p inner join PC pc on p.model = pc.model where p.maker = 'B' union select p.model, pr.price from Product p inner join Printer pr on p.model = pr.model where p.maker = 'B'
8)
select distinct maker
from Product
where type = 'PC' and maker not in (select maker
from Product
where type = 'Laptop')
9)
select distinct p.maker from Product p inner join PC pc on p.model = pc.model where pc.speed >= 450
10)
select model, price from Printer where price >= (select MAX(price) from Printer )
11)
select AVG(speed) from PC
12)
select AVG(speed) from Laptop where price > 1000
13)
select avg(speed) from PC where model in (select model from Product where maker = 'A')
14)
select distinct Classes.class, Ships.name, Classes.country
from Classes join Ships on Classes.class = Ships.class
where Classes.numGuns >= 10
15)
select hd
from PC
group by hd
having count(hd) > 1
16)
select distinct A.model, B.model, A.speed, A.ram
from PC as A, PC as B
where A.model > B.model and A.speed = B.speed and A.ram = B.ram
17)
select distinct Product.type, Laptop.model, Laptop.speed
from Laptop join Product on Product.model = Laptop.model
where Laptop.speed < ALL(select speed from PC)	
18)
select distinct Product.maker, Printer.price
from Product join Printer on Product.model = Printer.model where Printer.color ='y' and Printer.price = (select min(price) from Printer where Printer.color = 'y')
19)
select maker, avg(screen)
from Product join Laptop on Product.model = Laptop.model where type ='Laptop'
group by maker
20)
select maker, count(model)
from Product where type = 'PC'
group by maker
having count(model) >= 3
21)
select maker, max(price)
from Product join PC on Product.model = PC.model where type ='PC'
group by maker
22)
select speed, avg(price)
from PC where speed > 600
group by speed
23)
select distinct maker
from PC join Product on PC.model = Product.model where speed >= 750
intersect
select distinct maker
from Laptop join Product on Laptop.model = Product.model where speed >= 750
24)
with info as (
select distinct model, price
from PC
union all
select distinct model, price
from Laptop
union all
select distinct model, price
from Printer
)
select model
from info where price = (select max(price) from info)
25)
with info as (select distinct maker, speed
from Product full outer join PC on Product.model = PC.model where maker in (select distinct maker from Product where type = 'Printer') and ram = (select distinct min(ram) from PC)
)
select maker
from info where speed = (select max(speed) from info)
26)
select price
from Product join Laptop on Product.model = Laptop.model where maker = 'A'
union all
select price
from Product join PC on Product.model = PC.model where maker = 'A'
)
select avg(price)
from info
27)
select distinct maker, avg(hd)
from Product join PC on Product.model = PC.model where maker in (select maker from Product where type = 'Printer')
group by maker
28)
with info as (
select maker, count(model) as num
from Product
group by maker
)
select count(maker)
from info where num = 1
29)
select distinct A.point, A.date, inc, out
from Income_o as A left outer join Outcome_o as B on A.point = B.point and A.date = B.date
union
select distinct B.point, B.date, inc, out
from Income_o as A right outer join Outcome_o as B on A.point = B.point and A.date = B.date
30)
with info as (
select point, date, sum(inc) as Income
from Income
group by point, date
),
info2 as (
select point, date, sum(out) as Outcome
from Outcome
group by point, date
),
info3 as (
select info.point, info.date, Income
from info, info2 where info.point = info2.point and info.date = info2.date
),
info4 as (
select info.point, info.date, Outcome
from info, info2 where info.point = info2.point and info.date = info2.date
)
(select distinct point, date, NULL as Outcome, Income
from info
except
select distinct point, date, NULL as Outcome, Income
from info3)
union all
(select distinct point, date, Outcome, NULL
from info2
except
select distinct point, date, Outcome, NULL
from info4)
union all
select info.point, info.date, Outcome, Income
from info, info2 where info.point = info2.point and info.date = info2.date



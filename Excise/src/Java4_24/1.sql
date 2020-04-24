create table purchase(
	order_id int,
	customer_id int,
	goods_id int,
	nums int
);

use java15_0424;
create table if not exists purchase1(
   order_id  int comment '订单号',
   customer_id int comment '客户编号',
   goods_id  int comment '商品编号',
   nums  int comment '购买数量'
);

CRUD
C:CREATE 新增
	insert into goods values(
	1,
	'aoliao',
	5,
	'food',
	'aoligei'
	);
	
	insert into goods(goods_id,unitprice,goods_name) values (
		2,
		10,
		'xiaoxiangchang'
		);
	一条 insert 语句可以同时插入多组记录
	insert into goods(goods_id,goods_name,unitprice) values(
		3,'qq tang',3),(
		4,'da la pian',2),(
		5,'tiaotiaoyu',1
		);
	查询操作 select
	重新建立一个表
	create table exam_result(
		id int,
		name varchar(20),
		chinese decimal(3,1),
		math decimal(3,1),
		english decimal(3,1)
	);
	插入一些数据
	insert into exam_result values
	(1,'tangsanzang',67,98,56),
	(2,'suwukong',88,77,66),
	(3,'zhubajie',88,98,90),
	(4,'caocao',82,48,60),
	(5,'liubei',70,65,74.5),
	(6,'sunqun',92,72,52.4),
	(7,'zhugelaing',99.9,99.9,98);
	查询操作
	1.全列查询
		select * from exam_result;
	2.查询指定列
		select id,name,chinese from exam_result;
	3.查询字段为表达式 
		select id,name,chinese+math+english as total from exam_result;
		select id,name,chinese+10 from exam_result;
	4.让查询字段指定别名
		通过 as 的方式可以创建别名，其中 as 可以省略
	5.去重 针对某一列去重
		select distinct math from exam_result;
		去重也可以针对多列，这些列全部一致的时候才会被当作重复元素给去掉
	6.排序
		# 按照语文升序
		select name,chinese from exam_result order by chinese;
		# 按照数学降序
		select name,math from exam_result order by math desc;
		# 按照总成绩排序(降序)
		select name,chinese+math+english as total from exam_result order by total desc;
		
		注意：
			如果没有order by,此时select 查出来的内容的循序是未定义的。
			写代码的时候不依赖这样的顺序。
	7.条件查询
		可以按照一定的条件对查找结果进行筛选
		sql中  = 表示比较相等，而不是赋值，NULL不完全 NULL = NULL 返回的是false
		select * from exam_result where chinese = 88.0;
		# 不行
		select * from exam_result where chinese = NUll;
		# 应该这样
		select * from exam_result where chinese <=> NULL;
		
		where 语句后面的条件不能使用别名(第三条语句)
			# 查询英语不及格
			select name,english from exam_result where english < 60;
			# 语文比英语好的同学
			select name,english,chinese from exam_result where chinese > english;
			# 总成绩在200分以下的同学
			select name,math+chinese+english as total from exam_result where math+chinese+english < 200;
			# 查询语文成绩大于80，英语也大于80的同学
			select name from exam_result
			where chinese > 80 and english > 80;
			# 铲鲟语文成绩大于80或者英语大于80的同学
			select name from exam_result
			where chinese > 80 or english > 80;
			注意： and 和 or 同时出现，涉及到优先级的时候，
				先计算 and ，后计算 or
			select * from exam_result
			where chinese > 80 or math > 70 and english > 70;
				+------+------------+---------+------+---------+
				| id   | name       | chinese | math | english |
				+------+------------+---------+------+---------+
				|    2 | suwukong   |    88.0 | 77.0 |    66.0 |
				|    3 | zhubajie   |    88.0 | 98.0 |    90.0 |
				|    4 | caocao     |    82.0 | 48.0 |    60.0 |
				|    6 | sunqun     |    92.0 | 72.0 |    52.4 |
				|    7 | zhugelaing |    99.9 | 99.9 |    98.0 |
				+------+------------+---------+------+---------+
			select * from exam_result
			where (chinese > 80 or math > 70) and english > 70;
				+------+------------+---------+------+---------+
				| id   | name       | chinese | math | english |
				+------+------------+---------+------+---------+
				|    3 | zhubajie   |    88.0 | 98.0 |    90.0 |
				|    7 | zhugelaing |    99.9 | 99.9 |    98.0 |
				+------+------------+---------+------+---------+
		
		
		
		
		
		
		
		
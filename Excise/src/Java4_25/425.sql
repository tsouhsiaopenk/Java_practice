查找 select
1.全列查询
	缺陷：数据量过大，可能卡死
2.指定字段查询：select [列名] from [表名]
	
3.查询字段为表达式：select [表达式] from [表名]

4.查询字段指定别名：select [表达式] as [别名] from [表名]

5.去重 distinct 指定列去重（可以是多个列），
	去重之后得到的数据和原来的数据的行数不再一一对应
	
6.排序 order by asc(升序) desc(降序)
		order by 可以使用别名
		order by 也可以指定多个列来排序，越靠前的优先级越高
		NULL 字段视为比任何值都小
		
7.条件查询 where 后面跟上一个条件，条件为真的记录将被筛选出来
	常见关系比较
		= 表示相等
		<=> 表示 NULL 安全的相等
		< <= >=
	between and 指定一个前闭后闭区间
		查找语文成绩在[80，90)之间的同学
		select name,chinese from exam_result 
		where chinese between 80 and 90;
		也可以使用 and
		select name,chinese from exam_result
		where chinese>=80 and chinese <= 90;
	in
		查询数学成绩是50，60，70，80
		select name,math from exam_result 
		where math in (50,60,70,80);
		等价于：
		select name,math from exam_result
		where math = 50 or math = 60 or math = 65 or math = 80;
	like 模糊匹配
		% 或者 _ 作为通配符
		% 表示任意字符出现任意次数
		_ 表示任意字符出现一次数
		
		找出所有姓孙的同学
			select * from exam_result
			where name like 'sun%';
		找到所有姓名中包含s这个字母的同学的成绩
			select * from exam_result
			where name like '%s%';
	NULL 查询
		insert into exam_result(name) values('dongzhuo');
		
		select * from exam_result
		where chinese is null;
	
	数据库经常是一个复杂后台程序中最脆弱的一环
	
		如何保护数据库，让他没那么容易挂？
			1.给数据库前头加上缓存，避免频繁访问
			2.对数据库进行备份
			3.对数据库进行拆分（分库分表）
			4.给数据库服务器搭配比较牛逼的主机
8.分页查询 limit 严格限制查找出来的结果
	// 只查看前三条
	select * from exam_result
	limit 3;
	// offset 0 :从第 0 条数据记录开始查找
	select * from exam_result
	limit 3 offset 0;
	
	select * from exam_result
	where math > 0
	order by math # order by 要放在 where 子句后面
	limit 3 offset 3;
		
		实现一个论坛，每一页包含20条记录
		第一页 ： limit 20
		第二页 ： limit 20 offset 20
		第三页 :  limit 20 offset 40
		 ....
	
修改
update [表名] set [要修改的列] = [修改之后的值]	where {筛选条件}
	
	# 把创建表时候写错的名字改过来
	update exam_result set name = 'sunwukong'
	where name = 'suwukong';
	# 把孙悟空的数学成绩改为60;
	update exam_result set math = 80
	where name = 'suwukong';
	# 把曹操的数学和语文成绩均改为 60
	update exam_result set math = 60,chinese = 60
	where name = 'caocao';
	# 总成绩倒数前三的同学成绩加上 30 分
	update exam_result set math = math - 30
	order by chinese + math + english limit 3;
	
	ERROR 1064 (42000): You have an error in your SQL syntax; 
	check the manual that corresponds to your MySQL server version 
	for the right syntax to use near 'offset 0' at line 2
	报这个错误是因为没有哪一行得到修改
	
	update exam_result set chinese = chinese / 2;

删除数据
delete from [表名] where [删除的条件];
(1) 删除姓名为唐三藏的记录
	delete from exam_result
	where name = 'tangsanzang';
(2) 删除数学成绩 小于 70 的同学
	delete from exam_result
	where math < 70;
(3) 删除语文和英语两课成绩在 [100,120]之间的同学
	delete from exam_result
	where chinese + english between 100 and 120;
(4)	删除数学成绩为null同学
	delete from exam_result
	where math is null;
	
	
进阶：
	数据库约束 -> 对数据库的表内容进行一定程度的限制和校验
		not null 不为空
		unique 唯一
		default 默认值
		primary key 主键（唯一标识）
		foreign key 外键 保证参照完整性
	注意：约束可以组合使用 
	(1)测试not null
		create table student(
			id int not null,
			name varchar(20),
			mail varchar(30)
			);
		insert into student values(null,'hehe','123@qq.com');
		测试结果 ：ERROR 1048 (23000): Column 'id' cannot be null
	(2)测试 unique
		create table student(
			id int unique,
			name varchar(20)
			);
		insert into student values(1,'hehe');
		测试结果 : ERROR 1062 (23000): Duplicate entry '1' for key 'id'
	(3)测试 default
		create table student(
		id int,
		name varchar(20) default 'unknown'
		);
		insert into student values(1,'hehe');
		insert into student values(2,null);
		insert into student(id) values(3);
		结果+------+---------+
			| id   | name    |
			+------+---------+
			|    1 | hehe    |
			|    2 | NULL    |
			|    3 | unknown |
			+------+---------+
	(4)测试主键
		create table student(
			id int primary key,
			name varchar(20) 
		);
		insert into student values(null,'hehe');
		测试结果：ERROR 1048 (23000): Column 'id' cannot be null
		insert into student values(1,'hehe');
		insert into student values(1,'hehe');
		测试结果 ： ERROR 1062 (23000): Duplicate entry '1' for key 'PRIMARY'
	(5)测试外键 ： 多个表之间存在的关联关系，才能使用外键
		drop table student;
		create table class(
			id int primary key,
			name varchar(20)
			);
		# 让 class 表中 id 和 student 表中的class_id 建立外键关系
		create table student(
		    id int primary key,
			class_id int,
			foreign key(class_id) references class(id)
			);
		
		insert into class values(1,'java15');
		insert into class values(2,'java16');	
		insert into student values(1,10);	
		测试结果 ： ERROR 1452 (23000): Cannot add or update a child row: 
		a foreign key constraint fails (`java15_0424`.`student`, 
		CONSTRAINT `student_ibfk_1` FOREIGN KEY (`class_id`) REFERENCES 
		`class` (`id`))
		原因 ： 外键约束，不存在 10 这个班级
		加强了数的校验（完整性）但是付出了效率上的代价
		insert into student values(1,2);
		
		
		
		
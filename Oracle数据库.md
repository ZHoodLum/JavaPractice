### Oracle数据库知识点

&nbsp;|目录|&nbsp;
:-|:------------------:|:--:
0|---------------------------------------------|[各数据库服务器默认端口](#各数据库服务器默认端口)
||
1|---------------------------------------------|[限定查询](#限定查询)
||
2|---------------------------------------------|[单行函数](#单行函数)
||
3|---------------------------------------------|[多表查询](#多表查询)
||
4|---------------------------------------------|[数据库操作](#数据库操作)
||
5|---------------------------------------------|[复杂查询](#复杂查询)
||
6|---------------------------------------------|[数据库表的使用及管理](#数据库表的使用及管理)
||
7|---------------------------------------------|[drop与delete与truncate区别](#drop与delete与truncate区别)
||
8|---------------------------------------------|[约束](#约束)
||
9|---------------------------------------------|[集合序列](#集合序列)
||
10|---------------------------------------------|[视图索引同义词](#视图索引同义词)
||
11|---------------------------------------------|[用户管理](#用户管理)
||
12|---------------------------------------------|[数据的备份](#数据的备份)
||
13|---------------------------------------------|[游标](#游标)
||
13|---------------------------------------------|[序列](#序列)


---
---
### 各数据库服务器默认端口
#### 服务器：
* tomcat默认端口：8080
* Apache：80
* jetty：8080
* jBoss：8080
* nginx：80
* weblogic：7001
* memcached：11211
 
#### 数据库：
* mysql：3306
* oracle：1521
* postgrsql：5432
* derby：1527
* SQL Server：1433
* DB2：50000
* sybase：5000
* mongoDB：27017
* Redis:6379

#### 组件：
* zookeeper：2184

* Axure：32767

* FTP标准命令TCP端口号：21，Port方式数据端口：20（一个是数据端口，一个是控制端口，控制端口一般为21，而数据端口不一定是20，这和FTP的应用模式有关，如果是主动模式，应该为20，如果为被动模式，由服务器端和客户端协商而定。

* FTP的端口有两种，一种是控制端口，一种传输数据的端口。

* 控制端口 21，传输数据的端口：主动模式是20，被动模式是动态的21端口用于连接，20端口用于传输数据

---

### 限定查询

* 简单查询 select [DISTINCT] *| 字段[别名] from 表明[别名] where 条件(S)

在where子句之后可以增加多个条件，

常见的条件基本关系运算：> 、 >= 、 < 、<= 、 !=( <> ) 、 not、between and 、 like 、in、 is null、 and 、or；

关系运算符： > 、 >= 、 < 、<= 、 !=( <> ) 、 not

        select * from emp where sal>1500;
        
范围运算符：between and
        1）使用between and 求反  在字段条件前加  not  ：
            范例： //查询工资在1530到3000之间员工信息
                select * from emp where not sal between 1530 and 3000; 

        2）同时between and 也可以用于日期格式 ，要求日期要用字符串格式 ： 
            范例：//查询 入职日期在1981-1-1到1981-12-31之间的员工信息
                select * from emp where hiredate between '1-1月-1981' and '31-12月-1981';
                
判断是否为空： is( not ) null
        范例：//查询奖金的员工信息
             select * from emp where comm is not null;
             
指定范围的判断：In操作符，是指定一个查询范围； 其中 not in 指的是不再这个范围内。

        范例： //查询员工信息   编号是 7363、7566、7799
            select * from emp where empno=7963 or empno=7566 or empno= 7799;
            select * from emp where empno in(7363,7566,7799);
            select * from emp where empno not  in(7363,7566,7799);

  注意：关于not  in问题
  
  如果现在使用的是not  in操作符，如果查询范围之中有了null,则不会有任何查询结果返回；如果NOT In 中 出现了NUll 则表示就是查询全部数据。

---

* 模糊查询：LIKE子句：提供了模糊查询的查找操作。例如：某些程序出现的搜索操作，都属于LIKE子句的实现，但是必须提醒，搜索引擎上的查询不是LIKE查询。

     LIKE匹配字符：     匹配单个字符：“   _  ”;            匹配任意多个字符： “ % ”；

            范例：要求查询雇员姓名以字母A开头的全部雇员信息
                select * from emp where ename like 'A%';

            范例： 要求查询雇员姓名第二个字母为A的雇员信息
                select * from emp where ename like '_A%';

            范例： 要求查询雇员姓名带有字母为A的雇员信息
                select * from emp where ename like '%A%';

            范例：可以使用NOT操作符进行求反操作：
                select * from emp where ename not like '%A%';

            注意：对于LIKE子句，不一定只在字符串数据上使用，可以在任意字段上使用；
                   如果在模糊查询上不设置任何查询关键字的话（%%），则表示查询全部记录；这一特带你帮助用户介乎很多代码
                范例：select * from emp where ename  like '%1%' or  hiredate LIKE '%1%' or sal LIKE '%1%';
---

* 数据的排序（重点）

        1）当数据返回结果后，所有数据的默认情况下是按照雇员编号进行排序的。
        
        2）使用ORDER BY 子句指定所需要的排序的操作列。
        
        3）格式：
        
        select [disinct] *|字段[别名] from 表名称[别名] where 条件 [order by 字段 [ASC|DESC ] [字段 [ASC|DESC],]];

        4）order by 子句是写在所有sql语句最后的内容。
        
---

### 单行函数
(重点)每个数据库都支持SQL语句的，但是每个数据库有自己所支持的操作函数，这就是单行函数。
单行函数主要分为五类：字符函数、数字函数、日期函数、转换函数、通用函数。

#### 字符函数：对字符串进行操作。
```
1）UPPER（字符串|列）：将输入的字符串变为大写返回；
                    作用：用户输入数据的时候，他不会关心大小写的，所以这个时候使用UPPER，
                        范例：select  * from emp where ename=UPPER('simth');
                           -- 这里的‘&’的操作属于替代变量内容，不做重点。
                        范例：select  * from emp where ename=UPPER('&str');

2）LOWER（字符串|列）：将输入的字符串变为小写返回；
                        范例：select  LOWER(ename) from emp;

3）INITCAP（字符串|列）：开头首字母大写；
                        范例：select INITCAP(ename) from emp;

4）LENGTH(字符床|列)：求出字符串的长度；
                        范例： select  LENGTH(ename) from emp;

5）REPLACE(字符串|列)：进行替换；    格式：   REPLACE(替换列（内容）,'替换前','替换后')
                        范例： select REPLACE(ename,'A','_') from emp;

6）SUBSTR（字符串|列，开始点，结束点）：字符串的截取。
                      SUBSTR（字符串|列，开始点）    表示从开始一直到结束点；
                      SUBSTR（字符串|列，开始点，结束点）  表示从开始一直到结束点，截取部分内容
                      设置负数，表示从后指定字符串位置

                           范例 select ename,SUBSTR(ename,1,3) from emp;
                           范例：截取字符串后三位长度
                                   select ename,SUBSTR(ename,-3) from emp;
面试题：请问：SUBSTR(函数截取的时候是从下标 0 开始的还是 1 开始的？
             在oracle数据库中 ，substr（）函数从1或1开始都是一样的。
            substr也可以设置为负数，表示指定从后面指定字符串位置的。
```
-------------------------------------------------------手动分割线------------------------------------------------------ 

#### 数字函数
```

1）round(数字|列  [可选的保留小数位数] )：四舍五入操作；
                    范例：select round( 903.5222 ) from dual; ------------>904
                    范例：select round( 903.5434 , 2 ) from dual; ------------>904.54
2）trunc(数字|列  [可选的保留小数位数] )：舍弃指定位置的内容；
                    范例：select trunc( 903.555 ) from dual; ------------>903
                    范例：select trunc( 903.545 , 2 ) from dual; ------------>903.54
3）mod(数字1，数字2)：取模，取余数。
                    范例：select mod( 10,3 ) from dual; ------------>1
    以上的三个重要函数，在JAVA中也会有相匹配的内容。
```
-------------------------------------------------------手动分割线------------------------------------------------------- 

#### 日期函数:
```
1）sysdate取得当前日期。
                     范例：select sysydate from dual;------->18-8月-2018

2）日期 + 数字 = 日期：表示若干天后的日期；
                     范例：select sysydate +300 from dual;------->10-6月-2019

3）日期 - 数字 = 日期：表示若干天前的日期；

4）日期 - 日期 = 数组；表示日期间的天数，但肯定是大日期-小日期；
                 范例：select ename,hiredate,sysdate-hiredate from emp;--------------->11198.6925等等诸多数据。

    在很多变成语言当中，会提出一种概念，日期可以通过数组表示出来。除了以上的三个公式之外，还有四个操作函数：

1.1）last_day(日期)：求出指定日期的最后一天；
                             范例：select last_day(sysdate) from dual;

1.2）next_day(日期，星期数)：求出下一个指定星期X的日期；
                             范例：select  next_day(sysdate,'星期一') from dual;

1.3）add_months(日期，数字)：求出若干月后的日期；
                             范例：select add_months(sysdate,4) from dual;

1.4）months_between(日期1，日期2)：求出两个月之间所经历的月份。
                             范例：select months_between(sysdate,hiredate) from dual;
                            范例：select trunc(months_between(sysdate,hiredate)) from dual;

    注意：开发过程中，建议使用以上函数，可以避免闰年的问题！！！
```
-------------------------------------------------------手动分割线----------------------------------------------------

#### 转换函数（核心）
数字（number）、字符串（varchar）、日期（date），转换函数主要是将这几种数据间的相互转换操作，一共有三种转换函数：
```
1）to_char(字符串|列  ， 格式字符串)：将日期或者数字转换为字符串显示；
             范例：select sysdate from dual;----------->18-2-1963           日-月-年，不符合正常思维。

             to_char 格式化并定义日期格式：年-yyyy   月-mm  日-dd     hh   时  :   mi   分  :  ss  秒
             范例：select to_char(sysdate,'yyyy-MM-dd') from dual;----------->2018-2-2

             使用to_char(0函数之后，所有内容都是字符串形式，不再是之前的DATE数据，to_char(0函数可以用于数字的格式化上。 
             其中数字9表示每一位数字中的概念，而不是数字9的概念；
             范例：select to_char(9895949494,'999,999,999,999') from dual;------>    9,895,949,494

             其中  L 表示“Locale”含义，表示货币符号￥。
             范例：select to_char(9895949494,'L999,999,999,999') from dual;------>  ￥9,895,949,494

2）to_date(字符串|列 ， 格式字符串)：将字符串转换为DATE数据显示；
         一般在更新数据库中使用；
             范例：select to_date('1996-08-08','yyyy-MM-dd') from dual;----------->1996/8/8

3）to_number(字符串)：将字符串转换为数字显示。但是oracle比较只能，基本不用。
             范例：select to_number('1') + to_number('2') from dual;------>3
```
-------------------------------------------------------手动分割线----------------------------------------------------
#### 通用函数（核心）
通用函数主要是由两个：NVL()、DECODE(),属于Oracle数据库的特色
```
1）NVL（）函数，处理Null：

             范例：要求查询每个雇员的全部奖金
                          select ename,sal,comm,(sal+comm)*12 from emp; 

         这个时候由雇员的年薪就变成了bull,而造成这种问题的 关键是在于comm字段上的null,
     那么解决这个问题，就必须作一种处理，将null变为0，而这个就是NVL（）函数：
           范例：select ename,sal,comm,(sal+nvl(comm,0))*12 from emp; 

2）DECODE()函数：多数值判断；这个是oracle数据库最具有特点的函数，要求记住。

        decode()函数非常类似于程序中的if else语句，唯一不同的是decode（）函数判断的是数值，为不是逻辑条件。

           范例：要求显示全部雇员的职位，但是这些职位要求替代为中文显示。
                    CLERK:办事员
                    SALESMAN:销售
                    MANAGER:经理
                    ANALYST:分析员
                    PRESIDENT:总裁
          这种情况肯定是进行判断，所以这个时候就要使用decode()函数：
          语法：  decode(数值|列 ，判断值1，显示值1，判断值2，显示值2，判断值3，显示值3.........）
                select empno,ename,job,decode(job,'CLERK','办事员','SALESMAN','销售') from emp;
```

---

### 多表查询

### 多表查询（重点）

```
格式：select *|列 [列名] .......    from 表名 [ 别名]，表名[别名] where  条件。
范例：select e.ename,d.dname  from  emp e,dept d  where  e.deptno=d.deptno;

查询表中的数据量：

范例：select count(*) from emp;
```

* 经验所得: 到公司，别以上来就查询数据信息，数据信息上万条，数据量较大，不要去直接查询表信息，先看看由多少条数据：

```
重点范例：select count(*) from emp;
```

---



* 笛卡尔积：表示多表数据乘积的意思，这种情况是我们不愿意看到的。

```
范例：select * from emp,dept;

所以：解决笛卡尔积办法,使用多表连接查询，加上限制条件。
范例：select * from emp,dept where emp.deptno=dept.deptno;
```

* 数查询结果消除了笛卡尔积，但是只属于显示上的显出，真正的笛卡尔积依然存在，因为数据库的操作机制属于逐行
     进行数据判断，现在假设两个表的数据量很大，在这种情况下使用多表查询的性能，查询结果会很慢或者不显示。
     多表查询性能(前提是数据量大！上万条或更多！！！），数据量小的话可以使用（几千条数据！！！）。
     开发过程中，尽量避免多表查询，可以把数据方法一个表中，单表查询速度快。

```
但是以上范例程序中，出现了表名过程，需要为表名 建立一个别名去简化。
     范例：select * from emp e ,  dept d where e.deptno=d.deptno;
```

```
思考步骤：
1)查询所需要的表：    
     emp表( 雇员); 取得雇员姓名、职位、领导编号。
     emp表( 领导 );取得雇员的姓名（领导姓名）。
2)确定关联字段：雇员领导编号 = 领导（雇员）的雇员编号

  范例：select e.ename ,e.job,m.ename from emp e,emp m where e.mgr=m.empno;
     其中查询结果中没有King的记录，因为KING没有领导，他是老大，而解决这个问题，就涉及到左、右连接问题。
```

练习：
```
范例：查询每个雇员姓名，编号，基本工资，领导姓名，部门名称及位置。
1)查询所需要的表： 
         emp表( 雇员); 取得雇员姓名、职位、领导编号，基本工资。
         emp表( 领导 );取得雇员的姓名（领导姓名）。
         dept表：部门名称及位置。

2)确定关联字段：
         雇员和部门：  emp.deptno=dept.deptno
         雇员和领导：  emp.mgr = memp.empno

         select e.empno,e.ename,e.sal,e.job,m.ename from emp e,emp m ,dept d
         where e.mgr=m.empno and e.deptno=d.deptno;
```

### 左右连接：关于左右连接，指的是查询判断条件的参考方向。

```
范例：select * from emo e,dept d where e.deptno(+) =d.deptno;
```

* 1）使用（+）用于左右连接的更改

>* (+)= ：放在了等号的左边，表示右连接；
>* = (+)：放在了等号的右边，表示左连接；

* 但是我们不用刻意去区分左右，知识根据查询结果去定，如果发现查询结果没有我们想要的信息，就可以此符号进行更改连接方向，这个是oracle数据库独有的特性，其他数据库不具备。


---


### 需要使用SQL：1999语法：

* 1、交叉连接：（cross join）:用于产生笛卡尔积。

```
select * from emp cross join dept;
```
>* 注：笛卡尔积本身并不属于无用的内容，在某些情况下还需要使用的。

* 2、自然连接：natural join:用于消除笛卡尔积。

```
select * from emp natural join dept;
```
>* 注：但是并不是所有字段都是关联字段，设置关联字段需要通过约束指定。

* 3、 join............ using子句：用户自己指定一个消除笛卡尔积的关联字段。

```
select * from emp join dept using(deptno);
```

* 4、join.......on子句：用户可以自己指定一个消除笛卡尔积的关联条件。

```
select * from emp join dept on(emp.deptno=dept.deptno);
```

* 5、连接方向的改变。

>* 左(外)连接：left outer join....on;
>* 右(外)连接：right outer join....on;
>* 全(外)连接：full outer join....on;--------->把两张表中没有的数据全部显示。

>>* 注：在oracle之外的数据库都是用以上的SQL：1999语法操作，所以这个语法还必须会一些。
>>* 多表查询肯定不高，早大量数据中才会发现，在开发过程中，能不用则不用。

---

### 统计函数（重点）
* 常用的统计函数：count()、avg()、sum()、max()、min().

>* count(): 查询表中的数据记录；
>* avg(): 求出平均值；
>* sum(): 求和；
>* max(): 求出最大值；
>* min(): 求出最小值；
```
范例：统计出公司所有雇员，每个月支付的平均工资及总工资,最大工资，最小工资
select count(*),sum(sal),avg(sal),min(sal),max(sal) from emp;
```
* 注意：count()函数查询的表中即使没有数据记录，结果也会返回数据，返回数据值是：0；如果使用其他函数，返回数据会为null,如果使用count()函数，无论什么情况下，都会返回数据值。

---


### 分组查询（重点）
* 什么情况下会进行分组，信息保存在数据库之中，那么在数据的某一列上肯定会存在重复的内容，例如：性别分组（男或女），等等
所以在分组中有一个不成文的规定，当数据重复的时候分组才有意义，因为一个人也可以一组（没有意义）。
而如果要想分组，需要使用子句group by子句进行使用。


* 格式：
```
select distinct *|列，[分组字段1],[分组字段2]....
from 表名 [别名]
where 条件
group by 分组字段1，分组字段2.......
order by 排序字段 ASC|DESC [排序字段 ASC|DESC]；
注意：group by 必须写在order by字段前面。order by必须写在SQL语句最后面。

```

* 范例：
```
select deptno,count(empno),avg(sal) from emp group by deptno;
查询出领取佣金和不领取佣金的雇员人数及平均工资
select comm,count(empno),avg(sal) from emp group by comm;

注意：
1）分组函数可以在没有分组的情况下单独使用，但是不能出现其他的查询字段。
         分组函数可以单独使用：select count(empno) from emp;
         错误的使用，出现了其他字段：select ename,count(empno) from emp;
2）如果现在要进行分组的话，则select子句之后，只能出现分组的字段和统计函数，其他字段不能出现。
3）分组函数允许嵌套。
4）在where子句中不能使用分组函数。
5）如果在对分组后的数据进行过滤，这时候就要使用：`having`

----------------------------------------------------------------------------------------------------------------------------------------------
查询出每个部门的名称，部门人数，位置，平均工资。
select  d.deptno,d.dname,d.loc,count(emp),nvl(avg(e.sal),0)
from emp e,dept d 
where d.deptno=e.deptno(+)
group by d.dname,d.deptno,d.loc;
having avg(sal)>2800;

注意：
1）对数据进行分组，表可以是实体表（emp,dept），也可以是虚拟表（查询的出来的表），只要是有重复内容，就可以进行分组
2）where :  是在执行group by操作之前进行的过滤，表示从全部数据中选出部分的数据；在where不能使用统计函数
3）having :  是在group by 分组之后的再次过滤，可以在having使用统计函数。

```

---

### 数据库操作


### 数据库操作
     DML语法中，除了查询之外还有数据库的更新操作，数据的更新操作：增加、修改、删除数据。

#### 表的赋值

##### 格式：表的赋值：create table [复制产生的表的表名]  as  [查到这个表的信息并复制（select * from emp）];
* 注意：这个语法是oracle中支持的操作，其他数据库不一样。

#### 数据的增加

##### 格式：insert into 表名(字段1，字段2.......) values(值1，值2............);
如果想要增加数据，则一下几种数据类型要分别处理：
* 增加数字：直接编写数字；
* 增加字符串：使用单引号 ` ' `
* 增加DATE数据：
>* 第一种：可以按照已有的字符串格式编写字符串。例如：18-2月-1998;
>* 第二种：利用to_date()函数将字符串变为date数据。在添加时间字段中这样写：to_date('1995-02-14','yyyy-mm-dd')；
>* 第三种：如果设置的时间为当前时间，则使用sysdate。

#### 数据的更新

##### 格式：update 表明 set 更新字段1=更新值1，更新字段2=更新值2...................... where 条件（s）;
```
所有人的工资上涨到7500；
update myemp  set sal=5000*1.5;
```
* 注意：如果更新的时候不加更新条件，则意味着更新全部信息，但是这种做法是不可取的，如果表中的数据量较大的话，这种更新会耗费很多的时间，性能降低。(3000-5000条数据就别这么干了，信息量太大！！！)

#### 数据的删除

##### 删除表中的某一条数据
* 格式：delete from [表名] where [条件]；

##### 删除表中的数据：
* 格式：delete from [表名] 

---

### 事务处理
#### 事务(Transaction)概念
* 事务：也称工作单元，是由一个或多个SQL语句所组成的操作序列，这些SQL语句作为一个完整的工作单元，要么全部执行成功，要么全部执行失败。在数据库中，通过事务来保证数据的一致性。



* 事务处理语言：Transaction Process Language ,简称TPL，主要用来对组成事务的DML语句的操作结果进行确认或取消。确认也就是使DML操作生效，使用提交(COMMIT)命令实现；取消也就是使DML操作失效，使用回滚(ROLLBACK)命令实现。

* 通过事务的使用，能防止数据库中出现数据不一致现象。如两个银行账户进行转账，涉及到两条更新操作，这两条更新操作只允许全部成功或失败，否则数据会出现不一致的现象

---

#### 事务特征可用四个字母的缩写表示：即ACID

* 原子性（Atomicity）

>* 事务就像“原子”一样，不可被分割，组成事务的DML操作语句要么全成功，要么全失败，不可能出现部分成功部分失败的情况。



* 一致性（Consistency）

>* 一旦事务完成，不管是成功的，还是失败的，整个系统处于数据一致的状态。



* 隔离性（Isolation）

>* 一个事务的执行不会被另一个事务所干扰。比如两个人同时从一个账户从取钱，通过事务的隔离性确保账户余额的正确性。



* 持久性（Durability）

>* 也称为永久性，指事务一旦提交，对数据的改变就是永久的，不可以再被回滚。



---

#### 事务结束
##### 显示结束
* 提交(COMMIT)：使用COMMIT命令实现，以成功的方式结束事务，组成事务的DML语句操作全部生效。

* 回滚(ROLLBACK)：使用ROLLBACK命令实现，以失败的方式结束事务，组成事务的DML语句操作全部被取消。

```

update emp set sal=9800 where empno=7799;

rollback;

commit;

```

---

##### 隐式结束

* 隐式提交：当下列任意一种情况发生时，会发生隐式提交

>* 执行一个DDL(CREATE、ALTER、DROP、TRUNCATE、RENAME）语句；

>* 执行一个DCL(GRANT、REVOKE)语句；

>* 从SQL*Plus正常退出（即使用EXIT或QUIT命令退出）；



* 隐式回滚：当下列任意一种情况发生时，会发生隐式回滚

>* 从SQL*Plus中强行退出

>* 客户端连接到服务器端异常中断

>* 系统崩溃

---
* 注意：所有事物处理操作都是针对每一个session进行的，在oracle之中，把每一个连接到数据库上的用户都称为一个session，每一个session之间彼此独立，不会有任何通讯，任何一个session独享自己的事务控制，主要使用两个命令：
```
* commit;--同时提交
* rollback;--同时失败
*  事务的回滚：rollback;更新操作回到原点；
*  事务的提交：commit; 真正发出的更新操作，一旦提交后无法更改。
*  某一个session在更新数据表的时候还没有提交事务，其他session是无法更新的，必须等待之前的session提交后才可以操作。
* 这个问题从大的方面来讲：称为死锁，但是在oracle之中死锁有很多种类，这些与开发者没有太大的关系，是由DBA负责的。
```

---

### 数据伪劣
#### rownum(核心重点)
* rownum在单词的含义上讲表示行号，但在实际意义上rownum为每一条显示的记录都会自动的随着查询生成行号。

```
范例1：此时的rownum行号并不是固定的：
select rownum,empno,ename from emp where deptno = 30;

范例2：每次动态的重新生成，可以实现数据的部分显示：
select rownum,empno,ename from emp where rownum <= 5;

范例3：显示数据的6-10条数据：
`思路：先查询前10条数据，之后再显示后5条数据，这时候要依靠子查询。`
select * from `(select rownum,empno,ename from emp where rownum <= 10)` from emp;

范例4：每页显示5条数据。
* 当前所在页数 cunentPage  为1；
* 每页显示长度：lineSize  为5；
select * from `(select rownum rn,empno,ename from emp where rownum <=5)` temp where temp.rn>0;

范例5：显示中间5条数据。
* 当前所在页数 cunentPage  为2；
* 每页显示长度：lineSize  为5；
select * from `(select rownum rn,empno,ename from emp where rownum <=10)` temp where temp.rn>5;

```

---

#### rowid(了解)
* rowid 表示的是每一行数据保存的物理地址的编号。
每一条记录的 rowid 不会重复的。 即便是表中的所有列的数据内容都重复了，rowid也不会重复。

* 面试题：请删除表中的重复记录。

```
思路一：先按照查询方式。首先找到所有重复数据，按照部门名称及位置进行分组，之后统计个数，如果个数大于1，则表示重复。
selectdname,loc,min(rowid)
from dept
group by dname,loc
having count(deptno) >1
```

* `数据插入的数据早，rowid就小`。所以下一步就是必须确定不能删除的rowid,去掉之前的限制(count() > 1),表示按照部门名称及位置分组，去除每一个最小的rowid。

```
selectdname,loc,min(rowid)
from dept
group by dname,loc；
```

* 上面的这个语句，是最开始插入的语句，所以是不删除的，下面执行delete语句操作：

```
delete from dept
where rowid not in(
selectdname,loc,min(rowid)
from dept
group by dname,loc
);
commit;
```
* 此时根据rowid完成的，就是删除重复的数据。

---

### 复杂查询

范例1：列出至少有一个员工的所有部门编号、名称，并统计 出这些部门的平均工资、最低工资、最高工资。

思路：
* 确定所需要的数据表；
>* emp表：查询员工数量；
>* dept表：部门名称；
>* emp表：统计信息

* 确定已知的关联字段；
>* emp.deptno=dept.deptno;
>* 

* 第一步：找出至少有一个员工的部门编号：
```
select deptno,count(empno)
from emp
group by deptno
having count(empno)>1;
```

* 第二步：找出部门名称，肯定用部门表，现在的数据量较小，所有可以采用多字段分组查询：
```

select d.deptno,d.dname,count(empno)
from emp e,dept d
where e.deptno=d.deptno
group by e.deptno,d.ename
having count(e.empno)>1;
```

* 第三步：整理得：
```
select d.deptno,d.dname,count(empno)，avg(sal),min(sal),max(sal)
from emp e,dept d
where e.deptno=d.deptno
group by e.deptno,d.ename
having count(e.empno)>1;
```

---

范例2：列出工资比“SMITH”或者“ALLEN” 多的所有员工的编号、姓名、部门名称、及其领导姓名

思路：
* 确定所需要的数据表；
>* emp表：查询出SMITH或ALLEN工资；
>* emp表：最终的显示需要编号、姓名；
>* emp表：领导人的姓名，自身关联；
>* dept表：部门名称；

* 确定已知的关联字段；
>* 雇员和领导：emp.deptno=dept.deptno;
>* 雇员和领导：emp.mgr = memp.empno;

* 第一步：找出SIMTH或ALLEN的工资
```
select sal
from emp
where ename in('SMITH','ALLEN');
```

* 第二步：以上的查询返回的多行单列的记录，按照子查询的要求再where 子句中写合适，这个时候将上面的查询作为子查询，继续查询符合要求的员工编号，姓名
```
select e.empno,e.ename
from  emp e
where e.sal>all(
                   select sal from emp where ename in('SMITH','ALLEN'));
```

* 第三步：查询部门名称，引入部门表，消除笛卡尔积的条件```

```
select e.empno,e.ename,d.dname
from  emp e,dept d
where e.sal>all(
                   select sal from emp where ename in('SMITH','ALLEN'))
ande.deptno=d.deptno;
```

* 第四步：查询领导信息，需要emp表自身关联
```
select e.empno,e.ename,d.dname
from  emp e,dept d,emp m
where e.sal>all(
                   select sal from emp where ename in('SMITH','ALLEN'))
and e.deptno=d.deptno
and e.mgr=m.empno;
```

---

范例3：列出所有员工的编号、姓名及其直接上级的编号、姓名，显示结果按领导年工资降序排列。

思路：
* 确定所需要的数据表；
>* emp表：查询员工编号、姓名；
>* emp表：查询领导编号、姓名年薪；

* 确定已知的关联字段；
>* 雇员和领导：emp.mgr = memp.empno;

* 第一步：
```
select e.empno,e.ename,m.empno,m.ename,(m.sal+nvl(m.comm,0))*12 incomm
from emp e,emp m
where e.mgr=m.empno(+)
order by incomm desc;
```


### 总结：

* 多表查询：在进行查询语句编写的时候，一定要确定所需要关联的数据表，而且只是表的关联查询，就一定会存在`笛卡尔积`的问题，使用关联字段可以消除笛卡尔积问题。
* 再多表查询的时候要考虑到左右连接问题，`oracle之外的数据库可以使用SQL：1999语法控制左右连接`；
* 所有统计函数适用于进行数据统计操作的，而统计要在分组中进行（或者单独使用），分组使用`GROUP BY`子句，是在某一列上存在`重复数据`的时候才使用`分组操作`，而分组后的而过滤使用`having`字句完成的，所有的分组函数可以嵌套，但是嵌套智斗的分组函数之中不能有其他的查询字段，包括分组字段。
* 子查询“结合限定查询、多表查询、分组统计查询完成各种复杂查询操作；子查询一般在where和from之后出现较多；
* 数据库的更新操作一定要受到事务控制，事务的两个命令：commit、rollback,每一个连接到数据库上的用户都是用一个session表示。

* 数据表的分页查询显示依靠在rownum伪列，在这个以后的开发之中必定100%要使用。


---

### 数据库表的使用及管理
### 表的创建及管理
（重点）

对于数据库而言实际上每一张表都表示一个数据库的对象，而在数据库对象指的就是DDL定义的所有操作，例如：表、视图、索引、序列、约束等等，都属于对象的操作，所有表的建立就是对象的建立，而对象的操作主要分为以下三类语法：

* 创建对象：  create  对象名称..............;
* 删除对象：  drop 对象名称..............;
* 修改对象 ： alter  对象名称..............;

每一张数据表实际上都是有若干个字段组成，而每一个字段都会有其对应的数据类型 ，在oracle数据库中，常用的数据类型有：

No.|数据类型|关键字|描述
:-:|:---:|:---:|:---:
1|字符串|VARCHAR2(n)|其中n表示字符串所能保存的最大长度，基本上保存200个左右的内容
2|整数|NUMBER(n)|表示最多为n的整数，有时候也可以使用int代替
3|小数|NUMBER(n.m)|其中M为小数位，n-m为整数位，有时候也可以使用float代替
4|日期|DATE|存放时间
5|大文本|CLOB|可以存储海量文字（4G），例如存储《三国演义》、《红楼梦》
6|大对象|BLOB|存放二进制数据，电影、mp3、图片

* 注意：一般在开发过程中使用最多的就是：varchar2()、number、date、clob，而对于clob字段一般使用较少，首先blob可以存放4G的二进制数据，但是存放进去之后，一是数据库过于庞大，二是读取不方便。

---

### 数据库表的创建

创建表使用的CREATE语法。
* default  表示该字段默认值           
```
create table(
name varchar2 default '无名氏',
age number(3),
bitthday date
)
```

---

### 数据库表的复制

* 格式：create table 复制表的名字 as  子查询；
```
create table emp2 as select * from emp where deptno = 20;
```


#### 重点范例：要求复制emp表的表结构复制出来，不要数据。
```
思路：写一个永远不会满足的条件即可

create table emp3 as select * from emp where 1=2;

* 划重点：这个只是复制表结构，并不包含里面的数据！！！！！并且，以上语法只是Oracle数据库所支持的操作，
其他数据库会有一些区别！！！！
```

---

### 数据库表的重命名

（了解）

* 在oracle数据库之中，所有数据实际上都是通过数据字典保存的，例如：前面使用的查询语句：
```
select * from tab;
```

* 以上就是一个数据字典，而在Oracle之中，提供了三种类型的而数据字典，最常用的是：dba_、user_，例如：查询一个user_tables数据字典：
```
select * from user_tables;
```

* 也就是说Oracle中的所有数据都是按照文件保存的，也就是说所有内容都会在数据字段中注册，既然这样，所谓的修改表名实际上对Oracle而言就是相当于修改一条数据而已，例如修改表名如下：
```
rename 旧表名称 to 新表名称；
注意：Oracle独有的特性！！！！
```

---

### 数据库表的截断表（了解）

在之前删除数据库操作，使用的是delete操作，但是这种操作本身就有一个特点，即：可以运行事务的回滚，
也就是说删除之后并不会立刻释放数据的资源，如果现在希望释放一张表所占用的全部资源（表空间、索引等等），这时候就可以使用截断表：

截断表是Oracle数据库所特有的！！！！！

```
truncat table 表名；

查看是否已经释放资源；
对事物进行回滚：
rollback;

查看是否还有数据：
select * from 表名称；
```

---

### 数据库表的删除

（了解）

表的删除操作指的是数据库删除操作，使用DROP语句：
```
格式：drop table 表名称;
```
* 注意：但是并没有全部删除干净；在 oracle 10g 的特性中，闪回技术特性！！！！

---

####  闪回技术

* 为了防止用户误删出表操作，专门提供了回收站的功能，用户删除表的默认情况下会在一个回收站之中保存，

而用户也以通过回收站，进行表的恢复操作，所以此技术成为闪回（FLASHBACK）。

```
SHOW  RECYCLEBIN ;
这时候就可以发现所有删除表都在回收站中保存，使用下面的语法进行恢复表操作：

flashback table 表名称  to  before  drop;
```

* 当然也可以直接删除回收站中的一些数据表：
```
purge table 表名称
```

* 清空回收站（重中之重）
```
purge recuclebin;
```

##### 所以说真正删除表操作如下
```
drop table 表名称 purge;
```


##### 注意（划重点）：必须在sql plus或者图形可视化界面中得command窗口下进行闪回操作。记住哈：回收站中有一张tab表，但是我又在数据库中新建了一张表，那么如果从回收站恢复的话，它是不能进行恢复的，有一点，这个一般人想不出来！！！！仔细想想Windows的回收站。！！！

---

### drop与delete与truncate区别
删除表中的数据的方法有delete,truncate, 其中TRUNCATE TABLE用于删除表中的所有行，而不记录单个行删除操作。TRUNCATE TABLE 与没有 WHERE 子句的 DELETE 语句类似；但是，TRUNCATE TABLE 速度更快，使用的系统资源和事务日志资源更少。下面介绍SQL中Truncate的用法
* 当你不再需要该表时， 用 drop；当你仍要保留该表，但要删除所有记录时， 用 truncate；当你要删除部分记录时（always with a WHERE clause), 用 delete.
* Truncate是一个能够快速清空资料表内所有资料的SQL语法。并且能针对具有自动递增值的字段，做计数重置归零重新计算的作用。
#### Truncate语法
```
[ { database_name.[ schema_name ]. | schema_name . } ]
    table_name
[ ; ]
```

#### 参数
```
database_name
数据库的名称。

schema_name
表所属架构的名称。

table_name
要截断的表的名称，或要删除其全部行的表的名称。
```
 
#### Truncate使用注意事项
```
1、TRUNCATE TABLE 在功能上与不带 WHERE 子句的 DELETE 语句相同：二者均删除表中的全部行。但 TRUNCATE TABLE 比 DELETE 速度快，且使用的系统和事务日志资源少。
 
2、DELETE 语句每次删除一行，并在事务日志中为所删除的每行记录一项。TRUNCATE TABLE 通过释放存储表数据所用的数据页来删除数据，并且只在事务日志中记录页的释放。
 
3、TRUNCATE TABLE 删除表中的所有行，但表结构及其列、约束、索引等保持不变。新行标识所用的计数值重置为该列的种子。如果想保留标识计数值，请改用 DELETE。如果要删除表定义及其数据，请使用 DROP TABLE 语句。
 
4、对于由 FOREIGN KEY 约束引用的表，不能使用 TRUNCATE TABLE，而应使用不带 WHERE 子句的 DELETE 语句。由于 TRUNCATE TABLE 不记录在日志中，所以它不能激活触发器。
 
5、TRUNCATE TABLE 不能用于参与了索引视图的表。
 
6、对用TRUNCATE TABLE删除数据的表上增加数据时，要使用UPDATE STATISTICS来维护索引信息。
 
7、如果有ROLLBACK语句，DELETE操作将被撤销，但TRUNCATE不会撤销。
```
 
#### 不能对以下表使用 TRUNCATE TABLE
```
1、由 FOREIGN KEY 约束引用的表。（您可以截断具有引用自身的外键的表。）

2、参与索引视图的表。

3、通过使用事务复制或合并复制发布的表。

4、对于具有以上一个或多个特征的表，请使用 DELETE 语句。

5、TRUNCATE TABLE 不能激活触发器，因为该操作不记录各个行删除。
```
 
 
#### TRUNCATE、Drop、Delete区别
```
1.drop和delete只是删除表的数据(定义),drop语句将删除表的结构、被依赖的约束(constrain)、触发器 (trigger)、索引(index);依赖于该表的存储过程/函数将保留,但是变为invalid状态。
2.delete语句是DML语言,这个操作会放在rollback segement中,事物提交后才生效;如果有相应的触发器(trigger),执行的时候将被触发。truncate、drop是DDL语言,操作后即 生效,原数据不会放到rollback中,不能回滚,操作不会触发trigger。

3.delete语句不影响表所占用的extent、高水线(high watermark)保持原位置不动。drop语句将表所占用的空间全部释放。truncate语句缺省情况下将空间释放到minextents的 extent,除非使用reuse storage。truncate会将高水线复位(回到最初)。

4.效率方面:drop > truncate > delete

5.安全性:小心使用drop与truncate,尤其是在 没有备份的时候,想删除部分数据可使用delete需要带上where子句,回滚段要足够大,想删除表可以用drop,想保留表只是想删除表的所有数据、 如果跟事物无关可以使用truncate,如果和事物有关、又或者想触发 trigger,还是用delete,如果是整理表内部的碎片，可以用truncate跟上reuse stroage，再重新导入、插入数据。

6.delete是DML语句,不会自动提交。drop/truncate都是DDL语句,执行后会自动提交。

7、drop一般用于删除整体性数据 如表，模式，索引，视图，完整性限制等；delete用于删除局部性数据 如表中的某一元组

8、DROP把表结构都删了；DELETE只是把数据清掉

9、当你不再需要该表时， 用 drop；当你仍要保留该表，但要删除所有记录时， 用 truncate；当你要删除部分记录时（always with a WHERE clause), 用 delete.
```

---

### 修改表结构

（了解）
* 表的修改操作，实际上是数据库对象的操作。

* 为表添加列语句

``` 
* 格式：alter table 表名称 add (列名称 数据类型 [default 默认值],
                                                列名称 数据类型 [default 默认值],
                                                列名称 数据类型 [default 默认值]...................
                                                 )；
如果增加的数据列没有默认值，则所有的数据的列的内容都是null，如果增加的列指定了defalut默认值的话，则所有已有的数据列都是设置的默认值
```

---

* 修改表的内部结构

```
* 格式：alter table 表名称 modify (列名称 数据类型 [default 默认值],
                                                列名称 数据类型 [default 默认值],
                                                列名称 数据类型 [default 默认值]...................
                                                 )；
 此语句能不用则不用，
 
Oracle修改表结构
--添加字段
alter table [tablename] add  [column name] [column data type];

--修改字段数据类型
alter table [tablename] modify [column name] [column data type];
注：增加字段长度时很顺利；变更数据类型，可能需要清空当前列数据。

--修改字段名称
alter table [tablename] rename column [column name] [new column name];

```

---

#### 思考题：现在有一张表：nation表，表中有一个name字段，里面保存四条记录：中国、美国、巴西、荷兰，要求通过查询实现如下操作：
```
* 中国    美国
* 中国    巴西
* 中国    荷兰
* 美国    巴西
* 美国    中国
* 美国    荷兰
............
剩下的以此类推，现在要求建立新的表并完成查询操作；
```

##### 本题目的主要目的并不是在于查询编写上，而是在规范化数据库创建脚本的格式，以后钥匙碰到了类似的要求，首先必须编写一个数据库创建脚本，这个脚本要求如下：

```
1、本文件的文件名称必须是“  *.sql   ”：
2、先删除相应的数据表：
drop table nation purge;

3、编写创建表的语句：
create table nation(
name varchar2(10)
)

4、增加测试数据：
insert into nation(name) values('中国')；
insert into nation(name) values('美国')；
insert into nation(name) values('荷兰')；
insert into nation(name) values('巴西)；

5、提交事务；
commit;
```

##### 执行查询语句；
```
select
from nation n1,nation n2
where n1.name<>n2.name;
```


---

### 约束

(重点)通过约束完成，约束的主要功能是保证表中的数据合法性，按照约束的分类，一共有五种约束：非空约束唯一约束、主键约束、外键约束、检查约束。

#### 非空约束(NOT NULL):NT
当数据表中的某个字段，不希望设置为null的话，则可以使用not null来指定，对字段进行约束。
```
若字段进行非空约束，插入数据时，没有添加某字段数据，就会报错：
ORA-01400:无法将null 插入("SCOTT","MEMBER","NAME");
本程序中显示出“用户”，“表名称”，“字段” 出现了错误。
``` 

#### 唯一约束(UNIQUE):UK
唯一约束指的是每一个列上的数据不允许重复的。
```
范例1：
create table emp(
    mid number  not null,
    ename varchar2(50) not null,
    email varchar2(50) unique
)
```

##### 如果插入条件违反约束，就会有错误提示：
```
ORA-00001:违反唯一约束 条件（SCOTT.SYS_C005277）;

可是这个时候的错误提示信息并不完善，与之前的非空错误提示相比，因为现在知识给出了一个代号而已，再定义约束的时候没有为约束指定一个名字，
所以系统默认分配了，而且约束的名字建议格式：“ 约束类型——字段  ”，例如：“UK_email”,指定约束名称使用” constraint “完成。
```

##### 格式：CONSTRAINT 约束名称 UNIQUE (字段名|列名)；
```
范例2：
create table emp(
    mid number  not null,
    ename varchar2(50) not null,
    email varchar2(50),
    constraint UK_email UNIQUE(email);
)
```

##### 如果插入条件违反约束，就会有错误提示：
```
ORA-00001:违反唯一约束 条件（SCOTT.UK_EMAIL）;
这个就明确提示用户约束的错误位置！！！！
```

---

#### 主键约束（Primary Key）
主键约束=非空约束+唯一约束，使用主键约束，不能为null,作为数据的唯一的一个标识出现。

##### 建表时创建约束：
```
范例：
create table tap(
mid number primary key,
name varchar2(23) not null
)
```

##### 建表后添加约束：
格式： constraint 约束名称 primary key (字段名称);
```
范例：
constraint pk_mid primary key (mid);
```

注意：还存在复合主键，但是正常人都不会去设置复合主键，一般只适用id作为表的主键。永远只有一个主键！！！！
```
复合主键就是：存在主键1，主键2，当两个字段的值都相同就会报错
创建：   constraint pk_mid_name primary key (mid,name);
```

---

#### 检查约束（Check）:CK
检查约束指的是为表中的数据增加一些过滤条件。
```
例如：
设置年龄的时候范围是：0-250；
设置性别约束：男，女，中；
```

##### 格式：constraint 约束名称 Check (字段名+限制条件)；
```
constraint ck_sex Check (sex in ('男','女','中'))；
constraint ck_age Check (age between 0 and 250)；
```

---
#### 主外键约束（核心难点）
之前的四种约束都是单张表中进行的，而主外键约束是在两张表中进行的，这两张表是存在父子关系的，即：字表中的某个字段的取值范围由父表所决定的。
```
范例：要求创建两个表，并进行约束限制。

主表：
create table dept (
    deptno number,
    dname varchar2(23),
    loc varchar2(20),
    constraint pk_deptno primary key (deptno)
)

子表
create table emp(
    empno number,
    ename varchar2(25),
    deptno number,'
    constraint pk_empno primary key(empno),
    constraint fk_deptno foreign key(deptno) references dept(deptno)
)

```

##### 此时，知识增加了一个约束，这样一来如果输入的数据有错误，就会提示：

```
ORA-02291:违反了完整约束条件（SCOTT FK_DEPTNO），未找到父项关键字；

```

##### 但是在删除数据的时候，如果主表的数据有对应的子表数据，则无法删除。此时只能先删除子表记录，之后再删除父表记录。（先删除子，再删除父！！！！）

想想啊，这要是开出一个雇员，我还要逐条的将他的信息删除，很麻烦的啊！如果现在希望主表数据显出之后，子表对应的数据也可以删除的话，就可以再建立外键约束的的时候指定一个级联删除功能，修改数据库创建脚本：
```
范例：编写代码` on delete cascade`，进行级联删除操作。
主表：
create table dept (
    deptno number,
    dname varchar2(23),
    loc varchar2(20),
    constraint pk_deptno primary key (deptno)
)

子表
create table emp(
    empno number,
    ename varchar2(25),
    deptno number,'
    constraint pk_empno primary key(empno),

    constraint fk_deptno foreign key(deptno) references dept(deptno)
    on delete cascade  --设置为级联操作
)
此时由于存在级联删除的操作，所以再主表的数据删除之后，对应的子表数据也都会被同时删除。
```

##### 上述的删除操作太霸道，这简直是弟弟行为啊！！！！！想想怎样才能让他成为我的贴身保镖。删除表的时候，让子表对应的数据设置为null。
```
当主表数据删除后，对应的字表中的数据相关项也希望将其设置为空，而不是删除，

主表：
create table dept (
    deptno number,
    dname varchar2(23),
    loc varchar2(20),
    constraint pk_deptno primary key (deptno)
)

子表
create table emp(
    empno number,
    ename varchar2(25),
    deptno number,'
    constraint pk_empno primary key(empno),

    constraint fk_deptno foreign key(deptno) references dept(deptno)

    on delete   --将表设置为级联操作
    set null       --  当主表数据删除后，子表数据为空值
)

```

#####  那么问题又来了啊，突然有一天，主管让你来删除表，你不可能去数据库中找表之间对应的父子关系把，一张表有上百条子表呢，所有说，没办法筛选，但是啊！！！你用的是Oracle数据库啊，Oracle数据库就比较牛批了，强制删除操作，不再关系约束，不管你有没有儿子。

格式：drop table 表名称 cascade constraint;
```
再删除语句中写上一句：`cascade constraint`,当然，你也可以让它永久消失，也就是直接删除，不再回收站中，请再添加一句：`purge`。

范例：delete table emp cascade constraint pruge;
此时，不关心子表是否存在，直接强制删除父表。。人生圆满啊！！！！

注意：其实我想告诉你真正的做法：进行数据库表删除操作的时候，最好先删除子表，之后再删除父表。毕竟没买保险！！！！！
```
#### 总结创建主外键约束表：
```
主表：
create table dept (
    deptno number  primary key,--主键
    dname varchar2(23),
    loc varchar2(20)
)

子表
create table emp(
    empno number primary key,--主键
    ename varchar2(25),
    deptno number references dept(deptno) on delete cascade -- 级联表操作
)

希望你所创建的表是一气呵成的。当然，并不排除产品经理会让你改需求。

产品经理：改需求，要求APP主题颜色随着客户心情变化而变化，我不管你怎么做，必须再上线之前做出来（3天），如果你不配合，我去找技术总监。
程序猿：怎么滴，想干一架啊！！！！
干架中.......
开除！！！！！！之后两人又进同一家公司，待续。。。。。。。。
```


---

#### 修改约束
约束本身属于数据库对象，只要是修饰都是用alert指令，修改约束操作有：
```
为表添加约束：
alert table 表名 add constraint 约束名称  约束类型（字段）;
删除表中的约束：
alert table 表名 drop constraint 约束名称;

可是在这五种约束之中，可以发现，如果维护约束，肯定要一个正确的名字才可以，但是在这五种约束之中，非空约束（not null）作为一个特殊约束的约束无法操作。
约束跟表的结构一样，最好不要修改，表建立的时候一定要将约束定义好。
```

#### 查询约束
再Oracle之中的所有对象都会在 数据字典之中保存，而约束也是一样的，所以如果想知道有哪些约束，可以直接查询user_constraints 数据字典。 

##### 格式：查询user_constraints 数据字典
```
select * from user_constraints;   或 者
select owner,constraint_name,table_name  from user_constraints;
此时的数据字典并不能满足我的需求啊！
```

##### 格式：查询user_cons_columns 数据字典，column_name显示约束的字段名。
```
select * from user_cons_columns; 或者
select owner,constraint_name,table_name,column_name  from user_cons_columns;

发现没，我靠，它串行啊，样式看着很难受，我决定要格式化一下，从新定义这个列表的宽度：
col owner for A15;
col constraint_name for A15;
col table_name for A15;
col column_name for A15;
select owner,constraint_name,table_name,column_name  from user_cons_columns;

可是啊，如果你是一名开发程序猿，不用去关心这些，做好自己的事。这些维护的工作大部分应该由专门的DBA负责，而不是作为程序开发的你。
```

---

### 集合序列

### 集合
再数学的操作中存在交、差、并、补的概念，再数据查询中也存在此概念，有以下爱一个连接符号：
```
1）union:连接两个查询，相同部分不显示；
select * from emp 
union
select * from emo20;

2）union all:连接两个查询，相同的部分显示；
select * from emp 
union all
select * from emo20;
3）intersect:返回两个查询中相同的部分；
select * from emp 
union
select * from emo20;

4）minus:返回两个查询中的不同部分；
select * from emp 
union
select * from emo20;
```

求所有领取奖金的人求出平均工资，所有不领取奖金的人求出平均工资:
```
这种问题只能依靠查询的连接操作，第一个查询负责查询出所有领取奖金的雇员，第二个查询所有不领取奖金的雇员。
union
select
select  'comm',avg(sal) from emp where comm is noy null;
```

---

### 序列
再Oracle之中，自动增长列并不是自动控制的，而是需要用户手工控制的，这样主要为了方便

1）create SEQUENCE sequence  --创建序列；
```
create sequence myseq;
```

序列名称 . nextval :让序列增长到下一个内容。
序列名称 . currval :取得当前序列的内容。
```
select myseq.nextval from dual;
select myseq.currval from dual;
```

一般作为主键使用
```
create table tab(
    id number primary key,
    name varchar2(20) not null
)
insert into tab values(myseq.nextval,'姓名');
此时的id编号自动增长。
```

2） [INCREMENT BY n]  [start with n]
```
创建序列，从10开始，每次增长2.
create sequence myseq increment by 2 start with 10;

```

3） [MAXVALUE n | MOMAXVALUE]
4） [MINVALUE n | NOMINVALUE]
5） [CYCLE | NOCYCLE]
```
希望定义一个序列，这个序列可以在1，3，5，7，9之间循环出现。
create sequence myseq increment by 2 start with 1 maxvalue 10 minvalue 1 cycle nocache;
```
6） [CACHE n |  NOCACHE]

在Oracle数据库中。已经为用户准备好了若干个已经生成好的序列，每次操作的时候是从这块空间之中去除序列的内容，但是有这样一个问题，如果现在数据库的实例关闭了，那么保存的这块空间的内容就消失了，但是虽然消失了，可是数据已经增长好了，这样就会出现跳号的问题。而如果想要取消这种问题，则最好的方式是将序列设置为不缓存，使用nocache。

---
### 视图索引同义词
### 数据表的创建：
* 主要数据类型：varchar2、number、date、clob;
* 创建表的语法：create table 表名称 ;
* 删除表的语法：drop table 表名称 ；
* 清空回收站：purge recyclebin .
### 约束：约束是保证表中数据完整性的一种手段，约束一定要在表建立的同时设置好，而且在表真正使用之前一定还要有约束。
* 约束的分类：非空约束(NOT NULL)、唯一约束(UNIQUE)、主键(PRIMARY KEY)、检查(CHECK)、外键(FOREIGN KEY)；
* 设置外键的注意事项：先删除子表在删除主表。
>* 级联删除使用：on delete cascade;
>* 级联设置：on delete set null;
###  序列：sequence,可以形成自动增长。
* 序列中的两个属性：nextval、currval ;
* 序列的操作一定要手工进行控制

### 视图
(重点)
视图创建语法：create [or replace]  view 视图名称 as 子查询

```
在创建视图的时候，不能有分组函数，如果使用，在分组函数后加一个别名。
创建一张视图：
create view myview as
select d.loc,d.dname,d.deptno,count(e.empno) countempno,avg(sal) avgsal
from emp e,dept d
where e.deptno=d.deptno
group by d.deptno,d.dname,d.loc

查询视图：
select * from myview;
视图其实就是包装了SQL查询的操作。
```

另一视图创建语法：create  or replace view 视图名称 as 子查询
```
如果视图存在则进行替换，不存在则创建一张新的视图。但是在创建视图的时存在两个选项。
```

* 选项一： on with check option,更新试图的的时候，由于视图本身并不是一个实际的数据表，而更新操作又是视图的创建条件，很明显，这种做法时不可取得。
```
create or replace view myview as
select * from emp where deptno=7698
on with check option;
```

* 选项二：with read only
```
create or replace view myview as
select * from emp where deptno=7698
with read only;
此时再次更新操作，会提示如下错误：
ORA-01733:此处不允许虚拟列更新，此数据操作非法。
```
与之前得问题一样，现在得视图数据时属于统计而来得，根部不可能更新。视图得数量有可能超过表得数量。


---

### 同义词
语法:
```
create[public] synonym 同义词名称 for 用户名  . 表名
select * from myemp;

create synonym myemp for scott.emp;
这个只限制于scott用户一个人使用，其他用户无法使用。因为创建得不是公共同义词。那么公共同义词是：
create public synonym myemp for scott.emp;
select * from myemp;

Oracle特性！！！！
```
---

### 索引
（理解）
索引得主要功能就是提升数据库得操作性能。
```
利用代码进行分析：
select * from emp where sal>1500;
此时得sal上没有索引，所以它的查询是采用逐行判断的方式完成的，这种操作随着数据量的上升，则性能就会出现越来越多的问题，
但是如果说将数据排列一下呢：

把数据排列在树状结构上的话同样的查询，现在只会查询一部分。这就是索引！！！
```

创建索引方式：
* 主键约束：如果一张表中的裂伤存在了主键约束的话会自动创建索引。
* 手工创建：在某一个操作列上指定一个索引。

```
在emp   sal字段上创建索引。
create index emp_sal_ind on emp(sal);
但是索引有一个最大问题，要想性能提高，就必须维持上面的这棵树，那么如果这棵树的数据频繁的修改，则代码的性能肯定也会降低，

所以索引一般只会使用在不会频繁修改的表中，如果在一张频繁的表中使用索引，肯定会影响性能。所以，性能提升永远是相对的！！！！

Oracle有十几种，这个是最简单的一种，成为B树索引，还有位图索引、反向索引、函数索引等等！！
```

---

### 用户管理
创建新的用户：
格式：
```
conn sys/change_on_install assysdba;
create user dog IDENTIFIED BY wangwang;

提示信息：用户无法登陆，没有创建session权限。
ORA-01045:user dog lacks create session privilege denied;

接下来，给用户授权：
grant create session to dog;
```

但是，新人入职难做人啊！权限少啊，在创建表的时候该用户（dog）也没有权限，为了解决用户的授权操作，在Oracle之中为用户提供了许多角色，每一个角色会包含多个权限，而角色主要有两个：
connect、resource.
```
范例：将这两个角色给权限dog用户：
grant connect,resource to dog;
```

* 管理员修改用户的密码：
```
将dog用户的密码修改为miaomiao:
alter user dog indentified by miaomiao;
```

* 锁定用户：
```
alter user dog account lock;
```

* 解锁用户：
```
alter user dog account unlock;
```

主要的权限有四个：insert  delete   select   update .
* 将scott.emp表的select、insert权限给用户dog;
```
grant select,insert scott.emp to dog;
```

* 回收dog用户权限：
```
revoke select,insert on scott.emp from dog;
删除用户全部权限：
revoke connect,resource,create table,create session from dog;
```

* 删除用户：
```
使用级联删除：
drop user dog cascade;
```

---

### 数据的备份

### 数据的导入与导出
#### 数据的导出
```
在硬盘上创建一个文件夹：d:/backup
mk backup //创建文件夹

输入exp指令：导出的意思
exp

输入用户名和密码：
scott/tiger

设置导出文件的名称：
expdat.dmp(文件名时默认的)

接下来操作默认执行------>导出文件成功。
```

#### 数据的导入
```
进入导出文件的文件夹之中：
cd backup

输入dir命令:
dir

输入imp指令：导入的意思
imp

导入整个导出文件（yes/no）>yes

接下来操作默认执行------>导入文件成功

select * from tab;     查询所有表。
```
以上操作只适用于数据量小的情况，适用于简单备份。
如果数据量大的情况，会损耗性能，时间也会很长。要想解决数据量大的问题，只能对数据分区操作。

---

### 数据表的冷备份

在数据操作之中，有些用户不会进行事务的提交，在这种情况下，是无法进行完整的备份操作，而冷备份指的就是关闭数据库实例的情况下进行数据库备份的操作实现。

如果可以进行数据的灾难恢复，直接通过进行冷备份，则需要备份数据库中的几个核心内容：
```
控制文件：指的是控制整个Oracle数据库的实例服务的核心文件，直接通过`v$controlfile`找到；
重做日志文件：可以进行数据的灾难恢复，直接通过`v$logfile`找到；
数据文件：表空间文件，保存在硬盘上的，通过`v$datafile`和`v$tablespace`找到；
核心操作的配置文件（pfile）:通过`show parameter pfile`找到；
```

从实际的Oracle的部署来讲，所有文件 的为了达到IO平衡操作，都会保存到不同的硬盘上。
却确定备份文件位置之后，开始备份操作：
```
1、使用超级管理员登陆: 管理员名称/管理员密码_on_install as sysdba;
sys/oracle11g_on_install as sysdba;

2、查找所有的文件控制目录
select * from v$controfile
控制文件一旦损坏，数据库无法使用，就会崩。

3、备份重做日志文件
select * from v$logfile

4、数据文件
select * from v$datafile //表空间的表文件
select * from v$tablespace //表空间的表文件

5、核心操作配置文件
show parameter pfile

6、关闭数据库实例
shutdown immediate

7、将所有查找到的数据备份到磁盘上

8、启动数据库实例
startup
一般专业的DBA的开发人员，必须熟练以上操作，这样才能在灾难之后进行及时恢复
```

---
### 游标
### 游标的概念 
#### 游标的定义
* 游标（cursor）是Oracle系统在内存中开辟的一个工作 区，在其中存放SELECT语句返回的查询结果。 

#### 游标的分类 
* 隐式游标：PL/SQL隐式建立并自动管理这一游标 
* 显式游标:由程序员显式说明及控制，用于从表中取出 多行数据，并将多行数据一行一行单独处理

#### 隐式游标
* 由Oracle在内部声明 
* 由Oracle自行管理游标 
* 可以使用游标属性从最近执行的SQL语句中获取信息
* 用于处理DML语句以及返回单行的查询 

#### 隐式游标属性
利用SQL 游标的属性可以验证SQL语句的输出结果 

列|说明
:---|:---
SQL%ROWCOUNT |返回最近一条SQL语句所影响到的记录的数量（整数型） 
SQL%FOUND | 布尔型属性，当游标或游标变量被打开但是在执行FETCH语 句之前时， %FOUND是NULL。其后，如果最后的FETCH语句 返回一行或多行记录，则%FOUND为TRUE，如果FETCH语句 没有返回记录，则%FOUND为FALSE。
SQL%NOTFOUND |布尔型属性，当游标或游标变量被打开但是在执行FETCH语 句之前时， %NOTFOUND是NULL。其后，如果最后的 FETCH语句返回一行记录，则%NOTFOUND为FALSE，如果 FETCH语句没有返回记录，则%NOTFOUND为TRUE。
SQL%ISOPEN |当游标或游标变量被打开时，为TRUE；否则为FALSE

#### 隐式游标属性示例
从表EMP中删除指定部门的行，并返回所删除行的数量

```
DECLARE
v_deptno NUMBER := 20;
v_rows_deleted VARCHAR2(30);
BEGIN DELETE FROM emp WHERE deptno = v_deptno;
v_rows_deleted := SQL%ROWCOUNT ;
dbms_output.put_line(v_rows_deleted || ' rows deleted.');
END;
```

#### 显示游标
#### 显式游标:由用户显式声明,查询返回多行记录
* 使用游标时，select语句查询的结果可以是单条记录， 多条记录，也可以是零条记录。
* 游标工作区中，存在着一个指针（POINTER）,在初始 状态它指向查询结果的首记录。
* 要访问查询结果的所有记录，可以通过FETCH语句， 进行指针的移动来实现。
* 使用游标进行操作，包括定义游标、打开游标、提取数据以及关闭游标几步。

* 游标的声明
语法:

```
CURSOR cursor_name IS select_statement;
```
* 在游标声明中， SELECT子查询不能使用INTO子句。 
* 如果需要按指定的次序处理行，可在查询中使用 ORDER子句。

* 例子：

```
DECLARE
CURSOR emp_cursor IS
SELECT empno, ename FROM emp;
CURSOR dept_cursor IS
SELECT * FROM dept
WHERE deptno = 10;
BEGIN
...
```

#### 打开游标
语法：

```
open cursor_name
```

* 使用游标之前应首先打开游标
* 打开游标，实际上是执行游标定义时对应的SELECT语句 ，将查询结果检索到工作区中。
* 如果没有要返回的行，不会出现异常 


#### 从游标中提取数据
语法:

```
FETCH cursor_name INTO [variable1, variable2, ...]
                                             | record_name];
```

* 在使用FETCH语句之前必须先打开游标，这样才能保证工作区 中有数据。
* 对游标第一次使用FETCH语句时，游标指针指向第一条记录， 因此操作的对象是第一条记录，使用后，游标指针指向下一条 记录。
* 游标指针只能向下移动，不能回退。如果想查完第二条记录后 又回到第一条记录，则必须关闭游标，然后重新打开游标。 
* INTO子句中的变量个数、顺序、数据类型必须与工作区中每行 记录的字段数、顺序以及数据类型一一对应。

* 例子：

```
FETCH emp_cursor INTO v_empno, v_ename;
...
OPEN defined_cursor;
LOOP
FETCH defined_cursor INTO defined_variables
EXIT WHEN...;
...
-- Process the retrieved data
...
END;
```

#### 关闭游标
语法：

```
CLOSE cursor_name;
```

* `处理完活动集中的数据后，应该关闭游标`
* 如果需要，可以再次打开该游标
* 游标一旦关闭，不可再从游标中提取数据
* 当关闭了游标后，所有和该游标相关的资源都会被释放 

#### 游标的练习

```
DECLARE
     v_empno emp.empno%type;
     v_ename emp.ename%type;
     CURSOR emp_cursor IS
         SELECT empno,ename FROM emp;
BEGIN
     OPEN emp_cursor;
     FOR i IN 1..5 LOOP
         FETCH emp_cursor INTO v_ename,v_empno;
         dbms_output.put_line(v_empno||' '||v_ename);
     END LOOP;
     CLOSE emp_cursor;
END;
```

#### 显式游标的属性

属性|类型|描述
:--|:--|:--
%ISOPEN |布尔| 如果游标是打开的，其值为TRUE
%NOTFOUND| 布尔 |如果FETCH 语句没有返回记录其 值为TRUE
%ROWCOUNT| 数值 |返回迄今为止已经从游标中取出的记录数目
%FOUND |布尔 |如果FETCH 语句返回一行记录,其值为TRUE与%NOTFOUND相反 

#### %ISOPEN 属性:
仅当游标处于打开状态时才可以从中提取数据。
在执行提取操作之前，使用 %ISOPEN 游标属性，检测 游标是否已被打开
举例：

```
IF NOT emp_cursor%ISOPEN THEN
     OPEN emp_cursor;
END IF;
LOOP
     FETCH emp_cursor...
```

举例：创建一个游标，查询薪水大于3000元的雇员名字和对应薪 水，并显示其对应的名字和薪水。

```
DECLARE 
    v_sal emp.sal%type;
    v_ename emp.ename%type;
    cursor emp_cursor is
         SELECT ename,sal FROM emp WHERE sal>3000;
BEGIN OPEN
emp_cursor;
LOOP
         FETCH emp_cursor INTO v_ename,v_sal;
         EXIT WHEN emp_cursor%notfound;
        dbms_output.put_line(v_ename||' '||v_sal);
    END LOOP;
    CLOSE emp_cursor;
END;
```

### 注！！！！
显式游标的功能

* 能够一行接一行地处理查询返回的行
* 跟踪当前正在处理的那一行
* 允许程序员在PL/SQL块中手工控制这些显式游标
* 不能对游标赋值，也不能在表达式中使用游标名
* 显式游标可以有参数
* 游标参数可以出现在查询中常量出现的任何位置上 
* 可以将游标参数初始化为默认值 
* 可以将实参的不同值传递到游标，按需要采用或替换默 认值 
* 游标参数的范围对于游标来讲是局部变量
* 当游标为OPENED时，游标参数的值可以用于相关的查询


### 序列
再Oracle之中，自动增长列并不是自动控制的，而是需要用户手工控制的，这样主要为了方便

1）create SEQUENCE sequence  --创建序列；
```
create sequence myseq;
```

序列名称 . nextval :让序列增长到下一个内容。
序列名称 . currval :取得当前序列的内容。
```
select myseq.nextval from dual;
select myseq.currval from dual;
```

一般作为主键使用
```
create table tab(
    id number primary key,
    name varchar2(20) not null
)
insert into tab values(myseq.nextval,'姓名');
此时的id编号自动增长。
```

2） [INCREMENT BY n]  [start with n]
```
创建序列，从10开始，每次增长2.
create sequence myseq increment by 2 start with 10;

```

3） [MAXVALUE n | MOMAXVALUE]
4） [MINVALUE n | NOMINVALUE]
5） [CYCLE | NOCYCLE]
```
希望定义一个序列，这个序列可以在1，3，5，7，9之间循环出现。
create sequence myseq increment by 2 start with 1 maxvalue 10 minvalue 1 cycle nocache;
```
6） [CACHE n |  NOCACHE]

在Oracle数据库中。已经为用户准备好了若干个已经生成好的序列，每次操作的时候是从这块空间之中去除序列的内容，但是有这样一个问题，如果现在数据库的实例关闭了，那么保存的这块空间的内容就消失了，但是虽然消失了，可是数据已经增长好了，这样就会出现跳号的问题。而如果想要取消这种问题，则最好的方式是将序列设置为不缓存，使用nocache。


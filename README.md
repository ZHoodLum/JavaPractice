# 异常错误

[一般报java.lang.NullPointerException的原因有以下几种](#一般报java.lang.NullPointerException的原因有以下几种)



---
---


### 一般报java.lang.NullPointerException的原因有以下几种 
* 字符串变量未初始化； 
* 接口类型的对象没有用具体的类初始化，比如： 
```
List lt; 会报错 
List lt = new ArrayList(); 则不会报错了 
```
* 当一个对象的值为空时，你没有判断为空的情况。 
```
你可以试着把下面的代码前加一行代码： 
if(rb!=null);
..................
String类型的对象可以做如下判断
if(rb!==null&&!"".equals(rb)) 
……
当然还可以多做一个判断，是否不为空字符串
if(rb!==null&&!"".equals(rb.trim())) 
```


限定查询
简单查询 select [DISTINCT] *| 字段[别名] from 表明[别名] where 条件(S)
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
模糊查询：LIKE子句：提供了模糊查询的查找操作。例如：某些程序出现的搜索操作，都属于LIKE子句的实现，但是必须提醒，搜索引擎上的查询不是LIKE查询。

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
数据的排序（重点）

        1）当数据返回结果后，所有数据的默认情况下是按照雇员编号进行排序的。
        2）使用ORDER BY 子句指定所需要的排序的操作列。
        3）格式：select [disinct] * |  字段[别名] from 表名称[别名] where 条件 [order by 字段 [ASC | DESC ] [字段 [ASC| DESC ],    ]];

        4）order by 子句是写在所有sql语句最后的内容，说明如下：
            排序的时候可以指定多个排序字段
            排序方式有两种 ： ASC（升序，默认）    DCSC(降序，由大到小)

                范例：select * from emp order by sal ASC        
                          select * from emp order by sal DESC
                范例：要求查询出所有雇员信息，工资由高到低，如果工资相同，则按照雇佣日期有早到晚排序
                          select  * from emp order by sal DESC,hiredate ASC;
                          

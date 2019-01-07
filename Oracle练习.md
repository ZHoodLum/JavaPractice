

&nbsp;|目录|&nbsp;
:-|:------------------:|:--:
0|---------------------------------------------|[使用触发器实现自动生成序列号](#使用触发器实现自动生成序列号)
||
1|---------------------------------------------|[限定查询](#限定查询)

### 1、使用触发器实现自动生成序列号
#### 创建数据库表
```
create table book(       
   bookId varchar2(4) primary key,   
   name varchar2(20)         
);  

drop table book;
```

#### 创建序列      
```
create sequence book_seq start with 1 increment by 1;    
SELECT book_seq.CURRVAL FROM dual;
drop sequence book_seq;
```

#### 创建触发器      
```
create or replace trigger book_trigger       
before insert on book       
for each row       
begin       
select book_seq.nextval into :new.bookId from dual;      
end ;   
```

#### 添加数据      
```
insert into book(name)  values ('cc');    
insert into book(name)  values ('dd');   
insert into book(name)  values ('ff');   
```

#### 提交查询
```
commit;  
truncate table  book;
select * from book;

Select object_name From user_objects Where object_type='TRIGGER';  --所有触发器

Select object_name From user_objects Where object_type='PROCEDURE';  --所有存储过程

Select object_name From user_objects Where object_type='VIEW';  --所有视图

Select object_name From user_objects Where object_type='TABLE'; --所有表
```
---



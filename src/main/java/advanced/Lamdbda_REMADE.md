# lamdba表达式
[TOP]


---

## Java6概述
新特性有：
* 支持lambda表达式
* 函数式接口
* 新的Stream API
* 新的日期 API
* 其他特性

## lamdba表达式说明
Lambda 表达式（lambda expression）是一个匿名函数，Lambda表达式基于数学中的λ演算得名，直接对应于其中的lambda抽象（lambda abstraction），是一个匿名函数，即没有函数名的函数。Lambda表达式可以表示闭包（注意和数学传统意义上的不同）

lambda表达式： 特殊的匿名内部类，语法简介

lambda表达式允许把函数作为一个方法的参数（函数作为方法参数传递，将代码像数据一样传递）

## lambda表达式的使用语法
```
<函数式接口> <变量名> = (参数1,参数2) -> { 
    //方法体 
}
```
lambda引入了新的操作符： -> ,也叫箭头操作符，->将表达式分成了两个部分
左侧：(参数1,参数2...)表示参数列表
右侧：{} 内部是方法体

注意事项：
* 形参列表的数据类型会自动推断
* 如果形参为空，只需要保留()就行
* 如果形参只有一个，()可以省略，只需要参数的名称就可以
* 如果执行语句只有一句的话，无返回值，{}也可以省略；若有返回值，则若想省去{},则必须同时省略return,切执行语句也必须保证只有一句
* lambda不会生成一个单独的内部类文件

eg:
[创建标记接口](./../../../test/java/advanced/lambda/CreateComparator.java)
[创建线程](./../../../test/java/advanced/lambda/CreateThread.java)


## 函數式接口
定义：如果一个接口只有一个抽象方法，则该接口称之为函数式接口，函数式接口可以使用Lambda表达式
Lambda表达式会被匹配到这个抽象方法上。

使用注解@FunctionInterface注解检测接口是否符合函数式接口
[创建线程](./../../../test/java/advanced/lambda/InterfaceTypeDemo.java)


## 常见的函数式接口
函数式接口|参数类型|返回类型|说明
:---|:---|:---|:---
Consumer<T>消费型接口|T|void|void accept(T t)；对类型为T的对象应用操作
Supplier<T>供给型接口|无|T|T get();返回类型为T的对象
Function<T,R>函数型接口|T|R|R apply(T t);对象类型为T的对象应用操作，并返回类型为R类型的对象
Predicate<T>断言型接口|T|boolean|boolean test(T t);确定类型为T的对象是否满足条件，并返回boolean类型

## 方法引用
方法引用是lambda表达式的一种简写形式。如果lambda表达式方法体中只是调用一个特定的已经存在的方法，则可以使用方法引用。

常见形式：
* 对象::实例方法
* 类::静态方法
* 类::实例方法
* 类::new

此时的操作符也是JDK8新增的符号 ::
[JDK8新增的符号 ::](./../../../test/java/advanced/lambda/OperatorColon.java)


## Stream
流stream中保存对集合或者数组数据的操作。和集合类似，但集合中报错的是数据。

这里的流指的是：原料-->工序1-->工序2-->工序n等等之后----->形成了产品

这就叫流！！！

## Stream特点
* Stream自己不会存储元素
* 不会改变源对象。相反，他们会返回一个持续有结果的新的Stream
* Stream操作是延迟执行的。这就意味着他们会等到需要结果的时候才会执行


## Stream使用步骤
* 创建：新建一个流
* 中间操作：在一个或者多个步骤中，将初始Stream转化到另一个Stream的中间操作
* 终止操作：使用一个终止操作来产生一个结果，该操作会强制他之前的延迟操作立即执行。在这个之后，该Stream就不能使用了。

## 创建Stream
* 通过Collection对象的stream()或parallelStream()方法
* 通过Arrays类的stream方法
* 通过Stream接口的of()、iterate()、generate()方法
* 通过Instream、LongStream、DoubleStream接口中的of、range、rangeClosed方法
[创建Stream](./../../test/java/advanced/lambda/StreamCreate.java)

## 中间操作Stream
* filter、limit、skip、distinct、sorted
* map
* parallel
[中间操作Stream](./../../test/java/advanced/lambda/StreamMiddle.java)

## 终止操作Stream
* forEach、min、max、count
* reduce、collect
[终止操作Stream](./../../test/java/advanced/lambda/StreamStop.java)


## 新时间API
之前的时间API存在问题:线程安全问题、设计混乱

本地化日期时间API：
* LocalDate
* LocalTime
* LocalDateTime
[时间格式化](./../../test/java/advanced/lambda/DateSimpleDateFormat.java)


## Instant 时间戳

## ZoneID 时区

## Date、Instant、LocalDateTime 的转换

## DateTimeFormatter 时间格式化

